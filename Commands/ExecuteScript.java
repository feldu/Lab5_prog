package lab5.Commands;

import lab5.Collections.SpaceMarine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Класс команды execute_script
 *
 * @author Остряков Егор, P3112
 */
public class ExecuteScript extends AbstractCommand {
    HashSet<String> scriptsNames = new HashSet<>();

    public ExecuteScript() {
        name = "execute_script";
        help = "Запускает исполняемый скрипт";
    }

    /**
     * Исполняет указанный скрипт
     *
     * @param args            имя скрипта
     * @param priorityQueue   коллекция, с которой работает пользователь
     * @param commandsManager объект класса CommandsManager
     */
    @Override
    public void execute(String[] args, PriorityQueue<SpaceMarine> priorityQueue, CommandsManager commandsManager) {
        if (args.length != 1) System.out.println("Команда принимает лишь один аргумент");
        else {
            commandsManager.setScript(true);
            try {
                String sfn = args[0];
                commandsManager.setScriptFileName(sfn);
                commandsManager.setScriptBufferedReader(new BufferedReader(new FileReader(commandsManager.getScriptFileName())));
                String line = "";
                while (true) {
                    line = commandsManager.getScriptBufferedReader().readLine();
                    String[] nargs = line.split(" ");
                    if (nargs[0].equals("execute_script")) {
                        if (!scriptsNames.contains(nargs[1])) {
                            scriptsNames.add(sfn);
                            CommandsManager.ExecuteCommand(nargs, priorityQueue);
                        } else {
                            System.out.println("Вы не можете выполнить команду в исполняемом скрипте, которая вызывает исполняемый скрипт, содержащий команду вызова другого исполняемого скрипта, который уже исполнялся ранее");
                            System.out.println("Не удалось выполнить: execute_script " + sfn + ". Запущенные скрипты: " + scriptsNames);
                        }
                    }
                    scriptsNames.add(sfn);
                }
            } catch (NullPointerException ignored) {
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        commandsManager.setScript(false);
        scriptsNames.clear();
    }
}
