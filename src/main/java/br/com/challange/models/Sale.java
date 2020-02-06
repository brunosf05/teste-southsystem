package br.com.challange.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Sale{
	
	@Getter @Setter
	private long id;
	
	@Getter @Setter
	private List<ItemSale> itens;

	@Getter @Setter
	private String salemanName;
}
