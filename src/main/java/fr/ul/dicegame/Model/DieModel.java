package fr.ul.dicegame.Model;

import java.util.Random;

public class DieModel {
    private int value;

    public void roll() {
        value = new Random().nextInt(6)+1;
    }

    public int getValue() {
        return value;
    }
}
