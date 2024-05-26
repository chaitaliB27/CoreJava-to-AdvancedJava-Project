package com.repms.serviceImpl;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repms.entity.SaleImformation;
import com.repms.exception.IdNotFoundException;
import com.repms.model.SaleImformationDTO;
import com.repms.repository.SaleImformationrepository;
import com.repms.service.SaleImformationservice;
import com.repms.util.SaleImformationConverter;
@Service
public class SaleImformationServiceImpl implements SaleImformationservice{
	@Autowired
	SaleImformationrepository salerepo;
	
	@Autowired
    private SaleImformationConverter saleImformationConverter;

	@Override
	public SaleImformationDTO addSaleImformations(SaleImformation saleImformation) {
		salerepo.save(saleImformation);
		return saleImformationConverter.convertToSaleImformationDTO(saleImformation);
	}

	@Override
	public SaleImformation getSaleImformationsDetail(int sid) {
		return salerepo.findById(sid).orElseThrow( ()-> new IdNotFoundException("SaleInformation id is not found"));
	}

	@Override
	public SaleImformation updateSaleImformationsDetail(SaleImformation saleImformation, int sid) {
		SaleImformation updatesaleImformation = salerepo.findById(sid).orElseThrow( ()-> new IdNotFoundException("SaleInformation id is not correct"));
		updatesaleImformation.setSit(saleImformation.getSit());
		updatesaleImformation.setPaymentMode(saleImformation.getPaymentMode());
		updatesaleImformation.setPriceofpropertyC(saleImformation.getPriceofpropertyC());
		updatesaleImformation.setPriceofpropertyS(saleImformation.getPriceofpropertyS());
		updatesaleImformation.setSaleDate(saleImformation.getSaleDate());
		salerepo.save(updatesaleImformation);
		
		return updatesaleImformation;
	}

	@Override
	public void deleteSaleImformationsDetail(int sid) {
		salerepo.findById(sid).orElseThrow( ()-> new IdNotFoundException("SaleImformation id is not correct"));
		salerepo.deleteById(sid);
		
	}

	@Override
	public List<SaleImformationDTO> getAllSaleInformations() {
List<SaleImformation> saleImformation = salerepo.findAll();
		
		List<SaleImformationDTO> dtoList = new ArrayList<>();
		for(SaleImformation a: saleImformation)
		{
			dtoList.add(saleImformationConverter.convertToSaleImformationDTO(a));
		}
		return dtoList;
	}
	
	
}
