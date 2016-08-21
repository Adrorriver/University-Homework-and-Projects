/*
 * class represent an Item in stock.  
 */
public class Item implements Comparable<Item> {
	private String catalogNumber;
	private String description;
	private double price;

	public Item(String catalogNumber, String description, double price) {
		super();
		this.catalogNumber = catalogNumber;
		this.description = description;
		this.price = price;
	}

	public String getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(String catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return price;
	}

	public void setAmount(double price) {
		this.price = price;
	}
	
	@Override
	public String toString(){
		return String.format("%n %s, %s ,%f", catalogNumber,description,price);
	}

	@Override
	public int compareTo(Item o) {
		return this.getCatalogNumber().compareTo(o.getCatalogNumber());
	}

}
