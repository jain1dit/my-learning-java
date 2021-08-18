package com.ctci.OOD.ParkingLot;

import java.util.ArrayList;

public abstract class Vehicle {
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
    private String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;

    /* Park Vehicle in this spot */
    public void parkInSpot(ParkingSpot s) {
        parkingSpots.add(s);
    }

    /* Remove Car from spot, and notify spot that it's gone */
    public void clearSpots() {/*...*/}

    public abstract boolean canFitInSpot(ParkingSpot spot);

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public void setSpotsNeeded(int spotsNeeded) {
        this.spotsNeeded = spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void setSize(VehicleSize size) {
        this.size = size;
    }

}
