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
	@NamedQuery(name = "Client.getAllClients", query = "select c from Client c order by c.id") })



@Entity
@Table(name = "clients")
public class Client {
	private Long id;
	private String name;
	private String cpf;

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
}
