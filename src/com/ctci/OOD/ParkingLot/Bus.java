package com.ctci.OOD.ParkingLot;

public class Bus extends Vehicle {

    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }

    /* check if the spot is a large. Doesn't check num of spots*/
    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return false;
    }
}
