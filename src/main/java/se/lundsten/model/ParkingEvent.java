package se.lundsten.model;

import java.time.LocalDateTime;

public class ParkingEvent {
    long id;
    String reg;
    LocalDateTime in;
    LocalDateTime out;
    long price;
    boolean paid;

    public ParkingEvent(long id){
        this.id = id;
    }
    public void setReg (String carReg){
        reg = carReg;
    }


    public void setIn (LocalDateTime carIn){
        in = carIn;
    }

    public void setOut (LocalDateTime carOut){
        out = carOut;
    }
    public void setPrice (long carPrice){
        price = carPrice;
    }
    public void setPaid (boolean carPaid){
        paid = carPaid;
    }

    public long getId() {
        return id;
    }

    public String getReg() {
        return reg;
    }

    public LocalDateTime getIn() {
        return in;
    }

    public LocalDateTime getOut() {
        return out;
    }

    public long getPrice() {
        return price;
    }

    public boolean getIsPaid() {
        return paid;
    }
}

