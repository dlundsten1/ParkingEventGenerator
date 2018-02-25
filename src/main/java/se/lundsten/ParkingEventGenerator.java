package se.lundsten;
import se.lundsten.model.ParkingEvent;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;


public abstract class ParkingEventGenerator {
    public static ParkingEvent createCar(long id,LocalDateTime inTime) {

        ParkingEvent parkingEvent = new ParkingEvent(id);
        parkingEvent.setReg(randomReg());
        parkingEvent.setIn(inTime);
        parkingEvent.setPaid(false);
        return parkingEvent;
    }


    private static String randomReg() {

        String letters = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 3; i++) letters = letters + alphabet.charAt(ThreadLocalRandom.current().nextInt(alphabet.length()));
        letters = letters+ Integer.toString(ThreadLocalRandom.current().nextInt(100, 999));;
        return letters;
    }

}
