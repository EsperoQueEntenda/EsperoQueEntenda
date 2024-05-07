package com.dogspot.dogspot.Controllers;

import com.dogspot.dogspot.DTO.CachorroDTO;
import com.dogspot.dogspot.DTO.TutorDTO;
import com.dogspot.dogspot.Entities.Cachorro;
import com.dogspot.dogspot.Entities.Tutor;
import com.dogspot.dogspot.Repositories.CachorroRepository;
import com.dogspot.dogspot.Repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
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

    @GetMapping("/tutores")
    public ResponseEntity<List<TutorDTO>> listarTutores() {
        List<TutorDTO> tutores = new ArrayList<>();
        tutorRepository.findAll().forEach(tutor -> tutores.add(new TutorDTO(tutor)));

        return ResponseEntity.ok(tutores);
    }


    @GetMapping("/cachorros/{id}")
    public ResponseEntity<CachorroDTO> obterCachorroPorId(@PathVariable Long id) {
        Cachorro cachorro = cachorroRepository.getReferenceById(id);
        return ResponseEntity.ok(new CachorroDTO(cachorro));
    }


    @GetMapping("/tutores/{id}")
    public ResponseEntity<TutorDTO> obterTutorPorId(@PathVariable Long id) {
        Tutor tutor = tutorRepository.getReferenceById(id);
        return ResponseEntity.ok(new TutorDTO(tutor));
    }

    @PostMapping("/cachorros")
    public ResponseEntity<Cachorro> adicionarCachorro(@RequestBody Cachorro cachorro) {
        Cachorro novoCachorro = cachorroRepository.save(cachorro);
        return new ResponseEntity<>(novoCachorro, HttpStatus.CREATED);
    }

    @PostMapping("/tutores")
    public ResponseEntity<Tutor> adicionarTutor(@RequestBody Tutor tutor) {
        Tutor novoTutor = tutorRepository.save(tutor);
        return new ResponseEntity<>(novoTutor, HttpStatus.CREATED);
    }
}
