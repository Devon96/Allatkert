package hu.alkfejl.allatkert.model.bean;

import javafx.beans.property.*;

import java.io.Serializable;

public class Konyveles implements Serializable {

    private static final LongProperty serialVersionUID = new SimpleLongProperty(-7140401042409163579L);
    private ObjectProperty<Allat> orokbefogadott = new SimpleObjectProperty<>();
    private ObjectProperty<Orokbefogado> orokbefogado = new SimpleObjectProperty<>();
    private StringProperty orokbefogadasIdeje = new SimpleStringProperty();
    private StringProperty leiras = new SimpleStringProperty();
    private StringProperty tamogatasTipusa = new SimpleStringProperty();
    private IntegerProperty tamogatasOsszege = new SimpleIntegerProperty();
    private IntegerProperty tamogatasMennyisege = new SimpleIntegerProperty();
    private StringProperty gyakorisag = new SimpleStringProperty();

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

    public Allat getOrokbefogadott() {
        return orokbefogadott.get();
    }

    public ObjectProperty<Allat> orokbefogadottProperty() {
        return orokbefogadott;
    }

    public void setOrokbefogadott(Allat orokbefogadott) {
        this.orokbefogadott.set(orokbefogadott);
    }

    public Orokbefogado getOrokbefogado() {
        return orokbefogado.get();
    }

    public ObjectProperty<Orokbefogado> orokbefogadoProperty() {
        return orokbefogado;
    }

    public void setOrokbefogado(Orokbefogado orokbefogado) {
        this.orokbefogado.set(orokbefogado);
    }

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

    public int getTamogatasOsszege() {
        return tamogatasOsszege.get();
    }

    public IntegerProperty tamogatasOsszegeProperty() {
        return tamogatasOsszege;
    }

    public void setTamogatasOsszege(int tamogatasOsszege) {
        this.tamogatasOsszege.set(tamogatasOsszege);
    }

    public int getTamogatasMennyisege() {
        return tamogatasMennyisege.get();
    }

    public IntegerProperty tamogatasMennyisegeProperty() {
        return tamogatasMennyisege;
    }

    public void setTamogatasMennyisege(int tamogatasMennyisege) {
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
}
