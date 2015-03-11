package anuncios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String img;
	private String description;
	private double price;
	
	
	public Product() {}
	
	public Product(String name, String img, String description, double price){
		this.name=name;
		this.img=img;
		this.description=description;
		this.price=price;
	}
	
	public String getDescription() {
		return description;
	}
	public String getName() {
		return name;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	

}
