package lab5.Collections;

/**
 * Класс с координатами SpaceMarine
 *
 * @author Остряков Егор, P3112
 */
public class Coordinates {
    private int x;
    private long y;

    /**
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return "координаты{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Конструктор
     *
     * @param x координата x
     * @param y координата y
     */
    public Coordinates(int x, long y) {
        setX(x);
        setY(y);
    }

    /**
     * @param x параметр сеттера координаты x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return координату x
     */
    public int getX() {
        return x;
    }

    /**
     * @param y параметр сеттера координаты y
     */
    public void setY(long y) {
        this.y = y;
    }

    /**
     *
     * @return координату y
     */
    public long getY() {
        return y;
    }
}