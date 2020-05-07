package hu.alkfejl.allatkert.controller;

import hu.alkfejl.allatkert.model.AllatDAO;
import hu.alkfejl.allatkert.model.AllatDAOImpl;
import hu.alkfejl.allatkert.model.OrokbefogadoDAO;
import hu.alkfejl.allatkert.model.OrokbefogadoDAOImpl;
import hu.alkfejl.allatkert.model.bean.Allat;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;

import java.util.List;

public class OrokbefogadoController {

    private OrokbefogadoDAO dao = new OrokbefogadoDAOImpl();
    private static OrokbefogadoController single_instance = null;

    private OrokbefogadoController(){

    }

    public static OrokbefogadoController getInstance(){
        if(single_instance == null){
            single_instance = new OrokbefogadoController();
        }
        return single_instance;
    }

    public boolean addOrokbefogado(Orokbefogado orokbefogado){return dao.addOrokbefogado(orokbefogado);}
    public List<Orokbefogado> listOrokbefogado(){return dao.listOrokbefogado();}
    public boolean updateOrokbefogado(Orokbefogado orokbefogado){return dao.updateOrokbefogado(orokbefogado);}
    public boolean deleteOrokbefogado(Orokbefogado orokbefogado){return dao.deleteOrokbefogado(orokbefogado);}
    public List<String> listFelhasznalonev(){return dao.listFelhasznalonev();}
    public Orokbefogado login(String username, String password){return dao.login(username, password);}



}
