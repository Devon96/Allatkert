package hu.alkfejl.controller;

import hu.alkfejl.allatkert.controller.OrokbefogadoController;
import hu.alkfejl.allatkert.model.OrokbefogadoDAO;
import hu.alkfejl.allatkert.model.OrokbefogadoDAOImpl;
import hu.alkfejl.allatkert.model.bean.Orokbefogado;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public LoginController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        OrokbefogadoController orokbefogadoController = OrokbefogadoController.getInstance();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Orokbefogado orokbefogado = orokbefogadoController.login(username, password);

        if (orokbefogado == null) {
            response.sendRedirect("pages/login.jsp");
            return;
        }
        request.getSession().setAttribute("currentUser", orokbefogado);
        response.sendRedirect("pages/list_person.jsp");
    }

}
