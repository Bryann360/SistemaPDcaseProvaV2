<%@page import="br.pd.inf.sistemahospital.beans.Especialidades"%>
<%@page import="br.pd.inf.sistemahospital.dao.PlanosDeSaudeDAO"%>
<%@page import="br.pd.inf.sistemahospital.beans.PlanosDeSaude"%>
<%@page import="br.pd.inf.sistemahospital.dao.EspecialidadesDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.pd.inf.sistemahospital.beans.FichaPaciente"%>
<%@page import="br.pd.inf.sistemahospital.dao.FichaPacienteDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    FichaPacienteDAO dao = new FichaPacienteDAO();
    List<FichaPaciente> ficha = dao.findAll();
    
    EspecialidadesDAO dao1 = new EspecialidadesDAO();
    List<Especialidades> esp = dao1.findAll();
    
    PlanosDeSaudeDAO dao2 = new PlanosDeSaudeDAO();
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Hospital</title>
    </head>
    <body>
        <center>
        <h1>Sistema De Hospitais</h1>
        <h2>
            <a href="criarFicha.jsp">Criar Ficha</a>
            &nbsp;&nbsp;&nbsp;
            <a href="pesquisarFicha.jsp">Pesquisar Ficha</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Fichas</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Numero da Carteira</th>
                <th>Id Plano</th>
                <th>Id Especialidade</th>
                <th>Opções</th>
            </tr>
            <%
            for(FichaPaciente item:ficha){
                for(Especialidades item2:esp)
                        if(item.getIdEspecialidade()==item2.getId())
            %>
                <tr>
                    <td><%=item.getId() %></td>
                    <td><%=item.getNomePaciente() %></td>
                    <td><%=item.getNumeroCarteiraPlano() %></td>
                    <td><%=item.getIdEspecialidade() %></td>
                    <td><%=item.getIdEspecialidade() %></td>
                    <td>
                        <a href="ediatFicha?id=<%=item.getId() %>">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deletarFicha?id=<%=item.getId() %>">Delete</a>                     
                    </td>
                </tr>
            <%
            }
            %>
        </table>
    </div>   
        
    </body>
</html>
