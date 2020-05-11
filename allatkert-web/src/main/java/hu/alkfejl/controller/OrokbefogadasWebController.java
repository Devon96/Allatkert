package hu.alkfejl.controller;

import hu.alkfejl.allatkert.controller.AllatController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/OrokbefogadasWebController")
public class OrokbefogadasWebController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AllatController allatController = AllatController.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        req.setAttribute("orokbefogadhatokList", allatController.OrokbefogadhatoAllatok());

    }
}
