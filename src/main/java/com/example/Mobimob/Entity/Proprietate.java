package com.example.Mobimob.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Imobile")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Proprietate {
    public enum TipImobil {
        CASA,
        APARTAMENT,
        DUPLEX,
        TEREN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipImobil")
    private TipImobil tipImobil;
    @Column(name = "pret")
    private String pret;
    @NotNull(message = "Imobilul necesita o locatie")
    @Column(name = "locatie")
    private String locatie;
    @NotNull(message = "Este necesara o persoana de contact")
    private String persoanaContact;
    private String telefon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipImobil getTipImobil() {
        return tipImobil;
    }

    public void setTipImobil(TipImobil tipImobil) {
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

    public Proprietate(Long id, TipImobil tipImobil, String pret, String locatie, String persoanaContact, String telefon) {
        this.id = id;
        this.tipImobil = tipImobil;
        this.pret = pret;
        this.locatie = locatie;
        this.persoanaContact = persoanaContact;
        this.telefon = telefon;
    }

    public Proprietate() {
    }
}


