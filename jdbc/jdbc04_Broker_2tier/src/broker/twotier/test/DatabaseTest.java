package broker.twotier.test;

import java.util.ArrayList;

import broker.twotier.dao.Database;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.StockRec;

public class DatabaseTest {

	public static void main(String[] args) throws Exception {
		Database db = new Database("127.0.0.1");
		/*db.addCustomer(new CustomerRec("123-123","아이유","판교"));
		db.deleteCustomer("123-123");
		db.updateCustomer(new CustomerRec("111-119","김춘배","화양동"));*/
		//db.getPortolio("111-119");
		/*db.getCustonmer("111-119");
		db.getCustonmer("123-123");
		
		ArrayList<CustomerRec> custTmp = db.getAllCustomers();
		for(CustomerRec c: custTmp) System.out.println(c);
		
		ArrayList<StockRec> stockTmp = db.getAllPortfolio("111-119");
		for(StockRec c: stockTmp) System.out.println(c);*/
		
		//db.buyShares("111-119", "DUKE", 3);
		db.sellShares("111-119", "DUKE", 2);
		
		
		
		
		
	}

}
