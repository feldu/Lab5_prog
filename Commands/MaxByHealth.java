package lab5.Commands;

import lab5.Collections.SpaceMarine;

import java.util.PriorityQueue;

/**
 * Класс команды max_by_health
 *
 * @author Остряков Егор, P3112
 */
public class MaxByHealth extends AbstractCommand {
    public MaxByHealth() {
        name = "max_by_health";
        help = "выводит любой объект из коллекции, значение поля health которого является максимальным";
    }

    /**
     * Выводит элемент коллекции с максимальным здоровьем
     *
     * @param args            не принимает аргументов
     * @param priorityQueue   коллекция, с которой работает пользователь
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        if (args.length > 0) System.out.println("Команда не принимает аргументы");
        else {
            try {
                if (priorityQueue.size() > 0) {
                    float max = Float.MIN_VALUE;
                    SpaceMarine maxMarine = null;
                    for (SpaceMarine each : priorityQueue) {
                        if (each.getHealth() > max) {
                            max = each.getHealth();
                            maxMarine = each;
                        }
                    }
                    System.out.println("Максимальный элемент по health: " + maxMarine);
                } else System.out.println("Список пуст");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
