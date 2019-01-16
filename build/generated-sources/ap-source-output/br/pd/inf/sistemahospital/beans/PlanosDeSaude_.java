package br.pd.inf.sistemahospital.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PlanosDeSaude.class)
public abstract class PlanosDeSaude_ {

	public static volatile SingularAttribute<PlanosDeSaude, Integer> id;
	public static volatile ListAttribute<PlanosDeSaude, FichaPaciente> fichaPacienteList;
	public static volatile SingularAttribute<PlanosDeSaude, String> nome;

}

