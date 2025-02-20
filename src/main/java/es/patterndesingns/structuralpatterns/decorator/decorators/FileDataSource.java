package es.patterndesingns.structuralpatterns.decorator.decorators;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileDataSource implements DataSource{
    private final String name;


    public FileDataSource(String name) {
        this.name = name;
    }

    @Override
    public void writeData(String data) {
        File file = new File(name);
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public String readData() {
        char[] buffer = new char[0];
        File file = new File(name);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            int charReads = reader.read(buffer);
            System.out.println("Char reads: " + charReads);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(buffer);
    }
}
