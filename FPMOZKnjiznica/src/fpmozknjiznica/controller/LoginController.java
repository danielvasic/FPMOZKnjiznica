/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpmozknjiznica.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import service.LoginService;
import fpmozknjiznica.Utils;
import javafx.stage.Stage;
/**
 *
 * @author itic-4
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField korisnickoImeTxt;
    
    @FXML
    private PasswordField lozinkaTxt;
    
    @FXML
    private Label greskaLbl;
    
    @FXML
    private void prijava (ActionEvent event) {
        if (korisnickoImeTxt.getText().equals("") || lozinkaTxt.getText().equals("")) {
            greskaLbl.setText("Morate unijeti sve tražene korisničke podatke.");
        } else {
            greskaLbl.setText("");
            String email = korisnickoImeTxt.getText();
            String password = lozinkaTxt.getText();
            if (LoginService.login(email, password)) {
                Node source = (Node) event.getSource();
                Stage stage = (Stage)source.getScene().getWindow();
                Utils.prikazi(stage, "Administracija");
            } else {
                greskaLbl.setText("Pogrešni korisnički podaci...");
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
