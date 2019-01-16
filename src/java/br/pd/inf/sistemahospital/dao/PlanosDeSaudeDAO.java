/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pd.inf.sistemahospital.dao;

import br.pd.inf.sistemahospital.beans.PlanosDeSaude;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ADM
 */
public class PlanosDeSaudeDAO extends Cadastro{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaPDcaseProvaV2PU");
    private EntityManager em = emf.createEntityManager();

    public PlanosDeSaudeDAO() {
        super(PlanosDeSaude.class);
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List findAll() {
        return em.createNamedQuery("PlanosDeSaude.findAll").getResultList();
    }
}
