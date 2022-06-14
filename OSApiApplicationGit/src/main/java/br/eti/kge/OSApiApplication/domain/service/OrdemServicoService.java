/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.eti.kge.OSApiApplication.domain.service;

import br.eti.kge.OSApiApplication.domain.model.OrdemServico;
import br.eti.kge.OSApiApplication.domain.model.StatusOrdemServico;
import br.eti.kge.OSApiApplication.domain.repository.OrdemServicoRepository;
import java.time.LocalDateTime;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author devsys-a
 */
@Service
public class OrdemServicoService {
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    public OrdemServico criar(OrdemServico ordemServico){
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());
        
        return ordemServicoRepository.save(ordemServico);
    }
    
    public ResponseEntity<OrdemServico> cancela(OrdemServico ordemServico){
        ordemServico.setStatus(StatusOrdemServico.CANCELADA);
        ordemServico.setDataAbertura(ordemServico.getDataAbertura());
        ordemServico.setDataFinalizada(LocalDateTime.now());
        
        ordemServicoRepository.save(ordemServico);
        
        return ResponseEntity.ok(ordemServico);
    }
    
    public ResponseEntity<OrdemServico> finaliza(OrdemServico ordemServico){
        ordemServico.setStatus(StatusOrdemServico.FINALIZADA);
       
        ordemServico.setDataFinalizada(LocalDateTime.now());
        
        
        ordemServicoRepository.save(ordemServico);
        
        return ResponseEntity.ok(ordemServico);
    }
    
    public void excluir (Long ordemId){
        ordemServicoRepository.deleteById(ordemId);
    }
}
