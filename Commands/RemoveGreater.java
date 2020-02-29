package lab5.Commands;

import lab5.Collections.SpaceMarine;

import java.util.PriorityQueue;

/**
 * Класс команды remove_greater
 *
 * @author Остряков Егор, P3112
 */
public class RemoveGreater extends AbstractCommand {
    public RemoveGreater() {
        name = "remove_greater";
        help = "удаляет из коллекции все элементы, превышающие заданный";
    }

    /**
     * Удаляет из коллекции элементы, здоровье которых больше указанного
     *
     * @param args            не принимает аргументы
     * @param priorityQueue   коллекция, из которой удаляются элементы
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        if (args.length > 0) {
            System.out.println("На данном этапе команда не принимает аргументы");
            commandsManager.commandRewider();
        } else {
            try {
                if (priorityQueue.size() > 0) {
                    commandsManager.setNotPrintAdd(true);
                    String[] nargs = new String[]{"add"};
                    CommandsManager.ExecuteCommand(nargs, priorityQueue);
                    SpaceMarine added = null;
                    for (SpaceMarine each : priorityQueue) {
                        if (each.getId() == SpaceMarine.idSetter - 1)
                            added = each;
                    }
                    float hp = added.getHealth();
                    priorityQueue.removeIf(spaceMarine -> spaceMarine.getHealth() > hp);
                    priorityQueue.remove(added);
                    SpaceMarine.idSetter--;
                    System.out.println("Элемент превышающие заданный удалены из коллекции");
                } else System.out.println("Список пуст");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        commandsManager.setNotPrintAdd(false);
    }
}
