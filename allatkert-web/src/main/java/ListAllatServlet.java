import hu.alkfejl.allatkert.model.AllatDAO;
import hu.alkfejl.allatkert.model.AllatDAOImpl;
import hu.alkfejl.allatkert.model.bean.Allat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/allat")
public class ListAllatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        AllatDAO dao = new AllatDAOImpl();
        PrintWriter pw = resp.getWriter();

        for(Allat aktualis : dao.listAllat()){
            pw.println(aktualis);

        }

    }
}
