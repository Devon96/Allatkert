package hu.alkfejl.allatkert.model;

import hu.alkfejl.allatkert.model.bean.Konyveles;

import java.util.List;

public interface KonyvelesDAO {


    boolean addKonyveles(Konyveles konyveles);
    List<Konyveles> listKonyveles();
    boolean deleteKonyveles(Konyveles konyveles);
    List<Konyveles> listOrokbefogadoSzerint(String orokbefogado);
    List<Konyveles> listOrokbefogadottSzerint(String orokbefogadott);
    List<Konyveles> listIdopontSzerint(String idopont);
    List<Konyveles> listTipusSzerint(String tipus);
    List<String> listOrokbefogadok();
    List<String> listOrokbefogadottak();
    List<String> listTamogatasTipusok();




}
