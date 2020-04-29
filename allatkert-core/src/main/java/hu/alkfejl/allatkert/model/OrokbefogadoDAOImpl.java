package hu.alkfejl.allatkert.model;

import hu.alkfejl.allatkert.model.bean.Allat;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrokbefogadoDAOImpl implements OrokbefogadoDAO {

    private static final String CONN_STR = "jdbc:sqlite:/opt/tomcat/bin/allatkert.db";
    private static final String SELECT_ALL_OROKBEFOGADO = "SELECT felhasznalonev, nev, telefon, email, felvetel_ideje FROM Orokbefogadok";
    private static final String INSERT_OROKBEFOGADO = "";


    @Override
    public boolean addOrokbefogado(Orokbefogado orokbefogado) {
        return false;
    }

    @Override
    public List<Orokbefogado> listOrokbefogado() {

        List<Orokbefogado> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(CONN_STR);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL_OROKBEFOGADO);
        ){
            while(rs.next()){
                Orokbefogado orokbefogado = new Orokbefogado(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                result.add(orokbefogado);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateOrokbefogado(Orokbefogado orokbefogado) {
        return false;
    }

    @Override
    public boolean deleteOrokbefogado(Orokbefogado orokbefogado) {
        return false;
    }
}
