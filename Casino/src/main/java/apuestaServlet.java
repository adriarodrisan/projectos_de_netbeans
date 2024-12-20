/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import com.mvm.daw.casino.model.Apuesta;
import com.mvm.daw.casino.model.ApuestaService;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author isard
 */
@WebServlet(urlPatterns = {"/apuestaServlet"})
public class apuestaServlet extends HttpServlet {
    private ApuestaService apuestaService;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet apuestaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet apuestaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    public void init() throws ServletException {
        // Inicializar la lista de usuarios en el contexto de la aplicación 
        List<Apuesta> listaApuestas = new ArrayList<>();
        int ContadorID = 0;
        boolean ganar = false;
        getServletContext().setAttribute("ganar", ganar);
        getServletContext().setAttribute("ContadorID", ContadorID);
        getServletContext().setAttribute("listaApuestas", listaApuestas);
        apuestaService = new ApuestaService();
        
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String accion = request.getParameter("submit");
        if ("Enviar Apuesta".equals(accion)) {
            // recuperar la lista que está guardada en el contexto
            List<Apuesta> listaApuestas = (ArrayList<Apuesta>) getServletContext().getAttribute("listaApuestas");
            int ContadorID = (int) getServletContext().getAttribute("ContadorID");
            boolean ganar = (boolean) getServletContext().getAttribute("ganar");
            apuestaService.addApuesta(listaApuestas, ContadorID, ganar, request);
            getServletContext().setAttribute("ContadorID", ContadorID + 1);
            // redirigimos al jsp
            request.setAttribute("apuestas", listaApuestas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultat.jsp");
            dispatcher.forward(request, response);
        } else if ("Borrar".equals(accion)) {
            String ID = request.getParameter("ID");
            //List<Apuesta> listaFiltrada = new ArrayList();
            List<Apuesta> listaApuestas = (ArrayList<Apuesta>) getServletContext().getAttribute("listaApuestas");
            apuestaService.Borrar(listaApuestas, request);
            request.setAttribute("apuestas", listaApuestas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultat.jsp");
            dispatcher.forward(request, response);
            /**
             * Returns a short description of the servlet.
             *
             * @return a String containing servlet description
             */
        } else if ("Editar".equals(accion)) {
            List<Apuesta> listaApuestas = (ArrayList<Apuesta>) getServletContext().getAttribute("listaApuestas");
            int ID = Integer.parseInt(request.getParameter("ID"));
            Apuesta apuestaAEditar = null;
            for (Apuesta apuesta : listaApuestas) {
                if (apuesta.getID() == ID) {
                    apuestaAEditar = apuesta;
                    break;
                }
            }
            if (apuestaAEditar != null) {
                request.setAttribute("apuesta", apuestaAEditar);
                RequestDispatcher dispatcher = request.getRequestDispatcher("EditarApuesta.jsp");
                dispatcher.forward(request, response);
            }
        } else if ("Detalles".equals(accion)) {
            List<Apuesta> listaApuestas = (ArrayList<Apuesta>) getServletContext().getAttribute("listaApuestas");
            apuestaService.Mostrar(listaApuestas, request);
            request.setAttribute("apuestas", listaApuestas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Detallesapuesta.jsp");
            dispatcher.forward(request, response);
        } else if ("Volver".equals(accion)) {
            List<Apuesta> listaApuestas = (List<Apuesta>) getServletContext().getAttribute("listaApuestas");
            request.setAttribute("apuestas", listaApuestas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultat.jsp");
            dispatcher.forward(request, response);
        } else if ("Modificar".equals(accion)) {
            List<Apuesta> listaApuestas = (ArrayList<Apuesta>) getServletContext().getAttribute("listaApuestas");
            apuestaService.Modificar(listaApuestas, request);
            getServletContext().setAttribute("listaApuestas", listaApuestas);
            request.setAttribute("apuestas", listaApuestas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultat.jsp");
            dispatcher.forward(request, response);
        } else if ("FiltraPorUsuario".equals(accion)) {
            String nombreFiltro = request.getParameter("nombre");
            List<Apuesta> listaApuestas = (ArrayList<Apuesta>) getServletContext().getAttribute("listaApuestas");
            List<Apuesta> listaFiltrada = new ArrayList<>();
            listaFiltrada = apuestaService.filtrarPorUsuario(listaApuestas, nombreFiltro);
             request.setAttribute("apuestas", listaFiltrada);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultat.jsp");
            dispatcher.forward(request, response);
        }else if ("Guañadora".equals(accion)) {
            List<Apuesta> listaApuestas = (List<Apuesta>) getServletContext().getAttribute("listaApuestas");
            request.setAttribute("apuestas", listaApuestas);
            apuestaService.ganar(listaApuestas,request);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultat.jsp");
            dispatcher.forward(request, response);
    }else if ("FiltraPorPartidoifecha".equals(accion)) {
            List<Apuesta> listaApuestas = (ArrayList<Apuesta>) getServletContext().getAttribute("listaApuestas");
            List<Apuesta> listaFiltrada = new ArrayList<>();
            listaFiltrada = apuestaService.filtrarPorPartidoyFecha(listaApuestas,request);
             request.setAttribute("apuestas", listaFiltrada);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultat.jsp");
            dispatcher.forward(request, response);
}else if ("FiltraPorUsuarioirango".equals(accion)) {
            String nombreFiltro = request.getParameter("nombre");
            double valor_minimo = Double.parseDouble(request.getParameter("valor_minimo"));
            double valor_maximo = Double.parseDouble(request.getParameter("valor_maximo"));
            List<Apuesta> listaApuestas = (ArrayList<Apuesta>) getServletContext().getAttribute("listaApuestas");
            List<Apuesta> listaFiltrada = new ArrayList<>();
            listaFiltrada = apuestaService.filtrarPorUsuarioirango(listaApuestas, nombreFiltro,valor_minimo,valor_maximo);
             request.setAttribute("apuestas", listaFiltrada);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultat.jsp");
            dispatcher.forward(request, response);
}}}
