package org.miaad.compteservice.service;

import org.miaad.compteservice.entities.Compte;
import org.miaad.compteservice.repositories.CompteRepository;
import org.miaad.compteservice.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {
    @Autowired
    private CompteRepository compteRepository;
    @Override
    public void viremment(Long codeSource, Long codeDestination, double montant) {
        Compte c1=compteRepository.getById(codeSource);
        Compte c2=compteRepository.getById(codeDestination);
        c1.setSolde(c1.getSolde()-montant);
        c2.setSolde(c2.getSolde()+montant);
        compteRepository.save(c1);
        compteRepository.save(c2);
    }
}
