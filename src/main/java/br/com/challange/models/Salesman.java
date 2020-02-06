package br.com.challange.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Salesman {
	
	@Getter @Setter
	private long id;
	
	@Getter @Setter
	private long cpf;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private double Salaray;
}
