package lab5.Commands;

import lab5.Collections.SpaceMarine;

import java.util.PriorityQueue;

/**
 * Класс команды remove_any_by_loyal
 *
 * @author Остряков Егор, P3112
 */
public class RemoveAnyByLoyal extends AbstractCommand {
    public RemoveAnyByLoyal() {
        name = "remove_any_by_loyal";
        help = "удаляет из коллекции один элемент, значение поля loyal которого эквивалентно заданному";
    }

    /**
     * Удаляет из коллекции один элемент с указанным значением лояльности
     *
     * @param args            значение лояльности
     * @param priorityQueue   коллекция, из которой удаляется элемент
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        if (args.length != 1)
            System.out.println("Команда принимает лишь один аргумент");
        else {
            try {
                if (priorityQueue.size() > 0) {
                    commandsManager.setExist(false);
                    Boolean loyal = null;
                    if (args[0].equalsIgnoreCase("true")) loyal = true;
                    else if (args[0].equalsIgnoreCase("false")) loyal = false;
                    else if (args[0].equals("null")) loyal = null;
                    else {
                        System.out.println("Неверный аргумент");
                    }
                    for (SpaceMarine each : priorityQueue) {
                        if (each.getLoyal() == loyal) {
                            priorityQueue.remove(each);
                            System.out.println("Элемент с id= " + each.getId() + " удалён");
                            commandsManager.setExist(true);
                            break;
                        }
                    }
                    if (!commandsManager.isExist()) {
                        System.out.println("Элемент с loyal = " + args[0] + " не найден");
                    }
                } else System.out.println("Список пуст");
            } catch (Exception e) {
                System.out.println("Неверный тип аргумента");
            }
        }
    }
}
