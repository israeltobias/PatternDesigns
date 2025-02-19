package es.patterndesingns.patterns;

import es.patterndesingns.creationalpatterns.builder.builders.CarBuilder;
import es.patterndesingns.creationalpatterns.builder.builders.CarManualBuilder;
import es.patterndesingns.creationalpatterns.builder.cars.Car;
import es.patterndesingns.creationalpatterns.builder.cars.Manual;
import es.patterndesingns.creationalpatterns.builder.director.Director;

public class BuilderPattern {
    public static void execute() {
        Director director = new Director();

        // Director gets the concrete builder object from the client
        // (application code). That's because application knows better which
        // builder to use to get a specific product.
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);
        // The final product is often retrieved from a builder object, since
        // Director is not aware and not dependent on concrete builders and
        // products.
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.print());


        CarManualBuilder manualBuilder = new CarManualBuilder();
        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());

        CarBuilder cityCarBuilder = new CarBuilder();
        director.constructCityCar(cityCarBuilder);
        Car cityCar = cityCarBuilder.getResult();
        System.out.println("\nCity car built:\n" + cityCar.print());

        CarManualBuilder suvBuilder = new CarManualBuilder();
        director.constructSUV(suvBuilder);
        Manual suv = suvBuilder.getResult();
        System.out.println("\nSUV manual built:\n" + suv.print());
    }
}
