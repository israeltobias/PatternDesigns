package es.patterndesingns.creationalpatterns.builder.builders;

import es.patterndesingns.creationalpatterns.builder.cars.CarType;
import es.patterndesingns.creationalpatterns.builder.components.Engine;
import es.patterndesingns.creationalpatterns.builder.components.GPSNavigator;
import es.patterndesingns.creationalpatterns.builder.components.Transmission;
import es.patterndesingns.creationalpatterns.builder.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}
