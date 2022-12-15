package com.bank.bank_of_lebanon;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Collections;
import java.util.regex.Pattern;

public class GeneralUtil {
    public static Double convertTextToDouble(TextField textField) {
        Double value = null;

        try {
            value = Double.parseDouble(textField.getText());

            if (value < 0)
                throw new Exception("Enter a positive number");
        } catch (Exception e) {
            textField.setText("");
            textField.setPromptText("Enter a positive number");

            value = null;
        }

        return value;
    }
    public static Integer convertTextToInteger(TextField textField) {
        Integer value = null;

        try {
            value = Integer.parseInt(textField.getText());

            if (value < 0)
                throw new Exception("Enter a positive number");
        } catch (Exception e) {
            textField.setText("");
            textField.setPromptText("Enter a positive number");

            value = null;
        }

        return value;
    }
    public static int GenerateRandom(){
        return (int)(Math.random()*(999999999-100000000+1)+100000000);
    }
    public static int GetInt(TextField text){
        int id = 0;
        try {
            id = Integer.parseInt(text.getText());
            return id;
        } catch (NumberFormatException nfe) {
            return id;
        }
    }
    public static boolean isValidPhone(String txt){

        boolean isValid = txt.matches("[0-9]+") && txt.length() >= 8;

        return isValid;
    }
    public static boolean isValidEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();

    }



}
