<%@page import="br.pd.inf.sistemahospital.beans.PlanosDeSaude"%>
<%@page import="java.util.List"%>
<%@page import="br.pd.inf.sistemahospital.beans.Especialidades"%>
<%@page import="br.pd.inf.sistemahospital.dao.PlanosDeSaudeDAO"%>
<%@page import="br.pd.inf.sistemahospital.dao.EspecialidadesDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    EspecialidadesDAO esp = new EspecialidadesDAO();
    PlanosDeSaudeDAO pla = new PlanosDeSaudeDAO();
    List<Especialidades> objEsp = esp.findAll();
    List<PlanosDeSaude> objPla = pla.findAll();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Hospital</title>
    </head>
    <body>
        <div>
        <form name="criarFicha" action="servletcontroller?flag=CriarFicha" method="POST">
            <label style=" float: left; ">Nome:</label><input style="margin-left: 100px;" type="text" name="nome"  >     <br>
            <label style=" float: left; ">Numero Carteira:</label><input style="margin-left: 100px;" type="number" name="numeroCarteira"  >   <br>
            <label style=" float: left; ">Id Especialidade:</label> <br>
            <select name="idEspecialidade" style="margin-left: 100px;">
              <%
              for(Especialidades item:objEsp){
              %>
              <option value="<%=item.getId()%>"><%=item.getNome()%></option>
              <%
              }
              %>
            </select> <br>
            <label style=" ">Id Plano:</label>
            <select name="idPlano" style="margin-left: 100px;">
              <%
              for(PlanosDeSaude item:objPla){
              %>
              <option value="<%=item.getId()%>"><%=item.getNome()%></option>
              <%
              }
              %>
            </select> <br>
            <label style=" "></label><input style="margin-left: 100px;" type="submit" value="Cadastrar" >   
        </form>
        </div>
    </body>
</html>
