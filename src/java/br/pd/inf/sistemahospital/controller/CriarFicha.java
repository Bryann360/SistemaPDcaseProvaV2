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
public class CriarFicha implements ProcessoGenerico{
    
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
    
    public String getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(String searchResults) {
        this.searchResults = searchResults;
    }
    
    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }
    
    public int getEspecialidadeId() {
        return especialidadeId;
    }

    public void setEspecialidadeId(int especialidadeId) {
        this.especialidadeId = especialidadeId;
    }

    public int getPlanoId() {
        return planoId;
    }

    public void setPlanoId(int planoId) {
        this.planoId = planoId;
    }

    public FichaPaciente getFicha() {
        return ficha;
    }

    public void setFicha(FichaPaciente ficha) {
        this.ficha = ficha;
    }

    public KeepCadastroImplementacao getManterCadastro() {
        return keepCadastro;
    }

    public void setManterCadastro(KeepCadastroImplementacao manterCadastro) {
        this.keepCadastro = manterCadastro;
    }

    public String getNomepaciente() {
        return nomepaciente;
    }

    public void setNomepaciente(String nomepaciente) {
        this.nomepaciente = nomepaciente;
    }

    public int getNumerocarteiraplano() {
        return numerocarteiraplano;
    }

    public void setNumerocarteiraplano(int numerocarteiraplano) {
        this.numerocarteiraplano = numerocarteiraplano;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidades especialidade) {
        this.especialidade = especialidade;
    }

    public PlanosDeSaude getPlano() {
        return plano;
    }

    public void setPlano(PlanosDeSaude plano) {
        this.plano = plano;
    }
    //neste momeno do código me encontro extremamente frustrado com a tonelada de Erros (apenas para avaliação posterior).
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String pageJSP = "";
        String nome = req.getParameter("nome");
        String numeroCarteira = req.getParameter("numeroCarteira");
        int foo = Integer.parseInt(numeroCarteira);
        String planoIdString = req.getParameter("idPlano");
        planoId = Integer.parseInt(planoIdString);
        String especialidadeIdString = req.getParameter("idEspecialidade");
        especialidadeId = Integer.parseInt(especialidadeIdString);
        plano = (PlanosDeSaude) planoDAO.find(planoId);
        especialidade = (Especialidades) especialidadesDAO.find(especialidadeId);
        ficha = new FichaPaciente();
        ficha.setNomePaciente(nome);
        ficha.setNumeroCarteiraPlano(foo);
        ficha.setIdEspecialidade(especialidade);
        ficha.setIdPlanoDeSaude(plano);
        keepCadastro = new KeepCadastroImplementacao();
        keepCadastro.criarFicha(ficha);
            pageJSP = "/index.jsp";
        return pageJSP;
    }
    
}
