package com.company.buildings.logic;

import com.company.buildings.ui.OutputInterface;

/**
 * This Neighborhood utility class provides static helper methods the
 * print a Building List and calculate the area of a Building list.
 * A utility class in Java should always be final and have a private
 * constructor, as per https://en.wikipedia.org/wiki/Utility_class.
 */

public final class Neighborhood {

    private Neighborhood() {
        // Private constructor to prevent instantiation of the utility class
    }

    public static void print(Building[] buildings, String header, OutputInterface out) {
        out.print(header);
        for (Building building : buildings) {
            out.print(building.toString());
        }
    }

    public static int calcArea(Building[] buildings) {
        int totalArea = 0;
        for (Building building : buildings) {
            totalArea += building.calcLotArea();
        }
        return totalArea;
    }
}
