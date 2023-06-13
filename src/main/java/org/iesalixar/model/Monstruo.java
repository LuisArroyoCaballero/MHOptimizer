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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="monstruo")
public class Monstruo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true,nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String mapa1;
	
	@Column(nullable=false)
	private String mapa2;
	
	@OneToMany(mappedBy="monstruo",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Material> materiales = new ArrayList<Material>();
	
	@OneToMany(mappedBy="monstruo",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Armadura> armaduras = new ArrayList<Armadura>();
	

	public Monstruo() {
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



	public String getMapa1() {
		return mapa1;
	}



	public void setMapa1(String mapa1) {
		this.mapa1 = mapa1;
	}



	public String getMapa2() {
		return mapa2;
	}



	public void setMapa2(String mapa2) {
		this.mapa2 = mapa2;
	}



	public List<Material> getMateriales() {
		return materiales;
	}



	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}



	public List<Armadura> getArmaduras() {
		return armaduras;
	}



	public void setArmaduras(List<Armadura> armaduras) {
		this.armaduras = armaduras;
	}



	@Override
	public int hashCode() {
		return Objects.hash(armaduras, id, mapa1, mapa2, materiales, nombre);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monstruo other = (Monstruo) obj;
		return Objects.equals(armaduras, other.armaduras) && Objects.equals(id, other.id)
				&& Objects.equals(mapa1, other.mapa1) && Objects.equals(mapa2, other.mapa2)
				&& Objects.equals(materiales, other.materiales) && Objects.equals(nombre, other.nombre);
	}



	
	
	
	
	
}
