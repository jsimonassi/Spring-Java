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
	@NamedQuery(name = "Store.getAllStores", query = "select s from Store s order by s.id") })

@Entity
@Table(name = "stores")
public class Store {
	private Long id;
	private String address;


	public Store() {
	}

	public Store(String address) {
		this.address = address;
	}

	// ********* M�todos do Tipo Get *********

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	// ********* M�todos do Tipo Set *********

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "N�mero: " + this.id + " | Endere�o: " + this.address;
	}
}
