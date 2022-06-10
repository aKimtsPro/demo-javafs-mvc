package bstorm.akimts.mvc.service;

import bstorm.akimts.mvc.models.dto.ClientDTO;
import bstorm.akimts.mvc.models.entity.Client;
import bstorm.akimts.mvc.models.form.ClientInsertForm;
import bstorm.akimts.mvc.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<ClientDTO> getAll(){
        return repository.findAll().stream()
                .map(ClientDTO::of)
                .toList();
    }

    public long insert(ClientInsertForm form){
        Client c = form.toEntity();
        return repository.save(c).getId();
    }
}
