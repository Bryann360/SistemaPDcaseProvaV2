<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Hospital</title>
    </head>
    <body>
        
        <form name="criarFicha" action="servletcontroller?flag=CriarFicha" method="POST">
            <label>Nome:</label><input type="text" name="nome"  >     
            <label>Numero Carteira:</label><input type="number" name="numeroCarteira"  >   
            <label>Id Especialidade:</label><input type="number" name="idEspecialidade"  >   
            <label>Id Plano:</label><input type="number" name="idPlano">   
            <label></label><input type="submit" value="Cadastrar" >   
        </form>
    </body>
</html>
