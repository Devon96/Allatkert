package hu.alkfejl.controller;

import hu.alkfejl.allatkert.controller.OrokbefogadoController;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public LoginController() {
        super();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        OrokbefogadoController orokbefogadoController = OrokbefogadoController.getInstance();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Orokbefogado orokbefogado = orokbefogadoController.login(username, password);

        if (orokbefogado == null) {
            resp.sendRedirect("pages/login.jsp");
            return;
        }
        req.getSession().setAttribute("currentUser", orokbefogado);
        resp.sendRedirect("pages/list_konyveles.jsp");
    }

}
