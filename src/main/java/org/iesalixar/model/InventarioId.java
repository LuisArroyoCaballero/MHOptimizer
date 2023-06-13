package org.iesalixar.model;

import java.io.Serializable;
import java.util.Objects;

public class InventarioId implements Serializable {
	
	private Long armadura;
	private Long material;
	
	
	public InventarioId() {
		// TODO Auto-generated constructor stub
	}


	public Long getArmadura() {
		return armadura;
	}


	public void setArmadura(Long armadura) {
		this.armadura = armadura;
	}


	public Long getMaterial() {
		return material;
	}


	public void setMaterial(Long material) {
		this.material = material;
	}


	@Override
	public int hashCode() {
		return Objects.hash(armadura, material);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventarioId other = (InventarioId) obj;
		return Objects.equals(armadura, other.armadura) && Objects.equals(material, other.material);
	}
	
	
	
	
	

}
