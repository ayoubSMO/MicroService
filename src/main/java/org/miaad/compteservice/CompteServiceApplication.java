package org.miaad.compteservice;

import org.miaad.compteservice.entities.Compte;
import org.miaad.compteservice.enums.TypeCompte;
import org.miaad.compteservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class CompteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }

     @Bean
    CommandLineRunner start(CompteRepository compteRepository , RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class);
            compteRepository.save(new Compte(null , Math.random()*4435 , new Date() , TypeCompte.COURANT));
            compteRepository.save(new Compte(null , Math.random()*1212 , new Date() , TypeCompte.COURANT));
            compteRepository.save(new Compte(null , Math.random()*4435 , new Date() , TypeCompte.EPARGNE));

            compteRepository.findAll().forEach(cp -> {
                System.out.println(cp.getType());
                System.out.println(cp.getSolde());
            });
        };
    }
}
