/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import static fpmozknjiznica.model.Baza.DB;
import fpmozknjiznica.model.Korisnik;
import interfaces.model;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class KorisnikService implements model <Korisnik>{

    @Override
    public Korisnik spasi(Korisnik korisnik) {
        try {
            PreparedStatement upit = DB.prepare ("INSERT INTO korisnici VALUES(null, ?, ?, ?, ?)");
            upit.setString(1, korisnik.getIme());
            upit.setString(2, korisnik.getPrezime());
            upit.setString(3, korisnik.getEmail());
            upit.setString(4, korisnik.getLozinka());
            upit.executeUpdate();
            return korisnik;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        }
    
    }

    @Override
    public Korisnik uredi(Korisnik korisnik) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean brisi(Korisnik korisnik) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Korisnik> sveIzBaze() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Korisnik izBazePremaId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
