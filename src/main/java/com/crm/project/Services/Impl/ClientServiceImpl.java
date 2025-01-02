package com.crm.project.Services.Impl;

import com.crm.project.DTO.ClientDTO;
import com.crm.project.Model.ClientModel;
import com.crm.project.Repository.ClientRepository;
import com.crm.project.Services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientModel> getAllClients() {
        return clientRepository.findAll();
    }

    public ClientModel getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Client not found"));
    }
    @Override
    public ClientModel createClient(ClientModel client) {
        if(client.getName() ==  null || client.getName().isEmpty()){
            throw new IllegalArgumentException("Name is required");
        }
        if(client.getEmail() == null || client.getEmail().isEmpty()){
            throw new IllegalArgumentException("Email is required");
        }
        if(client.getPhone() == null || client.getPhone().isEmpty()){
            throw new IllegalArgumentException("Phone is required");
        }
        if(client.getCompany() == null || client.getCompany().isEmpty()){
            throw new IllegalArgumentException("Company is required");
        }
        ClientModel newClient = new ClientModel();
        newClient.setName(client.getName());
        newClient.setEmail(client.getEmail());
        newClient.setPhone(client.getPhone());
        newClient.setCompany(client.getCompany());
        newClient.setNotes(client.getNotes());

        return clientRepository.save(client);
    }

    @Override
    public ClientModel updateClient(Long id, ClientDTO clientDetails) {
        ClientModel client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Client not found"));
        client.setName(clientDetails.getName());
        client.setEmail(clientDetails.getEmail());
        client.setPhone(clientDetails.getPhone());
        client.setCompany(clientDetails.getCompany());
        client.setNotes(clientDetails.getNotes());
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        ClientModel client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Client not found"));
        clientRepository.delete(client);
    }

}
