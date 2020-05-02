package hu.alkfejl.allatkert.model;

import hu.alkfejl.allatkert.model.bean.Konyveles;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;

import java.util.List;

public interface KonyvelesDAO {


    boolean addKonyveles(Konyveles konyveles);
    List<Konyveles> listKonyveles();
    boolean updateKonyveles(Konyveles konyveles);
    boolean deleteKonyveles(Konyveles konyveles);


}
