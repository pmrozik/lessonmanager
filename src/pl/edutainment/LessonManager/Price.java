package pl.edutainment.LessonManager;

import java.util.Currency;
import java.text.NumberFormat;

class Price {

	private double price;
	private Currency currency;
	
	Price(double price, Currency currency)
	{
		this.price = price;
		this.currency = currency;
	}
	
	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		nf.setCurrency(currency);
		sb.append("Price: ");
		sb.append(nf.format(price));
		sb.append("\n");
		
		return sb.toString();
	}
	

}
