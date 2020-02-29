package lab5.Commands;

import lab5.Collections.SpaceMarine;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Класс команды print_unique_health
 *
 * @author Остряков Егор, P3112
 */
public class PrintUniqueHealth extends AbstractCommand {
    public PrintUniqueHealth() {
        name = "print_unique_health";
        help = " выводит уникальные значения поля health";
    }

    /**
     * Выводит уникальные значения здоровья
     *
     * @param args            значение здоровья
     * @param priorityQueue   коллекция, с которой работает пользователь
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        if (args.length != 1)
            System.out.println("Команда принимает лишь один аргумент");
        else {
            try {
                if (priorityQueue.size() > 0) {
                    HashSet<Float> healthSet = new HashSet<>(priorityQueue.size());
                    for (SpaceMarine spaceMarine : priorityQueue) {
                        healthSet.add(spaceMarine.getHealth());
                    }
                    System.out.println("Уникальные значения health: ");
                    System.out.println(healthSet);
                } else System.out.println("Список пуст");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
