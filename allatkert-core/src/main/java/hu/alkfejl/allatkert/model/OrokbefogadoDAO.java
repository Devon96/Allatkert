package hu.alkfejl.allatkert.model;

import hu.alkfejl.allatkert.model.bean.Orokbefogado;

import java.util.List;

public interface OrokbefogadoDAO {

    boolean addOrokbefogado(Orokbefogado orokbefogado);
    List<Orokbefogado> listOrokbefogado();
    boolean updateOrokbefogado(Orokbefogado orokbefogado);
    boolean deleteOrokbefogado(Orokbefogado orokbefogado);
    List<String> listFelhasznalonev();
    Orokbefogado login (String username, String password);
}
