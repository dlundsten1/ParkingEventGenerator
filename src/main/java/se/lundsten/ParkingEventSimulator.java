package se.lundsten;

import se.lundsten.model.ParkingEvent;
import se.lundsten.repository.ParkingEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class ParkingEventSimulator {
    private final AtomicLong counter = new AtomicLong();


private static final Logger LOGGER = LoggerFactory.getLogger(ParkingEventSimulator.class);
    @Autowired
    public ParkingEventSimulator(ParkingEventRepository parkingEventRepository) {


        Timer maintainer = new Timer();
        maintainer.schedule(new TimerTask() {
            @Override
            public void run() {
                List<ParkingEvent> parkingEventList = parkingEventRepository.getAllCars();
                parkingEventList.add(ParkingEventGenerator.createCar(counter.incrementAndGet(), LocalDateTime.now().minusMinutes(ThreadLocalRandom.current().nextInt(2, 180))));

                LOGGER.info("\"En ny bil har kört in i garaget: {}", parkingEventList.get(parkingEventList.size()-1).getReg());

                for(ParkingEvent parkingEvent : parkingEventList){
                    if (parkingEvent.getOut() == null){
                        int random = ThreadLocalRandom.current().nextInt(0, 10);
                        if (random < 2){
                            parkingEvent.setOut(LocalDateTime.now());
                            parkingEvent.setPaid(true);
                            long hours = ChronoUnit.HOURS.between(parkingEvent.getIn(), parkingEvent.getOut());
                            long minutes = ChronoUnit.MINUTES.between(parkingEvent.getIn(), parkingEvent.getOut());
                            parkingEvent.setPrice((hours+1)*12);
                            LOGGER.info("{} har lämnat garaget efter {} minuter och betalat {} kr.", parkingEvent.getReg(), minutes,(hours+1)*12 );



                        }

                    }


                }
            }
        }, 0, 10 * 1000);


    }
    public void CreateParkingEvent (){




    }

}
