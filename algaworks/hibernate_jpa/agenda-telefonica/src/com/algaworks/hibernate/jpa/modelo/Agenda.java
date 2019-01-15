package com.algaworks.hibernate.jpa.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private String telefone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegistro;

    public Long getCodigo() {
	return codigo;
    }

    public void setCodigo(Long codigo) {
	this.codigo = codigo;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getTelefone() {
	return telefone;
    }

    public void setTelefone(String telefone) {
	this.telefone = telefone;
    }

    public Date getDataRegistro() {
	return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
	this.dataRegistro = dataRegistro;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Agenda other = (Agenda) obj;
	if (codigo == null) {
	    if (other.codigo != null)
		return false;
	} else if (!codigo.equals(other.codigo))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Agenda [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", dataRegistro=" + dataRegistro + "]";
    }

}
