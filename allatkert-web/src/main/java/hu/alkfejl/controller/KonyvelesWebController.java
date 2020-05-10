package hu.alkfejl.controller;


import hu.alkfejl.allatkert.controller.KonyvelesController;
import hu.alkfejl.allatkert.model.bean.Konyveles;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/KonyvelesWebController")
public class KonyvelesWebController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private KonyvelesController konyvelesController = KonyvelesController.getInstance();


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setCharacterEncoding("UTF-8");
        /*
        if(request.getParameter("id") != null && !request.getParameter("id").equals("0") ){
            doPut(request, response);
            return;
        }

         */

        resp.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Konyveles k = new Konyveles();
/*
        Person p = new Person();
        User user = (User) request.getSession().getAttribute("currentUser");


        try {
            k.setKonyvelesID(Integer.parseInt(req.getParameter("id")));
            k.setFelhasznalonev(req.getParameter("felhasznalonev"));
            k.setAzonosito(req.getParameter("azonosito"));
            k.setOrokbefogadasIdeje(req.getParameter("idopont"));
            k.setLeiras(req.getParameter("leiras"));
            k.setTamogatasTipusa(req.getParameter("tipus"));
            k.setTamogatasOsszege(req.getParameter("osszeg"));
            k.setTamogatasMennyisege(req.getParameter("mennyiseg"));
            k.setGyakorisag(req.getParameter("gyakorisag"));


            if(dao.addSzemely(p, user)) {
                response.sendRedirect("pages/list_person.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }




 */

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("konyvelesList", konyvelesController.listKonyveles());
    }
}
