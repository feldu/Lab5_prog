package lab5;

import lab5.Collections.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.PriorityQueue;
import java.util.Scanner;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lab5.Commands.CommandsManager;

/**
 * Класс, обрабатывающий пользовательский ввод
 */
public class InputHandler {
    public static String[] arguments = null;

    /**
     * Создаёт элемент коллекции с указанными полями
     *
     * @param arguments поля элемента коллекции
     * @return сформированный элемент коллекции
     */
    static SpaceMarine TransformArguments(String[] arguments) {
        try {
            for (int i = 0; i < arguments.length && i != 5; i++)
                if (arguments[i].isEmpty()) throw new Exception();
            String name = arguments[0];
            Coordinates coordinates = new Coordinates(Integer.parseInt(arguments[1]), Long.parseLong(arguments[2]));
            Float health = Float.parseFloat(arguments[3]);
            Long heartCount = Long.parseLong(arguments[4]);
            Boolean loyal = arguments[5].isEmpty() ? null : parseBoolean(arguments[5]);
            MeleeWeapon meleeWeapon = MeleeWeapon.valueOf(arguments[6]);
            Chapter chapter = new Chapter(arguments[7], arguments[8]);
            return new SpaceMarine(name, coordinates, health, heartCount, loyal, meleeWeapon, chapter);
        } catch (Exception e) {
            System.out.println("Не удалось добавить объект, некоторые данные введены неверно!");
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @param s строка, которую нужно запарсить в Boolean
     * @return true, false или null
     */
    public static Boolean parseBoolean(String s) {
        if (s.equalsIgnoreCase("true")) return true;
        else if (s.equalsIgnoreCase("false")) return false;
        else {
            System.out.println("*Не удалось распознать значение поля \"loyal\". Поле примет значение null.");
            return null;
        }
    }

    /**
     * Загрузчик коллекции из файла
     *
     * @param args          значения полей элемента коллекции
     * @param priorityQueue коллекция
     */
    static void InputLoader(String[] args, PriorityQueue<SpaceMarine> priorityQueue) {
        arguments = args;
        CSVParser parser = new CSVParserBuilder().withSeparator(args[1].charAt(0)).build();
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]));
             CSVReader reader = new CSVReaderBuilder(br).withCSVParser(parser).build()) {
            String[] line;
            do {
                line = reader.readNext();
                if (line == null) break;
                if (line.length != 9) {
                    System.out.println("Не удалось загрузить элемент. Строка имеет неверный формат");
                    System.out.println(line.length);
                } else {
                    SpaceMarine spaceMarine = TransformArguments(line);
                    if (spaceMarine != null) priorityQueue.add(spaceMarine);
                }
            } while (true);
        } catch (FileNotFoundException e) {
            System.out.println("Неверное имя файла. Попробуйте ввести ещё раз.");
            System.exit(-1);
        } catch (Exception e) {
            System.out.println("Произошла ошибка");
        }
    }

    /**
     * Формирует аргументы из пользовательского ввода
     *
     * @param commandsManager объект класса CommandsManager
     * @return массив аргументов
     */
    public static SpaceMarine ArgumentsReader(CommandsManager commandsManager) {
        String[] arguments = new String[9];
        arguments[0] = InputValidation("Введите имя:", false, commandsManager);
        arguments[1] = InputValidation("Введите координату x(целое число):", Integer.MIN_VALUE, Integer.MAX_VALUE, commandsManager);
        arguments[2] = InputValidation("Введите координату y(целое число):", Long.MIN_VALUE, Long.MAX_VALUE, commandsManager);
        arguments[3] = InputValidation("Введите значение здоровья(вещественное число больше нуля):", 0.0f, Float.MAX_VALUE, commandsManager);
        arguments[4] = InputValidation("Введите количество сердечек(целое число от 1 до 3):", 1L, 3L, commandsManager);
        arguments[5] = InputValidation("Введите значение лояльности(true или false): \n*Поле не обязательно", true, commandsManager);
        arguments[6] = "";
        while (!arguments[6].equals("CHAIN_SWORD") && !arguments[6].equals("POWER_SWORD") && !arguments[6].equals("MANREAPER") && !arguments[6].equals("LIGHTING_CLAW")) {
            arguments[6] = InputValidation("Выберите дип оружия (CHAIN_SWORD, POWER_SWORD, MANREAPER или LIGHTING_CLAW):", false, commandsManager);
            if (commandsManager.isScript()) break;
        }
        arguments[7] = InputValidation("Введите название главы:", false, commandsManager);
        arguments[8] = InputValidation("Введите название мира:", false, commandsManager);
        return TransformArguments(arguments);
    }

    /**
     * Валидация вводимых данных
     *
     * @param message         полученное сообщение
     * @param maybenull       может ли поле быть null
     * @param commandsManager объект класса CommandsManager
     * @return Корректное значение поля
     */
    static String InputValidation(String message, Boolean maybenull, CommandsManager commandsManager) {
        String line = "";
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                if (!commandsManager.isScript()) System.out.println(message);
                line = commandsManager.isScript() ? commandsManager.getScriptBufferedReader().readLine() : scanner.nextLine();
            } while (!maybenull && line.isEmpty());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (NullPointerException ignored) {
        } catch (Exception e) {
            System.out.print("Введены неверные данные. ");
            if (commandsManager.isScript()) return line;
        }
        return line;
    }

    /**
     * Валидация вводимых данных
     *
     * @param message         полученное сообщение
     * @param min             левая граница диапазона
     * @param max             правая граница диапазона
     * @param commandsManager объект класса CommandsManager
     * @return Корректное значение поля
     */
    static String InputValidation(String message, int min, int max, CommandsManager commandsManager) {
        String line = "";
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                if (!commandsManager.isScript()) System.out.println(message);
                line = commandsManager.isScript() ? commandsManager.getScriptBufferedReader().readLine() : scanner.nextLine();
                if (!commandsManager.isScript()) {
                    if ((Integer.parseInt(line) > max || Integer.parseInt(line) < min)) {
                        System.out.print("Значение вне диапазона. ");
                        line = InputValidation(message, min, max, commandsManager);
                    }
                    Integer.parseInt(line);
                }
            } while (line.isEmpty());
            return line;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            return null;
        } catch (Exception e) {
            System.out.print("Введены неверные данные.");
            if (commandsManager.isScript()) return line;
            else return InputValidation(message, min, max, commandsManager);
        }
    }

    /**
     * Валидация вводимых данных
     *
     * @param message         полученное сообщение
     * @param min             левая граница диапазона
     * @param max             правая граница диапазона
     * @param commandsManager объект класса CommandsManager
     * @return Корректное значение поля
     */
    static String InputValidation(String message, long min, long max, CommandsManager commandsManager) {
        String line = "";
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                if (!commandsManager.isScript()) System.out.println(message);
                line = commandsManager.isScript() ? commandsManager.getScriptBufferedReader().readLine() : scanner.nextLine();
                if (!commandsManager.isScript()) {
                    if ((Long.parseLong(line) > max || Long.parseLong(line) < min)) {
                        System.out.print("Значение вне диапазона.");
                        line = InputValidation(message, min, max, commandsManager);
                    }
                    Long.parseLong(line);
                }
            } while (line.isEmpty());
            return line;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            return null;
        } catch (Exception e) {
            System.out.print("Введены неверные данные.");
            if (commandsManager.isScript()) return line;
            else return InputValidation(message, min, max, commandsManager);
        }
    }

    /**
     * Валидация вводимых данных
     *
     * @param message         полученное сообщение
     * @param min             левая граница диапазона
     * @param max             правая граница диапазона
     * @param commandsManager объект класса CommandsManager
     * @return Корректное значение поля
     */
    static String InputValidation(String message, float min, float max, CommandsManager commandsManager) {
        String line = "";
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                if (!commandsManager.isScript()) System.out.println(message);
                line = commandsManager.isScript() ? commandsManager.getScriptBufferedReader().readLine() : scanner.nextLine();
                if (!commandsManager.isScript()) {
                    if ((Float.parseFloat(line) > max || Float.parseFloat(line) <= min)) {
                        System.out.print("Значение вне диапазона. ");
                        line = InputValidation(message, (float) min, (float) max, commandsManager);
                    }
                    Float.parseFloat(line);
                }
            } while (line.isEmpty());
            return line;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            return null;
        } catch (Exception e) {
            System.out.print("Введены неверные данные.");
            if (commandsManager.isScript()) return line;
            else return InputValidation(message, (float) min, (float) max, commandsManager);
        }
    }
}
