package lab5.Commands;

import lab5.Collections.SpaceMarine;

import java.util.PriorityQueue;

/**
 * Класс команды help
 *
 * @author Остряков Егор, P3112
 */
public class Help extends AbstractCommand {
    public Help() {
        name = "help";
        help = "выводит справку по доступным командам";
    }

    /**
     * Выводит справку по командам
     *
     * @param args            не принимает аргументов
     * @param priorityQueue   коллекция, с которой работает пользователь
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        if (args.length > 0) {
            System.out.println("На данном этапе команда не принимает аргументы");
        } else
            for (AbstractCommand command : commandsManager.getCommands())
                System.out.println("Команда " + command.getName() + ": " + command.getHelp());
    }
}
