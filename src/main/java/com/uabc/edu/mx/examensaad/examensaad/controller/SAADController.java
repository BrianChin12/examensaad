package com.uabc.edu.mx.examensaad.examensaad.controller;

import com.uabc.edu.mx.examensaad.examensaad.exception.RecordNotFoundException;
import com.uabc.edu.mx.examensaad.examensaad.model.Animalentidad;
import com.uabc.edu.mx.examensaad.examensaad.service.Animalservicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class SAADController {
    @Autowired
    Animalservicio service;

    @RequestMapping("/")
    public String getAllAnimal(Model model)
    {
        List<Animalentidad> list = service.getAllAnimal();
        for(int y =0; y<list.size(); y++){
            if ("Adoptado".equalsIgnoreCase(list.get(y).getEstado())){
                list.remove(y);
                y--;
            }
        }
        model.addAttribute("animal", list);
        return "listaanimal";
    }

    @RequestMapping("/listAdopcion")
    public String getAllAdopcion(Model model)
    {
        List<Animalentidad> list = service.getAllAdopcion();
        for(int y =0; y<list.size(); y++){
            if ("Adopcion".equalsIgnoreCase(list.get(y).getEstado())){
             list.remove(y);
             y--;
            }
        }
        model.addAttribute("animal", list);
        return "listaadopcion";
    }

    @RequestMapping(path = {"/newAnimal"})
    public String newAnimal(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {

            model.addAttribute("animal", new Animalentidad());
        return "nuevo-animal";
    }

    @RequestMapping(path = {"/adopt/{id}"})
    public String adopt(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            Animalentidad entity = service.getAnimalById(id.get());
            model.addAttribute("animal", entity);
        } else {
            model.addAttribute("animal", new Animalentidad());
        }
        return "adoptar";
    }

    @RequestMapping(path = {"/edit/{id}"})
    public String editAnimalById(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            Animalentidad entity = service.getAnimalById(id.get());
            model.addAttribute("animal", entity);
        } else {
            model.addAttribute("animal", new Animalentidad());
        }
        return "editaranimal";
    }


    @RequestMapping(path = "/delete/{id}")
    public String deleteAnimalById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        service.deleteAnimalById(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/createAnimal", method = RequestMethod.POST)
    public String createOrUpdateAnimal(Animalentidad animal)
    {
        service.createOrUpdateAnimal(animal);
        return "redirect:/";
    }


}
