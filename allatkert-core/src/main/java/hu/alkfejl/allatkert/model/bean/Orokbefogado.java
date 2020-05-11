package hu.alkfejl.allatkert.model.bean;

import javafx.beans.property.*;

import java.io.Serializable;

public class Orokbefogado implements Serializable {

    private static final LongProperty serialVersionUID = new SimpleLongProperty(5252858952828847026L);
    private StringProperty felhasznalonev = new SimpleStringProperty();
    private StringProperty nev = new SimpleStringProperty();
    private StringProperty telefonszam = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();
    private StringProperty felvetelIdeje = new SimpleStringProperty();
    private StringProperty jelszo = new SimpleStringProperty();


    public Orokbefogado() {
    }

    public Orokbefogado(StringProperty felhasznalonev, StringProperty nev, StringProperty telefonszam, StringProperty email, StringProperty felvetelIdeje, StringProperty jelszo) {
        this.felhasznalonev = felhasznalonev;
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

    public String getFelhasznalonev() {
        return felhasznalonev.get();
    }

    public StringProperty felhasznalonevProperty() {
        return felhasznalonev;
    }

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev.set(felhasznalonev);
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

    public String getTelefonszam() {
        return telefonszam.get();
    }

    public StringProperty telefonszamProperty() {
        return telefonszam;
    }

    public void setTelefonszam(String telefonszam) {
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

    public Orokbefogado(String felhasznalonev, String jelszo, String nev, String telefonszam, String email, String felvetelIdeje) {
        this.felhasznalonev.set(felhasznalonev);
        this.jelszo.set(jelszo);
        this.nev.set(nev);
        this.telefonszam.set(telefonszam);
        this.email.set(email);
        this.felvetelIdeje.set(felvetelIdeje);
    }

    public Orokbefogado(String felhasznalonev, String nev, String telefonszam, String email, String felvetelIdeje) {
        this.felhasznalonev.set(felhasznalonev);
        this.nev.set(nev);
        this.telefonszam.set(telefonszam);
        this.email.set(email);
        this.felvetelIdeje.set(felvetelIdeje);
    }

    public void copyTo(Orokbefogado target){
        target.setFelhasznalonev(this.getFelhasznalonev());
        target.setJelszo(this.getJelszo());
        target.setNev(this.getNev());
        target.setTelefonszam(this.getTelefonszam());
        target.setEmail(this.getEmail());
        target.setFelvetelIdeje(this.getFelvetelIdeje());
    }








}
