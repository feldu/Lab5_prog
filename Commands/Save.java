package lab5.Commands;

import lab5.InputHandler;
import lab5.Collections.SpaceMarine;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.PriorityQueue;

/**
 * Класс команды save
 *
 * @author Остряков Егор, P3112
 */
public class Save extends AbstractCommand {
    public Save() {
        name = "save";
        help = "сохраняет коллекцию в файл";
    }

    /**
     * Сохраняет коллекцию в файл
     *
     * @param args            не принимает аргументов
     * @param priorityQueue   коллекция, которую нужно сохоранить
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        if (args.length > 0) System.out.println("Команда не принимает аргументы");
        else {
            try (FileWriter fw = new FileWriter(InputHandler.arguments[0]); CSVWriter writer = new CSVWriter(fw, InputHandler.arguments[1].charAt(0), '"', '"', "\n")) {
                for (SpaceMarine spaceMarine : priorityQueue)
                    writer.writeNext(new String[]{spaceMarine.getName(), String.valueOf(spaceMarine.getCoordinates().getX()), String.valueOf(spaceMarine.getCoordinates().getY()), spaceMarine.getHealth().toString(), String.valueOf(spaceMarine.getHeartCount()), spaceMarine.getLoyal() == null ? "" : String.valueOf(spaceMarine.getLoyal()), spaceMarine.getMeleeWeapon().name(), spaceMarine.getChapter().getName(), spaceMarine.getChapter().getWorld()});
                System.out.println("Коллекция успешно сохранена");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
