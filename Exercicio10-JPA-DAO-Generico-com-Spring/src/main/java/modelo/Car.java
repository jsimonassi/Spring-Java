package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(name = "Car.getAllCars", query = "select c from Car c order by c.id") })

@Entity
@Table(name = "cars")
public class Car {
	private Long id;
	private String identification;
	private String model;
	private String brand;


	public Car() {
	}

	public Car(String identification, String model, String brand) {
		this.identification = identification;
		this.model = model;
		this.brand = brand;
	}

	// ********* Métodos do Tipo Get *********

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public String getModel() {
		return model;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getIdentification() {
		return identification;
	}

	// ********* Métodos do Tipo Set *********

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
	@Override
	public String toString() {
		return "Número: " + this.id + " | Placa: " + this.identification + " | Model: " + this.model + " | Marca: " + this.brand;
	}
}
