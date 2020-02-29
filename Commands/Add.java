package lab5.Commands;

import lab5.Collections.*;
import lab5.InputHandler;

import java.util.PriorityQueue;

/**
 * Класс команды add
 *
 * @author Остряков Егор, P3112
 */
public class Add extends AbstractCommand {
    public Add() {
        name = "add";
        help = "выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    /**
     * Добавляет новый элемент в коллекцию
     *
     * @param args            не принимает аргументы
     * @param priorityQueue   коллекция, в которую нужно добавить элемент
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        try {
            if (args.length > 0) {
                System.out.println("На данном этапе команда не принимает аргументы");
                if (commandsManager.isScript()) {
                    commandsManager.commandRewider();
                }
            } else {
                if (priorityQueue.add(InputHandler.ArgumentsReader(commandsManager)) && !commandsManager.isNotPrintAdd()) {
                    System.out.println("Элемент добавлен в коллекцию");
                }
            }
        } catch (NullPointerException ignored) {
        }
    }
}
