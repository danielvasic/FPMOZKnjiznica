/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpmozknjiznica;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author itic-4
 */
public class Utils {
    public void prikazi (Stage window, String view) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("view/"+view+".fxml"));
            Scene scene = new Scene(root);
            window.setScene(scene);
            window.show();
        } catch (IOException ex) {
            System.out.println("Greska prilikom otvaranja prozora..");
        }
    }
    
}
