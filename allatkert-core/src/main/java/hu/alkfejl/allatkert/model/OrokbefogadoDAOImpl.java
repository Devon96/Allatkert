package hu.alkfejl.allatkert.model;

import hu.alkfejl.allatkert.model.bean.Allat;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrokbefogadoDAOImpl implements OrokbefogadoDAO {

    private static final String CONN_STR = "jdbc:sqlite:/opt/tomcat/bin/allatkert.db";
    private static final String SELECT_ALL_OROKBEFOGADO = "SELECT felhasznalonev, nev, telefon, email, felvetel_ideje FROM Orokbefogadok";
    private static final String INSERT_OROKBEFOGADO = "INSERT INTO Orokbefogadok VALUES(?,?,?,?,?,datetime('now'))";
    private static final String DELETE_OROKBEFOGADO = "DELETE FROM Orokbefogadok WHERE felhasznalonev = (?)";
    private static final String UPDATE_OROKBEFOGADO = "UPDATE Orokbefogadok SET jelszo=?, nev=?, telefon=?, email=? WHERE felhasznalonev=?";
    private static final String SELECT_FELHASZNALONEV = "SELECT felhasznalonev FROM Orokbefogadok";

    @Override
    public boolean addOrokbefogado(Orokbefogado orokbefogado) {

        try (Connection conn = DriverManager.getConnection(CONN_STR);
             PreparedStatement st = conn.prepareStatement(INSERT_OROKBEFOGADO)
        ) {
            st.setString(1, orokbefogado.getFelhasznalonev());
            st.setString(2, orokbefogado.getJelszo());
            st.setString(3, orokbefogado.getNev());
            st.setString(4, orokbefogado.getTelefonszam());
            st.setString(5, orokbefogado.getEmail());

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
    public List<Orokbefogado> listOrokbefogado() {

        List<Orokbefogado> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(CONN_STR);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL_OROKBEFOGADO)
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

        try (Connection conn = DriverManager.getConnection(CONN_STR);
             PreparedStatement st = conn.prepareStatement(UPDATE_OROKBEFOGADO)
        ) {
            st.setString(1, orokbefogado.getJelszo());
            st.setString(2, orokbefogado.getNev());
            st.setString(3, orokbefogado.getTelefonszam());
            st.setString(4, orokbefogado.getEmail());
            st.setString(5, orokbefogado.getFelhasznalonev());

            int res = st.executeUpdate();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteOrokbefogado(Orokbefogado orokbefogado) {

        try (Connection conn = DriverManager.getConnection(CONN_STR);
             PreparedStatement st = conn.prepareStatement(DELETE_OROKBEFOGADO)
        ) {
            st.setString(1,orokbefogado.getFelhasznalonev());
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
    public List<String> listFelhasznalonev() {
        List<String> result = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(CONN_STR);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_FELHASZNALONEV)
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
