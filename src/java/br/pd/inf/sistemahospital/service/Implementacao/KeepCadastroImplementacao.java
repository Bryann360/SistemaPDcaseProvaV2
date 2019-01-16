/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pd.inf.sistemahospital.service.Implementacao;

import br.pd.inf.sistemahospital.beans.FichaPaciente;
import br.pd.inf.sistemahospital.beans.Especialidades;
import br.pd.inf.sistemahospital.beans.PlanosDeSaude;
import br.pd.inf.sistemahospital.services.KeepCadastro;
import br.pd.inf.sistemahospital.dao.FichaPacienteDAO;
import br.pd.inf.sistemahospital.dao.EspecialidadesDAO;
import br.pd.inf.sistemahospital.dao.PlanosDeSaudeDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADM
 */
public class KeepCadastroImplementacao implements KeepCadastro{
    

    FichaPacienteDAO ficha = new FichaPacienteDAO();
    
    @Override
    public void criarFicha(FichaPaciente ficha){

        
        List <FichaPaciente> lista;
        
        lista = this.ficha.findAll();
        
        for(FichaPaciente f : lista){
            if (ficha.getIdEspecialidade() == f.getIdEspecialidade() && ficha.getIdPlanoDeSaude() == f.getIdPlanoDeSaude()){
                
                EspecialidadesDAO especialidade = new EspecialidadesDAO();
                PlanosDeSaudeDAO planos = new PlanosDeSaudeDAO();
                
                PlanosDeSaude plan = (PlanosDeSaude) planos.find(f.getIdPlanoDeSaude().getId());
                Especialidades espe = (Especialidades) especialidade.find(f.getIdEspecialidade().getId());
                
                try {
                    throw new InavlidInputException("Esta especialidade " + espe.getNome() + " já foi utilizada para o plano " + plan.getNome());
                } catch (InavlidInputException ex) {
                    Logger.getLogger(KeepCadastroImplementacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        this.ficha.create(ficha);
    }
        @Override
        public void deletarFicha (FichaPaciente ficha){
            this.ficha.remove(ficha);
        }
            @Override
            public void editarFicha (FichaPaciente ficha){
                this.ficha.edit(ficha);
            }
                @Override
                public FichaPaciente pesquisarFichaByID(int Id){
                    
                    FichaPaciente resultado = (FichaPaciente) ficha.find(Id);
                    return resultado;
                    
                }
                
}
