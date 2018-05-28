/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpmozknjiznica.controller;

import fpmozknjiznica.model.Korisnik;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.KorisnikService;
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
    
    @FXML
    TextField ime;
    
    @FXML
    TextField prezime;
    
    @FXML
    TextField email;
    
    @FXML
    PasswordField lozinka;
    
    
    @FXML
    TableView table;
    
    @FXML
    TableColumn tableId;
    
    @FXML
    TableColumn tableIme;
    
    @FXML
    TableColumn tablePrezime;
    
    @FXML
    TableColumn tableEmail;
    
    @FXML
    TableColumn tableLozinka;
    
    
    @FXML
    public void dodajKorisnika (ActionEvent evt) {
        String sIme = this.ime.getText();
        String sPrezime = this.prezime.getText();
        String sEmail = this.email.getText();
        String sLozinka = this.lozinka.getText();
        
        Korisnik k = new Korisnik (0, sIme, sPrezime, sEmail, sLozinka);
        KorisnikService.korisnikService.spasi(k);
        this.ime.setText("");
        this.prezime.setText("");
        this.email.setText("");
        this.lozinka.setText("");
        this.popuniKorisnike();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Korisnik prijavljeni = LoginService.logiraniKorisnik();
        korisnikLbl.setText(prijavljeni.getIme() + " " + prijavljeni.getPrezime());
        this.popuniKorisnike();
    }   
    
    
    public void popuniKorisnike () {
        ObservableList <Korisnik> korisnici = KorisnikService.korisnikService.sveIzBaze();
        
        tableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        tablePrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        tableEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableLozinka.setCellValueFactory(new PropertyValueFactory<>("lozinka"));
        
        table.setItems(korisnici);
    }
    
    
}
