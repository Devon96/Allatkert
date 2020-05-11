package hu.alkfejl.allatkert.model.bean;

import hu.alkfejl.allatkert.utils.Utils;
import javafx.beans.property.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Base64;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;

public class Allat implements Serializable {

    private static final LongProperty serialVersionUID = new SimpleLongProperty(9131632767569531030L);
    private IntegerProperty azonosito = new SimpleIntegerProperty();
    private StringProperty nev = new SimpleStringProperty();
    private StringProperty faj = new SimpleStringProperty();
    private StringProperty kep = new SimpleStringProperty();
    private StringProperty bemutatkozas = new SimpleStringProperty();
    private IntegerProperty szuletesiEv = new SimpleIntegerProperty();
    private ObjectProperty<Image> photo = new SimpleObjectProperty<>();



    public Image getPhoto() {
        return photo.get();
    }

    public ObjectProperty<Image> photoProperty() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo.set(photo);
    }

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
/*
    public Allat(IntegerProperty azonosito, StringProperty nev, StringProperty faj, StringProperty kep, StringProperty bemutatkozas, IntegerProperty szuletesiEv) {
        this.azonosito = azonosito;
        this.nev = nev;
        this.faj = faj;
        this.kep = kep;
        this.bemutatkozas = bemutatkozas;
        this.szuletesiEv = szuletesiEv;
    }
*/
    public static long getSerialVersionUID() {
        return serialVersionUID.get();
    }

    public static LongProperty serialVersionUIDProperty() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Allat.serialVersionUID.set(serialVersionUID);
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

    public int getSzuletesiEv() {
        return szuletesiEv.get();
    }

    public IntegerProperty szuletesiEvProperty() {
        return szuletesiEv;
    }

    public void setSzuletesiEv(int szuletesiEv) {
        this.szuletesiEv.set(szuletesiEv);
    }
/*
    public Allat(int azonosito, String nev, String faj, String kep, String bemutatkozas, int szuletesiEv) {
        this.azonosito.set(azonosito);
        this.nev.set(nev);
        this.faj.set(faj);
        this.kep.set(kep);
        this.bemutatkozas.set(bemutatkozas);
        this.szuletesiEv.set(szuletesiEv);
    }
*/
    public Allat(int azonosito, String nev, String faj, String kep, String bemutatkozas, int szuletesiEv) {
        this.azonosito.set(azonosito);
        this.nev.set(nev);
        this.faj.set(faj);
        this.kep.set(kep);
        this.bemutatkozas.set(bemutatkozas);
        this.szuletesiEv.set(szuletesiEv);


    }










}
