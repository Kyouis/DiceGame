package fr.ul.dicegame.Controller;

import fr.ul.dicegame.Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class DiceGameController {
    private DieModel d1 = new DieModel();
    private DieModel d2 = new DieModel();

    private Strategy strat1 = new DieOneFirstStrategy();
    private Strategy strat2 = new DieTwoFirstStrategy();

    private CareTaker ct;

    private XmlMapper map = new

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Label score;
    @FXML
    private RadioButton rb1;

    @FXML
    private RadioButton rb2;

    @FXML
    private Label lthrow;

    private ToggleGroup tg = new ToggleGroup();

    private DiceState d = new DiceState(0,0,0,0);

    private int currentScore = 0;

    public void initialize() {
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb1.setSelected(true);
        ct = CareTaker.getInstance(d);
    }

    private int throwNumber = 0;

    public void save() {
        CareTaker.getInstance(d).getDs().setCurrentScore(currentScore);
        CareTaker.getInstance(d).getDs().setNbTour(throwNumber);
        CareTaker.getInstance(d).getDs().setD1Value(Integer.parseInt(l1.getText()));
        CareTaker.getInstance(d).getDs().setD2Value(Integer.parseInt(l2.getText()));
    }

    public void load() {
        currentScore = CareTaker.getInstance(d).getDs().getCurrentScore();
        throwNumber = CareTaker.getInstance(d).getDs().getNbTour();
        lthrow.setText("Lancé n°: "+throwNumber);
        l1.setText(String.valueOf(CareTaker.getInstance(d).getDs().getD1Value()));
        l2.setText(String.valueOf(CareTaker.getInstance(d).getDs().getD2Value()));
    }

    public void roll() {
        if (throwNumber < 10) {
            if (tg.getSelectedToggle().equals(rb1)) {
                strat1.doRoll(d1, d2, l1, l2);
            } else if (tg.getSelectedToggle().equals(rb2)) {
                strat2.doRoll(d1, d2, l1, l2);
            }
            if (d1.getValue() + d2.getValue() == 7) {
                currentScore += 10;
                score.setText("Score : "+currentScore);
            }

            throwNumber++;
            lthrow.setText("Lancé n°: "+throwNumber);
        } else {
            HighScore h = new HighScore("Jean", currentScore);
            throwNumber = 0;
            currentScore = 0;
        }
    }


}
