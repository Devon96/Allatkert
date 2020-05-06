package hu.alkfejl.allatkert.model;

import hu.alkfejl.allatkert.model.bean.Allat;
import hu.alkfejl.allatkert.model.bean.Konyveles;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KonyvelesDAOImpl implements KonyvelesDAO {

    private static final String CONN_STR = "jdbc:sqlite:/opt/tomcat/bin/allatkert.db";
    private static final String SELECT_ALL_KONYVELES = "SELECT id,felhasznalonev,azonosito,idopont,leiras,tipus,osszeg,mennyiseg,gyakorisag FROM Konyveles";
    private static final String INSERT_KONYVELES= "INSERT INTO Konyveles (felhasznalonev,azonosito,idopont,leiras,tipus,osszeg,mennyiseg,gyakorisag) VALUES(?,?,datetime('now'),?,?,?,?,?)";
    private static final String DELETE_KONYVELES = "DELETE FROM Konyveles WHERE id = (?)";
    private static final String UPDATE_KONYVELES = "UPDATE Konyveles SET felhasznalonev=?, azonosito=?, idopont=?, leiras=?, tipus=?, osszeg=?, mennyiseg=?, gyakorisag=? WHERE id=?";
    private static final String LIST_OROKBEFOGADO_SZERINT = "SELECT * FROM Konyveles WHERE felhasznalonev = ?";
    private static final String LIST_OROKBEFOGADOTT_SZERINT = "SELECT * FROM Konyveles WHERE azonosito = ?";
    private static final String LIST_IDOPONT_SZERINT = "SELECT * FROM Konyveles WHERE idopont LIKE ?";
    private static final String LIST_TIPUS_SZERINT = "SELECT * FROM Konyveles WHERE tipus = ?";
    private static final String LIST_OROKBEFOGADOK = "SELECT DISTINCT felhasznalonev FROM Konyveles";
    private static final String LIST_OROKBEFOGADOTTAK = "SELECT DISTINCT azonosito FROM Konyveles";
    private static final String LIST_TAMOGATASTIPUSOK = "SELECT DISTINCT tipus FROM Konyveles";


    @Override
    public boolean addKonyveles(Konyveles konyveles) {

        try (Connection conn = DriverManager.getConnection(CONN_STR);
             PreparedStatement st = conn.prepareStatement(INSERT_KONYVELES)
        ) {
            st.setString(1, konyveles.getFelhasznalonev());
            st.setString(2, konyveles.getAzonosito());
            st.setString(3, konyveles.getLeiras());
            st.setString(4, konyveles.getTamogatasTipusa());
            st.setString(5, konyveles.getTamogatasOsszege());
            st.setString(6, konyveles.getTamogatasMennyisege());
            st.setString(7, konyveles.getGyakorisag());

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
    public List<Konyveles> listKonyveles() {

        List<Konyveles> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(CONN_STR);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL_KONYVELES)
        ){
            while(rs.next()){
                Konyveles konyveles = new Konyveles(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                result.add(konyveles);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateKonyveles(Konyveles konyveles) {

        try (Connection conn = DriverManager.getConnection(CONN_STR);
             PreparedStatement st = conn.prepareStatement(UPDATE_KONYVELES)
        ) {
            st.setString(1, konyveles.getFelhasznalonev());
            st.setString(2, konyveles.getAzonosito());
            st.setString(3, konyveles.getOrokbefogadasIdeje());
            st.setString(4, konyveles.getLeiras());
            st.setString(5, konyveles.getTamogatasTipusa());
            st.setString(6, konyveles.getTamogatasOsszege());
            st.setString(7, konyveles.getTamogatasMennyisege());
            st.setString(8, konyveles.getGyakorisag());
            st.setInt(9, konyveles.getKonyvelesID());

            int res = st.executeUpdate();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteKonyveles(Konyveles konyveles) {

        try (Connection conn = DriverManager.getConnection(CONN_STR);
             PreparedStatement st = conn.prepareStatement(DELETE_KONYVELES)
        ) {
            st.setInt(1,konyveles.getKonyvelesID());
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
    public List<Konyveles> listOrokbefogadoSzerint(String orokbefogado) {
        List<Konyveles> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(CONN_STR);
            PreparedStatement st = conn.prepareStatement(LIST_OROKBEFOGADO_SZERINT)
        ){
            st.setString(1,orokbefogado);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Konyveles konyveles = new Konyveles(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                result.add(konyveles);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Konyveles> listOrokbefogadottSzerint(String orokbefogadott) {
        List<Konyveles> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(CONN_STR);
            PreparedStatement st = conn.prepareStatement(LIST_OROKBEFOGADOTT_SZERINT)
        ){
            st.setInt(1,Integer.parseInt(orokbefogadott));
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Konyveles konyveles = new Konyveles(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                result.add(konyveles);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Konyveles> listIdopontSzerint(String idopont) {
        List<Konyveles> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(CONN_STR);
            PreparedStatement st = conn.prepareStatement(LIST_IDOPONT_SZERINT)
        ){
            st.setString(1,idopont+"%");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Konyveles konyveles = new Konyveles(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                result.add(konyveles);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Konyveles> listTipusSzerint(String tipus) {
        List<Konyveles> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(CONN_STR);
            PreparedStatement st = conn.prepareStatement(LIST_TIPUS_SZERINT)
        ){
            st.setString(1,tipus);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Konyveles konyveles = new Konyveles(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                result.add(konyveles);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public List<String> listOrokbefogadok() {
        List<String> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(CONN_STR);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(LIST_OROKBEFOGADOK)
        ){
            while(rs.next()){
                String string = rs.getString(1);
                result.add(string);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<String> listOrokbefogadottak() {
        List<String> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(CONN_STR);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(LIST_OROKBEFOGADOTTAK)
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
    public List<String> listTamogatasTipusok() {
        List<String> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(CONN_STR);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(LIST_TAMOGATASTIPUSOK)
        ){
            while(rs.next()){
                String string = rs.getString(1);
                result.add(string);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
