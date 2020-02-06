package br.com.challange.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Client {
	
	@Getter @Setter
	private int id;
	
	@Getter @Setter
	private long cnpj;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private String nameBusinessArea;
	
}
