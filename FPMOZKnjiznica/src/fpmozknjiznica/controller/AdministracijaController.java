/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpmozknjiznica.controller;

import fpmozknjiznica.model.Korisnik;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import service.LoginService;

/**
 * FXML Controller class
 *
 * @author itic-4
 */
public class AdministracijaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Label korisnikLbl;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Korisnik prijavljeni = LoginService.logiraniKorisnik();
        korisnikLbl.setText(prijavljeni.getIme() + " " + prijavljeni.getPrezime());
    }    
    
}
