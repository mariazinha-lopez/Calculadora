/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author M.Luiza
 */
public class MyServelet extends HttpServlet {

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
        
        Cookie[] ck = request.getCookies();   
        int val_ck = 0;
        if (ck != null) {
          for(int i = 0; i < ck.length; i++) {
            String nome = ck[i].getName();
            String val = ck[i].getValue();
            if (nome.equals("usos")) {  
                val_ck = Integer.parseInt(val) + 1;
            } 
          }
        }
        
        Cookie contador = new Cookie("usos", Integer.toString(val_ck));
        contador.setMaxAge(60*60*24);
        response.addCookie(contador);
       
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculadora (Servelet)</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>Calculadora Online</h1></center>");
            out.println("<center>");
            out.println("<form action=\'MyServelet \' method=\"post\">");
            out.println("<table> <tr>");
            out.println("<td> <input type=\"number\" step=\"0.00001\" size=\"10\" name='num1'/></td>\n"+"<td>\n" +
"                            <select name=\"operacao\">\n" +
"                                <option></option>\n" +
"                                <option value=\"+\">+</option>\n" +
"                                <option value=\"-\">-</option>\n" +
"                                <option value=\"x\">x</option>\n" +
"                                <option value=\"^\">xª</option>\n" +
"                                <option value=\"/\">/</option>\n" +
"                            </select>\n" +
"                        </td>");
            out.println("<td><input type=\"number\" step=\"0.00001\" size=\"10\" name='num2'/></td>");
            out.println("</tr>");
            out.println("<tr>\n" +
"                        <td><center>Operando 1</center></td>\n" +
"                        <td></td>\n" +
"                        <td><center>Operando 2</center></td>\n" +
"                    </tr>");
            out.println("<tr>\n" +
"                        <td><br><br><input type=\"submit\" value='Calcular'/></td>\n" +
"                    </tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

      
        
        

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>




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
        
              
        Cookie contador[] = request.getCookies(); 
        for(int i=0;i<contador.length;i++){  
           if (contador[i].getName().equals("usos")) {
                int atual = Integer.parseInt(contador[i].getValue())+ 1;
                request.setAttribute("usos", atual);
           }
        }
        double operador1 = Double.parseDouble(request.getParameter("num1"));
        double operador2 = Double.parseDouble(request.getParameter("num2"));
        String operacao = request.getParameter("operacao");
        double resultado;     
        
        if(operacao.equals("+")){
            resultado = operador1 + operador2;
        }else if(operacao.equals("-")){
            resultado = operador1 - operador2;
        }else if(operacao.equals("x")){
            resultado = operador1 * operador2;
        }else if(operacao.equals("^")){
            resultado = Math.pow(operador1,operador2);
        }else{
            resultado = operador1 / operador2;
        }    
        
        request.setAttribute("resultado", resultado);
        request.setAttribute("operador1", operador1);
        request.setAttribute("operador2", operador2);
        request.setAttribute("operacao", operacao);
        
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
        
    }
 

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    

}
