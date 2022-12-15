package com.bank.bank_of_lebanon;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EmployeeInterface extends Scene {
    Styling style = new Styling();

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
        EmployeeId.setText("abbas123");


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
    private Rectangle Frame(double height, double width){

        Rectangle Frame = new Rectangle();
        Frame.setHeight(height);
        Frame.setWidth(width);
        Frame.setStroke(Color.rgb(65,95,169));
        Frame.setFill(Color.WHITE);

        return Frame;
    }
    //Stages Methods ( Errors / Success Operations )
    public void AddedClientStage(Stage stage) {
        Stage ClientAddedStage = new Stage();

        BorderPane pane = new BorderPane();
        VBox Vbox = new VBox();
        Vbox.setSpacing(30);
        Vbox.setPadding(new Insets(10,10,10,10));
        Vbox.setAlignment(Pos.CENTER);
        Button btn = new Button(" OK ");
        btn.setAlignment(Pos.BOTTOM_CENTER);

        btn.setTextFill(Color.WHITE);

        btn.setId("BTN");
        style.ChangeButtonColor(btn,"BTN","BTN2");

        Text text = new Text("CLIENT ADDED SUCCESSFULLY !");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        text.setFill(Color.rgb(65,95,169));

        Vbox.getChildren().addAll(text,btn);
        pane.setCenter(Vbox);

        Scene AddedClientScene = new Scene(pane, 300, 150);
        ClientAddedStage.initOwner(stage);
        // Set position of second window, related to primary window.
        ClientAddedStage.initModality(Modality.WINDOW_MODAL);
        ClientAddedStage.setX(1280 / 2.0);
        ClientAddedStage.setY(720 / 2.0);
        ClientAddedStage.setScene(AddedClientScene);
        ClientAddedStage.show();
        ClientAddedStage.setTitle("Client Added");
        ClientAddedStage.getIcons().add(new Image("C:\\Users\\User\\Desktop\\Programing\\Java\\JavaFx\\project\\Bank Of Lebanon\\src\\main\\images\\BankLogo.png"));

        btn.setOnAction(e->{
            ClientAddedStage.close();
        });

        AddedClientScene.getStylesheets().addAll("style1.css","style2.css");
    }
    public void AddedMoneyStage(Stage stage,String Text, double width) {
        Stage ClientAddedStage = new Stage();

        BorderPane pane = new BorderPane();
        VBox Vbox = new VBox();
        Vbox.setSpacing(30);
        Vbox.setPadding(new Insets(10,10,10,10));
        Vbox.setAlignment(Pos.CENTER);
        Button btn = new Button(" OK ");
        btn.setAlignment(Pos.BOTTOM_CENTER);

        btn.setTextFill(Color.WHITE);

        btn.setId("BTN");
        style.ChangeButtonColor(btn,"BTN","BTN2");

        Text text = new Text(Text);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        text.setFill(Color.rgb(65,95,169));

        Vbox.getChildren().addAll(text,btn);
        pane.setCenter(Vbox);

        Scene AddedClientScene = new Scene(pane, width, 150);
        ClientAddedStage.initOwner(stage);
        // Set position of second window, related to primary window.
        ClientAddedStage.initModality(Modality.WINDOW_MODAL);
        ClientAddedStage.setX(1280 / 2.0);
        ClientAddedStage.setY(720 / 2.0);
        ClientAddedStage.setScene(AddedClientScene);
        ClientAddedStage.show();
        ClientAddedStage.setTitle("Updated Balance");
        ClientAddedStage.getIcons().add(new Image("C:\\Users\\User\\Desktop\\Programing\\Java\\JavaFx\\project\\Bank Of Lebanon\\src\\main\\images\\BankLogo.png"));

        btn.setOnAction(e->{
            ClientAddedStage.close();
        });

        AddedClientScene.getStylesheets().addAll("style1.css","style2.css");
    }
    public void ClientHasStage(Stage stage,String Type) {
        Stage ClientHasStage = new Stage();

        BorderPane pane = new BorderPane();
        VBox Vbox = new VBox();
        Vbox.setSpacing(30);
        Vbox.setPadding(new Insets(10,10,10,10));
        Vbox.setAlignment(Pos.CENTER);
        Button btn = new Button(" OK ");
        btn.setAlignment(Pos.BOTTOM_CENTER);

        btn.setTextFill(Color.WHITE);

        btn.setId("BTN");
        style.ChangeButtonColor(btn,"BTN","BTN2");

        Text text = new Text("CLIENT ALREADY HAS " + Type + " !");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        text.setFill(Color.rgb(65,95,169));

        Vbox.getChildren().addAll(text,btn);
        pane.setCenter(Vbox);

        Scene HasClientScene = new Scene(pane, 300, 150);
        ClientHasStage.initOwner(stage);
        // Set position of second window, related to primary window.
        ClientHasStage.initModality(Modality.WINDOW_MODAL);
        ClientHasStage.setX(1280 / 2.0);
        ClientHasStage.setY(720 / 2.0);
        ClientHasStage.setScene(HasClientScene);
        ClientHasStage.show();
        ClientHasStage.setTitle("Client Error");
        ClientHasStage.getIcons().add(new Image("C:\\Users\\User\\Desktop\\Programing\\Java\\JavaFx\\project\\Bank Of Lebanon\\src\\main\\images\\BankLogo.png"));

        btn.setOnAction(e->{
            ClientHasStage.close();
        });

        HasClientScene.getStylesheets().addAll("style1.css","style2.css");
    }
    public void ErrorClientStage(Stage stage) {
        Stage ErrorStage = new Stage();

        BorderPane pane = new BorderPane();
        VBox Vbox = new VBox();
        Vbox.setSpacing(30);
        Vbox.setPadding(new Insets(10,10,10,10));
        Vbox.setAlignment(Pos.CENTER);
        Button btn = new Button(" OK ");
        btn.setAlignment(Pos.BOTTOM_CENTER);

        btn.setTextFill(Color.WHITE);

        btn.setId("BTN");
        style.ChangeButtonColor(btn,"BTN","BTN2");

        Text text = new Text("ERROR PLEASE CHECK ALL FIELDS !");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        text.setFill(Color.rgb(65,95,169));

        Vbox.getChildren().addAll(text,btn);
        pane.setCenter(Vbox);

        btn.setOnAction(e->{
            ErrorStage.close();
        });
        Scene ErrorScene = new Scene(pane, 300, 150);
        ErrorStage.initOwner(stage);
        // Set position of second window, related to primary window.
        ErrorStage.initModality(Modality.WINDOW_MODAL);
        ErrorStage.setX(1280 / 2.0);
        ErrorStage.setY(720 / 2.0);
        ErrorStage.setScene(ErrorScene);
        ErrorStage.show();
        ErrorStage.setTitle("Error");
        ErrorStage.getIcons().add(new Image("C:\\Users\\User\\Desktop\\Programing\\Java\\JavaFx\\project\\Bank Of Lebanon\\src\\main\\images\\BankLogo.png"));
        ErrorScene.getStylesheets().addAll("style1.css","style2.css");

    }
    public void ErrorEmployeeStage(Stage stage) {
        Stage ErrorStage = new Stage();

        BorderPane pane = new BorderPane();
        VBox Vbox = new VBox();
        Vbox.setSpacing(30);
        Vbox.setPadding(new Insets(10,10,10,10));
        Vbox.setAlignment(Pos.CENTER);
        Button btn = new Button(" OK ");
        btn.setAlignment(Pos.BOTTOM_CENTER);

        btn.setTextFill(Color.WHITE);

        btn.setId("BTN");
        style.ChangeButtonColor(btn,"BTN","BTN2");

        Text text = new Text("ERROR EITHER PASSWORD OR ID ARE INCORRECT !");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        text.setFill(Color.rgb(65,95,169));

        Vbox.getChildren().addAll(text,btn);
        pane.setCenter(Vbox);

        btn.setOnAction(e->{
            ErrorStage.close();
        });
        Scene ErrorScene = new Scene(pane, 450, 150);
        ErrorStage.initOwner(stage);
        // Set position of second window, related to primary window.
        ErrorStage.initModality(Modality.WINDOW_MODAL);
        ErrorStage.setX(1280 / 2.0);
        ErrorStage.setY(720 / 2.0);
        ErrorStage.setScene(ErrorScene);
        ErrorStage.show();
        ErrorStage.setTitle("Error");
        ErrorStage.getIcons().add(new Image("C:\\Users\\User\\Desktop\\Programing\\Java\\JavaFx\\project\\Bank Of Lebanon\\src\\main\\images\\BankLogo.png"));
        ErrorScene.getStylesheets().addAll("style1.css","style2.css");

    }
    public void ErrorNotFoundStage(Stage stage) {
        Stage ErrorStage = new Stage();

        BorderPane pane = new BorderPane();
        VBox Vbox = new VBox();
        Vbox.setSpacing(30);
        Vbox.setPadding(new Insets(10,10,10,10));
        Vbox.setAlignment(Pos.CENTER);
        Button btn = new Button(" OK ");
        btn.setAlignment(Pos.BOTTOM_CENTER);

        btn.setTextFill(Color.WHITE);

        btn.setId("BTN");
        style.ChangeButtonColor(btn,"BTN","BTN2");

        Text text = new Text("ERROR ID NOT FOUND !");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        text.setFill(Color.rgb(65,95,169));

        Vbox.getChildren().addAll(text,btn);
        pane.setCenter(Vbox);

        btn.setOnAction(e->{
            ErrorStage.close();
        });
        Scene ErrorScene = new Scene(pane, 300, 150);
        ErrorStage.initOwner(stage);
        // Set position of second window, related to primary window.
        ErrorStage.initModality(Modality.WINDOW_MODAL);
        ErrorStage.setX(1280 / 2.0);
        ErrorStage.setY(720 / 2.0);
        ErrorStage.setScene(ErrorScene);
        ErrorStage.show();
        ErrorStage.setTitle("Not Found");
        ErrorStage.getIcons().add(new Image("C:\\Users\\User\\Desktop\\Programing\\Java\\JavaFx\\project\\Bank Of Lebanon\\src\\main\\images\\BankLogo.png"));
        ErrorScene.getStylesheets().addAll("style1.css","style2.css");

    }
    public void ErrorNotCalculatedStage(Stage stage) {
        Stage ErrorStage = new Stage();

        BorderPane pane = new BorderPane();
        VBox Vbox = new VBox();
        Vbox.setSpacing(30);
        Vbox.setPadding(new Insets(10,10,10,10));
        Vbox.setAlignment(Pos.CENTER);
        Button btn = new Button(" OK ");
        btn.setAlignment(Pos.BOTTOM_CENTER);

        btn.setTextFill(Color.WHITE);

        btn.setId("BTN");
        style.ChangeButtonColor(btn,"BTN","BTN2");

        Text text = new Text("PLEASE CALCULATE LOAN !");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        text.setFill(Color.rgb(65,95,169));

        Vbox.getChildren().addAll(text,btn);
        pane.setCenter(Vbox);

        btn.setOnAction(e->{
            ErrorStage.close();
        });
        Scene ErrorScene = new Scene(pane, 300, 150);
        ErrorStage.initOwner(stage);
        // Set position of second window, related to primary window.
        ErrorStage.initModality(Modality.WINDOW_MODAL);
        ErrorStage.setX(1280 / 2.0);
        ErrorStage.setY(720 / 2.0);
        ErrorStage.setScene(ErrorScene);
        ErrorStage.show();
        ErrorStage.setTitle("Not Calculated");
        ErrorStage.getIcons().add(new Image("C:\\Users\\User\\Desktop\\Programing\\Java\\JavaFx\\project\\Bank Of Lebanon\\src\\main\\images\\BankLogo.png"));
        ErrorScene.getStylesheets().addAll("style1.css","style2.css");

    }
    public void DataBaseConnectivity(Stage stage){
        Stage DatabaseConnectivity = new Stage();

        ClientsDatabaseManip db = new ClientsDatabaseManip();
        boolean DbConnected = db.connect();
        BorderPane pane = new BorderPane();

        VBox Vbox = new VBox();
        Vbox.setSpacing(30);
        Vbox.setPadding(new Insets(10, 10, 10, 10));
        Vbox.setAlignment(Pos.CENTER);
        Button btn = new Button(" OK ");
        btn.setAlignment(Pos.BOTTOM_CENTER);

        Text text = new Text("ERROR PLEASE CHECK ALL FIELDS !");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        text.setFill(Color.rgb(65, 95, 169));

        btn.setTextFill(Color.WHITE);

        Vbox.getChildren().addAll(text, btn);
        pane.setCenter(Vbox);

        btn.setOnAction(e -> {
            DatabaseConnectivity.close();
        });

        btn.setId("BTN");
        style.ChangeButtonColor(btn, "BTN", "BTN2");

        if(DbConnected) {
            text.setText("CONNECTION AND DATABASE ARE SECURE !");
        }else
            text.setText("CONNECTION FAILED !");

        Scene DataScene = new Scene(pane, 350, 150);
        DatabaseConnectivity.initOwner(stage);
        // Set position of second window, related to primary window.
        DatabaseConnectivity.initModality(Modality.WINDOW_MODAL);
        DatabaseConnectivity.setX(1280 / 2.0);
        DatabaseConnectivity.setY(720 / 2.0);
        DatabaseConnectivity.setScene(DataScene);
        DatabaseConnectivity.show();
        DatabaseConnectivity.setTitle("Database Connection");
        DatabaseConnectivity.getIcons().add(new Image("C:\\Users\\User\\Desktop\\Programing\\Java\\JavaFx\\project\\Bank Of Lebanon\\src\\main\\images\\BankLogo.png"));
        DataScene.getStylesheets().addAll("style1.css", "style2.css");

    }
    public void ManageClientStage(Stage stage) {
        //Declare Panes and Nodes
        Stage ClientAddedStage = new Stage();
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10,10,10,10));

        //Employee Account Info Template ( no database )
        TextField EmpId = new TextField("abbas123");
        TextField Email = new TextField("abbas100@gmail.com");
        TextField Password = new TextField("abbas100");
        TextField Salary = new TextField("1200");

        EmpId.setEditable(false);
        Email.setEditable(false);
        Password.setEditable(false);
        Salary.setEditable(false);

        Label EmpIdL = new Label("Employee ID");
        Label EmailL = new Label("Email");
        Label PasswordL = new Label("Password");
        Label SalaryL = new Label("Salary");

        Text TEXT = new Text("ACCOUNT INFO");
        TEXT.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        TEXT.setFill(Color.rgb(65,95,169));

        gridPane.add(TEXT,0,0);

        gridPane.add(EmpIdL,0,1);
        gridPane.add(EmpId,1,1);

        gridPane.add(EmailL, 0, 2);
        gridPane.add(Email, 1, 2);

        gridPane.add(PasswordL, 0, 3);
        gridPane.add(Password, 1, 3);

        gridPane.add(SalaryL, 0, 4);
        gridPane.add(Salary, 1, 4);

        pane.getChildren().addAll(Frame(450,450),gridPane);

        Scene AddedClientScene = new Scene(pane, 500, 500);
        ClientAddedStage.initOwner(stage);

        // Set position of second window, related to primary window.
        ClientAddedStage.initModality(Modality.WINDOW_MODAL);
        ClientAddedStage.setX(600);
        ClientAddedStage.setY(100);
        ClientAddedStage.setScene(AddedClientScene);
        ClientAddedStage.show();
        ClientAddedStage.setTitle("Account Info");
        ClientAddedStage.getIcons().add(new Image("C:\\Users\\User\\Desktop\\Programing\\Java\\JavaFx\\project\\Bank Of Lebanon\\src\\main\\images\\BankLogo.png"));
        AddedClientScene.getStylesheets().addAll("style1.css","style2.css");
    }

}
