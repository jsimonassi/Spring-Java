package modelo;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private Long withdrawnStoreId;
	private Long devolutionStoreId;


	// ********* Construtores *********

	public Rent() {
	}

	public Rent(Calendar startDate, Calendar endDate, double price, Long carId, Long withdrawnStoreId, Long devolutionStoreId) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.carId = carId;
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
	public double getCarId() {
		return carId;
	}

	@Column(name = "withdrawn_store_id")
	@Temporal(TemporalType.DATE)
	public double getWithdrawnStoreId() {
		return withdrawnStoreId;
	}
	
	@Column(name = "devolution_store_id")
	@Temporal(TemporalType.DATE)
	public double getDevolutionStoreId() {
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

	public void setWithdrawnStoreId(Long withdrawnStoreId) {
		this.withdrawnStoreId = withdrawnStoreId;
	}

	public void setDevolutionStoreId(Long devolutionStoreId) {
		this.devolutionStoreId = devolutionStoreId;
	}
}
