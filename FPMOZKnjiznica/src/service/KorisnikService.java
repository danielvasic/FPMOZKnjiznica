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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
            /* Dohvati id korisnika iz baze podataka */
            ResultSet rs = upit.getGeneratedKeys();
            if (rs.next()){
                /* Postavi id korisnika iz baze podataka objektu korisnik */
                korisnik.setId(rs.getInt(1));
            }
            return korisnik;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        }
    
    }

    @Override
    public Korisnik uredi(Korisnik korisnik) {
        try {
            PreparedStatement upit = DB.prepare ("UPDATE korisnici SET ime=?, prezime=?, email=?, lozinka=? WHERE id=?");
            upit.setString(1, korisnik.getIme());
            upit.setString(2, korisnik.getPrezime());
            upit.setString(3, korisnik.getEmail());
            upit.setString(4, korisnik.getLozinka());
            upit.setInt(5, korisnik.getId());
            upit.executeUpdate();
            return korisnik;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        }    
    }

    @Override
    public boolean brisi(Korisnik korisnik) {
        try {
            PreparedStatement upit = DB.prepare ("DELETE FROM korisnici WHERE id=?");
            upit.setInt(1, korisnik.getId());
            upit.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return false;
        }
    
    }

    @Override
    public List<Korisnik> sveIzBaze() {
        try {
            List <Korisnik> korisnici = new ArrayList<Korisnik> ();
            ResultSet rs = DB.select("SELECT * FROM korisnici");
            while (rs.next()){
                korisnici.add(new Korisnik(
                        rs.getInt(1), 
                        rs.getString(1),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
            return korisnici;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Korisnik izBazePremaId(int id) {
        try {
            PreparedStatement upit = DB.prepare ("SELECT * FROM korisnici WHERE id=?");
            upit.setInt(1, id);
            ResultSet rs = upit.executeQuery();
            if (rs.next()){
                return new Korisnik(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        }
    }
    
}
