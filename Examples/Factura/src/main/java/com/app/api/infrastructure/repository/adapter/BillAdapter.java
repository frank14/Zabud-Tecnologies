package com.app.api.infrastructure.repository.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.domain.model.Bill;
import com.app.api.domain.service.BillService;
import com.app.api.infrastructure.mapper.BillMapper;
import com.app.api.infrastructure.repository.database.BillRepository;
import com.app.api.shared.domain.Id;

@Service
public class BillAdapter implements BillService {
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	BillMapper billMapper;
	
	@Override
	public Bill save(Bill bill) {
		return billMapper.dtoDom(billRepository.save(billMapper.domDto(bill)));
	}

	@Override
	public Bill getBill(Id id) {
		return billMapper.dtoDom(billRepository.findById(id.getId()).orElseThrow(() -> new RuntimeException()));
	}

	@Override
	public List<Bill> getBills() {
		return billMapper.listDtoDom(billRepository.findAll());
	}

	@Override
	public Bill updateBill(Bill bill, Id id) {
		Bill findBill = getBill(id);
		save(bill);
		return findBill;
	}

	@Override
	public void deleteBill(Id id) {
		billRepository.deleteById(id.getId());			
	}

}
