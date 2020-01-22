package com.app.api.domain.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.api.domain.model.Bill;
import com.app.api.shared.domain.Id;

@Component
public interface BillService {
	
	public Bill save(Bill bill);
	
	public Bill getBill(Id id);

	public List<Bill> getBills();

	public Bill updateBill(Bill bill, Id id);

	public void deleteBill(Id id);
	
}
