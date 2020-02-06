package br.com.challange.models;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ItemSale {
	
	@Getter @Setter
	private long id;
	
	@Getter @Setter
	private int amount;
	
	@Getter @Setter
	private BigDecimal price;
}
