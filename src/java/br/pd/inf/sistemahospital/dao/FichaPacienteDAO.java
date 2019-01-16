/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pd.inf.sistemahospital.dao;

import br.pd.inf.sistemahospital.beans.FichaPaciente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ADM
 */
public class FichaPacienteDAO extends Cadastro{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaPDcaseProvaV2PU");
    private EntityManager em = emf.createEntityManager();

    public FichaPacienteDAO() {
        super(FichaPaciente.class);
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List findAll() {
        return em.createNamedQuery("FichaPaciente.findAll").getResultList();
    }
    
    public FichaPaciente buscarPorChavePrimaria(int chave){
        return em.find(FichaPaciente.class, chave);
    }
}
