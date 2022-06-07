
package br.eti.kge.OSApiApplication.domain.service;

import br.eti.kge.OSApiApplication.domain.exception.DomainException;
import br.eti.kge.OSApiApplication.domain.model.Cliente;
import br.eti.kge.OSApiApplication.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente salvar (Cliente cliente){
        Cliente clienteExistente = (Cliente) clienteRepository.findByEmail(cliente.getEmail());
        
        if (clienteExistente != null && !clienteExistente.equals(cliente)) {
            throw new DomainException("Já existe um cliente cadastrado com esse email!");
        }
        
        return clienteRepository.save(cliente);
    }
    
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
    
}
