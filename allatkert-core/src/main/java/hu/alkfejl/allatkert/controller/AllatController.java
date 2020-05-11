package hu.alkfejl.allatkert.controller;

import hu.alkfejl.allatkert.model.AllatDAO;
import hu.alkfejl.allatkert.model.AllatDAOImpl;
import hu.alkfejl.allatkert.model.bean.Allat;

import java.util.List;

public class AllatController {

    private AllatDAO dao = new AllatDAOImpl();
    private static AllatController single_instance = null;

    private AllatController(){

    }

    public static AllatController getInstance(){
        if(single_instance == null){
            single_instance = new AllatController();
        }
        return single_instance;
    }

    public boolean addAllat(Allat allat){return dao.addAllat(allat);}
    public List<Allat> listAllat(){return dao.listAllat();}
    public boolean updateAllat(Allat allat){return dao.updateAllat(allat);}
    public boolean deleteAllat(Allat allat){return dao.deleteAllat(allat);}
    public List<String> listAzonosito(){return dao.listAzonosito();}
    public List<Allat> listOrokbefogadottAllat(){return dao.listOrokbefogadottAllat();};
    public List<Allat> listOrokbefogadatlanAllat(){return dao.listOrokbefogadatlanAllat();};
    public List<Allat> OrokbefogadhatoAllatok(){return dao.OrokbefogadhatoAllatok();}




}
