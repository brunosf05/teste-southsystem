package br.com.challange.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import br.com.challange.models.ItemSale;
import br.com.challange.models.Sale;
import br.com.challange.util.ConstantUtil;

public class SaleService {

	private static final String FILE_NAME = "vendas";

	public List<Sale> findAllSales() throws IOException {

		ArrayList<Sale> newSales = new ArrayList<>();
		String line = "";
		FileService file = new FileService();
		BufferedReader br = file.readFile(ConstantUtil.DIR_IN, FILE_NAME);

		while ((line = br.readLine()) != null) {
			Sale s = new Sale();

			String[] salesLabel = line.split("ç");

			s.setId(Long.parseLong(salesLabel[0]));
			s.setItens(createItemSale(salesLabel[2]));
			s.setSalemanName(salesLabel[3]);
			newSales.add(s);
		}

		return newSales;
	}

	public List<ItemSale> createItemSale(String itemSale) {
		List<ItemSale> saleItems = new ArrayList();
		List<String> items = Arrays.asList(itemSale.replace("[", "").replace("]", "").split(","));
		SaleItemService ss = new SaleItemService();

		for (int i = 0; i < items.size(); i++) {
			String string = items.get(i);
			saleItems.add(ss.registerItemSale(items.get(i)));

		}

		return saleItems;

	}

	public long getMostExpensiveSaleId() throws IOException {
		BigDecimal mostExpensiveSale = BigDecimal.ZERO;
		Long mostExpensiveSaleId = 0L;
		List<Sale> sales = findAllSales();
		for (Sale sale : sales) {
			BigDecimal purchaseTotal = purchaseTotal(sale);
			if (mostExpensiveSale.compareTo(purchaseTotal) <= 0) {
				mostExpensiveSaleId = sale.getId();
				mostExpensiveSale = purchaseTotal;
			}
		}
		return mostExpensiveSaleId;

	}

	private BigDecimal purchaseTotal(Sale sale) {
		BigDecimal purchaseTotal = BigDecimal.ZERO;
		for (ItemSale item : sale.getItens()) {
			purchaseTotal = purchaseTotal.add(item.getPrice());
		}
		return purchaseTotal;
	}
	
	 public String getWorstSalesman() throws IOException{
	        List<Sale> sales = findAllSales();
	        BigDecimal worstSalePrice = purchaseTotal(sales.get(0));
	        Sale worstSale = sales.get(0);
	        for(Sale sale : sales) {
	            if(worstSalePrice.compareTo(purchaseTotal(sale)) < 0){
	            } else {
	                worstSalePrice = purchaseTotal(sale);
	                worstSale = sale;
	            }
	        }
	        
	        return worstSale.getSalemanName();
	    }

}
