package se.lundsten;

import org.junit.Test;
import se.lundsten.model.ParkingEvent;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static se.lundsten.ParkingEventGenerator.createCar;

public class ParkingEventGeneratorTest {
    @Test
    public void createCarTestSuccessful() {
        ParkingEvent parkingEvent = createCar(01, LocalDateTime.now());
        assertThat(parkingEvent.getId()).isEqualTo(01);
        assertThat(parkingEvent.getOut()).isNull();
    }
}
