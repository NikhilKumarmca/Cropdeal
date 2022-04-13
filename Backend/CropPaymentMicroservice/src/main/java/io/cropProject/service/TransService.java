	package io.cropProject.service;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razorpay.*;
import io.cropProject.model.Transaction;
import io.cropProject.repo.TransRepo;

@Service
public class TransService {

	@Autowired
	public TransRepo transrepo;
	
	public List<Transaction> getAllTransaction() {
		return transrepo.findAll();
	}

	public String createTransaction(Map<String, Object> data) throws RazorpayException {
		int amt=Integer.parseInt(data.get("totalAmt").toString());
		RazorpayClient client =	new RazorpayClient("rzp_test_TL2qlHMYIy8nUO", "5yfXw7iue03QbYombindJCIh");
		
		JSONObject obj = new JSONObject();
		obj.put("amount", amt*100);
		obj.put("currency", "INR");
		obj.put("receipt", "txn_122311");
		
		Order order = client.Orders.create(obj);
		System.out.println(order);
		
		Transaction trans = new Transaction();
		trans.setAmount(order.get("amount"));
		trans.setOrderId(order.get("id"));
		trans.setPaymentId(null);
		trans.setStatus("created");
		trans.setDealerEmail(data.get("dealerEmail").toString());
		trans.setTransDate(order.get("created_at"));
		transrepo.save(trans);
		return order.toString();
	}
	
	public Transaction getbyorderid(String orderid)
	{
		return transrepo.findByOrderId(orderid);
	}

	public Transaction updatetran(Transaction updateTrns) {
		
		return transrepo.save(updateTrns);
	}
}
