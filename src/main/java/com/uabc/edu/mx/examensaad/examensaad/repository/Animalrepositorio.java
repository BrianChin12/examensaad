package com.uabc.edu.mx.examensaad.examensaad.repository;

import com.uabc.edu.mx.examensaad.examensaad.model.Animalentidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
    public interface Animalrepositorio
            extends CrudRepository<Animalentidad, Long> {

    }