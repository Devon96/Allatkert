package hu.alkfejl.controller;


import hu.alkfejl.allatkert.controller.KonyvelesController;
import hu.alkfejl.allatkert.model.bean.Konyveles;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;

import javax.servlet.RequestDispatcher;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");


        String felhasznalonev = req.getParameter("konyvelesOrokbefogadoFelhasznalonev");
        String azonosito = req.getParameter("konyvelesOrokbefogadottAzonosito");
        String idopont = req.getParameter("konyvelesIdopont");
        String tipus = req.getParameter("konyvelesTamogatasTipusa");

        if(felhasznalonev != null && !felhasznalonev.equals("")){
            req.setAttribute("kivalasztottFelhasznalonev",felhasznalonev);
            doGet(req, resp);
        }
        if(azonosito != null && !azonosito.equals("")){
            req.setAttribute("kivalasztottAzonosito",azonosito);
            doGet(req, resp);
        }
        if(idopont != null && !idopont.equals("")){
            req.setAttribute("kivalasztottIdopont",idopont);
            doGet(req, resp);
        }
        if(tipus != null && !tipus.equals("")){
            req.setAttribute("kivalasztottTipus",tipus);
            doGet(req, resp);
        }










    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");


        if(req.getParameter("konyvelesOrokbefogadoFelhasznalonev") != null){
            if(req.getParameter("konyvelesOrokbefogadoFelhasznalonev").equals("frissites")){
                req.setAttribute("konyvelesList", konyvelesController.listKonyveles());
            }else{
                req.setAttribute("konyvelesList", konyvelesController.listOrokbefogadoSzerint(req.getParameter("konyvelesOrokbefogadoFelhasznalonev")));
            }
        }else if(req.getParameter("konyvelesOrokbefogadottAzonosito") != null){
            if(req.getParameter("konyvelesOrokbefogadottAzonosito").equals("frissites")){
                req.setAttribute("konyvelesList", konyvelesController.listKonyveles());
            }else{
                req.setAttribute("konyvelesList", konyvelesController.listOrokbefogadottSzerint(req.getParameter("konyvelesOrokbefogadottAzonosito")));
            }
        }else if(req.getParameter("konyvelesIdopont") != null){
            req.setAttribute("konyvelesList", konyvelesController.listIdopontSzerint(req.getParameter("konyvelesIdopont")));
        }else if(req.getParameter("konyvelesTamogatasTipusa") != null){
            if(req.getParameter("konyvelesTamogatasTipusa").equals("frissites")){
                req.setAttribute("konyvelesList", konyvelesController.listKonyveles());
            }else{
                req.setAttribute("konyvelesList", konyvelesController.listTipusSzerint(req.getParameter("konyvelesTamogatasTipusa")));
            }
        }else{
            req.setAttribute("konyvelesList", konyvelesController.listKonyveles());
        }


        //lenyíló listák feltöltése
        req.setAttribute("orokbefogadoFelhasznalonevekList",konyvelesController.listOrokbefogadok());
        req.setAttribute("orokbefogadottAzonositokList",konyvelesController.listOrokbefogadottak());
        req.setAttribute("tamogatasTipusaList",konyvelesController.listTamogatasTipusok());

    }
}
