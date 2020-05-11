package hu.alkfejl.controller;

import hu.alkfejl.allatkert.controller.AllatController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AllatWebController")
public class AllatWebController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AllatController allatController = AllatController.getInstance();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");


        String statusz = req.getParameter("orokbefogadottsagiStatusz");
        if(statusz != null && !statusz.equals("")){
            req.setAttribute("kivalasztottStatusz",statusz);
            doGet(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if(req.getParameter("orokbefogadottsagiStatusz") != null){
            if(req.getParameter("orokbefogadottsagiStatusz").equals("orokbefogadottak")){
                req.setAttribute("allatList", allatController.listOrokbefogadottAllat());
            } else if(req.getParameter("orokbefogadottsagiStatusz").equals("orokbefogadatlanok")){
                req.setAttribute("allatList", allatController.listOrokbefogadatlanAllat());
            } else{
                req.setAttribute("allatList", allatController.listAllat());
            }
        }else{
            req.setAttribute("allatList", allatController.listAllat());
        }

    }
}
