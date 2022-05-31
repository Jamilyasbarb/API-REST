package br.eti.kge.OSApiApplication.domain.repository;

import br.eti.kge.OSApiApplication.domain.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author devsys-a
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    List<Cliente>findByNome(String nome);
    List<Cliente>findByEmail(String email);
//    List<Cliente>findByNomeContaining(String nome);
    
}
