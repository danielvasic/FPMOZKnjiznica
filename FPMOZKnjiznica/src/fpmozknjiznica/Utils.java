/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpmozknjiznica;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author itic-4
 */
public class Utils {
    public static void prikazi (Stage window, String view) {
        try {
            Parent root = FXMLLoader.load(Utils.class.getResource("view/"+view+".fxml"));
            Scene scene = new Scene(root);
            window.setScene(scene);
            window.show();
        } catch (IOException ex) {
            System.out.println("Greska prilikom otvaranja prozora..");
        }
    }
    
}
