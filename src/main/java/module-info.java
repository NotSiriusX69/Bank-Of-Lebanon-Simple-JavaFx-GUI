module com.bank.bank_of_lebanon {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.bank.bank_of_lebanon to javafx.fxml;
    exports com.bank.bank_of_lebanon;
}