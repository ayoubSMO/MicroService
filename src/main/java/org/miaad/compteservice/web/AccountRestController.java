package org.miaad.compteservice.web;

import org.miaad.compteservice.dtos.VirementRequestDTO;
import org.miaad.compteservice.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
    @Autowired
    private CompteService compteService;

    @PutMapping(path = "comptes/virement")
    public void viremment (@RequestBody VirementRequestDTO request){
        compteService.viremment(request.getCodeSource(),request.getCodeDestination(),request.getMontant());


    }
}