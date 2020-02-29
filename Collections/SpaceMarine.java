package lab5.Collections;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Класс SpaceMarine, объектами которого заполняется коллекция
 *
 * @author Остряков Егор, P3112
 */
public class SpaceMarine implements Serializable {
    public static long idSetter = 1;
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float health; //Поле не может быть null, Значение поля должно быть больше 0
    private long heartCount; //Значение поля должно быть больше 0, Максимальное значение поля: 3
    private Boolean loyal = null; //Поле может быть null
    private MeleeWeapon meleeWeapon; //Поле не может быть null
    private Chapter chapter; //Поле не может быть null

    /**
     * Конструктор класса
     *
     * @param name        имя
     * @param coordinates координаты
     * @param health      здоровье
     * @param heartCount  количество сердечек
     * @param loyal       показатель лояльности
     * @param meleeWeapon оружие ближнего боя
     * @param chapter     глава
     */
    public SpaceMarine(String name, Coordinates coordinates, Float health, Long heartCount, Boolean loyal, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.creationDate = LocalDate.now();
        setId(idSetter++);
        setName(name);
        setCoordinates(coordinates);
        setHealth(health);
        setHeartCount(heartCount);
        setLoyal(loyal);
        setMeleeWeapon(meleeWeapon);
        setChapter(chapter);
    }

    /**
     * @return id SpaceMarine
     */
    public long getId() {
        return id;
    }

    /**
     * @param id SpaceMarine
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param name имя SpaceMarine
     * @throws NullPointerException если имя не указано при вводе
     */
    public void setName(String name) throws NullPointerException {
        if (name != null && !name.isEmpty())
            this.name = name;
        else throw new NullPointerException();
    }

    /**
     * @param coordinates координаты SpaceMarine
     * @throws NullPointerException если координаты не указаны при вводе
     */
    public void setCoordinates(Coordinates coordinates) throws NullPointerException {
        if (coordinates != null)
            this.coordinates = coordinates;
        else throw new NullPointerException();
    }

    /**
     * @return здоровье SpaceMarine
     */
    public Float getHealth() {
        return health;
    }

    /**
     * @param health здоровье SpaceMarine
     * @throws NullPointerException если здоровье не указано при вводе
     */
    public void setHealth(Float health) throws NullPointerException {
        if (health != null && health > 0)
            this.health = health;
        else throw new NullPointerException();
    }

    /**
     * @param heartCount количество сердечек SpaceMarine
     * @throws NullPointerException если количество сердечек не указано при вводе
     */
    public void setHeartCount(long heartCount) throws NullPointerException {
        if (heartCount > 0 && heartCount <= 3)
            this.heartCount = heartCount;
        else throw new NullPointerException();

    }

    /**
     * @return значение лояльности SpaceMarine
     */
    public Boolean getLoyal() {
        return loyal;
    }

    /**
     * @param loyal значение лояльности SpaceMarine
     */
    public void setLoyal(Boolean loyal) {
        this.loyal = loyal;
    }

    /**
     * @param meleeWeapon оружие ближнего боя SpaceMarine
     * @throws NullPointerException если оружие ближнего боя не указано при вводе
     */
    public void setMeleeWeapon(MeleeWeapon meleeWeapon) throws NullPointerException {
        if (meleeWeapon != null)
            this.meleeWeapon = meleeWeapon;
        else throw new NullPointerException();

    }

    /**
     * @param chapter глава SpaceMarine
     * @throws NullPointerException если оружие глава не указано при вводе
     */
    public void setChapter(Chapter chapter) throws NullPointerException {
        if (chapter != null)
            this.chapter = chapter;
        else throw new NullPointerException();
    }

    /**
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * @return координаты
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return количество сердечек
     */
    public long getHeartCount() {
        return heartCount;
    }

    /**
     * @return тип оружия ближнего боя
     */
    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    /**
     * @return главу
     */
    public Chapter getChapter() {
        return chapter;
    }

    /**
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return "Космический десант с " +
                "id = " + id +
                "{имя: '" + name + '\'' +
                ", " + coordinates +
                ", дата создания: " + creationDate +
                ", здоровье: " + health +
                ", количество сердечек: " + heartCount +
                ", значение лояльности: " + loyal +
                ", оружие ближнего боя: " + meleeWeapon +
                ", " + chapter +
                "}\n";
    }

}