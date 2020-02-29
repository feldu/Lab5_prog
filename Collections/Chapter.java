package lab5.Collections;

/**
 * Класс с главой SpaceMarine
 *
 * @author Остряков Егор, P3112
 */
public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String world; //Поле не может быть null

    /**
     * @param name  имя главы
     * @param world название мира
     * @throws Exception при передаче null
     */
    public Chapter(String name, String world) throws Exception {
        setName(name);
        setWorld(world);
    }

    /**
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return "глава{" +
                "имя=: '" + name + '\'' +
                ", мир: '" + world + '\'' +
                '}';
    }

    /**
     * @param name параметр сеттера имени
     */

    public void setName(String name) {
        if (name != null)
            this.name = name;
    }

    /**
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * @param world параметр сеттера названия мира
     */
    public void setWorld(String world) {
        if (world != null)
            this.world = world;
    }

    /**
     * @return мир
     */
    public String getWorld() {
        return world;
    }
}