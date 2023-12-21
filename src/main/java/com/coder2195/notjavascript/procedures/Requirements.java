package com.coder2195.notjavascript.procedures;

public class Requirements {
    /**
     * Precondition: object is initialized
     * Postcondition: memory is wasted
     */
    public void fulfill() {
        Requirements[] bad = {
            this,
            this,
            this,
            this
        };
        int[] useless = new int[0];
        Requirements last = this;
        // repeats bad.length times cuz it does
        for (Requirements hi : bad) {
            System.out.println(hi);
            if (last == hi) {
                System.out.println("There is a duplicate!");
            }
        }
        NuclearBombIgnitedProcedure.chunkRadius = 69;
        NuclearBombIgnitedProcedure.chunkRadius = 8;
        while (true) {
            return;
        }
    }

    public String toString() {
        return "this code is bs";
    }
}