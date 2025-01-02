package com.crm.project.Controller;


import com.crm.project.DTO.ClientDTO;
import com.crm.project.Model.ClientModel;
import com.crm.project.Services.Impl.ClientServiceImpl;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;


    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<ClientModel>> getAllClients() {
        var newClient = clientService.getAllClients();
        return ResponseEntity.ok(newClient);
    }
    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<ClientModel> getClientById(@PathVariable Long id) {
        var newClient = clientService.getClientById(id);
        return ResponseEntity.ok(newClient);
    }
    @PostMapping
    @CrossOrigin
    public ResponseEntity<ClientModel> createClient(@RequestBody ClientModel client) {
        var newClient = clientService.createClient(client);
        return ResponseEntity.ok(newClient);
    }
    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<ClientModel> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDetails) {
        var newClient = clientService.updateClient(id, clientDetails);
        return ResponseEntity.ok(newClient);
    }
    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok("Client deleted");
    }

    
}
