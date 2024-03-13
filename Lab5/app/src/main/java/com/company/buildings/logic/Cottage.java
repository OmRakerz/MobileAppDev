package com.company.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */

public class Cottage extends House {

    private final boolean mSecondFloor;

    public Cottage(int dimension, int lotLength, int lotWidth) {
        super(dimension, dimension, lotLength, lotWidth);
        this.mSecondFloor = false;
    }

    public Cottage(int dimension, int lotLength, int lotWidth, String owner, boolean secondFloor) {
        super(dimension, dimension, lotLength, lotWidth, owner);
        this.mSecondFloor = secondFloor;
    }

    public boolean hasSecondFloor() {
        return mSecondFloor;
    }

    @Override
    public String toString() {
        String result = "Cottage - Area: " + super.calcBuildingArea() + " sq.ft, Lot Area: " + super.calcLotArea()
                + " sq.ft, Owner: " + super.getOwner();

        if (mSecondFloor) {
            result += ", Second Floor: Yes";
        } else {
            result += ", Second Floor: No";
        }

        return result;
    }
}

