package com.movies.api.model;

import javax.persistence.Column;

public class QuantityByGenre {
	@Column
	private String genre;
	@Column
	private int quantity;
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
