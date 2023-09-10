package com.cliente.controller;

import com.cliente.domain.Client;
import com.cliente.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        Client client = this.clientService.findById(id);
        return ResponseEntity.ok().body(client);
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> clientList = clientService.findAll();
        return ResponseEntity.ok().body(clientList);
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client){
        Client createClient = clientService.create(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createClient.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client){
        Client updateClient = clientService.update(id, client);
        return ResponseEntity.ok().body(updateClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
