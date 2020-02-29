package lab5.Commands;

import lab5.Collections.SpaceMarine;

import java.util.PriorityQueue;

/**
 * Класс команды remove_first
 *
 * @author Остряков Егор, P3112
 */
public class RemoveFirst extends AbstractCommand {

    public RemoveFirst() {
        name = "remove_first";
        help = "удаляет первый элемент из коллекции";
    }

    /**
     * Удаляет первый элемент коллекции
     *
     * @param args            не принимает аргументов
     * @param priorityQueue   коллекция, из которой удаляется элемент
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        if (args.length > 0) System.out.println("Команда не принимает аргументы");
        else {
            try {
                System.out.println("Элемент с id = " + priorityQueue.poll().getId() + " удалён");
            } catch (Exception e) {
                System.out.println("Список пуст");
            }
        }
    }
}
