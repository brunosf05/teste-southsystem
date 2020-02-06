package br.com.challange.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.challange.models.Salesman;
import br.com.challange.util.ConstantUtil;

public class SalesmanService {
	private static final String FILE_NAME = "vendedor";

	public List<Salesman> findAllSalesman() throws IOException {

		ArrayList<Salesman> newSalesmans = new ArrayList();

		String line = "";
		FileService file = new FileService();
		BufferedReader br = file.readFile(ConstantUtil.DIR_IN, FILE_NAME);

		while ((line = br.readLine()) != null) {
			String[] salesmanLabel = line.split("ç");
			Salesman s = new Salesman();
			s.setId(Long.parseLong(salesmanLabel[0]));
			s.setCpf(Long.parseLong(salesmanLabel[1]));
			s.setName(salesmanLabel[2]);
			s.setSalaray(Double.parseDouble(salesmanLabel[3]));
			newSalesmans.add(s);
		}
		return newSalesmans;
	}
	
	public long amountSalesman() throws IOException{
		return findAllSalesman().size();
	}
}
