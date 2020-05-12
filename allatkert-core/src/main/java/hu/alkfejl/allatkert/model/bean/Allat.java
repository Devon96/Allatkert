package hu.alkfejl.allatkert.model.bean;

import javafx.beans.property.*;

import java.io.Serializable;

public class Allat implements Serializable {

    private static final LongProperty serialVersionUID = new SimpleLongProperty(9131632767569531030L);
    private StringProperty azonosito = new SimpleStringProperty();
    private StringProperty nev = new SimpleStringProperty();
    private StringProperty faj = new SimpleStringProperty();
    private StringProperty kep = new SimpleStringProperty();
    private StringProperty bemutatkozas = new SimpleStringProperty();
    private StringProperty szuletesiEv = new SimpleStringProperty();



    public Allat() {
    }

    @Override
    public String toString() {
        return "Allat{" +
                "azonosito=" + azonosito +
                ", nev=" + nev +
                ", faj=" + faj +
                ", kep=" + kep +
                ", bemutatkozas=" + bemutatkozas +
                ", szuletesiEv=" + szuletesiEv +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID.get();
    }

    public static LongProperty serialVersionUIDProperty() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Allat.serialVersionUID.set(serialVersionUID);
    }

    public String getAzonosito() {
        return azonosito.get();
    }

    public StringProperty azonositoProperty() {
        return azonosito;
    }

    public void setAzonosito(String azonosito) {
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

    public String getFaj() {
        return faj.get();
    }

    public StringProperty fajProperty() {
        return faj;
    }

    public void setFaj(String faj) {
        this.faj.set(faj);
    }

    public String getKep() {
        return kep.get();
    }

    public StringProperty kepProperty() {
        return kep;
    }

    public void setKep(String kep) {
        this.kep.set(kep);
    }

    public String getBemutatkozas() {
        return bemutatkozas.get();
    }

    public StringProperty bemutatkozasProperty() {
        return bemutatkozas;
    }

    public void setBemutatkozas(String bemutatkozas) {
        this.bemutatkozas.set(bemutatkozas);
    }

    public String getSzuletesiEv() {
        return szuletesiEv.get();
    }

    public StringProperty szuletesiEvProperty() {
        return szuletesiEv;
    }

    public void setSzuletesiEv(String szuletesiEv) {
        this.szuletesiEv.set(szuletesiEv);
    }


    public Allat(String azonosito, String nev, String faj, String kep, String bemutatkozas, String szuletesiEv) {
        this.azonosito.set(azonosito);
        this.nev.set(nev);
        this.faj.set(faj);
        this.kep.set(kep);
        this.bemutatkozas.set(bemutatkozas);
        this.szuletesiEv.set(szuletesiEv);
    }

    public void copyTo(Allat target){
        target.setAzonosito(this.getAzonosito());
        target.setNev(this.getNev());
        target.setFaj(this.getFaj());
        target.setKep(this.getKep());
        target.setBemutatkozas(this.getBemutatkozas());
        target.setSzuletesiEv(this.getSzuletesiEv());
    }








}
