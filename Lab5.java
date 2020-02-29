package lab5;

import lab5.Collections.*;
import lab5.Commands.CommandsManager;

import java.util.*;

/**
 * Main class
 *
 * @author Остряков Егор, P3112
 */
public class Lab5 {
    public static Date creationDate;

    /**
     * метод main
     *
     * @param args имя файла, для загрузки коллекции и сплитер для парсинга (опционально)
     */
    public static void main(String[] args) {
        PriorityQueue<SpaceMarine> priorityQueue = new PriorityQueue<>(idComparator);
        creationDate = new Date();
        try {
            Scanner scanner = new Scanner(System.in);
            //args = new String[]{"C:\\Users\\ADMIN\\IdeaProjects\\lab5\\in.csv", ";"};
            if (args.length < 1 || args.length > 2) {
                System.out.println("Неверное количество аргументов");
                System.exit(-1);
            }
            if (args.length == 1) {
                args = new String[]{args[0], ";"};
            }
            if (args.length == 2 && !args[1].equals(";") && !args[1].equals(",")) {
                System.out.println("Вторым аргументом может являться только ',' или ';'");
                System.exit(-1);

            }
            InputHandler.InputLoader(args, priorityQueue);
            System.out.println("Коллекция загружена");
            while (true) {
                CommandsManager.ExecuteCommand(scanner.nextLine().split(" "), priorityQueue);
            }

        } catch (NoSuchElementException ignored) {
        } catch (Exception e) {
            System.out.println("Не удалось загрузить файл");
            e.printStackTrace();
        }

    }

    /**
     * Переопределение интерфейса Comparator для сравнения элементов коллекции по полю Health
     */
    public static Comparator<SpaceMarine> idComparator = (o1, o2) -> (int) (o1.getHealth() - o2.getHealth());
}