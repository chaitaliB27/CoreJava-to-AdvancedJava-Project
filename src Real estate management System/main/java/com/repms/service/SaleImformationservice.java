package com.repms.service;

import java.util.List;

import com.repms.entity.SaleImformation;
import com.repms.model.SaleImformationDTO;

public interface SaleImformationservice {
	SaleImformationDTO addSaleImformations(SaleImformation saleImformation);
	
	SaleImformation getSaleImformationsDetail(int sid);
	
	
	SaleImformation updateSaleImformationsDetail(SaleImformation saleImformation, int sid);
	
	void deleteSaleImformationsDetail(int sid);
	
	List<SaleImformationDTO> getAllSaleInformations();
}
