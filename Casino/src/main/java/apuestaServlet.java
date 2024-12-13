/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.mvm.daw.casino.model.Apuesta;
import com.mvm.daw.casino.model.ApuestaService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        int ContadorID=0;
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
            int ContadorID= (int) getServletContext().getAttribute("ContadorID");
            apuestaService.addApuesta(listaApuestas, ContadorID, request);
            getServletContext().setAttribute("ContadorID", ContadorID+1);
            
            // redirigimos al jsp
            request.setAttribute("apuestas", listaApuestas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultat.jsp");
            dispatcher.forward(request, response);
    }else if("Borrar".equals(accion)){
            String ID = request.getParameter("ID");
            //List<Apuesta> listaFiltrada = new ArrayList();
            List<Apuesta> listaApuestas = (ArrayList<Apuesta>) getServletContext().getAttribute("listaApuestas");
            apuestaService.Borrar(listaApuestas, request);
            request.setAttribute("apuestas",  listaApuestas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultat.jsp");
            dispatcher.forward(request, response);

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    }

}
}
