package ru.htp.ipetshop_ognivenko.bean;

import java.io.Serializable;
import java.sql.Time;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer orderId;
	private Time orderDate;
	private String orderStatus;
	private Integer userId;
	private Integer goodsId;
	private Integer deliveryId;

	public Order() {
	}

	public Order(Time dateOrder, String statusOrder, Integer idUser, Integer idGoods, Integer idDelivery) {
		this.orderDate = dateOrder;
		this.orderStatus = statusOrder;
		this.userId = idUser;
		this.goodsId = idGoods;
		this.deliveryId = idDelivery;
	}

	public Integer getIdOrder() {
		return orderId;
	}

	public Time getDateOrder() {
		return orderDate;
	}

	public void setDateOrder(Time dateOrder) {
		this.orderDate = dateOrder;
	}

	public String getStatusOrder() {
		return orderStatus;
	}

	public void setStatusOrder(String statusOrder) {
		this.orderStatus = statusOrder;
	}

	public Integer getIdUser() {
		return userId;
	}

	public void setIdUser(Integer idUser) {
		this.userId = idUser;
	}

	public Integer getIdGoods() {
		return goodsId;
	}

	public void setIdGoods(Integer idGoods) {
		this.goodsId = idGoods;
	}

	public Integer getIdDelivery() {
		return deliveryId;
	}

	public void setIdDelivery(Integer idDelivery) {
		this.deliveryId = idDelivery;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliveryId == null) ? 0 : deliveryId.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
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
		Order other = (Order) obj;
		if (deliveryId == null) {
			if (other.deliveryId != null)
				return false;
		} else if (!deliveryId.equals(other.deliveryId))
			return false;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [idOrder=" + orderId + ", statusOrder=" + orderStatus + ", idUser=" + userId + ", idGoods="
				+ goodsId + ", idDelivery=" + deliveryId + "]";
	}

}
