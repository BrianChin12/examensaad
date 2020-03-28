package com.uabc.edu.mx.examensaad.examensaad.service;

import com.uabc.edu.mx.examensaad.examensaad.exception.RecordNotFoundException;
import com.uabc.edu.mx.examensaad.examensaad.model.Animalentidad;
import com.uabc.edu.mx.examensaad.examensaad.repository.Animalrepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Animalservicio {
    @Autowired
    Animalrepositorio repository;

    public List<Animalentidad> getAllAnimal()
    {
        List<Animalentidad> result = (List<Animalentidad>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Animalentidad>();
        }
    }

    public List<Animalentidad> getAllAdopcion()
    {
        List<Animalentidad> result = (List<Animalentidad>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Animalentidad>();
        }
    }

    public Animalentidad getAnimalById(Long id) throws RecordNotFoundException {
        Optional<Animalentidad> animal = repository.findById(id);

        if(animal.isPresent()) {
            return animal.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }




    public Animalentidad createOrUpdateAnimal(Animalentidad entity)
    {
        if(entity.getId()  == null)
        {
            entity.setEstado("Adopcion");
            entity.setResponsable("");
            entity = repository.save(entity);

            return entity;
        }
        else
        {
            Optional<Animalentidad> animal = repository.findById(entity.getId());

            if(animal.isPresent())
            {
                Animalentidad newEntity = animal.get();
                newEntity.setTipo(entity.getTipo());
                newEntity.setRaza(entity.getRaza());
                newEntity.setColor(entity.getColor());
                newEntity.setTipo_pelaje(entity.getTipo_pelaje());
                newEntity.setF_nacimiento(entity.getF_nacimiento());
                newEntity.setVacunas(entity.getVacunas());
                if(entity.getResponsable().equalsIgnoreCase("")==false){
                    newEntity.setEstado("Adoptado");
                }
                newEntity.setResponsable(entity.getResponsable());
                newEntity.setFoto(entity.getFoto());
                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }
    }

    public void deleteAnimalById(Long id) throws RecordNotFoundException
    {
        Optional<Animalentidad> employee = repository.findById(id);

        if(employee.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}
