/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pd.inf.sistemahospital.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADM
 */
@Entity
@Table(name = "FichaPaciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FichaPaciente.findAll", query = "SELECT f FROM FichaPaciente f"),
    @NamedQuery(name = "FichaPaciente.findById", query = "SELECT f FROM FichaPaciente f WHERE f.id = :id"),
    @NamedQuery(name = "FichaPaciente.findByNomePaciente", query = "SELECT f FROM FichaPaciente f WHERE f.nomePaciente = :nomePaciente"),
    @NamedQuery(name = "FichaPaciente.findByNumeroCarteiraPlano", query = "SELECT f FROM FichaPaciente f WHERE f.numeroCarteiraPlano = :numeroCarteiraPlano")})
public class FichaPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NomePaciente")
    private String nomePaciente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumeroCarteiraPlano")
    private int numeroCarteiraPlano;
    @JoinColumn(name = "IdPlanoDeSaude", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private PlanosDeSaude idPlanoDeSaude;
    @JoinColumn(name = "IdEspecialidade", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Especialidades idEspecialidade;

    public FichaPaciente() {
    }

    public FichaPaciente(Integer id) {
        this.id = id;
    }

    public FichaPaciente(Integer id, String nomePaciente, int numeroCarteiraPlano) {
        this.id = id;
        this.nomePaciente = nomePaciente;
        this.numeroCarteiraPlano = numeroCarteiraPlano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public int getNumeroCarteiraPlano() {
        return numeroCarteiraPlano;
    }

    public void setNumeroCarteiraPlano(int numeroCarteiraPlano) {
        this.numeroCarteiraPlano = numeroCarteiraPlano;
    }

    public PlanosDeSaude getIdPlanoDeSaude() {
        return idPlanoDeSaude;
    }

    public void setIdPlanoDeSaude(PlanosDeSaude idPlanoDeSaude) {
        this.idPlanoDeSaude = idPlanoDeSaude;
    }

    public Especialidades getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Especialidades idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaPaciente)) {
            return false;
        }
        FichaPaciente other = (FichaPaciente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.pd.inf.sistemahospital.beans.FichaPaciente[ id=" + id + " ]";
    }
    
}
