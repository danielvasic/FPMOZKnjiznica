/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import static fpmozknjiznica.model.Baza.DB;
import fpmozknjiznica.model.Korisnik;
import interfaces.model;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author Admin
 */
public class KorisnikService implements model <Korisnik>{
    
    /**
     *
     */
    public static final KorisnikService korisnikService = new KorisnikService();

    @Override
    public Korisnik spasi(Korisnik korisnik) {
        try {
            
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(SwingFXUtils.fromFXImage(korisnik.getSlika(), null),"jpg", os); 
            InputStream fis = new ByteArrayInputStream(os.toByteArray());

            
            PreparedStatement upit = DB.prepare ("INSERT INTO korisnici VALUES(null, ?, ?, ?, ?, ?)");
            upit.setString(1, korisnik.getIme());
            upit.setString(2, korisnik.getPrezime());
            upit.setString(3, korisnik.getEmail());
            upit.setString(4, korisnik.getLozinka());
            upit.setBinaryStream(5, fis);
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
        } catch (FileNotFoundException ex) {
            System.out.println("Greška prilikom čitanja datoteke: " + ex.getMessage());
            return null;
        } catch (IOException ex) {
            System.out.println("Greška prilikom čitanja datoteke: " + ex.getMessage());
            return null;
        }
    
    }

    @Override
    public Korisnik uredi(Korisnik korisnik) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(SwingFXUtils.fromFXImage(korisnik.getSlika(), null), "jpg", os);
            InputStream fis = new ByteArrayInputStream(os.toByteArray());
            
            PreparedStatement upit = DB.prepare ("UPDATE korisnici SET ime=?, prezime=?, email=?, lozinka=?, slika=? WHERE id=?");
            upit.setString(1, korisnik.getIme());
            upit.setString(2, korisnik.getPrezime());
            upit.setString(3, korisnik.getEmail());
            upit.setString(4, korisnik.getLozinka());
            upit.setBinaryStream(5, fis);
            
            upit.setInt(6, korisnik.getId());
            upit.executeUpdate();
            return korisnik;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        } catch (FileNotFoundException ex) {
            System.out.println("Greška prilikom dodavanja slike: " + ex.getMessage());
            return null;
        } catch (IOException ex) {
            System.out.println("Greška prilikom dodavanja slike: " + ex.getMessage());
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
    public ObservableList<Korisnik> sveIzBaze() {
        try {
            ObservableList <Korisnik> korisnici = FXCollections.observableArrayList();
            ResultSet rs = DB.select("SELECT * FROM korisnici");
            
            while (rs.next()){
                Image fxSlika = null;
                try {
                    BufferedImage bImage = ImageIO.read(rs.getBinaryStream(6));
                    fxSlika = SwingFXUtils.toFXImage(bImage, null);
                } catch (NullPointerException ex) {
                    fxSlika = null;
                }
                
                
                korisnici.add(new Korisnik(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        fxSlika
                ));
            }
            return korisnici;
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        } catch (IOException ex) {
            System.out.println("Greška prilikom dodavanja slike: " + ex.getMessage());
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
                
                Image fxSlika = null;
                try {
                    BufferedImage bImage = ImageIO.read(rs.getBinaryStream(6));
                    fxSlika = SwingFXUtils.toFXImage(bImage, null);
                } catch (NullPointerException ex) {
                    fxSlika = null;
                }
                return new Korisnik(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        fxSlika
                );
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Greška prilikom izvršavanja upita: " + ex.getMessage());
            return null;
        } catch (IOException ex) {
            System.out.println("Greška prilikom čitanja datoteke: " + ex.getMessage());
            return null;
        }
    }
    
}
