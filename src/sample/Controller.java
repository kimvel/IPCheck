package sample;

import javafx.fxml.FXML;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    @FXML TextField textField;
    @FXML Button btn;
    @FXML Text getResult;

    private String ipAddress = "";
    private String isReachable = "";

    public void onClick () {

        ipAddress = textField.getText();

        if (ipAddress.length() > 3){
            isAddressConnectible();
            getResult.setText(ipAddress + " " + isReachable);
        } else {
            getResult.setText("Incorrect input");
        }

    }

    private void isAddressConnectible (){

        try {
            InetAddress getCon = InetAddress.getByName(ipAddress);
            System.out.println("Sending request to: " + ipAddress);
            getResult.setText("wohpsi");

            if (getCon.isReachable(5000)){
                System.out.println(ipAddress + " is reachable.");
                isReachable = "is reachable";
            } else {
                System.out.println(ipAddress + " is not reachable");
                isReachable = "is not reachable";
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
