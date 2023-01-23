package fr.ul.dicegame.Model;

import java.util.Objects;

public class DiceState {
    private int nbTour;
    private int currentScore;
    private int d1Value;
    private int d2Value;


    public DiceState(int n, int c, int un, int deux) {
        nbTour = n;
        currentScore = c;
        d1Value = un;
        d2Value = deux;
    }



    public int getNbTour() {
        return nbTour;
    }

    public void setNbTour(int nbTour) {
        this.nbTour = nbTour;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getD1Value() {
        return d1Value;
    }

    public void setD1Value(int d1Value) {
        this.d1Value = d1Value;
    }

    public int getD2Value() {
        return d2Value;
    }

    public void setD2Value(int d2Value) {
        this.d2Value = d2Value;
    }
}
