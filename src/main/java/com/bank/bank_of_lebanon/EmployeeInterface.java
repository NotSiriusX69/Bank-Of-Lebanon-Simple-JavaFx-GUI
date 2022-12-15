package com.bank.bank_of_lebanon;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EmployeeInterface extends Scene {

    public final Font fontFutura = Font.loadFont("src/main/fonts/futura/futura medium bt.ttf", 45);
    //Constructors
    public EmployeeInterface(BorderPane pane, double width, double height) {
        super(pane,width,height);
    }
    public ImageView LoginLogoView() throws FileNotFoundException {

        Image LoginLogo = new Image(new FileInputStream("src/main/images/Login Logo.png"));
        ImageView LoginLogoView = new ImageView(LoginLogo);

        LoginLogoView.setFitHeight(30);
        LoginLogoView.setFitWidth(30);
        LoginLogoView.setPreserveRatio(true);

        return LoginLogoView;
    }
    public ImageView LockLogoView() throws FileNotFoundException {

        Image LockLogo = new Image(new FileInputStream("src/main/images/Lock Logo.png"));
        ImageView LockLogoView = new ImageView(LockLogo);

        LockLogoView.setFitHeight(30);
        LockLogoView.setFitWidth(30);
        LockLogoView.setPreserveRatio(true);

        return LockLogoView;
    }
    public ImageView ButtonImageView(String source) throws FileNotFoundException {

        Image LockLogo = new Image(new FileInputStream(source));
        ImageView LockLogoView = new ImageView(LockLogo);

        LockLogoView.setFitHeight(30);
        LockLogoView.setFitWidth(30);
        LockLogoView.setPreserveRatio(true);

        return LockLogoView;
    }
    public BackgroundImage BankView() throws FileNotFoundException {

        Image LockLogo = new Image(new FileInputStream("src/main/images/Bank.jpg"));

        BackgroundImage BankView = new BackgroundImage(LockLogo,BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false));

        return BankView;
    }
    public HBox EmployeeTextInfoHBox() throws FileNotFoundException {

        HBox EmployeeTextInfoHBox = new HBox();
        EmployeeTextInfoHBox.setSpacing(10);
        EmployeeTextInfoHBox.setAlignment(Pos.TOP_CENTER);
        EmployeeTextInfoHBox.setPadding(new Insets(20,20,20,20));
        EmployeeTextInfoHBox.getChildren().addAll(EmployeeLogoCircle(),EmployeeTextInfoVBox());

        return EmployeeTextInfoHBox;
    }
    private Circle EmployeeLogoCircle() throws FileNotFoundException {

        Circle CircleFrame = new Circle();
        CircleFrame.setRadius(30);

        Image LoginLogo = new Image(new FileInputStream("src/main/images/Login Logo.png"));
        ImagePattern LoginLogoPattern = new ImagePattern(LoginLogo);

        CircleFrame.setFill(LoginLogoPattern);

        return CircleFrame;
    }
    private Text EmployeeId(){

        Text EmployeeId = new Text();
        EmployeeId.setFont(fontFutura);
        EmployeeId.setText("Test-1234"); //temporary


        return EmployeeId;
    }
    private Text EmployeeFirstLastName(){

        String FirstName = "Abbas";
        String LastName = "Sleiman";

        Text FirstNameLastName = new Text();
        FirstNameLastName.setFont(fontFutura);
        FirstNameLastName.setText(FirstName + " " +  LastName); //temporary

        return FirstNameLastName;
    }
    private VBox EmployeeTextInfoVBox(){

        VBox EmployeeTextInfoVBox = new VBox();
        EmployeeTextInfoVBox.setSpacing(5);
        EmployeeTextInfoVBox.setAlignment(Pos.TOP_CENTER);
        EmployeeTextInfoVBox.setPadding(new Insets(10,10,10,10));
        EmployeeTextInfoVBox.getChildren().addAll(EmployeeId(),EmployeeFirstLastName());

        return EmployeeTextInfoVBox;
    }

}
