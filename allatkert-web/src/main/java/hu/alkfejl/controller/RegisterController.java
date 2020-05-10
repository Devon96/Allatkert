package hu.alkfejl.controller;

import hu.alkfejl.allatkert.controller.OrokbefogadoController;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {

    OrokbefogadoController orokbefogadoController = OrokbefogadoController.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");

        Orokbefogado orokbefogado = new Orokbefogado();

        orokbefogado.setFelhasznalonev(req.getParameter("felhasznalonev"));
        orokbefogado.setJelszo(req.getParameter("jelszo"));
        orokbefogado.setNev(req.getParameter("nev"));
        orokbefogado.setTelefonszam(req.getParameter("telefon"));
        orokbefogado.setEmail(req.getParameter("email"));

        System.out.println(orokbefogado.getFelhasznalonev() + " " + orokbefogado.getJelszo() + " " + orokbefogado.getNev()
                + " " + orokbefogado.getTelefonszam() + " " + orokbefogado.getEmail());

        orokbefogadoController.addOrokbefogado(orokbefogado);

        resp.sendRedirect("pages/login.jsp");
    }
}