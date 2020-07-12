package ru.htp.ipetshop_ognivenko.bean;

import java.io.Serializable;
import java.sql.Time;

public class Delivery implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idDelivery;
	private String address;
	private Double priceDelivery;
	private Time dateDelivery;
	private String statusDelivery;

	public Delivery() {
	}

	public Delivery(String address, Double priceDelivery, Time dateDelivery, String statusDelivery) {
		this.address = address;
		this.priceDelivery = priceDelivery;
		this.dateDelivery = dateDelivery;
		this.statusDelivery = statusDelivery;
	}

	public Integer getIdDelivery() {
		return idDelivery;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getPriceDelivery() {
		return priceDelivery;
	}

	public void setPriceDelivery(Double priceDelivery) {
		this.priceDelivery = priceDelivery;
	}

	public Time getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(Time dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	public String getStatusDelivery() {
		return statusDelivery;
	}

	public void setStatusDelivery(String statusDelivery) {
		this.statusDelivery = statusDelivery;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((idDelivery == null) ? 0 : idDelivery.hashCode());
		result = prime * result + ((priceDelivery == null) ? 0 : priceDelivery.hashCode());
		result = prime * result + ((statusDelivery == null) ? 0 : statusDelivery.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Delivery other = (Delivery) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (idDelivery == null) {
			if (other.idDelivery != null)
				return false;
		} else if (!idDelivery.equals(other.idDelivery))
			return false;
		if (priceDelivery == null) {
			if (other.priceDelivery != null)
				return false;
		} else if (!priceDelivery.equals(other.priceDelivery))
			return false;
		if (statusDelivery == null) {
			if (other.statusDelivery != null)
				return false;
		} else if (!statusDelivery.equals(other.statusDelivery))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Delivery [idDelivery=" + idDelivery + ", address=" + address + ", priceDelivery=" + priceDelivery
				+ ", statusDelivery=" + statusDelivery + "]";
	}

}
