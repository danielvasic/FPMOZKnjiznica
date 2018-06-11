/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpmozknjiznica.model;

import javafx.scene.image.Image;

/**
 *
 * @author itic-4
 */
public class Korisnik {
    private int id;
    private String ime;
    private String prezime;
    private String email;
    private String lozinka;
    private Image slika;

    public Korisnik(int id, String ime, String prezime, String email, String lozinka, Image slika) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.slika = slika;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    
    public Image getSlika () {
        return this.slika;
    }
    
    public void setSlika (Image slika){
        this.slika = slika;
    }
}
