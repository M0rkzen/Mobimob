package com.example.Mobimob.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Imobile")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Proprietate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tipImobil")
    private String tipImobil;
    @Column(name = "pret")
    private String pret;
    @NotNull(message = "Imobilul necesita o locatie")
    @Column(name = "locatie")
    private String locatie;
    @NotNull(message = "Este necesara o persoana de contact")
    private String persoanaContact;
    private String telefon;
    @Column(name = "disponibil")
    private boolean disponibil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipImobil() {
        return tipImobil;
    }

    public void setTipImobil(String tipImobil) {
        this.tipImobil = tipImobil;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getPersoanaContact() {
        return persoanaContact;
    }

    public void setPersoanaContact(String persoanaContact) {
        this.persoanaContact = persoanaContact;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public boolean isDisponibil() {
        return disponibil;
    }

    public void setDisponibil(boolean disponibil) {
        this.disponibil = disponibil;
    }

    public Proprietate(Long id, String tipImobil, String pret, String locatie, String persoanaContact, String telefon, boolean disponibil) {
        this.id = id;
        this.tipImobil = tipImobil;
        this.pret = pret;
        this.locatie = locatie;
        this.persoanaContact = persoanaContact;
        this.telefon = telefon;
        this.disponibil = disponibil;
    }

    public Proprietate() {
    }
}


