package fr.ul.dicegame.Model;

import javafx.scene.control.Label;

public interface Strategy {


    public void doRoll(DieModel d1, DieModel d2, Label l1, Label l2);
}
