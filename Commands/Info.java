package lab5.Commands;

import lab5.Lab5;
import lab5.Collections.SpaceMarine;

import java.util.PriorityQueue;

/**
 * Класс команды info
 *
 * @author Остряков Егор, P3112
 */
public class Info extends AbstractCommand {
    public Info() {
        name = "info";
        help = "выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    /**
     * Выводит инормацию о коллекции
     *
     * @param args            не принимает аргументов
     * @param priorityQueue   коллекция, с которой работает пользователь
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        if (args.length > 0) System.out.println("Команда не принимает аргументы");
        else {
            System.out.println("Тип коллекции: " + priorityQueue.getClass().getName());
            System.out.println("Время создания коллекции: " + Lab5.creationDate);
            System.out.println("Количество элементов в коллеции: " + priorityQueue.size());
        }
    }
}
