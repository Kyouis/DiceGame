package fr.ul.dicegame.Model;

public class CareTaker {
    private DiceState ds;
    private static CareTaker ct;

    private CareTaker(DiceState ds) {
        this.ds = ds;
    }

    public DiceState getDs() {
        return ds;
    }

    public static CareTaker getInstance(DiceState d) {
        if (ct == null ) {
            ct =  new CareTaker((d));
        }
        return ct;
    }
}
