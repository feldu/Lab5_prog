package lab5.Commands;

import lab5.Collections.SpaceMarine;

import java.util.PriorityQueue;

/**
 * Класс команды exit
 *
 * @author Остряков Егор, P3112
 */
public class Exit extends AbstractCommand {
    public Exit() {
        name = "exit";
        help = "завершает программу (без сохранения в файл)";
    }

    /**
     * Завершает работу с коллекций, выходит без сохранения
     *
     * @param args            не принимает аргументы
     * @param priorityQueue   коллекция, с которой работает пользователь
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        if (args.length > 0) System.out.println("Команда не принимает аргументы");
        else {
            System.exit(0);
        }
    }
}
