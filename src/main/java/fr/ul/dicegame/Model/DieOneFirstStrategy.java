package fr.ul.dicegame.Model;

import javafx.scene.control.Label;

public class DieOneFirstStrategy implements Strategy{
    @Override
    public void doRoll(DieModel d1, DieModel d2, Label l1, Label l2) {
        d1.roll();
        l1.setText(String.valueOf(d1.getValue()));
        System.out.println(l1.getText());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        d2.roll();
        l2.setText(String.valueOf(d2.getValue()));
        System.out.println(l2.getText());
    }
}
