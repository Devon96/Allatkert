package hu.alkfejl.allatkert.controller;

import hu.alkfejl.allatkert.model.KonyvelesDAO;
import hu.alkfejl.allatkert.model.KonyvelesDAOImpl;
import hu.alkfejl.allatkert.model.OrokbefogadoDAO;
import hu.alkfejl.allatkert.model.OrokbefogadoDAOImpl;
import hu.alkfejl.allatkert.model.bean.Konyveles;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;

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
    public boolean updateKonyveles(Konyveles konyveles){return dao.updateKonyveles(konyveles);}
    public boolean deleteKonyveles(Konyveles konyveles){return dao.deleteKonyveles(konyveles);}





}
