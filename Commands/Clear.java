package lab5.Commands;

import lab5.Collections.SpaceMarine;

import java.util.PriorityQueue;

/**
 * Класс команды clean
 *
 * @author Остряков Егор, P3112
 */
public class Clear extends AbstractCommand {
    public Clear() {
        name = "clear";
        help = "очищает коллекцию";
    }

    /**
     * Удаляет все элементы коллекции
     *
     * @param args            не принимает аргументы
     * @param priorityQueue   коллекция, которую нужно очистить
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        if (args.length > 0) System.out.println("Команда не принимает аргументы");
        else {
            priorityQueue.clear();
            System.out.println("Коллекция очищена");
        }
    }
}
