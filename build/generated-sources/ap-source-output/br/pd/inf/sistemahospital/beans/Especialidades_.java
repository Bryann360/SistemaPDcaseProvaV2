package br.pd.inf.sistemahospital.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Especialidades.class)
public abstract class Especialidades_ {

	public static volatile SingularAttribute<Especialidades, Integer> id;
	public static volatile ListAttribute<Especialidades, FichaPaciente> fichaPacienteList;
	public static volatile SingularAttribute<Especialidades, String> nome;

}

