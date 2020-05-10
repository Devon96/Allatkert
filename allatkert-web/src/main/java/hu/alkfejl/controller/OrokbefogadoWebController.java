package hu.alkfejl.controller;

import hu.alkfejl.allatkert.controller.KonyvelesController;
import hu.alkfejl.allatkert.controller.OrokbefogadoController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/OrokbefogadoWebController")
public class OrokbefogadoWebController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private OrokbefogadoController orokbefogadoController = OrokbefogadoController.getInstance();



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        req.setAttribute("orokbefogadoList", orokbefogadoController.listOrokbefogado());




    }
}
