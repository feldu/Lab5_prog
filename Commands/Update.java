package lab5.Commands;

import lab5.Collections.SpaceMarine;

import java.util.PriorityQueue;

/**
 * Класс команды update
 */
public class Update extends AbstractCommand {
    public Update() {
        name = "update";
        help = "обновляет значение элемента коллекции, id которого равен заданному";
    }

    /**
     * Обновляет элемент коллекции по id
     *
     * @param args            id
     * @param priorityQueue   коллекция, элемент которой нужно обновить
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        try {
            if (args.length != 1) {
                System.out.println("Команда принимает лишь один аргумент");
                if (commandsManager.isScript()) {
                    commandsManager.commandRewider();
                }
            } else {
                long oldIdSetter = SpaceMarine.idSetter;
                commandsManager.setNotPrintAdd(true);
                SpaceMarine.idSetter = Long.parseLong(args[0]);
                String[] nargs = new String[]{"remove_by_id", args[0]};
                CommandsManager.ExecuteCommand(nargs, priorityQueue);
                if (commandsManager.isExist()) {
                    nargs = new String[]{"add"};
                    CommandsManager.ExecuteCommand(nargs, priorityQueue);
                    System.out.println("Элемент с id = " + (SpaceMarine.idSetter - 1) + " обновлён");
                }
                SpaceMarine.idSetter = oldIdSetter;
            }
        } catch (NullPointerException ignored) {
        } catch (Exception e) {
            System.out.println("Неверный тип аргумента");
            if (commandsManager.isScript()) {
                commandsManager.commandRewider();
            }
        }
        commandsManager.setNotPrintAdd(false);
    }
}
