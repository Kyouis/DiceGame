package fr.ul.dicegame.Controller;

import fr.ul.dicegame.Model.DieModel;
import fr.ul.dicegame.Model.DieOneFirstStrategy;
import fr.ul.dicegame.Model.DieTwoFirstStrategy;
import fr.ul.dicegame.Model.Strategy;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class DiceGameController {
    private DieModel d1 = new DieModel();
    private DieModel d2 = new DieModel();

    private Strategy strat1 = new DieOneFirstStrategy();
    private Strategy strat2 = new DieTwoFirstStrategy();

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private RadioButton rb1;

    @FXML
    private RadioButton rb2;

    ToggleGroup tg = new ToggleGroup();

    public void initialize() {
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb1.setSelected(true);
    }

    private record HighScore(String player, int score) {}



    private int throwNumber = 0;

    public void roll() {
        int currentScore = 0;
        if (throwNumber < 10) {
            if (tg.getSelectedToggle().equals(rb1)) {
                strat1.doRoll(d1, d2, l1, l2);
            } else if (tg.getSelectedToggle().equals(rb2)) {
                strat2.doRoll(d1, d2, l1, l2);
            }
            if (d1.getValue() + d2.getValue() == 7) currentScore += 10;

            throwNumber++;
        } else {
            HighScore h = new HighScore("Jean", currentScore);
            System.out.println(currentScore);
            throwNumber = 0;
        }
    }


}
