package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(name = "Client.getAllClients", query = "select c from Client c order by c.id"),
	@NamedQuery(name = "Client.getClientWithAllRents", query = "select j from Client j left outer join fetch j.rents where j.id = ?1")})
	


@Entity
@Table(name = "clients")
public class Client {
	private Long id;
	private String name;
	private String cpf;
	private List<Rent> rents = new ArrayList<>();

	public Client() {
	}

	public Client(String name, String cpf) {
		this.name = name;
		this.cpf = cpf;
	}

	// ********* Métodos do Tipo Get *********

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getCpf() {
		return cpf;
	}

	// ********* Métodos do Tipo Set *********

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	@Override
	public String toString() {
		return "Número: " + this.id + " | Nome: " + this.name + " | CPF: " + this.cpf;
	}
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	@OrderBy
	public List<Rent> getRents() {
		return this.rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}
}
