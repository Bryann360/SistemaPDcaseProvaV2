/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pd.inf.sistemahospital.services;

import br.pd.inf.sistemahospital.beans.FichaPaciente;

/**
 *
 * @author ADM
 */
public interface KeepCadastro {
    public void criarFicha(FichaPaciente ficha);
        public void deletarFicha (FichaPaciente ficha);
            public void editarFicha (FichaPaciente ficha);
                public FichaPaciente pesquisarFichaByID(long Id);           
}
