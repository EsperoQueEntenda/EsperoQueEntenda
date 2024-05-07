package com.dogspot.dogspot.Controller;

import com.dogspot.dogspot.Entities.Cachorro;
import com.dogspot.dogspot.Entities.Tutor;
import com.dogspot.dogspot.Repository.CachorroRepository;
import com.dogspot.dogspot.Repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DogSpotController {

    @Autowired
    private CachorroRepository cachorroRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @GetMapping("/cachorros")
    public ResponseEntity<List<Cachorro>> listarCachorros() {
        List<Cachorro> cachorros = cachorroRepository.findAll();
        return new ResponseEntity<>(cachorros, HttpStatus.OK);
    }

    @GetMapping("/cachorros/{id}")
    public ResponseEntity<Cachorro> obterCachorroPorId(@PathVariable Integer id) {
        Optional<Cachorro> cachorroOptional = cachorroRepository.findById(id);
        return cachorroOptional.map(cachorro -> new ResponseEntity<>(cachorro, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/cachorros")
    public ResponseEntity<Cachorro> adicionarCachorro(@RequestBody Cachorro cachorro) {
        Cachorro novoCachorro = cachorroRepository.save(cachorro);
        return new ResponseEntity<>(novoCachorro, HttpStatus.CREATED);
    }

    @GetMapping("/tutores")
    public ResponseEntity<List<Tutor>> listarTutores() {
        List<Tutor> tutores = tutorRepository.findAll();
        return new ResponseEntity<>(tutores, HttpStatus.OK);
    }

    @GetMapping("/tutores/{id}")
    public ResponseEntity<Tutor> obterTutorPorId(@PathVariable Integer id) {
        Optional<Tutor> tutorOptional = tutorRepository.findById(id);
        return tutorOptional.map(tutor -> new ResponseEntity<>(tutor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/tutores")
    public ResponseEntity<Tutor> adicionarTutor(@RequestBody Tutor tutor) {
        Tutor novoTutor = tutorRepository.save(tutor);
        return new ResponseEntity<>(novoTutor, HttpStatus.CREATED);
    }
}
