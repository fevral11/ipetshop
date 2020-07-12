package ru.htp.ipetshop_ognivenko.bean;

import java.io.Serializable;
import java.sql.Time;

public class Supply implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer supplyId;
	private Time supplyDete;
	private Integer quantity;
	private Integer goodsId;

	public Supply() {
	}

	public Supply(Time dateSupply, Integer quantity, Integer idGoods) {
		this.supplyDete = dateSupply;
		this.quantity = quantity;
		this.goodsId = idGoods;
	}

	public Integer getIdSupply() {
		return supplyId;
	}

	public Time getDateSupply() {
		return supplyDete;
	}

	public void setDateSupply(Time dateSupply) {
		this.supplyDete = dateSupply;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getIdGoods() {
		return goodsId;
	}

	public void setIdGoods(Integer idGoods) {
		this.goodsId = idGoods;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((supplyId == null) ? 0 : supplyId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		Supply other = (Supply) obj;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (supplyId == null) {
			if (other.supplyId != null)
				return false;
		} else if (!supplyId.equals(other.supplyId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Supply [idSupply=" + supplyId + ", quantity=" + quantity + ", idGoods=" + goodsId + "]";
	}

}
