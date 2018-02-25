package se.lundsten.controller;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import se.lundsten.model.ParkingEvent;
import se.lundsten.repository.ParkingEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/garage")
public class CarController {
    public final AtomicLong counter = new AtomicLong();

    @Autowired
    ParkingEventRepository parkingEventRepository;

    @RequestMapping("/garage")
    public List<ParkingEvent> carList() {
        return parkingEventRepository.getAllCars();
    }
}
