package lab5.Commands;

import lab5.Collections.SpaceMarine;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Класс управляющий выборкой команд
 *
 * @author Остряков Егор, P3112
 */

public class CommandsManager {
    private static HashSet<AbstractCommand> commands = new HashSet<>();
    private static CommandsManager commandsManager = new CommandsManager();

    /**
     * Конструктор при вызове которого в HashSet commands будут добавлены все доступные команды
     */
    private CommandsManager() {
        commands.add(new Add());
        commands.add(new AddIfMin());
        commands.add(new Clear());
        commands.add(new ExecuteScript());
        commands.add(new Exit());
        commands.add(new Help());
        commands.add(new Info());
        commands.add(new MaxByHealth());
        commands.add(new PrintUniqueHealth());
        commands.add(new RemoveAnyByLoyal());
        commands.add(new RemoveById());
        commands.add(new RemoveFirst());
        commands.add(new RemoveGreater());
        commands.add(new Save());
        commands.add(new Show());
        commands.add(new Update());

    }

    private boolean exist = false;
    private boolean notPrintAdd = false;
    private String scriptFileName;
    private boolean isScript = false;
    private BufferedReader scriptBufferedReader;

    /**
     * Определяет, какую команду ввёл пользователь и запускает её выполнение
     *
     * @param args          команда с её аргументами
     * @param priorityQueue коллекция с которой работает пользователь
     */
    public static void ExecuteCommand(String[] args, PriorityQueue<SpaceMarine> priorityQueue) {
        String cmd = args[0].trim();
        args = Arrays.copyOfRange(args, 1, args.length);
        boolean exist = false;
        for (AbstractCommand command : commands)
            if (command.getName().equals(cmd)) {
                command.execute(args, priorityQueue, commandsManager);
                exist = true;
            }
        if (!exist) System.out.println("Команда не найдена. Для просмотра доступных команд введите help");
    }

    /**
     * Проматывает строки в случае ошибки при считывании команды из скрипта
     */
    public void commandRewider() {
        try {
            for (int i = 1; i < 10; i++) scriptBufferedReader.readLine();
        } catch (Exception ignored) {
        }
    }

    /**
     * @return HashSet с командами
     */
    public static HashSet<AbstractCommand> getCommands() {
        return commands;
    }

    /**
     * @param script работает в данный момент пользователь со скриптом или нет
     */
    public void setScript(boolean script) {
        isScript = script;
    }

    /**
     * @return работает в данный момент пользователь со скриптом или нет
     */
    public boolean isScript() {
        return isScript;
    }

    /**
     * @return стоит ли оповещать пользователя о добавлении объекта
     */
    public boolean isNotPrintAdd() {
        return notPrintAdd;
    }

    /**
     * @param notPrintAdd стоит ли оповещать пользователя о добавлении объекта
     */
    public void setNotPrintAdd(boolean notPrintAdd) {
        notPrintAdd = notPrintAdd;
    }

    /**
     * @return существование элемента коллекции
     */
    public boolean isExist() {
        return exist;
    }

    /**
     * @param exist существование элемента коллекции
     */
    public void setExist(boolean exist) {
        this.exist = exist;
    }

    /**
     * @return имя скрипта
     */
    public String getScriptFileName() {
        return scriptFileName;
    }

    /**
     * @param scriptFileName имя скрипта
     */
    public void setScriptFileName(String scriptFileName) {
        this.scriptFileName = scriptFileName;
    }

    /**
     * @return считыватель скрипта
     */
    public BufferedReader getScriptBufferedReader() {
        return scriptBufferedReader;
    }

    /**
     * @param scriptBufferedReader считыватель скрипта
     */
    public void setScriptBufferedReader(BufferedReader scriptBufferedReader) {
        this.scriptBufferedReader = scriptBufferedReader;
    }
}
