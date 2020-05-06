package hu.alkfejl.allatkert.model.bean;

import javafx.beans.property.*;

import java.io.Serializable;

public class Konyveles implements Serializable {

    private static final LongProperty serialVersionUID = new SimpleLongProperty(-7140401042409163579L);
    private IntegerProperty konyvelesID = new SimpleIntegerProperty();
    // private ObjectProperty<Allat> orokbefogadott = new SimpleObjectProperty<>();
   // private ObjectProperty<Orokbefogado> orokbefogado = new SimpleObjectProperty<>();
    private StringProperty orokbefogadasIdeje = new SimpleStringProperty();
    private StringProperty leiras = new SimpleStringProperty();
    private StringProperty tamogatasTipusa = new SimpleStringProperty();
    private StringProperty tamogatasOsszege = new SimpleStringProperty();
    private StringProperty tamogatasMennyisege = new SimpleStringProperty();
    private StringProperty gyakorisag = new SimpleStringProperty();
    private StringProperty felhasznalonev = new SimpleStringProperty();
    private StringProperty azonosito = new SimpleStringProperty();

    public Konyveles() {
    }




    public static long getSerialVersionUID() {
        return serialVersionUID.get();
    }

    public static LongProperty serialVersionUIDProperty() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Konyveles.serialVersionUID.set(serialVersionUID);
    }


    public int getKonyvelesID() {
        return konyvelesID.get();
    }

    public IntegerProperty konyvelesIDProperty() {
        return konyvelesID;
    }

    public void setKonyvelesID(int konyvelesID) {
        this.konyvelesID.set(konyvelesID);
    }

    /*
        public Allat getOrokbefogadott() {
            return orokbefogadott.get();
        }

        public ObjectProperty<Allat> orokbefogadottProperty() {
            return orokbefogadott;
        }

        public void setOrokbefogadott(Allat orokbefogadott) {
            this.orokbefogadott.set(orokbefogadott);
        }
    */
/*
    public Orokbefogado getOrokbefogado() {
        return orokbefogado.get();
    }

    public ObjectProperty<Orokbefogado> orokbefogadoProperty() {
        return orokbefogado;
    }

    public void setOrokbefogado(Orokbefogado orokbefogado) {
        this.orokbefogado.set(orokbefogado);
    }
*/
    public String getOrokbefogadasIdeje() {
        return orokbefogadasIdeje.get();
    }

    public StringProperty orokbefogadasIdejeProperty() {
        return orokbefogadasIdeje;
    }

    public void setOrokbefogadasIdeje(String orokbefogadasIdeje) {
        this.orokbefogadasIdeje.set(orokbefogadasIdeje);
    }

    public String getLeiras() {
        return leiras.get();
    }

    public StringProperty leirasProperty() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras.set(leiras);
    }

    public String getTamogatasTipusa() {
        return tamogatasTipusa.get();
    }

    public StringProperty tamogatasTipusaProperty() {
        return tamogatasTipusa;
    }

    public void setTamogatasTipusa(String tamogatasTipusa) {
        this.tamogatasTipusa.set(tamogatasTipusa);
    }

    public String getTamogatasOsszege() {
        return tamogatasOsszege.get();
    }

    public StringProperty tamogatasOsszegeProperty() {
        return tamogatasOsszege;
    }

    public void setTamogatasOsszege(String tamogatasOsszege) {
        this.tamogatasOsszege.set(tamogatasOsszege);
    }

    public String getTamogatasMennyisege() {
        return tamogatasMennyisege.get();
    }

    public StringProperty tamogatasMennyisegeProperty() {
        return tamogatasMennyisege;
    }

    public void setTamogatasMennyisege(String tamogatasMennyisege) {
        this.tamogatasMennyisege.set(tamogatasMennyisege);
    }

    public String getGyakorisag() {
        return gyakorisag.get();
    }

    public StringProperty gyakorisagProperty() {
        return gyakorisag;
    }

    public void setGyakorisag(String gyakorisag) {
        this.gyakorisag.set(gyakorisag);
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

    public String getAzonosito() {
        return azonosito.get();
    }

    public StringProperty azonositoProperty() {
        return azonosito;
    }

    public void setAzonosito(String azonosito) {
        this.azonosito.set(azonosito);
    }

    public Konyveles(int konyvelesID, String felhasznalonev, String azonosito, String orokbefogadasIdeje, String leiras, String tamogatasTipusa, String tamogatasOsszege, String tamogatasMennyisege, String gyakorisag) {
        this.konyvelesID.set(konyvelesID);
        this.felhasznalonev.set(felhasznalonev);
        this.azonosito.set(azonosito);
        this.orokbefogadasIdeje.set(orokbefogadasIdeje);
        this.leiras.set(leiras);
        this.tamogatasTipusa.set(tamogatasTipusa);
        this.tamogatasOsszege.set(tamogatasOsszege);
        this.tamogatasMennyisege.set(tamogatasMennyisege);
        this.gyakorisag.set(gyakorisag);
    }

    public Konyveles(StringProperty felhasznalonev, StringProperty azonosito, IntegerProperty konyvelesID, StringProperty orokbefogadasIdeje, StringProperty leiras, StringProperty tamogatasTipusa, StringProperty tamogatasOsszege, StringProperty tamogatasMennyisege, StringProperty gyakorisag) {
        this.konyvelesID = konyvelesID;
        this.felhasznalonev = felhasznalonev;
        this.azonosito = azonosito;
        this.orokbefogadasIdeje = orokbefogadasIdeje;
        this.leiras = leiras;
        this.tamogatasTipusa = tamogatasTipusa;
        this.tamogatasOsszege = tamogatasOsszege;
        this.tamogatasMennyisege = tamogatasMennyisege;
        this.gyakorisag = gyakorisag;

    }
}
