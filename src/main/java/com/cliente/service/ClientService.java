package com.cliente.service;

import com.cliente.domain.Client;
import com.cliente.exception.ClientNotFoundException;
import com.cliente.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findById(Long id){
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new ClientNotFoundException(
                "Cliente não encontrado - ID " + id + " Tipo " + Client.class.getName()
        ));
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client create(Client client){
        client.setId(null);
        return clientRepository.save(client);
    }

    public Client update(Long id, Client client){
        Client updateClient = findById(id);
        updateClient.setNome(client.getNome());
        updateClient.setSobrenome(client.getSobrenome());
        updateClient.setLogin(client.getLogin());
        updateClient.setSenha(client.getSenha());
        return clientRepository.save(updateClient);
    }

    public void delete(Long id){
        findById(id);
        clientRepository.deleteById(id);
    }

}
