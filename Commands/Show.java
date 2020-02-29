package lab5.Commands;

import lab5.Collections.SpaceMarine;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Класс команды show
 *
 * @author Остряков Егор, P3112
 */
public class Show extends AbstractCommand {
    public Show() {
        name = "show";
        help = "выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    /**
     * Показывает элементы коллекции
     *
     * @param args            аргументы, принимаемые командой
     * @param priorityQueue   коллекция, которую нужно показать
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        if (args.length > 0) {
            System.out.println("Команда не принимает аргументы");
        } else System.out.println(Arrays.toString(priorityQueue.toArray()));
    }
}
