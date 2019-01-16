/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pd.inf.sistemahospital.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADM
 */
@Entity
@Table(name = "PlanosDeSaude")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanosDeSaude.findAll", query = "SELECT p FROM PlanosDeSaude p"),
    @NamedQuery(name = "PlanosDeSaude.findById", query = "SELECT p FROM PlanosDeSaude p WHERE p.id = :id"),
    @NamedQuery(name = "PlanosDeSaude.findByNome", query = "SELECT p FROM PlanosDeSaude p WHERE p.nome = :nome")})
public class PlanosDeSaude implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlanoDeSaude")
    private List<FichaPaciente> fichaPacienteList;

    public PlanosDeSaude() {
    }

    public PlanosDeSaude(Integer id) {
        this.id = id;
    }

    public PlanosDeSaude(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<FichaPaciente> getFichaPacienteList() {
        return fichaPacienteList;
    }

    public void setFichaPacienteList(List<FichaPaciente> fichaPacienteList) {
        this.fichaPacienteList = fichaPacienteList;
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
        if (!(object instanceof PlanosDeSaude)) {
            return false;
        }
        PlanosDeSaude other = (PlanosDeSaude) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.pd.inf.sistemahospital.beans.PlanosDeSaude[ id=" + id + " ]";
    }
    
}
