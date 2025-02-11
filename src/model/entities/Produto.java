package model.entities;

import java.util.Objects;

public class Produto {
	
	private static Integer counterId = 1;
	private Integer id;
	private String name;
	private Double price;
	
	public Produto() {
		
	}
	
	public Produto(String name, Double price) {
		this.id = counterId++;
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return String.format("|ID Product: %d \n|Product Name: %s \n|Price: R$ %.2f\n",
				getId(), getName(), getPrice());
	}
	
}
