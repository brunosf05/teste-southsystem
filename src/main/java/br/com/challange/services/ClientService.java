package br.com.challange.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import br.com.challange.util.ConstantUtil;
import br.com.challange.models.Client;
import br.com.challange.services.FileService;

public class ClientService {

	private static final String FILE_NAME = "cliente";

	public List<Client> findAllClient() throws IOException {
		
		ArrayList<Client> newClient = new ArrayList<>();
		
		String line = "";
		FileService file = new FileService();
		BufferedReader br = file.readFile(ConstantUtil.DIR_IN, FILE_NAME);

		while ((line = br.readLine()) != null) {
			String[] clientLabel = line.split("ç");
			Client c = new Client();
			c.setId(Integer.parseInt(clientLabel[0]));
			c.setCnpj(Long.parseLong(clientLabel[1]));
			c.setName(clientLabel[2]);
			c.setNameBusinessArea(clientLabel[3]);
			newClient.add(c);
		}
		return newClient;
	}
	
	public long amountClient() throws IOException {
		return findAllClient().size();
	}
}
