package lab5.Commands;

import lab5.Collections.SpaceMarine;

import java.util.PriorityQueue;

/**
 * Класс команды remove_by_id
 *
 * @author Остряков Егор, P3112
 */
public class RemoveById extends AbstractCommand {
    public RemoveById() {
        name = "remove_by_id";
        help = "удаляет элемент из коллекции по его id";
    }

    /**
     * Удаляет элемент по id
     *
     * @param args            id
     * @param priorityQueue   коллекция, из которой удаляется элемент
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        if (args.length != 1) {
            System.out.println("Команда принимает лишь один аргумент");
        } else {
            try {
                long id = Long.parseLong(args[0]);
                commandsManager.setExist(false);
                for (SpaceMarine spaceMarine : priorityQueue)
                    if (spaceMarine.getId() == id) {
                        commandsManager.setExist(true);
                        break;
                    }
                priorityQueue.removeIf(spaceMarine -> spaceMarine.getId() == id);
                if (!commandsManager.isExist()) {
                    System.out.println("Элемент коллекции с id = " + args[0] + " не найден");
                } else if (!commandsManager.isNotPrintAdd())
                    System.out.println("Элемент коллекции с id = " + args[0] + " удалён");

            } catch (Exception e) {
                System.out.println("Неверный тип аргумента");
            }
        }
    }
}
