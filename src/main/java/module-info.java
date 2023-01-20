module fr.ul.dicegame {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens fr.ul.dicegame to javafx.fxml;
    exports fr.ul.dicegame;
    exports fr.ul.dicegame.Controller;

    opens fr.ul.dicegame.Controller to javafx.fxml;
}
