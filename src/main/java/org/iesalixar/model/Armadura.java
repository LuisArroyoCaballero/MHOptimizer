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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="armadura")
public class Armadura implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true,nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private Long rareza;
	
	@Column(nullable=false)
	private String parte;
	
	@ManyToOne
	@JoinColumn(name="id_monstruo", insertable=false, updatable=false, nullable=false)
	private Monstruo monstruo;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "inventario", 
        joinColumns = { @JoinColumn(name = "id_armadura") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_material") }
    )
    private List<Material> materiales = new ArrayList<Material>();
	
	
	
	@OneToMany(mappedBy="armadura",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Inventario> inventario = new ArrayList<Inventario>();
	
	@OneToMany(mappedBy="armadura",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Arsenal> arsenal = new ArrayList<Arsenal>();
	
	

	public Armadura() {
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







	public Long getRareza() {
		return rareza;
	}







	public void setRareza(Long rareza) {
		this.rareza = rareza;
	}







	public String getParte() {
		return parte;
	}







	public void setParte(String parte) {
		this.parte = parte;
	}







	public Monstruo getMonstruo() {
		return monstruo;
	}







	public void setMonstruo(Monstruo monstruo) {
		this.monstruo = monstruo;
	}







	public List<Material> getMateriales() {
		return materiales;
	}







	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}







	public List<Inventario> getInventario() {
		return inventario;
	}







	public void setInventario(List<Inventario> inventario) {
		this.inventario = inventario;
	}







	public List<Arsenal> getArsenal() {
		return arsenal;
	}







	public void setArsenal(List<Arsenal> arsenal) {
		this.arsenal = arsenal;
	}







	@Override
	public int hashCode() {
		return Objects.hash(arsenal, id, inventario, materiales, nombre, parte, rareza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Armadura other = (Armadura) obj;
		return Objects.equals(arsenal, other.arsenal) && Objects.equals(id, other.id)
				&& Objects.equals(inventario, other.inventario) && Objects.equals(materiales, other.materiales)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(parte, other.parte)
				&& Objects.equals(rareza, other.rareza);
	}
	
	
	
}
