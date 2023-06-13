package org.iesalixar.model;

import java.io.Serializable;
import java.util.Objects;

public class ArsenalId implements Serializable {
	
	private Long usuario;
	private Long armadura;
	
	public ArsenalId() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getUsuario() {
		return usuario;
	}
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	public Long getArmadura() {
		return armadura;
	}
	public void setArmadura(Long armadura) {
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
		ArsenalId other = (ArsenalId) obj;
		return Objects.equals(armadura, other.armadura) && Objects.equals(usuario, other.usuario);
	}
	
	
	
	
	
	

}
