/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.syllab.linkleraning.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gloria.besamba
 */
@WebServlet(name = "SuiviServelet", urlPatterns = {"/suivi"})
public class SuiviServelet extends HttpServlet {

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
        /**
         *  Initialiser une variable « login » de type chaîne de caractère, avec ce que l'on récupère dans le « request » 
         * qui est le paramètre qu'on a reçu ici, qui contient toutes les informations de la requête HTTP reçue. 
         * Donc on récupère le paramètre avec « getParameter ». Ici on spécifie le nom du paramètre attendu. Ici : « qui ». 
         * Ce paramètre, nous pouvons donc maintenant l'utiliser dans notre page pour afficher l'utilisateur reçu. 
         * Attention : quand on affiche le contenu d'un paramètre, il faut toujours filtrer le contenu du paramètre. 
         * En effet, il faut toujours se méfier de ce qui vient du client et ici il peut venir un JavaScript qu'on introduirait sur notre page. 
         * On parle de faille XSS. Pour éviter ça, on implémente souvent une fonction de nettoyage. 
         * On en utilise une quand il y a en une de disponible. Ici on n'en a pas directement dans la servlet 
         * donc on va en faire une rudimentaire qui consiste à avoir enlevé tout caractère qui est « &lt; », « », 
         * par une expression régulière, « ' », le « "», que j'échappe ici puisque c'est un caractère spécial en chaîne, le « &amp; », 
         * que j'échappe aussi avec un « \\ » puisque le « \ » est spécifique dans les chaînes, il faut toujours le doubler, en Java. 
         * Et le « \ » aussi, qui est un caractère spécial, avec un « \\ ». Donc voilà ce « nettoyer », 
         * que j'ai d'ailleurs appelé « nettoyer », pas « nettoyage ». Il va nous permettre d'avoir un paramètre fiable. 
         * Quand je reçois ici « anonym », je réutilise bien « anonym » ici, que je reçois en paramètre là. 
         * Et si jamais j'introduis un « &lt; », cet « &lt; » n'est pas repris dans ma page et donc j'évite les failles XSS. 
         * On sait maintenant personnaliser une servlet et utiliser dans la servlet les paramètres reçus correctement.
         * 
         **/
        String login = request.getParameter("qui");
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html lang='fr'>");
                out.println("<head>");
                out.println("<meta charset='utf-8'>");    
                out.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
                out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
                out.println("<script src='https://cdn.tailwindcss.com'></script>");

                out.println("<meta name='description' content='Application de mesure du temps passé sur chaque projet'>");
                out.println("<meta name='author' content='S.Labasse'>");

                out.println("<title>TemPass - Suivi de temps passé par projet</title>");

                out.println("<link rel='icon' href='favicon.ico'>");

                out.println("<link href='css/style.css' rel='stylesheet' type='text/css'>");
                out.println("</head>");
                out.println("<body class='bg-blue-gray'>");
                out.println("<header>");
                out.println("<a href='/'><img src='img/logo.png' id='logo' alt='logo'></a>");
                out.println("<h1>TemPass de " + nettoyer(login) + "</h1>");
                out.println("</header>");
                out.println("<main class='mx-auto w-1/2 py-5 shadow-xl rounded-3xl max-w-2xl'>");
                out.println("<p>Temps passé sur les projets Linkedin Learning.</p>");
                out.println("<form id='liste' method='post'>");
                    out.println("<ul>");
                        out.println("<li>");
                        out.println("<label>");
                        out.println("<input class='text-gray-700 text-sm font-bold mb-2' type='radio' name='projet' value='0'> Aucune tâche<span class='temps' data-idprojet='0'>Repos</span>");
                        out.println("</label>");
                        out.println("<li>");
                        out.println("<label>");
                        out.println("<input type='radio' name='projet' value='1'> Euismod nibh");
                        out.println("<span class='temps' data-idprojet='21'>0j 0:00'00</span>");
                        out.println("</label>");
                        out.println("</li>");
                        out.println("<li>");
                        out.println("<label>");
                        out.println("<input type='radio' name='projet' value='2'> Sagittis");
                        out.println("<span class='temps' data-idprojet='32'>0j 0:00'00</span>");
                        out.println("</label>");
                        out.println("</li>");
                        out.println("<li>");
                        out.println("<label>");
                        out.println("<input type='radio' name='projet' value='3'> Tempor vivamus");
                        out.println("<span class='temps' data-idprojet='43'>0j 0:00'00</span>");
                        out.println("</label>");
                        out.println("</li>");
                        out.println("<li>");
                        out.println("<label>");
                        out.println("<input type='radio' name='projet' value='4'> Dui maximus");
                        out.println("<span class='temps' data-idprojet='54'>0j 0:00'00</span>");
                        out.println("</label>");
                        out.println("</li>");
                        out.println("<li>");
                        out.println("<label>");
                        out.println("<input type='radio' name='projet' value='5'> Odio pharetra in");
                        out.println("<span class='temps' data-idprojet='65'>0j 0:00'00</span>");
                        out.println("</label>");
                        out.println("</li>");
                        out.println("<li>");
                        out.println("<label>");
                        out.println("<input type='radio' name='projet' value='6' checked> Natoque donec");
                        out.println("<span class='temps' data-idprojet='76'>0j 0:00'00</span>");
                        out.println("</label>");
                        out.println("</li>");
                        out.println("<li>");
                        out.println("<input type='text' class='appearance-none w-auto bg-gray-200 text-gray-700 border rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white' placeholder='Nouveau projet' name='nom'>");
                        out.println("<button type='button' name='nouv' class='bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline'>");
                        out.println("Ajouter");
                        out.println("</button>");
                        out.println("</li>");
                    out.println("</ul>");

                out.println("</form>");
                out.println("</main>");
                out.println("<footer>");
                out.println("<p>(c) Copyright 2017</p>");
                out.println("</footer>");
                out.println("<script src='js/temps.js'></script>");
                out.println("<script>");
                out.println("var liste = {_");
                    out.println("'0': {nom: 'Aucune tâche'},");
                    out.println("'21': {nom: 'Euismod nibh', duree: 245 },");
                    out.println("'32': {nom: 'Sagittis', duree: 4096 },");
                    out.println("'43': {nom: 'Tempor vivamus', duree: 3600 },");
                    out.println("'54': {nom: 'Dui maximus', duree: 7456 },");
                    out.println("'65': {nom: 'Odio pharetra in', duree: 548 },");
                    out.println("'76': {nom: 'Natoque donec', duree: 879 }");
                out.println("};");
                out.println("var tempsCourant = document.querySelector('input[checked]+.temps');");
                out.println("var idCourant = tempsCourant.getAttribute('data-idprojet');");
                out.println("var projetCourant = liste[idCourant];");

                out.println("if(idCourant!=0) {");
                    out.println("var majTemps = function () {");
                        out.println("var total = projetCourant.duree + maintenant() - projetCourant.debut;");

                        out.println("tempsCourant.innerHTML = formatDuree(total, 'repos');");
                    out.println("};");
                    out.println("projetCourant.debut = maintenant();");

                    out.println("setInterval(majTemps, 1000);");
                    out.println("majTemps();");
                out.println("}");
                out.println("</script>");        
                out.println("</body>");
                out.println("</html>"); 

        }
    }
    
    private static String nettoyer(String msg) {
        return msg == null
                ? null
                : msg.replace("[<>'\"\\&\\\\]", "");
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
