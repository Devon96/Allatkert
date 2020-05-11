package hu.alkfejl.allatkert.controller;

import hu.alkfejl.allatkert.model.KonyvelesDAO;
import hu.alkfejl.allatkert.model.KonyvelesDAOImpl;
import hu.alkfejl.allatkert.model.bean.Konyveles;

import java.util.List;

public class KonyvelesController {

    private KonyvelesDAO dao = new KonyvelesDAOImpl();
    private static KonyvelesController single_instance = null;

    private KonyvelesController(){

    }

    public static KonyvelesController getInstance(){
        if(single_instance == null){
            single_instance = new KonyvelesController();
        }
        return single_instance;
    }

    public boolean addKonyveles(Konyveles konyveles){return dao.addKonyveles(konyveles);}
    public List<Konyveles> listKonyveles(){return dao.listKonyveles();}
    public boolean deleteKonyveles(Konyveles konyveles){return dao.deleteKonyveles(konyveles);}
    public List<Konyveles> listOrokbefogadoSzerint(String orokbefogado){return dao.listOrokbefogadoSzerint(orokbefogado);}
    public List<Konyveles> listOrokbefogadottSzerint(String orokbefogadott){return dao.listOrokbefogadottSzerint(orokbefogadott);}
    public List<Konyveles> listIdopontSzerint(String idopont){return dao.listIdopontSzerint(idopont);}
    public List<Konyveles> listTipusSzerint(String tipus){return dao.listTipusSzerint(tipus);}
    public List<String> listOrokbefogadok(){return dao.listOrokbefogadok();}
    public List<String> listOrokbefogadottak(){return dao.listOrokbefogadottak();}
    public List<String> listTamogatasTipusok(){return dao.listTamogatasTipusok();}





}
