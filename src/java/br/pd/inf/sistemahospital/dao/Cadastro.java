package br.pd.inf.sistemahospital.dao;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class Cadastro<T> {
    
    private Class<T> entityClass;
    
    public Cadastro(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEntityManager(); 
    
    public void create(T entity){
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }
    
    public void edit(T entity){
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
    }
    
    public void remove(T entity){
        getEntityManager().getTransaction().begin();
        T aux = getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(aux);
        getEntityManager().getTransaction().commit();
    }
    
    public T find(Object id){
        return getEntityManager().find(entityClass, id);
    }
    
    public abstract List<T> findAll();
        
    
}
