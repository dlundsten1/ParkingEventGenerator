package se.lundsten.repository;

import se.lundsten.ParkingEventGenerator;
import se.lundsten.model.ParkingEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class ParkingEventInMemoryRepository implements ParkingEventRepository {

    private List<ParkingEvent> parkingEventList;
    private final AtomicLong counter = new AtomicLong();
    public ParkingEventInMemoryRepository() {
        parkingEventList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            parkingEventList.add(ParkingEventGenerator.createCar(counter.incrementAndGet(), LocalDateTime.now().minusMinutes(ThreadLocalRandom.current().nextInt(2, 180))));

        }


    }
    @Override
    public ParkingEvent getCar(String reg) {
        for(ParkingEvent parkingEvent : parkingEventList){
            if (parkingEvent.getReg().equals(reg)){
                return parkingEvent;
            }
        }
        return null;
    }

    @Override
    public void addCar(ParkingEvent parkingEvent) {
        parkingEventList.add(parkingEvent);
    }

    @Override
    public List<ParkingEvent> getAllCars() {
        return parkingEventList;
    }
}
