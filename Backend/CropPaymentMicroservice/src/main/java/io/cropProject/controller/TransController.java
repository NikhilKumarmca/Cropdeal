package io.cropProject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.razorpay.RazorpayException;

import io.cropProject.model.Transaction;
import io.cropProject.service.TransService;


@RestController
@CrossOrigin
@RequestMapping("/transaction")
public class TransController {

	@Autowired
	public TransService transService;
	
	
	
	@PostMapping("/create")
	
	public String createTran(@RequestBody Map<String, Object> data) throws RazorpayException
	{
		
		return transService.createTransaction(data);
		
			
	}
	
	@PutMapping("/update")
	public ResponseEntity<Transaction> updatetran(@RequestBody Map<String, Object> trans)
	{
		try {
			Transaction existTrns = transService.getbyorderid(trans.get("orderId").toString());
			existTrns.setPaymentId(trans.get("paymentId").toString());
			existTrns.setStatus(trans.get("status").toString());
			Transaction updatedTrans = transService.updatetran(existTrns);
			System.out.println(updatedTrans.getStatus());
			return new ResponseEntity<Transaction>(updatedTrans,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Transaction>> getAllTransaction()
	{
		try {
			return new ResponseEntity<List<Transaction>>(transService.getAllTransaction(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Transaction> getbyorderid(@PathVariable("id") String orderid)
	{
		try
		{
			return new ResponseEntity<Transaction>(transService.getbyorderid(orderid),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
