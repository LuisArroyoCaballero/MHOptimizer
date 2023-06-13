package org.iesalixar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="material")
public class Material implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true,nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private Long porcentaje;
	
	@Column(nullable=false)
	private String parte_monstruo;
	
	@ManyToOne
	@JoinColumn(name="id_monstruo")
	private Monstruo monstruo;
	
	@ManyToMany(mappedBy = "materiales")
    private List<Armadura> armaduras = new ArrayList<Armadura>();
	
	@OneToMany(mappedBy="material",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Inventario> inventario = new ArrayList<Inventario>();

	public Material() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Long porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getParte_monstruo() {
		return parte_monstruo;
	}

	public void setParte_monstruo(String parte_monstruo) {
		this.parte_monstruo = parte_monstruo;
	}

	public Monstruo getMonstruo() {
		return monstruo;
	}

	public void setMonstruo(Monstruo monstruo) {
		this.monstruo = monstruo;
	}

	public List<Armadura> getArmaduras() {
		return armaduras;
	}

	public void setArmaduras(List<Armadura> armaduras) {
		this.armaduras = armaduras;
	}

	public List<Inventario> getInventario() {
		return inventario;
	}

	public void setInventario(List<Inventario> inventario) {
		this.inventario = inventario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(armaduras, id, inventario, monstruo, nombre, parte_monstruo, porcentaje);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		return Objects.equals(armaduras, other.armaduras) && Objects.equals(id, other.id)
				&& Objects.equals(inventario, other.inventario) && Objects.equals(monstruo, other.monstruo)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(parte_monstruo, other.parte_monstruo)
				&& Objects.equals(porcentaje, other.porcentaje);
	}

	

	
	
	

	
}
