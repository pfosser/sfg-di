package it.paofos.sfgdi.controllers;

import org.springframework.stereotype.Controller;

import com.paofos.pets.PetService;

@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String whichPetIsTheBest(){
        return petService.getPetType();
    }
}
