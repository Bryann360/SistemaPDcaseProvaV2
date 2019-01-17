<%@page import="br.pd.inf.sistemahospital.beans.FichaPaciente"%>
<%@page import="br.pd.inf.sistemahospital.dao.FichaPacienteDAO"%>
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
    
    String msg="";
    if(request.getParameter("id")== null){
        response.sendRedirect("index.jsp");
        return;
    }
        String id = request.getParameter("id");
        int foo = Integer.parseInt(id);
        
        FichaPacienteDAO dao = new FichaPacienteDAO();
        FichaPaciente obj = dao.buscarPorChavePrimaria(foo);
        
        if(obj==null){
            response.sendRedirect("index.jsp");
            return;
        }
       
    

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Hospital</title>
    </head>
    <body>
        <div>
        <form name="criarFicha" action="servletcontroller?flag=EditarFicha" method="POST">
            <input type="hidden" name="IDFICHA" value="<%=foo%>"/>
            <table>
            <tr>
            <td><label style=" float: left; ">Nome:</label></td><td><input style="margin-left: 100px;" type="text" name="nome" value="<%=obj.getNomePaciente() %>"  > </td>    
            </tr>
            <tr>
            <td><label style=" float: left; ">Numero Carteira:</label></td><td><input style="margin-left: 100px;" type="number" name="numeroCarteira" value="<%=obj.getNumeroCarteiraPlano() %>" >   </td>
            </tr>
            <tr>
            <td><label style=" float: left; ">Id Especialidade:</label> </td>
            <td>
            <select name="idEspecialidade" style="margin-left: 100px;">
              <%
              for(Especialidades item:objEsp){
              %>
              <option value="<%=item.getId()%>"><%=item.getNome()%></option>
              <%
              }
              %>
              <option value="<%=obj.getIdEspecialidade().getId() %>" selected><%=obj.getIdEspecialidade().getNome() %></option>
            </select></td> 
            </tr>
            <tr>
                <td><label style=" ">Id Plano:</label></td>
                <td>
            <select name="idPlano" style="margin-left: 100px;">
              <%
              for(PlanosDeSaude item:objPla){
              %>
              <option value="<%=item.getId()%>"><%=item.getNome()%></option>
              <%
              }
              %>
              <option value="<%=obj.getIdPlanoDeSaude().getId() %>" selected><%=obj.getIdPlanoDeSaude().getNome() %></option>
            </select> </td>
            </tr>
            <tr>
                <td><label style=" "></label></td><td><input style="margin-left: 100px;" type="submit" value="Atualizar" >   </td>
            </tr>
        </form>
        </div>
            
    </body>
</html>

