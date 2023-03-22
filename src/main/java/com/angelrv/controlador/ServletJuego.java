/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.angelrv.controlador;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.angelrv.modelo.Palabra;
import com.angelrv.modelo.Partida;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author veneg
 */
public class ServletJuego extends HttpServlet {

    
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
        
        String exe = request.getParameter("exe");
        String letra = request.getParameter("letra");
        
        HttpSession sesion = request.getSession(true);
        Partida partida = (Partida)sesion.getAttribute("miPartida");
        if (exe.equals("start")) {
            Palabra p = new Palabra();
            String palabra = p.getPalabra();
            partida = new Partida(palabra);
        }

        if (letra != null) {
            partida.validarLetra(letra);
        }
        
        RequestDispatcher req = null;
        // Casos del juego
        if (partida.quedanIntentos() && exe.equals("stop")) {
            // Game Over
            req = request.getRequestDispatcher("resultado.jsp");
            request.setAttribute("resultado_partida", "Estuvistes cerca :')");
        }
        else if (partida.asertoPalabra() && exe.equals("stop")) {
            // Win
            req = request.getRequestDispatcher("resultado.jsp");
            request.setAttribute("resultado_partida", "Acertastes la palabra :)");
            //request.setAttribute("exe", "stop");
        }
        else {
            req = request.getRequestDispatcher("game.jsp");
            sesion.setAttribute("miPartida", partida);
            request.setAttribute("miPartida", partida);
        }
        
        req.forward(request, response);
         
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
