package ru.htp.ipetshop_ognivenko.bean;

import java.io.Serializable;

public class Goods implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer goodsId;
	private String typeGoods;
	private String typeAnimal;
	private String title;
	private String manufacturer;
	private Double price;
	private Double priceSpecialOffer;
	private String picture;
	private String description;
	private Integer quantityOnWarehouse;
	private String status;

	public Goods() {
	}

	public Goods(Integer goodsId, String typeGoods, String typeAnimal, String title, String manufacturer, Double price,
			Double priceSpecialOffer, String picture, String description, Integer quantityOnWarehouse, String status) {
		this.goodsId = goodsId;
		this.typeGoods = typeGoods;
		this.typeAnimal = typeAnimal;
		this.title = title;
		this.manufacturer = manufacturer;
		this.price = price;
		this.priceSpecialOffer = priceSpecialOffer;
		this.picture = picture;
		this.description = description;
		this.quantityOnWarehouse = quantityOnWarehouse;
		this.status = status;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer idGoods) {
		this.goodsId = idGoods;
	}

	public String getTypeGoods() {
		return typeGoods;
	}

	public void setTypeGoods(String typeGoods) {
		this.typeGoods = typeGoods;
	}

	public String getTypeAnimal() {
		return typeAnimal;
	}

	public void setTypeAnimal(String typeAnimal) {
		this.typeAnimal = typeAnimal;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPriceSpecialOffer() {
		return priceSpecialOffer;
	}

	public void setPriceSpecialOffer(Double priceSpecialOffer) {
		this.priceSpecialOffer = priceSpecialOffer;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantityOnWarehouse() {
		return quantityOnWarehouse;
	}

	public void setQuantityOnWarehouse(Integer quantityOnWarehouse) {
		this.quantityOnWarehouse = quantityOnWarehouse;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((priceSpecialOffer == null) ? 0 : priceSpecialOffer.hashCode());
		result = prime * result + ((quantityOnWarehouse == null) ? 0 : quantityOnWarehouse.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((typeAnimal == null) ? 0 : typeAnimal.hashCode());
		result = prime * result + ((typeGoods == null) ? 0 : typeGoods.hashCode());
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
		Goods other = (Goods) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (priceSpecialOffer == null) {
			if (other.priceSpecialOffer != null)
				return false;
		} else if (!priceSpecialOffer.equals(other.priceSpecialOffer))
			return false;
		if (quantityOnWarehouse == null) {
			if (other.quantityOnWarehouse != null)
				return false;
		} else if (!quantityOnWarehouse.equals(other.quantityOnWarehouse))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (typeAnimal == null) {
			if (other.typeAnimal != null)
				return false;
		} else if (!typeAnimal.equals(other.typeAnimal))
			return false;
		if (typeGoods == null) {
			if (other.typeGoods != null)
				return false;
		} else if (!typeGoods.equals(other.typeGoods))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", typeGoods=" + typeGoods + ", typeAnimal=" + typeAnimal + ", title="
				+ title + ", manufacturer=" + manufacturer + ", price=" + price + ", priceSpecialOffer="
				+ priceSpecialOffer + ", picture=" + picture + ", description=" + description + ", quantityOnWarehouse="
				+ quantityOnWarehouse + ", status=" + status + "]";
	}

}
