package se.lundsten.repository;

import se.lundsten.model.ParkingEvent;

import java.util.List;

public interface ParkingEventRepository {
    ParkingEvent getCar(String reg);
    void addCar(ParkingEvent parkingEvent);
    List<ParkingEvent> getAllCars();
}


