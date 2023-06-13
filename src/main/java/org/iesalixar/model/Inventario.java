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
@Table(name="inventario")
@IdClass(InventarioId.class)
public class Inventario implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_armadura",insertable=false,updatable=false)
	private Armadura armadura;
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_material",insertable=false,updatable=false)
	private Material material;
	
	//@Column(nullable=false)
	private int cantidad_material;

	public Inventario() {
		// TODO Auto-generated constructor stub
	}

	public Armadura getArmadura() {
		return armadura;
	}

	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public int getCantidad_material() {
		return cantidad_material;
	}

	public void setCantidad_material(int cantidad_material) {
		this.cantidad_material = cantidad_material;
	}

	@Override
	public int hashCode() {
		return Objects.hash(armadura, cantidad_material, material);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventario other = (Inventario) obj;
		return Objects.equals(armadura, other.armadura) && cantidad_material == other.cantidad_material
				&& Objects.equals(material, other.material);
	} 
	
	
	
	
	
	

}
