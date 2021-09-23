package modelo;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import util.Util;

@NamedQueries({
	@NamedQuery(name = "Rent.getAllRents", query = "select r from Rent r order by r.id") })

@Entity
@Table(name = "rents")
public class Rent {
	private Long id;
	private Calendar startDate;
	private Calendar endDate;
	private double price;
	private Long carId;
	private Long clientId;
	private Long withdrawnStoreId;
	private Long devolutionStoreId;
	
	private Client client;
	private Car car;
	
	// ********* Construtores *********

	public Rent() {
	}

	public Rent(Calendar startDate, Calendar endDate, double price, Long carId, Long clientId, Long withdrawnStoreId, Long devolutionStoreId) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.carId = carId;
		this.clientId = clientId;
		this.withdrawnStoreId = withdrawnStoreId;
		this.devolutionStoreId = devolutionStoreId;
	}

	// ********* Métodos do Tipo Get *********

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	public Calendar getStartDate() {
		return startDate;
	}
	
	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	public Calendar getEndDate() {
		return endDate;
	}

	public double getPrice() {
		return price;
	}

	@Column(name = "car_id")
	public Long getCarId() {
		return carId;
	}
	
	@Column(name = "client_id")
	public Long getClientId() {
		return clientId;
	}

	@Column(name = "withdrawn_store_id")
	public Long getWithdrawnStoreId() {
		return withdrawnStoreId;
	}
	
	@Column(name = "devolution_store_id")
	public Long getDevolutionStoreId() {
		return devolutionStoreId;
	}
	
	// ********* Métodos do Tipo Set *********

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}
	
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}
	
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public void setWithdrawnStoreId(Long withdrawnStoreId) {
		this.withdrawnStoreId = withdrawnStoreId;
	}

	public void setDevolutionStoreId(Long devolutionStoreId) {
		this.devolutionStoreId = devolutionStoreId;
	}
	
	@Override
	public String toString() {
		return "Número: " + this.id + " | data de início: " +Util.calendarToStr(this.startDate) + " | data do término: " 
				+ Util.calendarToStr(endDate) + " | Preço: " + this.price + " | Id do carro: " + this.carId + " | ID do cliente: "
				+ this.clientId + " | ID Loja Retirada: " + this.withdrawnStoreId + " | ID Loja Devolução: " + this.devolutionStoreId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", insertable=false, updatable=false)
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id", insertable=false, updatable=false)
	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
