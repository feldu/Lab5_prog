package lab5.Commands;

import lab5.Collections.*;

import java.util.PriorityQueue;

/**
 * Абстрактный класс, от которого наследуются все команды
 *
 * @author Остряков Егор, P3112
 */
public abstract class AbstractCommand {
    protected String name;
    protected String help;

    /**
     * Метод выполнения команды
     *
     * @param args            аргументы, принимаемые командой
     * @param priorityQueue   коллекция, с которой работает пользователь
     * @param commandsManager объект класса CommandsManager
     */
    public abstract void execute(String args[], PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager);

    /**
     * @return имя команды
     */
    public String getName() {
        return name;
    }

    /**
     * @return описание работы команды
     */
    public String getHelp() {
        return help;
    }
}
