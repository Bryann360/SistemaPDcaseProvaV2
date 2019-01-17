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
public class EditarFicha implements ProcessoGenerico{
    
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
        
        FichaPacienteDAO dao = new FichaPacienteDAO();
        String id = req.getParameter("IDFICHA");
        int foo2 = Integer.parseInt(id);
        FichaPaciente obj = dao.buscarPorChavePrimaria(foo2);
        if(obj == null){
            pageJSP = "/index.jsp";
        return pageJSP;
        }
        String nome = req.getParameter("nome");
        String numeroCarteira = req.getParameter("numeroCarteira");
        int foo = Integer.parseInt(numeroCarteira);
        String planoIdString = req.getParameter("idPlano");
        planoId = Integer.parseInt(planoIdString);
        String especialidadeIdString = req.getParameter("idEspecialidade");
        especialidadeId = Integer.parseInt(especialidadeIdString);
        plano = (PlanosDeSaude) planoDAO.find(planoId);
        especialidade = (Especialidades) especialidadesDAO.find(especialidadeId);

        obj.setNomePaciente(nome);
        obj.setNumeroCarteiraPlano(foo);
        obj.setIdEspecialidade(especialidade);
        obj.setIdPlanoDeSaude(plano);
        
        dao.edit(obj);
        
            pageJSP = "/index.jsp";
        return pageJSP;
        
        
        
       
    }
    
}
