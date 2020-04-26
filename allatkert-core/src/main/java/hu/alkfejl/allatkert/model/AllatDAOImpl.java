package hu.alkfejl.allatkert.model;

import hu.alkfejl.allatkert.model.bean.Allat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AllatDAOImpl implements AllatDAO {

    private static final String CONN_STR = "jdbc:sqlite:allatkert.db";
    private static final String SELECT_ALL_ALLAT = "SELECT * FROM Allatok";

    public AllatDAOImpl(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Nem sikerult betolteni a JDBC drivert");
            e.printStackTrace();
        }
    }

    @Override
    public boolean addAllat(Allat allat) {
        return false;
    }

    @Override
    public List<Allat> listAllat() {

        List<Allat> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(CONN_STR);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL_ALLAT)
        ){
            while(rs.next()){
                Allat allat = new Allat(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                result.add(allat);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateAllat(Allat allat) {
        return false;
    }

    @Override
    public boolean deleteAllat(Allat allat) {
        return false;
    }
}
