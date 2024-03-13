package com.company.buildings.logic;

/**
 * This is the House class file that extends Building.
 */

public class House extends Building {

    private String mOwner;
    private boolean mPool;

    public House(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        this.mOwner = null;
        this.mPool = false;
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner) {
        super(length, width, lotLength, lotWidth);
        this.mOwner = owner;
        this.mPool = false;
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool) {
        super(length, width, lotLength, lotWidth);
        this.mOwner = owner;
        this.mPool = pool;
    }

    public String getOwner() {
        return mOwner;
    }

    public boolean hasPool() {
        return mPool;
    }

    public void setOwner(String owner) {
        this.mOwner = owner;
    }

    public void setPool(boolean pool) {
        this.mPool = pool;
    }

    @Override
    public String toString() {
        return "Owner: " + getOwner() + "; has a big open space";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof House)) {
            return false;
        }
        House otherHouse = (House) obj;
        return this.calcBuildingArea() == otherHouse.calcBuildingArea() && this.mPool == otherHouse.mPool;
    }
}