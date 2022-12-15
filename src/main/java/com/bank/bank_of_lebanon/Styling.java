package com.bank.bank_of_lebanon;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Styling {

public void ChangeButtonColor(Button btn, String id1, String id2) {

    EventHandler<ActionEvent> eventHandler = e -> {
        btn.setId(id2);
    };

    Timeline time = new Timeline(
            new KeyFrame(Duration.millis(50), eventHandler));

    btn.setOnMouseEntered(e -> {
        time.play();
        btn.setTextFill(Color.rgb(65, 95, 169));
    });

    btn.setOnMouseExited(e -> {
        time.stop();
        btn.setTextFill(Color.WHITE);
        btn.setId(id1);
    });
}

}
