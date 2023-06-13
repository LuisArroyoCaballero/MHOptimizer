package org.iesalixar.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="arsenal")
@IdClass(ArsenalId.class)
public class Arsenal implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_usuario",insertable=false,updatable=false)
	private Usuario usuario;
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_armadura",insertable=false,updatable=false)
	private Armadura armadura;


	public Arsenal() {
		// TODO Auto-generated constructor stub
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Armadura getArmadura() {
		return armadura;
	}


	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}


	@Override
	public int hashCode() {
		return Objects.hash(armadura, usuario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arsenal other = (Arsenal) obj;
		return Objects.equals(armadura, other.armadura) && Objects.equals(usuario, other.usuario);
	}
	
	
	
	

}
