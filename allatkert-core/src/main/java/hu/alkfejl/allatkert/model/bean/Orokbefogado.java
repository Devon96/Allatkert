package hu.alkfejl.allatkert.model.bean;

import javafx.beans.property.*;

import java.io.Serializable;

public class Orokbefogado implements Serializable {

    private static final LongProperty serialVersionUID = new SimpleLongProperty(5252858952828847026L);
    private IntegerProperty azonosito = new SimpleIntegerProperty();
    private StringProperty nev = new SimpleStringProperty();
    private IntegerProperty telefonszam = new SimpleIntegerProperty();
    private StringProperty email = new SimpleStringProperty();
    private StringProperty felvetelIdeje = new SimpleStringProperty();
    private StringProperty jelszo = new SimpleStringProperty();


    public Orokbefogado() {
    }

    public Orokbefogado(IntegerProperty azonosito, StringProperty nev, IntegerProperty telefonszam, StringProperty email, StringProperty felvetelIdeje, StringProperty jelszo) {
        this.azonosito = azonosito;
        this.nev = nev;
        this.telefonszam = telefonszam;
        this.email = email;
        this.felvetelIdeje = felvetelIdeje;
        this.jelszo = jelszo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID.get();
    }

    public static LongProperty serialVersionUIDProperty() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Orokbefogado.serialVersionUID.set(serialVersionUID);
    }

    public int getAzonosito() {
        return azonosito.get();
    }

    public IntegerProperty azonositoProperty() {
        return azonosito;
    }

    public void setAzonosito(int azonosito) {
        this.azonosito.set(azonosito);
    }

    public String getNev() {
        return nev.get();
    }

    public StringProperty nevProperty() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev.set(nev);
    }

    public int getTelefonszam() {
        return telefonszam.get();
    }

    public IntegerProperty telefonszamProperty() {
        return telefonszam;
    }

    public void setTelefonszam(int telefonszam) {
        this.telefonszam.set(telefonszam);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getFelvetelIdeje() {
        return felvetelIdeje.get();
    }

    public StringProperty felvetelIdejeProperty() {
        return felvetelIdeje;
    }

    public void setFelvetelIdeje(String felvetelIdeje) {
        this.felvetelIdeje.set(felvetelIdeje);
    }

    public String getJelszo() {
        return jelszo.get();
    }

    public StringProperty jelszoProperty() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo.set(jelszo);
    }
}
