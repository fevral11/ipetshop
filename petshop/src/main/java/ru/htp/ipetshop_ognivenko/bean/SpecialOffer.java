package ru.htp.ipetshop_ognivenko.bean;

import java.io.Serializable;
import java.sql.Time;

public class SpecialOffer implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer specialOfferId;
	private String typeOffer;
	private String valueSpecialOffer;
	private Time dateStart;
	private Time dateEnd;

	public SpecialOffer() {
	}

	public SpecialOffer(String typeOffer, String valueSpecialOffer, Time dateStart, Time dateEnd) {
		this.typeOffer = typeOffer;
		this.valueSpecialOffer = valueSpecialOffer;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}

	public Integer getIdSpecialOffer() {
		return specialOfferId;
	}

	public String getTypeOffer() {
		return typeOffer;
	}

	public void setTypeOffer(String typeOffer) {
		this.typeOffer = typeOffer;
	}

	public String getValueSpecialOffer() {
		return valueSpecialOffer;
	}

	public void setValueSpecialOffer(String valueSpecialOffer) {
		this.valueSpecialOffer = valueSpecialOffer;
	}

	public Time getDateStart() {
		return dateStart;
	}

	public void setDateStart(Time dateStart) {
		this.dateStart = dateStart;
	}

	public Time getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Time dateEnd) {
		this.dateEnd = dateEnd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateEnd == null) ? 0 : dateEnd.hashCode());
		result = prime * result + ((dateStart == null) ? 0 : dateStart.hashCode());
		result = prime * result + ((specialOfferId == null) ? 0 : specialOfferId.hashCode());
		result = prime * result + ((typeOffer == null) ? 0 : typeOffer.hashCode());
		result = prime * result + ((valueSpecialOffer == null) ? 0 : valueSpecialOffer.hashCode());
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
		SpecialOffer other = (SpecialOffer) obj;
		if (dateEnd == null) {
			if (other.dateEnd != null)
				return false;
		} else if (!dateEnd.equals(other.dateEnd))
			return false;
		if (dateStart == null) {
			if (other.dateStart != null)
				return false;
		} else if (!dateStart.equals(other.dateStart))
			return false;
		if (specialOfferId == null) {
			if (other.specialOfferId != null)
				return false;
		} else if (!specialOfferId.equals(other.specialOfferId))
			return false;
		if (typeOffer == null) {
			if (other.typeOffer != null)
				return false;
		} else if (!typeOffer.equals(other.typeOffer))
			return false;
		if (valueSpecialOffer == null) {
			if (other.valueSpecialOffer != null)
				return false;
		} else if (!valueSpecialOffer.equals(other.valueSpecialOffer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SpecialOffer [idSpecialOffer=" + specialOfferId + ", typeOffer=" + typeOffer + ", valueSpecialOffer="
				+ valueSpecialOffer + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + "]";
	}
}
