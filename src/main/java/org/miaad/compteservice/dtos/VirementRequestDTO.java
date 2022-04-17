package org.miaad.compteservice.dtos;

import lombok.Data;

@Data
public class VirementRequestDTO {
    public  Long codeSource;
    private  Long codeDestination;
    private  double montant;
}