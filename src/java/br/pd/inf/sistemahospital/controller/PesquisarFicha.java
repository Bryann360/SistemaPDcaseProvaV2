/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pd.inf.sistemahospital.controller;

import br.pd.inf.sistemahospital.beans.Especialidades;
import br.pd.inf.sistemahospital.beans.FichaPaciente;
import br.pd.inf.sistemahospital.beans.PlanosDeSaude;

import br.pd.inf.sistemahospital.dao.FichaPacienteDAO;
import br.pd.inf.sistemahospital.dao.EspecialidadesDAO;
import br.pd.inf.sistemahospital.dao.PlanosDeSaudeDAO;
import br.pd.inf.sistemahospital.service.Implementacao.InavlidInputException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.pd.inf.sistemahospital.service.Implementacao.KeepCadastroImplementacao;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADM
 */
public class PesquisarFicha implements ProcessoGenerico{
    
    KeepCadastroImplementacao keepCadastro;
    PlanosDeSaudeDAO planoDAO = new PlanosDeSaudeDAO();
    EspecialidadesDAO especialidadesDAO = new EspecialidadesDAO();
    private String nomepaciente;
    private int numerocarteiraplano;
    private int especialidadeId;
    private int planoId;
    private int pacienteId;
    Especialidades especialidade;
    PlanosDeSaude plano;
    FichaPaciente ficha;
    String searchResults;
    
    
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pageJSP = "";
        String idPaciente = req.getParameter("idPaciente");
        int id = Integer.parseInt(idPaciente);
        
        
        
        ficha = keepCadastro.pesquisarFichaByID(id);
        
        searchResults = "Nome do paciente: " + ficha.getNomePaciente() + 
                "\n Código da especialidade: " + ficha.getIdEspecialidade() +
                "\n Código do plano: " + ficha.getIdPlanoDeSaude() + 
                "\n Numero da carteira: " + ficha.getNumeroCarteiraPlano();
        
        res.sendRedirect("Test.jsp?nome="+ ficha.getNomePaciente() +"&codEsp=" +ficha.getIdEspecialidade()+"&codPla"+ ficha.getIdPlanoDeSaude() +"&numCart"+ficha.getNumeroCarteiraPlano());
        
        return pageJSP;
    }
    
}
