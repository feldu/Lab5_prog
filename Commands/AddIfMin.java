package lab5.Commands;

import lab5.Collections.SpaceMarine;

import java.util.PriorityQueue;

/**
 * Класс команды add_if_min
 *
 * @author Остряков Егор, P3112
 */
public class AddIfMin extends AbstractCommand {
    public AddIfMin() {
        name = "add_if_min";
        help = "добавляет новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }

    /**
     * Добавляет новый элемент в коллекцию, если значение его здоровья минимально
     *
     * @param args            не принимает аргументы
     * @param priorityQueue   коллекция, в которую нужно добавить элемент
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        if (args.length > 0) {
            System.out.println("На данном этапе команда не принимает аргументы");
            commandsManager.commandRewider();
        } else {
            commandsManager.setNotPrintAdd(true);
            try {
                String[] nargs = new String[]{"add"};
                CommandsManager.ExecuteCommand(nargs, priorityQueue);
                if (priorityQueue.peek().getId() != SpaceMarine.idSetter - 1 || priorityQueue.size() == 0) {
                    priorityQueue.removeIf(spaceMarine -> spaceMarine.getId() == SpaceMarine.idSetter - 1);
                    SpaceMarine.idSetter--;
                    System.out.println("Элемент не добавлен, так как не является минимальным");
                } else System.out.println("Элемент добавлен в коллекцию");
            } catch (NullPointerException ignored) {
            } catch (Exception e) {
                System.out.println("Неверный тип аргумента");
                if (commandsManager.isScript()) {
                    commandsManager.commandRewider();
                }
            }
        }
        commandsManager.setNotPrintAdd(false);
    }
}
