package br.com.challange.services;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import br.com.challange.models.ItemSale;;
public class SaleItemService {

	public ItemSale registerItemSale(String itemSale) {
		ItemSale is = new ItemSale();
		
		List<String> items = Arrays.asList(itemSale.split("-"));
		is.setId(Long.parseLong(items.get(0)));
		is.setAmount(Integer.parseInt(items.get(1)));
		is.setPrice(new BigDecimal(items.get(2)));
		
		return is;
		
	}
}
