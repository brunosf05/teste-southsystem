package br.com.challange.services;

import java.io.IOException;
import br.com.challange.util.ConstantUtil;

public class ReportService {

	private static final String FILE_NAME = "flat_file_name.done";

	public void generateReportContent() throws IOException {
		ClientService cs = new ClientService();
		SaleService ss = new SaleService();
		SalesmanService sm = new SalesmanService();

		System.out.println("Quantidade de Clientes: " + cs.amountClient());
		System.out.println("Quantidade de Vendedores: " + sm.amountSalesman());
		System.out.println("ID da maior venda: " + ss.getMostExpensiveSaleId());
		System.out.println("Obter pior Vendedor: " + ss.getWorstSalesman());

		saveReport(
				cs.amountClient() + "ç" + 
				sm.amountSalesman() + "ç" + 
				ss.getMostExpensiveSaleId() + "ç"+ 
				ss.getWorstSalesman());
	}

	public void saveReport(String body) {
		FileService file = new FileService();
		file.saveFile(ConstantUtil.DIR_OUT, FILE_NAME, body);
	}
}
