package com.company.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */

public class Office extends Building {
    private String mBusinessName;
    private int mParkingSpaces;
    private static int sTotalOffices = 0;

    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        mBusinessName = null;
        mParkingSpaces = 0;
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        super(length, width, lotLength, lotWidth);
        mBusinessName = businessName;
        mParkingSpaces = 0;
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName, int parkingSpaces) {
        super(length, width, lotLength, lotWidth);
        mBusinessName = businessName;
        mParkingSpaces = parkingSpaces;
        sTotalOffices++;
    }

    public String getBusinessName() {
        return mBusinessName;
    }

    public void setBusinessName(String businessName) {
        mBusinessName = businessName;
    }

    public int getParkingSpaces() {
        return mParkingSpaces;
    }

    public void setParkingSpaces(int parkingSpaces) {
        mParkingSpaces = parkingSpaces;
    }

    @Override
    public String toString() {
        StringBuilder officeString = new StringBuilder("Business: ");
        if (mBusinessName != null) {
            officeString.append(mBusinessName);
        } else {
            officeString.append("unoccupied");
        }

        if (mParkingSpaces > 0) {
            officeString.append("; has ").append(mParkingSpaces).append(" parking spaces");
        }

        officeString.append(" (total offices: ").append(sTotalOffices).append(")");

        return officeString.toString();
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Office)) return false;

        Office otherOffice = (Office) obj;

        return super.calcBuildingArea() == otherOffice.calcBuildingArea() &&
                this.mParkingSpaces == otherOffice.mParkingSpaces;
    }

    public static int getTotalOffices() {
        return sTotalOffices;
    }
}
