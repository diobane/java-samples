package gao.studies.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Giovanny", "Masculino", 24));
        pessoas.add(new Pessoa("Ana Paula", "Feminino", 23));

        String filePath = getFilePath();
        writeObjectsToFile(pessoas, filePath);
        readPersonsFromFile();
    }

    private static String getFilePath() {
        String separator = File.separator;
        return MessageFormat.format("D:{0}Giovanny{0}Desktop{0}teste{0}serial.bin", separator);
    }

    private static void writeObjectsToFile(List<Pessoa> objects, String filePath) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objects.forEach(object -> {
                try {
                    objectOutputStream.writeObject(object);
                } catch(IOException exception) {
                    System.out.println(exception.getMessage());
                }
            });
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void readPersonsFromFile() {
        try(FileInputStream fileInputStream = new FileInputStream(new File("D:\\Giovanny\\Desktop\\teste\\serial.bin"));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Pessoa readPessoa1 = (Pessoa) objectInputStream.readObject();
            Pessoa readPessoa2 = (Pessoa) objectInputStream.readObject();

            System.out.println(readPessoa1.toString());
            System.out.println("---------");
            System.out.println(readPessoa2.toString());
        } catch(IOException | ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}