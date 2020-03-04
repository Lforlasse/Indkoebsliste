import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "LogInServlet", urlPatterns = {"/LogInServlet"})
public class LogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();

        HttpSession session = request.getSession();

        String navn = request.getParameter("navn");
        String kodeord = request.getParameter("kodeord");

        if (servletContext.getAttribute("brugerMap") == null) {
            Map<String, String> brugerMap = new HashMap<>();
            //opretter brugere
            brugerMap.put("admin", "asdqwe123"); //ADMIN BRUGER.
            brugerMap.put("test", "test"); //TEST BRUGER.

            servletContext.setAttribute("brugerMap", brugerMap);
        }

        if (((Set<String>) servletContext.getAttribute(("aktiveBrugere")) == null)) {
            Set<String> aktivebrugere = new HashSet<>();
            servletContext.setAttribute("aktiveBrugere", aktivebrugere);
        }


        if (((Map<String, String>) servletContext.getAttribute("brugerMap")).containsKey(navn)) {

        }

        if (!((Map<String, String>) servletContext.getAttribute("brugerMap")).containsKey(navn)) {
            request.setAttribute("besked", "Registrer din bruger på huskelisten:");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request, response);
        }

        if (((Map<String, String>) servletContext.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)) {

            //ADMIN
            if (navn.equalsIgnoreCase("admin")) {
                //ADMIN
                request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);

            }

            if (!((Set<String>) servletContext.getAttribute(("aktiveBrugere"))).contains(navn)) {

                ((Set<String>)servletContext.setAttribute("aktiveBrugere")).add(navn);

                //REGISTRERER BRUGEREN
                session.setAttribute("besked", "Logget ind som: " + navn);
                request.getRequestDispatcher("WEB-INF/Huskeliste.jsp").forward(request, response);

            }
        }

        //todo gå til logIn dvs. index siden.
        request.setAttribute("besked", "Noget gik galt. Prøv igen");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
