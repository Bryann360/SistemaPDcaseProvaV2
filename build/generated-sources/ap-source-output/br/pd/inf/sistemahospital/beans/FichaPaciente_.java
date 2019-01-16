package br.pd.inf.sistemahospital.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FichaPaciente.class)
public abstract class FichaPaciente_ {

	public static volatile SingularAttribute<FichaPaciente, Integer> id;
	public static volatile SingularAttribute<FichaPaciente, Integer> numeroCarteiraPlano;
	public static volatile SingularAttribute<FichaPaciente, Especialidades> idEspecialidade;
	public static volatile SingularAttribute<FichaPaciente, PlanosDeSaude> idPlanoDeSaude;
	public static volatile SingularAttribute<FichaPaciente, String> nomePaciente;

}

