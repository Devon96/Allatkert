package hu.alkfejl.controller;

import hu.alkfejl.allatkert.controller.KonyvelesController;
import hu.alkfejl.allatkert.model.KonyvelesDAOImpl;
import hu.alkfejl.allatkert.model.bean.Konyveles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Orokbefogadas")
public class Orokbefogadas extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private KonyvelesController konyvelesController = KonyvelesController.getInstance();
    private Konyveles konyveles = new Konyveles();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");


        konyveles.setFelhasznalonev(req.getParameter("konyvelesFelhasznalonev"));
        konyveles.setAzonosito(req.getParameter("konyvelesAzonosito"));
        konyveles.setLeiras(req.getParameter("konyvelesLeiras"));
        konyveles.setTamogatasTipusa(req.getParameter("konyvelesTamogatasTipusa"));
        konyveles.setTamogatasOsszege(req.getParameter("konyvelesTamogatasOsszege"));
        konyveles.setTamogatasMennyisege(req.getParameter("konyvelesTamogatasMennyisege"));
        konyveles.setGyakorisag(req.getParameter("konyvelesTamogatasGyakorisaga"));

        konyvelesController.addKonyveles(konyveles);

        resp.sendRedirect("pages/list_konyveles.jsp");

    }



}
