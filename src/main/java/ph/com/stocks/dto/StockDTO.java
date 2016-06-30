package ph.com.stocks.dto;

import java.util.Date;
import java.util.List;

import ph.com.stocks.model.Stock;

public class StockDTO {
	
	List<Stock> stock;
	Date as_of;
	public List<Stock> getStock() {
		return stock;
	}
	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}
	public Date getAs_of() {
		return as_of;
	}
	public void setAs_of(Date as_of) {
		this.as_of = as_of;
	}
	
}
