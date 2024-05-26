package com.repms.service;

import java.util.List;

import com.repms.entity.ClientRes;
import com.repms.model.ClientDTO;

public interface ClientService {
	ClientDTO addClientRess(ClientRes clientRes);
	
	ClientRes getClientRessDetail(int cid);
	
	
	ClientRes updateClientRessDetail(ClientRes clientRes, int cid);
	
	void deleteClientRessDetail(int cid);
	
	List<ClientDTO> getAllClientRess();
}
