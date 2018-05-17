/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpmozknjiznica;

//import fpmozknjiznica.model.Korisnik;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.KorisnikService;

/**
 *
 * @author itic-4
 */
public class FPMOZKnjiznica extends Application {
    
    //private static KorisnikService korisnikService = new KorisnikService();
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/LoginView.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        /*
        //dodaj korisnika
        Korisnik k = new Korisnik (0, "Daniel", "Vasic", "daniel.vasic@fpmoz.sum.ba", "123456");
        korisnikService.spasi(k);
        //uredi email
        k.setEmail("dvasic1@gmail.com");
        //k.setIme("Marko");
        //Uredi korisnika
        korisnikService.uredi(k);
        
        
        //Dodaj korisnika i pobrisi ga iz baze
        Korisnik k1 = new Korisnik (0, "Daniel", "Vasic", "daniel.vasic@fpmoz.sum.ba", "123456");
        korisnikService.spasi(k1);
        korisnikService.brisi(k1);
        */
    }
    
}
