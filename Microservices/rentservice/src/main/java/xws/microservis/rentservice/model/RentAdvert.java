package xws.microservis.rentservice.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
public class RentAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn
	private Car car;
	
	@Column
	private Date advertStartDate;
	
	@Column
	private Date advertEndDate;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pricelist_id")
	private PriceList priceList;

	@ManyToOne
	@JoinColumn(name = "firm", nullable = true)
	private Firm firm;

	@ManyToOne
	@JoinColumn(name = "user", nullable = true)
	private User user;

	@ManyToMany(mappedBy = "rentAdvertList", fetch = FetchType.EAGER)
	private List<Chart> charts;


	public RentAdvert() {
		
	}


	public Car getCar() {
		return car;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public Date getAdvertStartDate() {
		return advertStartDate;
	}

	public void setAdvertStartDate(Date advertStartDate) {
		this.advertStartDate = advertStartDate;
	}

	public Date getAdvertEndDate() {
		return advertEndDate;
	}

	public void setAdvertEndDate(Date advertEndDate) {
		this.advertEndDate = advertEndDate;
	}


	public PriceList getPriceList() {
		return priceList;
	}

	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}

	public Firm getFirm() {
		return firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
	}




    public List<Chart> getCharts() {
        return charts;
    }

    public void setCharts(List<Chart> charts) {
        this.charts = charts;
    }
}
