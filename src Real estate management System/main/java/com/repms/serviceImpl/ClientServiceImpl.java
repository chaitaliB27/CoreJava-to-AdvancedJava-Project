package com.repms.serviceImpl;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.repms.entity.ClientRes;
import com.repms.exception.IdNotFoundException;
import com.repms.model.ClientDTO;
import com.repms.repository.ClientRepository;
import com.repms.service.ClientService;
import com.repms.util.ClientConverter;
@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
	ClientRepository creposi;
	 @Autowired
	    private ClientConverter clientConverter;
	@Override
	public ClientDTO addClientRess(ClientRes clientRes) {
		creposi.save(clientRes);
		return clientConverter.convertToClientDTO(clientRes);
	}

	@Override
	public ClientRes getClientRessDetail(int cid) {
		return creposi.findById(cid).orElseThrow( ()-> new IdNotFoundException("ClientRegistration id is not found"));
	}

	@Override
	public ClientRes updateClientRessDetail(ClientRes clientRes, int cid) {
		ClientRes updateClient = creposi.findById(cid).orElseThrow( ()-> new IdNotFoundException("Agent id is not correct"));
		updateClient.setCit(clientRes.getCit());
		updateClient.setCfname(clientRes.getCfname());
		updateClient.setClname(clientRes.getClname());
		updateClient.setUsername(clientRes.getUsername());
		updateClient.setPassword(clientRes.getPassword());
		updateClient.setCaddr(clientRes.getCaddr());
		updateClient.setCemail(clientRes.getCemail());
		updateClient.setCphone(clientRes.getCphone());
		updateClient.setGender(clientRes.getGender());
		creposi.save(updateClient);
		
		return updateClient;
	}

	@Override
	public void deleteClientRessDetail(int cid) {
		creposi.findById(cid).orElseThrow( ()-> new IdNotFoundException("ClientRegistration id is not correct"));
		creposi.deleteById(cid);
		
	}

	@Override
	public List<ClientDTO> getAllClientRess() {
List<ClientRes> clientRes = creposi.findAll();
		
		List<ClientDTO> dtoList = new ArrayList<>();
		for(ClientRes a: clientRes)
		{
			dtoList.add(clientConverter.convertToClientDTO(a));
		}
		return dtoList;
	}
	
	

}
