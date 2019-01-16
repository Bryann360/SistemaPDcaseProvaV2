<%-- 
    Document   : deletarFicha.jsp
    Created on : 13/01/2019, 11:47:16
    Author     : ADM
--%>

<%@page import="br.pd.inf.sistemahospital.beans.FichaPaciente"%>
<%@page import="br.pd.inf.sistemahospital.dao.FichaPacienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String msg="";
    if(request.getParameter("id")== null){
        response.sendRedirect("index.jsp");
    }else{
        String id = request.getParameter("id");
        int foo = Integer.parseInt(id);
        
        FichaPacienteDAO dao = new FichaPacienteDAO();
        FichaPaciente obj = dao.buscarPorChavePrimaria(foo);
        
        if(obj!=null){
            dao.remove(obj);
            msg="Registro excluido com sucesso!";
            
        }else{
            msg="Registro não encontrado!";
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="text-align: center;"><%=msg%></h1>
        <a href="index.jsp">Voltar a pagina principal!</a>
    </body>
</html>
