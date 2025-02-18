package es.patterndesingns.structuralpatterns.decorator.decorators;

public interface DataSource {
    void writeData(String data);

    String readData();

}
