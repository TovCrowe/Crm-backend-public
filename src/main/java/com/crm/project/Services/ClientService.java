package com.crm.project.Services;

import com.crm.project.DTO.ClientDTO;
import com.crm.project.Model.ClientModel;

import java.util.List;

public interface ClientService {
    List<ClientModel> getAllClients();
    ClientModel createClient(ClientModel client);
    ClientModel getClientById(Long id);
    ClientModel updateClient(Long id, ClientDTO clientDetails);
    void deleteClient(Long id);
}
