package hu.alkfejl.allatkert.model;

import hu.alkfejl.allatkert.model.bean.Konyveles;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KonyvelesDAOImpl implements KonyvelesDAO {

    private static final String CONN_STR = "jdbc:sqlite:/opt/tomcat/bin/allatkert.db";
    private static final String SELECT_ALL_KONYVELES = "SELECT id,felhasznalonev,azonosito,idopont,leiras,tipus,osszeg,mennyiseg,gyakorisag FROM Konyveles";
    private static final String INSERT_KONYVELES= "INSERT INTO Konyveles VALUES(?,?,datetime('now'),?,?,?,?,?)";
    private static final String DELETE_KONYVELES = "DELETE FROM Konyveles WHERE id = (?)";
    private static final String UPDATE_KONYVELES = "UPDATE Konyveles SET felhasznalonev=?, azonosito=?, idopont=?, leiras=?, tipus=?, osszeg=?, mennyiseg=?, gyakorisag=? WHERE id=?";




    @Override
    public boolean addKonyveles(Konyveles konyveles) {
        return false;
    }

    @Override
    public List<Konyveles> listKonyveles() {

        List<Konyveles> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(CONN_STR);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL_KONYVELES);
        ){
            while(rs.next()){
                Konyveles konyveles = new Konyveles(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getString(9));
                result.add(konyveles);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;


    }

    @Override
    public boolean updateKonyveles(Konyveles konyveles) {
        return false;
    }

    @Override
    public boolean deleteKonyveles(Konyveles konyveles) {
        return false;
    }
}
