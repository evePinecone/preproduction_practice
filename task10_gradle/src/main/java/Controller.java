import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Main controller servlet.
 *
 * @author R.Lutsenko
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = -5177314642991749871L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    /**
     * Main method of Controller. Gets command by name obtained from request and
     * executes it.
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    private static void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String commandName = request.getParameter("command");

        System.err.println("HOW IT WORKS");

        request.getRequestDispatcher("no-sidebar.html").forward(request,response);
    }

}
