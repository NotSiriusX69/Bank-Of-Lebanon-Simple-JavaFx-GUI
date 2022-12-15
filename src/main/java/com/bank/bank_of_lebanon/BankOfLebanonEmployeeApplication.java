package com.bank.bank_of_lebanon;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class BankOfLebanonEmployeeApplication extends Application {

    //Get User ID Through textField and initialize it to this Variable
    private int ID;
    ClientsDatabaseManip cdm = new ClientsDatabaseManip();
    AccountsDatabaseManip adm = new AccountsDatabaseManip();

    ObservableList<Client> clients_observable = cdm.getClientList();
    ObservableList<Account> accounts_observable = adm.getAccountList();

    //CheckClients Pane and Scene
    BorderPane CheckClientsBorderPane = new BorderPane();
    EmployeeInterface CheckClientsInterface = new EmployeeInterface(CheckClientsBorderPane,1290,720);

    //CheckAccounts Pane and Scene
    BorderPane CheckAccountsBorderPane = new BorderPane();
    EmployeeInterface CheckAccountsInterface = new EmployeeInterface(CheckAccountsBorderPane,1290,720);

    //AddClient Pane and Scene
    BorderPane AddClientBorderPane = new BorderPane();
    EmployeeInterface AddClientInterface = new EmployeeInterface(AddClientBorderPane,1290,720);

    //MoneyClient Pane and Scene
    BorderPane MoneyClientBorderPane = new BorderPane();
    EmployeeInterface MoneyClientInterface = new EmployeeInterface(MoneyClientBorderPane,1290,720);

    //Login Pane and Scene
    BorderPane LoginBorderPane = new BorderPane();
    EmployeeInterface LoginInterface = new EmployeeInterface(LoginBorderPane,1290,720);

    //Employee Management and Info Scene
    BorderPane EmployeeManageBorderPane = new BorderPane();
    EmployeeInterface EmployeeInterface = new EmployeeInterface(EmployeeManageBorderPane,1290,720);

    //Style for CSS
    Styling style = new Styling();

    public BankOfLebanonEmployeeApplication() throws SQLException, ClassNotFoundException {
    }

    //Start Method
    @Override
    public void start(Stage stage) throws IOException, SQLException, ClassNotFoundException {

        cdm.connect();
        cdm.CreateClientsTable();
        adm.CreateAccountsTable();
        //tdm.CreateTransactionsTable();

        //Set the LoginForm[StakePane] to center in the LoginBorderPane
        Background LoginBackGround = new Background(EmployeeInterface.BankView());
        LoginBorderPane.setRight(LoginForm(stage));
        LoginBorderPane.setBackground(LoginBackGround);

        //Set the ManageClientForm[GridPane] to center in the ManagerBorderPane
        EmployeeManageBorderPane.setCenter(ManageClientFlowPane(stage));

        //Set the EmployeeForm[StakePane] to left in the ManagerBorderPane
        EmployeeManageBorderPane.setLeft(EmployeeForm(stage));

        //Set the AddClientForm[StakePane] to center in the AddClientBorder
        AddClientBorderPane.setCenter(AddClientForm(stage));

        //Set the CheckClientForm[FlowPane] to center in the CheckClientsBorder
        CheckClientsBorderPane.setCenter(CheckClientsForm(stage));

        MoneyClientBorderPane.setCenter(ClientMoneyPane(stage));

        CheckAccountsBorderPane.setCenter(CheckAccountsForm(stage));

        //Add CSS StyleSheets
        LoginInterface.getStylesheets().addAll("style1.css","style2.css");
        EmployeeInterface.getStylesheets().addAll("style1.css","style2.css");
        AddClientInterface.getStylesheets().addAll("style1.css","style2.css");
        MoneyClientInterface.getStylesheets().addAll("style1.css","style2.css");
        CheckClientsInterface.getStylesheets().addAll("style1.css","style2.css");
        CheckAccountsInterface.getStylesheets().addAll("style1.css","style2.css");

        stage.setTitle("Bank Of Lebanon");
        stage.setScene(LoginInterface);
        stage.getIcons().add(new Image("C:\\Users\\User\\Desktop\\Programing\\Java\\JavaFx\\project\\Bank Of Lebanon\\src\\main\\images\\BankLogo.png"));
        stage.show();
    }

    //Main kept for testing purposes
    public static void main(String[] args) {
        launch();
    }

    //Client Management parts
    private Button ManageClientButton(String text, double width, double height){
        Button AddClientButton = new Button();
        AddClientButton.setText(text);
        AddClientButton.setMinWidth(width);
        AddClientButton.setMinHeight(height);
        return AddClientButton;
    }
    private TextField ManageClientTextField(String PromptText){
        TextField AddClientTextField = new TextField();
        AddClientTextField.setPromptText(PromptText);
        return AddClientTextField;
    }
    private Label ManageClientLabel(String Text){
        Label AddClientLabel = new Label();
        AddClientLabel.setText(Text);
        return AddClientLabel;
    }

    //Client Add Management GridPane parts
    private ComboBox<String> AddClientComboBox(String Text, String[] array){
        ComboBox<String> AddClientComboBox =
                new ComboBox<>(FXCollections
                        .observableArrayList(array));
        AddClientComboBox.setPromptText(Text);
        return AddClientComboBox;
    }
    private RadioButton AddClientRadioButton(String Text, ToggleGroup toggleGroup){
        RadioButton AddClientRadioButton = new RadioButton(Text);
        AddClientRadioButton.setToggleGroup(toggleGroup);
        return AddClientRadioButton;

    }
    private HBox AddClientCitiesHBox(ComboBox comboBox){
        HBox AddClientHBox = new HBox();
        AddClientHBox.setAlignment(Pos.CENTER);
        AddClientHBox.setSpacing(5);
        AddClientHBox.setPadding(new Insets(5,5,5,5));
        AddClientHBox.getChildren().addAll(comboBox);
        return AddClientHBox;
    }
    private HBox AddClientBirthDateHBox(ComboBox comboBox1,ComboBox comboBox2,ComboBox comboBox3){
        HBox AddClientHBox = new HBox();
        AddClientHBox.setAlignment(Pos.CENTER);
        AddClientHBox.setSpacing(5);
        AddClientHBox.setPadding(new Insets(5,5,5,5));
        AddClientHBox.getChildren().addAll(comboBox1,comboBox2,comboBox3);
        return AddClientHBox;
    }
    private HBox AddClientRadioHBox(RadioButton rd1, RadioButton rd2){
        HBox AddClientHBox = new HBox();
        AddClientHBox.setAlignment(Pos.CENTER);
        AddClientHBox.setSpacing(5);
        AddClientHBox.setPadding(new Insets(5,5,5,5));
        AddClientHBox.getChildren().addAll(rd1,rd2);
        return AddClientHBox;
    }
    private HBox AddClientButtonsHBox(Button btn1, Button btn2, Button btn3){
        HBox ClientButtons = new HBox();
        ClientButtons.setSpacing(5);
        ClientButtons.setAlignment(Pos.CENTER_RIGHT);
        ClientButtons.setPadding(new Insets(5,5,5,5));
        ClientButtons.getChildren().addAll(btn1,btn2,btn3);
        return ClientButtons;
    }

    //All Major panes and Non_Major panes will use this Frame with different sizes ( For Styling )
    private Rectangle Frame(double height, double width){

        Rectangle Frame = new Rectangle();
        Frame.setHeight(height);
        Frame.setWidth(width);
        Frame.setStroke(Color.rgb(65,95,169));
        Frame.setFill(Color.WHITE);

        return Frame;
    }

    //Money Related Panes and Stages ( For Account Class )
    private Pane ClientMoneyPane(Stage stage){
        //Declare Nodes andPanes
        BorderPane ClientMoneyPane = new BorderPane();
        GridPane ClientMoneyGridPane = new GridPane();
        HBox ClientMoneyHBox = new HBox();
        VBox vbox = new VBox();
        HBox ButtonsHBox = new HBox();
        StackPane ButtonsStackPane = new StackPane();
        TextField SearchField = ManageClientTextField("Account Number");
        TextField AccountNb = ManageClientTextField("Account Number");
        Label SearchL = ManageClientLabel("Search Account");
        Label AccountL = ManageClientLabel("Account ID");

        ClientMoneyGridPane.setVgap(20);
        ClientMoneyGridPane.setHgap(20);
        ClientMoneyGridPane.setAlignment(Pos.CENTER);

        ClientMoneyHBox.setAlignment(Pos.CENTER);
        ClientMoneyHBox.setSpacing(15);

        Button Loan = ManageClientButton("Loan",200,250);
        Loan.setTextFill(Color.WHITE);
        Loan.setId("BTN");//SET CSS ID
        style.ChangeButtonColor(Loan,"BTN","BTN2");//To change button color and hover

        Button Interest = ManageClientButton("Interest",200,250);
        Interest.setTextFill(Color.WHITE);
        Interest.setId("BTN");//SET CSS ID
        style.ChangeButtonColor(Interest,"BTN","BTN2");//To change button color and hover

        Button Deposit = ManageClientButton("Deposit",200,250);
        Deposit.setTextFill(Color.WHITE);
        Deposit.setId("BTN");//SET CSS ID
        style.ChangeButtonColor(Deposit,"BTN","BTN2");//To change button color and hover

        Button Withdraw = ManageClientButton("Withdraw",200,250);
        Withdraw.setTextFill(Color.WHITE);
        Withdraw.setId("BTN");//SET CSS ID
        style.ChangeButtonColor(Withdraw,"BTN","BTN2");//To change button color and hover

        Button btSearchClient = new Button("Search Account");
        btSearchClient.setTextFill(Color.WHITE);
        btSearchClient.setId("BTN");
        style.ChangeButtonColor(btSearchClient,"BTN","BTN2");

        Button Back = ManageClientButton(" Back ",30,15);
        Back.setTextFill(Color.WHITE);
        Back.setId("BTN");
        style.ChangeButtonColor(Back,"BTN","BTN2");

        SearchField.setPrefWidth(200);
        AccountNb.setEditable(false);

        //Button functions
        btSearchClient.setOnAction(e->{
            try { // Get the ID to be used in the loan and interest and withdraw and deposit scenes
                if(adm.isIdExist(GeneralUtil.GetInt(SearchField))) { // If ID is found in database
                    AccountNb.setText(SearchField.getText());
                    ID = GeneralUtil.GetInt(SearchField); // Assign the Client's ID from the TextField value
                }
                if(!adm.isIdExist(GeneralUtil.GetInt(SearchField))){ // If ID is not found in database
                    EmployeeInterface.ErrorNotFoundStage(stage); // Call the Error Stage
                    AccountNb.clear(); // Clear the TextField
                    ID = 0; // Assign 0 to the ID
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        Loan.setOnAction(e->{
            try {
                Loan(stage);
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        Interest.setOnAction(e->{
            try {
                Interest(stage);
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        Deposit.setOnAction(e->{
            try {
                Deposit(stage);
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        Withdraw.setOnAction(e->{
            try {
                Withdraw(stage);
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        Back.setOnAction(e->{
            stage.setScene(EmployeeInterface);
            AccountNb.clear();
        });

        ButtonsHBox.getChildren().addAll(Back,SearchL,SearchField,btSearchClient,AccountL, AccountNb);
        ButtonsHBox.setAlignment(Pos.CENTER);
        ButtonsHBox.setPadding(new Insets(25,25,25,25));
        ButtonsHBox.setSpacing(25);

        vbox.setAlignment(Pos.CENTER);

        ButtonsStackPane.setPadding(new Insets(15,15,15,15));
        ButtonsStackPane.getChildren().addAll(Frame(50,850),ButtonsHBox);
        ButtonsStackPane.setAlignment(Pos.CENTER);

        ClientMoneyHBox.getChildren().addAll(Loan,Interest,Withdraw,Deposit);
        vbox.getChildren().addAll(ButtonsStackPane, ClientMoneyHBox);
        ClientMoneyPane.setCenter(vbox);
        return ClientMoneyPane;
    }
    private void Loan(Stage stage) throws SQLException, ClassNotFoundException {
        Stage Loan = new Stage();
        BorderPane pane = new BorderPane();
        StackPane LoanStackPane = new StackPane();

        Loan loan = new Loan();

        Scene YearlyLoanScene = new Scene(pane, 720, 650);
        YearlyLoanScene.getStylesheets().addAll("Style1.css", "Style2.css");

        Text YearlyLoanText = new Text("YEARLY LOAN");
        YearlyLoanText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        YearlyLoanText.setFill(Color.rgb(65,95,169));

        TextField AccountNB = ManageClientTextField("Account ID");
        AccountNB.setText(Integer.toString(ID));

        TextField tfYears = ManageClientTextField("Number of years");
        TextField tfInterest = ManageClientTextField("Interest rate");
        TextField tfLoanAmount = ManageClientTextField("Loan Amount");
        TextField tfInterestValue = ManageClientTextField("Total Payment");
        Button btCalculate = new Button("Calculate Loan Amount");

        btCalculate.setTextFill(Color.WHITE);
        btCalculate.setId("BTN");//SET CSS ID
        style.ChangeButtonColor(btCalculate,"BTN","BTN2");

        Button btAddToClient = new Button("Add Loan To Client");

        btAddToClient.setTextFill(Color.WHITE);
        btAddToClient.setId("BTN");//SET CSS ID
        style.ChangeButtonColor(btAddToClient,"BTN","BTN2");

        //Buttons functions
        btCalculate.setOnAction(e->{
            //Calculate loan
            loan.calculateLoan(tfYears,tfInterest,tfLoanAmount,tfInterestValue);
        });
        btAddToClient.setOnAction(e->{
            try {
                if(adm.GetBoolean("isLoan", ID)) {
                    EmployeeInterface.ClientHasStage(stage, "LOAN");
                } else{
                    try{
                        double LoanAmount = Double.parseDouble(tfInterestValue.getText());
                        if(Double.parseDouble(tfInterestValue.getText()) == 0 || tfInterestValue.getText().isEmpty()) { //if TextFields are empty
                            EmployeeInterface.ErrorNotCalculatedStage(stage);
                        }else{
                            //Update values to the database
                            adm.UpdateDoubleAccount("LoanAmount",LoanAmount,ID);
                            adm.UpdateBooleanAccount("isLoan",true,ID);
                            EmployeeInterface.AddedMoneyStage(stage,"ADDED LOAN SUCCESSFULLY !",300);
                        }
                    }catch (NumberFormatException nfe){
                        EmployeeInterface.ErrorNotFoundStage(stage);
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(25);

        gridPane.add(YearlyLoanText,0,0);
        gridPane.add(new Label("Account ID"),0,1);
        gridPane.add(AccountNB,1,1);
        gridPane.add(new Label("Years"), 0, 2);
        gridPane.add(tfYears, 1, 2);
        gridPane.add(new Label("Interest Rate"), 0, 3);
        gridPane.add(tfInterest, 1, 3);
        gridPane.add(new Label("Loan Amount"), 0, 4);
        gridPane.add(tfLoanAmount, 1, 4);
        gridPane.add(new Label("Total Payment"), 0, 5);
        gridPane.add(tfInterestValue, 1, 5);
        gridPane.add(btCalculate, 0, 6);
        gridPane.add(btAddToClient, 1,6);

        gridPane.setAlignment(Pos.CENTER);
        tfYears.setAlignment(Pos.BOTTOM_LEFT);
        tfInterest.setAlignment(Pos.BOTTOM_LEFT);
        tfLoanAmount.setAlignment(Pos.BOTTOM_LEFT);
        tfInterestValue.setAlignment(Pos.BOTTOM_LEFT);
        tfInterestValue.setEditable(false);
        AccountNB.setEditable(false);

        LoanStackPane.getChildren().addAll(Frame(400,400), gridPane);
        pane.setCenter(LoanStackPane);

        // Set position of second window, related to primary window.
        Loan.initModality(Modality.WINDOW_MODAL);
        Loan.setX(1280 / 3.1);
        Loan.setY(30);
        Loan.setScene(YearlyLoanScene);
        Loan.initOwner(stage);
        Loan.show();
        Loan.setTitle("Client Loan");
    }
    private void Interest(Stage stage) throws SQLException, ClassNotFoundException{
        //Declare Nodes and Panes
        Stage Interest = new Stage();
        BorderPane pane = new BorderPane();
        StackPane InterestStackPane = new StackPane();

        Scene YearlyInterestScene = new Scene(pane, 720, 650);
        YearlyInterestScene.getStylesheets().addAll("Style1.css", "Style2.css");

        Text YearlyInterestText = new Text("YEARLY INTEREST");
        YearlyInterestText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        YearlyInterestText.setFill(Color.rgb(65,95,169));

        TextField tfYears = ManageClientTextField("Number of years");
        TextField tfInterest = ManageClientTextField("Interest rate");
        TextField tfInterestAmount = ManageClientTextField("Interest Amount");
        TextField tfInterestValue = ManageClientTextField("Total Amount");
        Button btCalculate = new Button("Calculate Interest Amount");

        btCalculate.setTextFill(Color.WHITE);
        btCalculate.setId("BTN");
        style.ChangeButtonColor(btCalculate,"BTN","BTN2");

        Button btAddToClient = new Button("Add Interest To Client");

        btAddToClient.setTextFill(Color.WHITE);
        btAddToClient.setId("BTN");
        style.ChangeButtonColor(btAddToClient,"BTN","BTN2");

        Button btNextScene = new Button("Monthly Interest");

        btNextScene.setTextFill(Color.WHITE);
        btNextScene.setId("BTN");
        style.ChangeButtonColor(btNextScene,"BTN","BTN2");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(45);

        TextField AccountNB = ManageClientTextField("Account ID");
        AccountNB.setText(Integer.toString(ID));

        gridPane.add(YearlyInterestText,0,0);
        gridPane.add(new Label("Account ID"),0,1);
        gridPane.add(AccountNB,1,1);
        gridPane.add(new Label("Years"), 0, 2);
        gridPane.add(tfYears, 1, 2);
        gridPane.add(new Label("Interest Rate"), 0, 3);
        gridPane.add(tfInterest, 1, 3);
        gridPane.add(new Label("Interest Amount"), 0, 4);
        gridPane.add(tfInterestAmount, 1, 4);
        gridPane.add(new Label("Total Payment"), 0, 5);
        gridPane.add(tfInterestValue, 1, 5);
        gridPane.add(btCalculate, 0, 6);
        gridPane.add(btAddToClient, 1,6);
        gridPane.add(btNextScene, 2,6);

        gridPane.setAlignment(Pos.CENTER);
        tfYears.setAlignment(Pos.BOTTOM_LEFT);
        tfInterest.setAlignment(Pos.BOTTOM_LEFT);
        tfInterestAmount.setAlignment(Pos.BOTTOM_LEFT);
        tfInterestValue.setAlignment(Pos.BOTTOM_LEFT);
        tfInterestValue.setEditable(false);
        AccountNB.setEditable(false);

        Interest interest = new Interest();

        btCalculate.setOnAction(e->{
            //Calculate Interest
            interest.calculateYInterest(tfYears,tfInterest,tfInterestAmount,tfInterestValue);
        });

        System.out.println(ID);
        //Buttons Declaration
        btAddToClient.setOnAction(e->{
            try {
                if(adm.GetBoolean("isInterest", ID)) { //If Client already has Interest
                    EmployeeInterface.ClientHasStage(stage, "INTEREST");
                }else{
                        double InterestAmount = Double.parseDouble(tfInterestValue.getText());
                        if(Double.parseDouble(tfInterestValue.getText()) == 0 || tfInterestValue.getText().isEmpty()) { // If Text fields are empty
                            EmployeeInterface.ErrorNotCalculatedStage(stage);
                        }else{
                            //Update values to the database
                            adm.UpdateDoubleAccount("InterestAmount",InterestAmount,ID);
                            adm.UpdateBooleanAccount("isInterest",true,ID);
                            EmployeeInterface.AddedMoneyStage(stage,"ADDED INTEREST SUCCESSFULLY !",300);
                        }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        btNextScene.setOnAction(e->{
            try {
                Interest.setScene(InterestMonthly(Interest,YearlyInterestScene));
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        InterestStackPane.getChildren().addAll(Frame(500,530),gridPane);
        pane.setCenter(InterestStackPane);

        // Set position of second window, related to primary window.
        Interest.initModality(Modality.WINDOW_MODAL);
        Interest.setX(1280 / 3.1);
        Interest.setY(30);
        Interest.setScene(YearlyInterestScene);
        Interest.initOwner(stage);
        Interest.show();
        Interest.setTitle("Client Interest");
    }
    private Scene InterestMonthly(Stage Interest, Scene YearlyInterestScene)throws SQLException, ClassNotFoundException{
        //Declare Panes and Nodes
        BorderPane pane = new BorderPane();
        Scene MonthlyInterestScene = new Scene(pane, 720, 650);
        StackPane InterestStackPane = new StackPane();
        Interest interest = new Interest();
        Text MonthlyInterestText = new Text("MONTHLY INTEREST");

        MonthlyInterestText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        MonthlyInterestText.setFill(Color.rgb(65,95,169));

        //Declare TextFields
        TextField tfYears = ManageClientTextField("Number of years");
        TextField tfInterest = ManageClientTextField("Interest rate");
        TextField tfInterestAmount = ManageClientTextField("Interest Amount");
        TextField tfInterestValue = ManageClientTextField("Total Amount");

        Button btCalculate = new Button("Calculate Interest Amount");
        btCalculate.setTextFill(Color.WHITE);
        btCalculate.setId("BTN");//SET CSS ID
        style.ChangeButtonColor(btCalculate,"BTN","BTN2");

        Button btAddToClient = new Button("Add Interest To Client");
        btAddToClient.setTextFill(Color.WHITE);
        btAddToClient.setId("BTN");//SET CSS ID
        style.ChangeButtonColor(btAddToClient,"BTN","BTN2");

        Button btNextScene = new Button("Yearly Interest");
        btNextScene.setTextFill(Color.WHITE);
        btNextScene.setId("BTN");//SET CSS ID
        style.ChangeButtonColor(btNextScene,"BTN","BTN2");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(45);

        TextField AccountNB = ManageClientTextField("Account ID");
        AccountNB.setText(Integer.toString(ID)); // Set the ID

        gridPane.add(MonthlyInterestText,0,0);
        gridPane.add(new Label("Account ID"),0,1);
        gridPane.add(AccountNB,1,1);
        gridPane.add(new Label("Years"), 0, 2);
        gridPane.add(tfYears, 1, 2);
        gridPane.add(new Label("Interest Rate"), 0, 3);
        gridPane.add(tfInterest, 1, 3);
        gridPane.add(new Label("Interest Amount"), 0, 4);
        gridPane.add(tfInterestAmount, 1, 4);
        gridPane.add(new Label("Total Payment"), 0, 5);
        gridPane.add(tfInterestValue, 1, 5);
        gridPane.add(btCalculate, 0, 6);
        gridPane.add(btAddToClient, 1,6);
        gridPane.add(btNextScene, 2,6);

        gridPane.setAlignment(Pos.CENTER);
        tfYears.setAlignment(Pos.BOTTOM_LEFT);
        tfInterest.setAlignment(Pos.BOTTOM_LEFT);
        tfInterestAmount.setAlignment(Pos.BOTTOM_LEFT);
        tfInterestValue.setAlignment(Pos.BOTTOM_LEFT);
        tfInterestValue.setEditable(false);
        AccountNB.setEditable(false);

        InterestStackPane.getChildren().addAll(Frame(500,530), gridPane);
        pane.setCenter(InterestStackPane);

        //Buttons functions
        btCalculate.setOnAction(e->{
            //calculate Interest
            interest.calculateMInterest(tfYears,tfInterest,tfInterestAmount,tfInterestValue);
        });
        btAddToClient.setOnAction(e->{
            try {
                if(adm.GetBoolean("isInterest", ID)) {
                    EmployeeInterface.ClientHasStage(Interest, "INTEREST");
                } else{
                    try{
                        double InterestAmount = Double.parseDouble(tfInterestValue.getText());
                        //if User did not Calculate Interest
                        if(Double.parseDouble(tfInterestValue.getText()) == 0 || tfInterestValue.getText().isEmpty()) {
                            EmployeeInterface.ErrorNotCalculatedStage(Interest);
                        }else{
                            //Add Values to the database through adm object
                            adm.UpdateDoubleAccount("InterestAmount",InterestAmount,ID);
                            adm.UpdateBooleanAccount("isInterest",true,ID);
                            EmployeeInterface.AddedMoneyStage(Interest,"ADDED INTEREST SUCCESSFULLY !",300);
                        }
                    }catch (NumberFormatException nfe){
                        EmployeeInterface.ErrorNotFoundStage(Interest);
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        btNextScene.setOnAction(e->{
            //Call Interest Interface
            Interest.setScene(YearlyInterestScene);
        });

        // Set position of second window, related to primary window.
        Interest.setX(1280 / 3.1);
        Interest.setY(30);
        Interest.setScene(YearlyInterestScene);
        Interest.show();
        Interest.setTitle("Client Interest");
        MonthlyInterestScene.getStylesheets().addAll("Style1.css", "Style2.css");
        return MonthlyInterestScene;
    }
    private void Deposit(Stage stage) throws SQLException, ClassNotFoundException {
        //Declare Nodes and Panes
        Stage Deposit = new Stage();
        BorderPane pane = new BorderPane();
        StackPane DepositStackPane = new StackPane();

        Scene DepositScene = new Scene(pane, 720, 650);
        DepositScene.getStylesheets().addAll("Style1.css", "Style2.css");

        TextField AccountNB = ManageClientTextField("Account ID");
        AccountNB.setText(Integer.toString(ID));

        Text DepositText = new Text("DEPOSIT");
        DepositText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        DepositText.setFill(Color.rgb(65,95,169));

        TextField tfAmount = ManageClientTextField("Amount in dollars");
        TextField tfTotalAfterDeposition = ManageClientTextField("Total");
        Button Depositbt = new Button("Deposit");

        Depositbt.setTextFill(Color.WHITE);
        Depositbt.setId("BTN");
        style.ChangeButtonColor(Depositbt,"BTN","BTN2");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(25);

        gridPane.add(DepositText,0,0);
        gridPane.add(new Label("Account ID"),0,1);
        gridPane.add(AccountNB,1,1);
        gridPane.add(new Label("Amount"), 0, 2);
        gridPane.add(tfAmount, 1, 2);
        gridPane.add(Depositbt,1,3);

        Depositbt.setOnAction(e->{
            try {
                double Amount = Double.parseDouble(tfAmount.getText());
                double AmountAfterDeposit = adm.GetDouble("money" ,ID) + Amount;
                adm.UpdateDoubleAccount("money" , AmountAfterDeposit ,ID);
                EmployeeInterface.AddedMoneyStage(stage, "ADDED " + Amount + "$ SUCCESSFULLY",300);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        gridPane.setAlignment(Pos.CENTER);
        tfTotalAfterDeposition.setEditable(false);

        DepositStackPane.getChildren().addAll(Frame(400,400), gridPane);
        pane.setCenter(DepositStackPane);

        // Set position of second window, related to primary window.
        Deposit.initModality(Modality.WINDOW_MODAL);
        Deposit.setX(1280 / 3.1);
        Deposit.setY(30);
        Deposit.initOwner(stage);
        Deposit.setScene(DepositScene);
        Deposit.show();
        Deposit.setTitle("Client Deposit");
    }
    private void Withdraw(Stage stage)throws SQLException, ClassNotFoundException{
        //Declare Nodes and Panes
        Stage Withdraw = new Stage();
        BorderPane pane = new BorderPane();
        StackPane WithdrawStackPane = new StackPane();

        Scene WithdrawScene = new Scene(pane, 720, 650);
        WithdrawScene.getStylesheets().addAll("Style1.css", "Style2.css");

        Text WithdrawText = new Text("WITHDRAW");
        WithdrawText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        WithdrawText.setFill(Color.rgb(65,95,169));

        TextField tfAmount = ManageClientTextField("Amount in dollars");
        TextField tfTotalAfterWithdrawion = ManageClientTextField("Total");

        Button Withdrawbt = new Button("Withdraw");
        Withdrawbt.setTextFill(Color.WHITE);
        Withdrawbt.setId("BTN");
        style.ChangeButtonColor(Withdrawbt,"BTN","BTN2");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(25);

        TextField AccountNB = ManageClientTextField("Account ID");
        AccountNB.setText(Integer.toString(ID));

        gridPane.add(WithdrawText,0,0);
        gridPane.add(new Label("Account ID"),0,1);
        gridPane.add(AccountNB,1,1);
        gridPane.add(new Label("Amount"), 0, 2);
        gridPane.add(tfAmount, 1, 2);
        gridPane.add(Withdrawbt,1,3);

        gridPane.setAlignment(Pos.CENTER);
        tfTotalAfterWithdrawion.setEditable(false);

        Withdrawbt.setOnAction(e->{
            try {
                double Amount = Double.parseDouble(tfAmount.getText());
                if(Amount > adm.GetDouble("money" ,ID)){ // get money from database
                    EmployeeInterface.AddedMoneyStage(stage,"CANNOT WITHDRAW " + Amount +"$ FROM " + adm.GetDouble("money",ID) + "$",450);
                }else{
                    double AmountAfterWithdraw = adm.GetDouble("money" ,ID) - Amount;
                    adm.UpdateDoubleAccount("money" , AmountAfterWithdraw ,ID);
                    EmployeeInterface.AddedMoneyStage(stage, "WITHDRAWN " + Amount + "$ SUCCESSFULLY",300);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        WithdrawStackPane.getChildren().addAll(Frame(400,400), gridPane);
        pane.setCenter(WithdrawStackPane);

        // Set position of second window, related to primary window.
        Withdraw.initModality(Modality.WINDOW_MODAL);
        Withdraw.setX(1280 / 3.1);
        Withdraw.setY(30);
        Withdraw.setScene(WithdrawScene);
        Withdraw.initOwner(stage);
        Withdraw.show();
        Withdraw.setTitle("Client Withdraw");
    }

    //Major Panes ( For Management )
    private GridPane LoginGridPane(Stage stage) throws FileNotFoundException{
        //Declare GridPane
        GridPane LoginGridPane = new GridPane();

        LoginGridPane.setVgap(20);
        LoginGridPane.setHgap(-40);
        LoginGridPane.setAlignment(Pos.TOP_CENTER);
        LoginGridPane.setPadding(new Insets(320,10,10,10));

        TextField EmployeeID = ManageClientTextField("Employee ID");
        TextField Password =ManageClientTextField("Password");

        Button LoginButton = ManageClientButton("Login",80,30);
        LoginButton.setTextFill(Color.WHITE);

        LoginButton.setId("BTN");
        style.ChangeButtonColor(LoginButton,"BTN","BTN2");

        //Login Template
        boolean isIdFound = false;
        String EmployeeS = EmployeeID.getText();
        boolean isPasswordFound = false;
        String passwordS = Password.getText();

        LoginButton.setOnAction(e->{
            stage.setScene(EmployeeInterface);
        });

        Label employee_id = ManageClientLabel("");
        employee_id.setGraphic(LoginInterface.LoginLogoView());
        Label password = new Label();
        password.setGraphic(LoginInterface.LockLogoView());

        LoginGridPane.add(employee_id,0,0);
        LoginGridPane.add(EmployeeID, 1,0);
        LoginGridPane.add(password,0,1);
        LoginGridPane.add(Password,1,1);
        LoginGridPane.add(LoginButton,0,2);
        return LoginGridPane;
    }
    private FlowPane ManageClientFlowPane(Stage stage) throws FileNotFoundException{
        FlowPane ManageFlowPane = new FlowPane();

        HBox AddClientHBox = new HBox();
        AddClientHBox.setAlignment(Pos.CENTER_LEFT);
        AddClientHBox.setSpacing(10);

        Label AddClientLabel = ManageClientLabel("Add Clients to the database, can be checked or edited or deleted in the CheckClients Field");
        AddClientLabel.setFont(new Font("Helvetica", 15));

        Button AddClient = ManageClientButton("",65,65);
        AddClientHBox.getChildren().addAll(AddClient, AddClientLabel);
        AddClient.setGraphic(EmployeeInterface.ButtonImageView("src/main/images/clientAdd.png"));
        AddClient.setId("BTNX"); // Set the CSS ID
        style.ChangeButtonColor(AddClient,"BTNX","BTNX2");

        HBox MoneyClientHBox = new HBox();
        MoneyClientHBox.setAlignment(Pos.CENTER_LEFT);
        MoneyClientHBox.setSpacing(10);

        Label MoneyClientLabel = ManageClientLabel("Deposit, Withdraw, add Loan or Interest for a specific Client");
        MoneyClientLabel.setFont(new Font("Helvetica", 15));

        Button MoneyClient = ManageClientButton("",65,65);
        MoneyClientHBox.getChildren().addAll(MoneyClient, MoneyClientLabel);
        MoneyClient.setGraphic(EmployeeInterface.ButtonImageView("src/main/images/clientMoney.png"));
        MoneyClient.setId("BTNX");
        style.ChangeButtonColor(MoneyClient,"BTNX","BTNX2");

        HBox CheckClientHBox = new HBox();
        CheckClientHBox.setAlignment(Pos.CENTER_LEFT);
        CheckClientHBox.setSpacing(10);

        Label CheckClientLabel = ManageClientLabel("All Clients from the Database will be shown in this Field, can search, edit and remove specific clients");
        CheckClientLabel.setFont(new Font("Helvetica", 15));

        Button CheckClient = ManageClientButton("",65,65);
        CheckClientHBox.getChildren().addAll(CheckClient, CheckClientLabel);
        CheckClient.setGraphic(EmployeeInterface.ButtonImageView("src/main/images/ClientsS.png"));
        CheckClient.setId("BTNX");// Set the CSS ID
        style.ChangeButtonColor(CheckClient,"BTNX","BTNX2");

        HBox CheckDatabaseHBox = new HBox();
        CheckDatabaseHBox.setAlignment(Pos.CENTER_LEFT);
        CheckDatabaseHBox.setSpacing(10);

        Label CheckDatabaseLabel = ManageClientLabel("Check if the Connection between the app and the database is secure and safe, if not please contact staff");
        CheckDatabaseLabel.setFont(new Font("Helvetica", 15));

        Button CheckDatabaseConnectivity = ManageClientButton("",65,65);
        CheckDatabaseHBox.getChildren().addAll(CheckDatabaseConnectivity, CheckDatabaseLabel);
        CheckDatabaseConnectivity.setGraphic(EmployeeInterface.ButtonImageView("src/main/images/Clients.png"));
        CheckDatabaseConnectivity.setId("BTNX");// Set the CSS ID
        style.ChangeButtonColor(CheckDatabaseConnectivity,"BTNX","BTNX2");

        HBox CheckAccountsHBox = new HBox();
        CheckAccountsHBox.setAlignment(Pos.CENTER_LEFT);
        CheckAccountsHBox.setSpacing(10);

        Label CheckAccountsLabel = ManageClientLabel("All Accounts from the Database will be shown in this Field");
        CheckAccountsLabel.setFont(new Font("Helvetica", 15));

        Button CheckAccounts = ManageClientButton("",65,65);
        CheckAccountsHBox.getChildren().addAll(CheckAccounts, CheckAccountsLabel);
        CheckAccounts.setGraphic(EmployeeInterface.ButtonImageView("src/main/images/Account.png"));
        CheckAccounts.setId("BTNX");// Set the CSS ID
        style.ChangeButtonColor(CheckAccounts,"BTNX","BTNX2");

        ManageFlowPane.setOrientation(Orientation.VERTICAL);
        ManageFlowPane.setVgap(45);
        ManageFlowPane.setHgap(45);
        ManageFlowPane.setAlignment(Pos.CENTER_LEFT);
        ManageFlowPane.setPadding(new Insets(10,10,10,10));

        ManageFlowPane.getChildren().addAll(AddClientHBox,CheckClientHBox,MoneyClientHBox,CheckAccountsHBox,CheckDatabaseHBox);

        //Buttons functions
        AddClient.setOnAction(e->{
            stage.setScene(AddClientInterface);
        });
        MoneyClient.setOnAction(e->{
            stage.setScene(MoneyClientInterface);
        });
        CheckAccounts.setOnAction(e->{
            stage.setScene(CheckAccountsInterface);
        });
        CheckDatabaseConnectivity.setOnAction(e->{
            EmployeeInterface.DataBaseConnectivity(stage);
        });
        CheckClient.setOnAction(e->{
            stage.setScene(CheckClientsInterface);
        });
        return ManageFlowPane;
    }
    private GridPane AddClientGridPane(Stage stage){
        //Declare GridPane
        GridPane AddClientGridPane = new GridPane();

        AddClientGridPane.setAlignment(Pos.CENTER);
        AddClientGridPane.setHgap(10);
        AddClientGridPane.setVgap(24);
        AddClientGridPane.setPadding(new Insets(10,10,10,10));

        //Declare Buttons
        Button Generate = ManageClientButton("Generate",30,15);
        Generate.setTextFill(Color.WHITE);
        Generate.setId("BTN");// Set the CSS ID
        style.ChangeButtonColor(Generate,"BTN","BTN2");// CSS Related - Check Styling Class

        Button SubmitClient = ManageClientButton("Submit",30,15);
        SubmitClient.setTextFill(Color.WHITE);
        SubmitClient.setId("BTN");// Set the CSS ID
        style.ChangeButtonColor(SubmitClient,"BTN","BTN2");// CSS Related - Check Styling Class

        Button ClearClient = ManageClientButton("Clear",30,15);
        ClearClient.setTextFill(Color.WHITE);
        ClearClient.setId("BTN");// Set the CSS ID
        style.ChangeButtonColor(ClearClient,"BTN","BTN2");// CSS Related - Check Styling Class

        Button BackClient = ManageClientButton("Back",30,15);
        BackClient.setTextFill(Color.WHITE);
        BackClient.setId("BTN");// Set the CSS ID
        style.ChangeButtonColor(BackClient,"BTN","BTN2");// CSS Related - Check Styling Class

        //Declare TextFields
        TextField AccountNumber = ManageClientTextField("Client's Account Number");
        String randomS = Integer.toString(GeneralUtil.GenerateRandom());
        AccountNumber.setText(randomS); //Set the Value of the TextField
        TextField FirstName = ManageClientTextField("Client's First Name");
        TextField LastName = ManageClientTextField("Client's Last Name");
        TextField Address = ManageClientTextField("Client's Address");
        TextField Email = ManageClientTextField("Client's Email");
        TextField TelephoneNumber = ManageClientTextField("Client's phone");
        TextField Job = ManageClientTextField("Client's Job");
        TextField AccountCreationDate = ManageClientTextField("Date");

        //Get Today date and convert it to String
        LocalDate today = LocalDate.now();
        String Stoday = today.toString();

        AccountCreationDate.setText(Stoday); //Set the TextField value

        //Declare Labels
        Label first_name = ManageClientLabel("First Name");
        Label last_name = ManageClientLabel("Last Name");
        Label email = ManageClientLabel("Email");
        Label telephone_nb = ManageClientLabel("Telephone Number");
        Label birth_date = ManageClientLabel("Birth Date");
        Label address = ManageClientLabel("Address");
        Label account_creation_date = ManageClientLabel("Account Creation date");
        Label is_married = ManageClientLabel("Client's Status");
        Label city = ManageClientLabel("City");
        Label gender = ManageClientLabel("Gender");
        Label job_name = ManageClientLabel("Job Name");

        //City ComboBox
        String[] cities =
                { "Beirut", "Tripoli", "Tyre", "Byblos","Jounieh","Sidon","Baalbak","Nabatieh","Batroun","Baabda","Aley"};
        ComboBox<String> Cities =
                AddClientComboBox("City",cities);
        Cities.setId("combo");
        HBox CitiesHBox = AddClientCitiesHBox(Cities);

        //Birthdate ComboBox
        String[] month_days =
                { "1", "2", "3","4", "5","6","7","8","9","10","11","12"
                        ,"13","14","15","16","17","18","19","20",
                        "21","22","23","24","25","26","27","28","29","30","31"};
        ComboBox<String> combo_box_month_days =
                AddClientComboBox("Day", month_days);
        combo_box_month_days.setId("combo");

        String[] month_names ={"1","2","3","4","5","6",
                "7","8","9","10","11","12"};
        ComboBox<String> combo_box_month_names =
                AddClientComboBox("Month", month_names);
        combo_box_month_names.setId("combo");

        String[] year_number = {"1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960",
                "1961","1961","1962","1963","1964","1966","1966","1967","1968","1969","1970",
                "1971","1971","1972","1973","1974","1977","1976","1977","1978","1979","1980",
                "1980","1981","1982","1983","1984","1988","1986","1987","1988","1989","1990",
                "1990","1991","1992","1993","1994","1999","1996","1997","1998","1999","2000",
                "2001","2002","2003"};
        ComboBox<String> combo_box_years =
                AddClientComboBox("Year", year_number);
        combo_box_years.setId("combo");
        HBox BirthDateHBox = AddClientBirthDateHBox(combo_box_month_days,combo_box_month_names,combo_box_years);

        //Gender Toggle Group
        ToggleGroup GenderToggleGroup = new ToggleGroup();
        RadioButton male = AddClientRadioButton("Male", GenderToggleGroup);
        RadioButton female = AddClientRadioButton("Female", GenderToggleGroup);
        HBox GenderRadioHBox = AddClientRadioHBox(male,female);

        //Status Toggle Group
        ToggleGroup MarriedToggleGroup = new ToggleGroup();
        RadioButton married = AddClientRadioButton("Married", MarriedToggleGroup);
        RadioButton single = AddClientRadioButton("Single",  MarriedToggleGroup);
        HBox MarriedRadioHBox = AddClientRadioHBox(married,single);

        AddClientGridPane.add(first_name,0,2);
        AddClientGridPane.add(FirstName,1,2);

        AddClientGridPane.add(last_name,0,3);
        AddClientGridPane.add(LastName,1,3);

        AddClientGridPane.add(email,0,4);
        AddClientGridPane.add(Email,1,4);

        AddClientGridPane.add(telephone_nb,0,5);
        AddClientGridPane.add(TelephoneNumber,1,5);

        AddClientGridPane.add(address,0,6);
        AddClientGridPane.add(Address,1,6);

        AddClientGridPane.add(job_name,0,7);
        AddClientGridPane.add(Job,1,7);

        AddClientGridPane.add(is_married,0,8);
        AddClientGridPane.add(MarriedRadioHBox,1,8);

        AddClientGridPane.add(gender,0,9);
        AddClientGridPane.add(GenderRadioHBox,1,9);

        AddClientGridPane.add(city,0,10);
        AddClientGridPane.add(CitiesHBox,1,10);

        AddClientGridPane.add(birth_date,0,11);
        AddClientGridPane.add(BirthDateHBox,1,11);

        AddClientGridPane.add(account_creation_date,0,12);
        AddClientGridPane.add(AccountCreationDate,1,12);
        AccountCreationDate.setEditable(false);
        AddClientGridPane.add(AddClientButtonsHBox(BackClient,ClearClient,SubmitClient),1,13);

        //Buttons Functions
        SubmitClient.setOnAction(e -> {
            //Call GeneralUtil static methods to make sure if formats are correct
            boolean isValidPhone = GeneralUtil.isValidPhone(TelephoneNumber.getText());
            boolean isValidEmail = GeneralUtil.isValidEmail(Email.getText());

            //Check if Email and Phone number are correct and if there's any empty text field or any null values
            if(!isValidPhone || !isValidEmail || FirstName.getText().isEmpty() || LastName.getText().isEmpty()
                    || Address.getText().isEmpty() || Job.getText().isEmpty() || combo_box_month_days.getValue() == null || combo_box_month_days.getValue().equals("Day")
                    || combo_box_month_names.getValue() == null || combo_box_month_names.getValue().equals("Month") || combo_box_years.getValue() == null
                    || combo_box_years.getValue().equals("Year") || Cities.getValue() == null || Cities.getValue().equals("City")
                    || !male.isSelected() && !female.isSelected() || !married.isSelected() && !single.isSelected()){
                EmployeeInterface.ErrorClientStage(stage);
            }else{
                //if values are correctly set
                //Initialize Values for Database and Observable List
                String ClientStatus = "";
                String Gender = "";
                String birthdate = combo_box_month_days.getValue() + "/" + combo_box_month_names.getValue() + "/" + combo_box_years.getValue();
                String City = Cities.getValue();
                //Assign values to the Strings
                if (married.isSelected())
                    ClientStatus = "married";
                else if (single.isSelected())
                    ClientStatus = "single";

                if (male.isSelected())
                    Gender = "male";
                else if (female.isSelected())
                    Gender = "female";

                //Generate new random Number
                int acc_nb = GeneralUtil.GenerateRandom();

                //Add Client to the Database
                try {
                    cdm.InsertClient(acc_nb, FirstName.getText(), LastName.getText(), Email.getText(), TelephoneNumber.getText(), Address.getText(),
                            Job.getText(), City, ClientStatus, Gender, birthdate,Stoday);
                    //Insert new account into the Account Database
                    adm.InsertAccount(acc_nb,100,false,0,false,0);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                //Add Client to Observable List
                clients_observable.add(new Client(acc_nb, FirstName.getText(), LastName.getText(), Email.getText(), TelephoneNumber.getText(), Address.getText(),
                        Job.getText(), City, ClientStatus, Gender, birthdate,Stoday));
                //Add Account to Observable List
                accounts_observable.add(new Account(acc_nb,100,false,false,0,0));

                //Clear Fields
                FirstName.clear();
                LastName.clear();
                Email.clear();
                Job.clear();
                Address.clear();
                TelephoneNumber.clear();
                married.setSelected(false);
                single.setSelected(false);
                male.setSelected(false);
                female.setSelected(false);
                combo_box_month_days.setPromptText(null);
                combo_box_month_names.setPromptText(null);
                combo_box_years.setPromptText(null);
                Cities.setPromptText(null);
                //Call Added Client Stage
                EmployeeInterface.AddedClientStage(stage);
            }

        });
        ClearClient.setOnAction(e->{
            //Clear All Fields
            FirstName.clear();
            LastName.clear();
            Email.clear();
            Job.clear();
            Address.clear();
            TelephoneNumber.clear();
            married.setSelected(false);
            single.setSelected(false);
            male.setSelected(false);
            female.setSelected(false);
            combo_box_month_days.setValue("Day");
            combo_box_month_names.setValue("Month");
            combo_box_years.setValue("Year");
            Cities.setValue("City");

        });
        BackClient.setOnAction(e->{
            //Call the Employee Interface Scene
            stage.setScene(EmployeeInterface);
            //Clear All fields
            FirstName.clear();
            LastName.clear();
            Email.clear();
            Job.clear();
            Address.clear();
            TelephoneNumber.clear();
            married.setSelected(false);
            single.setSelected(false);
            male.setSelected(false);
            female.setSelected(false);
            combo_box_month_days.setPromptText("Day");
            combo_box_month_names.setPromptText("Month");
            combo_box_years.setPromptText("Year");
            Cities.setPromptText("City");
        });
        return AddClientGridPane;
    }

    //TableViews ( Accounts / Clients )
    private TableView<Client> CheckClientsTable(Button Remove,TextField fname){
        //Declare TableView of Type Client
        TableView<Client> ClientsTable = new TableView<Client>();
        //Set the Items from the Clients Observable List
        ClientsTable.setItems(clients_observable);
        ClientsTable.setMinWidth(800);
        ClientsTable.setMinHeight(580);
        ClientsTable.setEditable(true);

        TableColumn accountNumberCol = new TableColumn("Account Number");
        accountNumberCol.setCellValueFactory(new PropertyValueFactory<Client,String>("accNb"));

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Client, String> t) {
                        ((Client) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setFirstname(t.getNewValue());
                        try {
                            cdm.UpdateStringClient("first_name",t.getNewValue(),t.getRowValue().getAccNb());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Client,String>("firstname"));

        TableColumn lastNameCol = new TableColumn("Last Name");

        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Client, String> t) {
                        ((Client) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setLastname(t.getNewValue());
                        try {
                            cdm.UpdateStringClient("last_name",t.getNewValue(),t.getRowValue().getAccNb());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        lastNameCol.setCellValueFactory(new PropertyValueFactory<Client,String>("lastname"));
        TableColumn emailCol = new TableColumn("Email");

        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Client, String> t) {
                        ((Client) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setEmail(t.getNewValue());
                        try {
                            cdm.UpdateStringClient("email",t.getNewValue(),t.getRowValue().getAccNb());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        emailCol.setCellValueFactory(new PropertyValueFactory<Client,String>("email"));
        TableColumn telephoneNumberCol = new TableColumn("Telephone Number");

        telephoneNumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
        telephoneNumberCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Client, String> t) {
                        ((Client) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setTelephone(t.getNewValue());
                        try {
                            cdm.UpdateStringClient("phone_nb",t.getNewValue(),t.getRowValue().getAccNb());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        telephoneNumberCol.setCellValueFactory(new PropertyValueFactory<Client,String>("telephone"));
        TableColumn addressCol = new TableColumn("Address");
        //Set prefWidth of the address Column by binding its width with table width
        addressCol.prefWidthProperty().bind(ClientsTable.widthProperty().multiply(0.225));

        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        addressCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Client, String> t) {
                        ((Client) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setAddress(t.getNewValue());
                        try {
                            cdm.UpdateStringClient("address",t.getNewValue(),t.getRowValue().getAccNb());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        addressCol.setCellValueFactory(new PropertyValueFactory<Client,String>("address"));
        TableColumn jobCol = new TableColumn("Job Name");

        jobCol.setCellFactory(TextFieldTableCell.forTableColumn());
        jobCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Client, String> t) {
                        ((Client) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setJob(t.getNewValue());
                        try {
                            cdm.UpdateStringClient("job",t.getNewValue(),t.getRowValue().getAccNb());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        jobCol.setCellValueFactory(new PropertyValueFactory<Client,String>("job"));
        TableColumn isMarriedCol = new TableColumn("Client's Status");

        isMarriedCol.setCellFactory(TextFieldTableCell.forTableColumn());
        isMarriedCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Client, String> t) {
                        ((Client) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setMarried(t.getNewValue());
                        try {
                            cdm.UpdateStringClient("status",t.getNewValue(),t.getRowValue().getAccNb());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        isMarriedCol.setCellValueFactory(new PropertyValueFactory<Client,String>("married"));
        TableColumn genderCol = new TableColumn("Gender");

        genderCol.setCellFactory(TextFieldTableCell.forTableColumn());
        genderCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Client, String> t) {
                        ((Client) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setGender(t.getNewValue());
                        try {
                            cdm.UpdateStringClient("gender",t.getNewValue(),t.getRowValue().getAccNb());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        genderCol.setCellValueFactory(new PropertyValueFactory<Client,String>("gender"));
        TableColumn cityCol = new TableColumn("City");

        cityCol.setCellFactory(TextFieldTableCell.forTableColumn());
        cityCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Client, String> t) {
                        ((Client) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setCity(t.getNewValue());
                        try {
                            cdm.UpdateStringClient("city",t.getNewValue(),t.getRowValue().getAccNb());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        cityCol.setCellValueFactory(new PropertyValueFactory<Client,String>("city"));
        TableColumn birthDateCol = new TableColumn("Birth Date");
        birthDateCol.setCellValueFactory(new PropertyValueFactory<Client,String>("birthdate"));
        TableColumn AccountDateCol = new TableColumn("Account Join Date");
        AccountDateCol.setCellValueFactory(new PropertyValueFactory<Client,String>("Today"));

        ClientsTable.getColumns().addAll(accountNumberCol, firstNameCol, lastNameCol,
                emailCol,telephoneNumberCol,addressCol, jobCol,
                isMarriedCol, genderCol, cityCol, birthDateCol,AccountDateCol);

    // Search Filter System
        //Remove the selected item in the table from the Observable list when (Remove Button is Clicked)
        Remove.setOnAction(e->{
            //get Selected Client in table
            Client selectedItem = ClientsTable.getSelectionModel().getSelectedItem();
            //Remove it from the list
            clients_observable.remove(selectedItem);


            //Delete Client from Database
            try {
                //Call the Delete Method from ClientsDatabaseManip
                cdm.DeleteClient(selectedItem);
                adm.DeleteAccount(selectedItem);

                //Update the Accounts TableView
                accounts_observable = adm.getAccountList();

            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }

        });

        FilteredList<Client> filteredData = new FilteredList<>(clients_observable, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        fname.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(client -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (client.getFirstname().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (client.getLastname().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                else if (String.valueOf(client.getAccNb()).contains(lowerCaseFilter))
                    return true;
                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Client> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(ClientsTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        ClientsTable.setItems(sortedData);

        return ClientsTable;
    }
    private TableView<Account> CheckAccountTable(TextField accountNb){
        //Declare TableView of Type Account
        TableView<Account> AccountsTable = new TableView<Account>();

        //Set the Items from the Accounts Observable List
        AccountsTable.setItems(accounts_observable);
        AccountsTable.setMinWidth(800);
        AccountsTable.setMinHeight(580);
        AccountsTable.setEditable(false);

        TableColumn accountNumberCol = new TableColumn("Account Number");
        accountNumberCol.setCellValueFactory(new PropertyValueFactory<Account,Integer>("account_number"));
        accountNumberCol.prefWidthProperty().bind(AccountsTable.widthProperty().multiply(0.165));

        TableColumn AccountBalanceCol = new TableColumn("Account Balance");
        AccountBalanceCol.setCellValueFactory(new PropertyValueFactory<Account,Double>("balance"));
        AccountBalanceCol.prefWidthProperty().bind(AccountsTable.widthProperty().multiply(0.165));

        TableColumn AccountIsLoanCol = new TableColumn("Account Loan");
        AccountIsLoanCol.setCellValueFactory(new PropertyValueFactory<Account,Boolean>("isLoan"));
        AccountIsLoanCol.prefWidthProperty().bind(AccountsTable.widthProperty().multiply(0.165));

        TableColumn AccountIsInterestCol = new TableColumn("Account Interest");
        AccountIsInterestCol.setCellValueFactory(new PropertyValueFactory<Account,Boolean>("isInterest"));
        AccountIsInterestCol.prefWidthProperty().bind(AccountsTable.widthProperty().multiply(0.165));

        TableColumn AccountLoanAmountCol = new TableColumn("Account Loan Amount");
        AccountLoanAmountCol.setCellValueFactory(new PropertyValueFactory<Account,Double>("loan_amount"));
        AccountLoanAmountCol.prefWidthProperty().bind(AccountsTable.widthProperty().multiply(0.165));

        TableColumn AccountInterestAmountCol = new TableColumn("Account Interest Amount");
        AccountInterestAmountCol.setCellValueFactory(new PropertyValueFactory<Account,Double>("interest_amount"));
        AccountInterestAmountCol.prefWidthProperty().bind(AccountsTable.widthProperty().multiply(0.165));

        AccountsTable.getColumns().addAll(accountNumberCol, AccountBalanceCol,AccountIsLoanCol,AccountIsInterestCol,AccountLoanAmountCol,AccountInterestAmountCol);

    // Search Filter System
        FilteredList<Account> filteredData = new FilteredList<>(accounts_observable, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        accountNb.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(account -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if (String.valueOf(account.getAccount_number()).toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else
                    return false; // Does not match.
            });
        });
        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Account> sortedData = new SortedList<>(filteredData);
        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(AccountsTable.comparatorProperty());
        // 5. Add sorted (and filtered) data to the table.
        AccountsTable.setItems(sortedData);
        return AccountsTable;
    }

    //Major Panes (Separated for better design )
    private StackPane LoginForm(Stage stage) throws FileNotFoundException, SQLException {
        StackPane LoginFormStackPane = new StackPane();
        LoginFormStackPane.setAlignment(Pos.CENTER);
        Rectangle Frame = Frame(1000,350);
        Frame.setTranslateY(-10);
        LoginFormStackPane.getChildren().addAll(Frame,LoginGridPane(stage));
        return LoginFormStackPane;
    }
    private StackPane EmployeeForm(Stage stage) throws FileNotFoundException {
        //Declare Nodes and Panes
        StackPane EmployeeStackPane = new StackPane();
        Button ManageAccount = ManageClientButton("Account Info",60,20);
        Button Logout = ManageClientButton("Logout",60,20);

        EmployeeStackPane.setMinHeight(700);

        ManageAccount.setId("BTN");
        style.ChangeButtonColor(ManageAccount,"BTN","BTN2");

        Logout.setId("BTN");
        style.ChangeButtonColor(Logout,"BTN","BTN2");

        ManageAccount.setAlignment(Pos.CENTER);
        ManageAccount.setMinWidth(150);
        ManageAccount.setTranslateY(EmployeeStackPane.getHeight()-250);
        ManageAccount.setTextFill(Color.WHITE);

        Logout.setAlignment(Pos.CENTER);
        Logout.setMinWidth(150);
        Logout.setTranslateY(EmployeeStackPane.getHeight()+300);
        Logout.setTextFill(Color.WHITE);

        Logout.setOnAction(e->{
            //Call the Login Interface scene
            stage.setScene(LoginInterface);
        });
        ManageAccount.setOnAction(e->{
            //Call the Manage Client Stage
            EmployeeInterface.ManageClientStage(stage);
        });

        EmployeeStackPane.getChildren().addAll(Frame(1000,250), EmployeeInterface.EmployeeTextInfoHBox(),ManageAccount,Logout);
        return EmployeeStackPane;
    }
    private StackPane AddClientForm(Stage stage){
        StackPane AddClientStackPane = new StackPane();
        AddClientStackPane.setAlignment(Pos.CENTER);
        AddClientStackPane.setPadding(new Insets(10,10,10,10));
        AddClientStackPane.getChildren().addAll(Frame(700,800),AddClientGridPane(stage));
        return  AddClientStackPane;
    }
    private VBox CheckClientsForm(Stage stage){
        //Declare Nodes and Panes
        VBox CheckClientsVBox = new VBox();
        HBox textHBox = new HBox();
        TextField SearchField = ManageClientTextField("AccountNb/ FirstName / LastName");
        Label SearchL = ManageClientLabel("Search Value");
        StackPane ButtonsStackPane = new StackPane();
        HBox ButtonsHBox = new HBox();
        Button Remove = new Button("Remove Client");
        Button Back = new Button(" Back ");
        Text text = new Text();

        text.setText("CLIENTS TABLE");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        text.setFill(Color.rgb(65,95,169));

        textHBox.getChildren().add(text);
        textHBox.setAlignment(Pos.CENTER);

        CheckClientsVBox.setAlignment(Pos.CENTER);
        CheckClientsVBox.setSpacing(20);
        CheckClientsVBox.setPadding(new Insets(10,10,10,10));

        SearchField.setPrefWidth(200);

        Remove.setTextFill(Color.WHITE);
        Remove.setId("BTN");
        style.ChangeButtonColor(Remove,"BTN","BTN2");

        Back.setTextFill(Color.WHITE);
        Back.setId("BTN");
        style.ChangeButtonColor(Back,"BTN","BTN2");

        ButtonsHBox.getChildren().addAll(Back,SearchL,SearchField,Remove);
        ButtonsHBox.setAlignment(Pos.CENTER_LEFT);
        ButtonsHBox.setPadding(new Insets(15,15,15,15));
        ButtonsHBox.setSpacing(25);

        ButtonsStackPane.getChildren().addAll(Frame(50,550),ButtonsHBox);
        ButtonsStackPane.setAlignment(Pos.CENTER_LEFT);

        Remove.setOnAction(e->{
            //Call the Clients TableView
            CheckClientsTable(Remove,SearchField);
            //Remove the selected Client through Remove argument
        });

        Back.setOnAction(e->{
            //Call the Employee Interface
            stage.setScene(EmployeeInterface);
        });

        CheckClientsVBox.getChildren().addAll(textHBox,CheckClientsTable(Remove,SearchField),ButtonsStackPane);
        return CheckClientsVBox;
    }
    private VBox CheckAccountsForm(Stage stage){
        //Declare Nodes and Panes
        VBox CheckClientsVBox = new VBox();
        HBox textHBox = new HBox();
        StackPane ButtonsStackPane = new StackPane();
        HBox ButtonsHBox = new HBox();
        TextField SearchField = ManageClientTextField("Account Number");
        Label SearchL = ManageClientLabel("Search Value");
        Text text = new Text();

        text.setText("ACCOUNTS TABLE");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        text.setFill(Color.rgb(65,95,169));

        textHBox.getChildren().add(text);
        textHBox.setAlignment(Pos.CENTER);

        CheckClientsVBox.setAlignment(Pos.CENTER);
        CheckClientsVBox.setSpacing(20);
        CheckClientsVBox.setPadding(new Insets(10,10,10,10));

        SearchField.setPrefWidth(200);

        Button Back = new Button(" Back ");
        Back.setTextFill(Color.WHITE);
        Back.setId("BTN");
        style.ChangeButtonColor(Back,"BTN","BTN2");

        ButtonsHBox.getChildren().addAll(Back,SearchL,SearchField);
        ButtonsHBox.setAlignment(Pos.CENTER_LEFT);
        ButtonsHBox.setPadding(new Insets(15,15,15,15));
        ButtonsHBox.setSpacing(25);

        ButtonsStackPane.getChildren().addAll(Frame(50,450),ButtonsHBox);
        ButtonsStackPane.setAlignment(Pos.CENTER_LEFT);

        Back.setOnAction(e->{
            stage.setScene(EmployeeInterface);
        });

        CheckClientsVBox.getChildren().addAll(textHBox,CheckAccountTable(SearchField),ButtonsStackPane);
        return CheckClientsVBox;
    }
}