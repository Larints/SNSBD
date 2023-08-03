package model_block;

import java.io.*;

public class Loader<T extends UserDB> implements UIWriteable {  // Класс загрузчик, который реализует через поток сохранение в файл


    /**
     * Метод записи в файл и использованием исключений
     * @param path - путь для записи
     * @param output - поток записи
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
     * @param path - путь чтения
     * @return - возврат null, если чтение не удалось
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