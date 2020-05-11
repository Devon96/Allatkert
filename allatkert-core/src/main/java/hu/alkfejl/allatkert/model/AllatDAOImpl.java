package hu.alkfejl.allatkert.model;

import hu.alkfejl.allatkert.config.DBConfig;
import hu.alkfejl.allatkert.model.bean.Allat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllatDAOImpl implements AllatDAO {

    private static final String SELECT_ALL_ALLAT = "SELECT * FROM Allatok";
    private static final String INSERT_ALLAT = "INSERT INTO Allatok(nev,faj,fenykep,bemutatkozas,szuletesi_ev) VALUES (?,?,?,?,?)";
    private static final String INSERT_ALLAT_DEFAULT = "INSERT INTO Allatok(nev,faj,bemutatkozas,szuletesi_ev) VALUES (?,?,?,?)";
    private static final String DELETE_ALLAT = "DELETE FROM Allatok WHERE azonosito = ?";
    private static final String SELECT_AZONOSITO = "SELECT azonosito FROM Allatok";
    private static final String SELECT_OROKBEFOGADOTT_ALLATOK = "SELECT * from Allatok,Konyveles WHERE Allatok.azonosito = Konyveles.azonosito GROUP BY Allatok.azonosito";
    private static final String SELECT_OROKBEFOGADATLAN_ALLATOK = "SELECT * from Allatok WHERE Allatok.azonosito NOT IN (SELECT azonosito FROM Konyveles)";
    private static final String SELECT_OROKBEFOGADHATO_ALLATOK = "SELECT DISTINCT Allatok.azonosito, Allatok.nev,Allatok.faj, Allatok.fenykep, Allatok.bemutatkozas, Allatok.szuletesi_ev FROM Allatok,Konyveles WHERE Allatok.azonosito = Konyveles.azonosito AND szuletesi_ev > 2018 OR Allatok.azonosito NOT IN (SELECT DISTINCT Konyveles.azonosito FROM Konyveles)";

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

        if(allat.getKep() != null && !(allat.getKep().isEmpty())){
            try (Connection conn = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                 PreparedStatement st = conn.prepareStatement(INSERT_ALLAT)
            ) {
                st.setString(1, allat.getNev());
                st.setString(2, allat.getFaj());
                st.setString(3, allat.getKep());
                st.setString(4, allat.getBemutatkozas());
                st.setInt(5,allat.getSzuletesiEv());

                int res = st.executeUpdate();
                if (res == 1) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            try (Connection conn = DriverManager.getConnection(DBConfig.DB_CONN_STR);
                 PreparedStatement st = conn.prepareStatement(INSERT_ALLAT_DEFAULT)
            ) {
                st.setString(1, allat.getNev());
                st.setString(2, allat.getFaj());
                st.setString(3, allat.getBemutatkozas());
                st.setInt(4,allat.getSzuletesiEv());

                int res = st.executeUpdate();
                if (res == 1) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Allat> listAllat() {

        List<Allat> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(DBConfig.DB_CONN_STR);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL_ALLAT)
        ){
            while(rs.next()){
                Allat allat = new Allat(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
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

        try (Connection conn = DriverManager.getConnection(DBConfig.DB_CONN_STR);
             PreparedStatement st = conn.prepareStatement(DELETE_ALLAT)
        ) {
            st.setInt(1,allat.getAzonosito());
            int res = st.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public List<String> listAzonosito() {
        List<String> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(DBConfig.DB_CONN_STR);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_AZONOSITO)
        ){
            while(rs.next()){
                String string = Integer.toString(rs.getInt(1));
                result.add(string);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public List<Allat> listOrokbefogadottAllat() {
        List<Allat> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(DBConfig.DB_CONN_STR);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_OROKBEFOGADOTT_ALLATOK)
        ){
            while(rs.next()){
                Allat allat = new Allat(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
                result.add(allat);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Allat> listOrokbefogadatlanAllat() {
        List<Allat> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(DBConfig.DB_CONN_STR);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_OROKBEFOGADATLAN_ALLATOK)
        ){
            while(rs.next()){
                Allat allat = new Allat(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
                result.add(allat);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public List<Allat> OrokbefogadhatoAllatok() {
        List<Allat> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(DBConfig.DB_CONN_STR);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_OROKBEFOGADHATO_ALLATOK)
        ){
            while(rs.next()){
                Allat allat = new Allat(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
                result.add(allat);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
