package hu.alkfejl.allatkert.model;

import hu.alkfejl.allatkert.model.bean.Allat;

import java.util.List;

public interface AllatDAO {

    boolean addAllat(Allat allat);
    List<Allat> listAllat();
    boolean updateAllat(Allat allat);
    boolean deleteAllat(Allat allat);
    List<String> listAzonosito();




}
