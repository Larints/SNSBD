package model_block;

import java.io.*;

public class Loader<T extends UserDB> implements UIWriteable {


    /**
     * Метод записи в файл
     * @param path   - путь записи
     * @param output - аргумент потока
     */

    @Override
    public void write(String path, Object output) {
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(
                             new FileOutputStream(new File(path)))) {
            objectOutputStream.writeObject(output);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Метод чтения
     * @param path - путь сохранения
     * @return - возвращает объект потока
     */
    @Override
    public Object read(String path) {
        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream(new
                             FileInputStream(path))) {
            return objectInputStream.readObject();
        } catch (IOException e) {
            System.out.println("Error reading");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}