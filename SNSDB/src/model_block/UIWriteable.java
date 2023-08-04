package model_block;

public interface UIWriteable <T> {

    /**
     * Интерфейс реализующий запись
     *
     * @param path   - путь записи
     * @param object - аргумент потока
     */
    void write(String path, T object);

    /**
     * Метод чтения
     */
    Object read(String path);
}
