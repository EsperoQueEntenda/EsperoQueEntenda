package com.dogspot.dogspot.Controllers;

import com.dogspot.dogspot.DTO.CachorroDTO;
import com.dogspot.dogspot.DTO.TutorDTO;
import com.dogspot.dogspot.DTO.ONGDTO;
import com.dogspot.dogspot.DTO.VeterinarioDTO;
import com.dogspot.dogspot.Entities.Cachorro;
import com.dogspot.dogspot.Entities.Tutor;
import com.dogspot.dogspot.Entities.ONG;
import com.dogspot.dogspot.Entities.Veterinario;
import com.dogspot.dogspot.Repositories.CachorroRepository;
import com.dogspot.dogspot.Repositories.TutorRepository;
import com.dogspot.dogspot.Repositories.ONGRepository;
import com.dogspot.dogspot.Repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class DogSpotController {

    private final CachorroRepository cachorroRepository;
    private final TutorRepository tutorRepository;
    private final ONGRepository ongRepository;
    private final VeterinarioRepository veterinarioRepository;

    @Autowired
    public DogSpotController(CachorroRepository cachorroRepository,
                             TutorRepository tutorRepository,
                             ONGRepository ongRepository,
                             VeterinarioRepository veterinarioRepository) {
        this.cachorroRepository = cachorroRepository;
        this.tutorRepository = tutorRepository;
        this.ongRepository = ongRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

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

    @GetMapping("/ongs")
    public ResponseEntity<List<ONGDTO>> listarONGs() {
        List<ONGDTO> ongs = new ArrayList<>();
        ongRepository.findAll().forEach(ong -> ongs.add(new ONGDTO(ong)));

        return ResponseEntity.ok(ongs);
    }

    @GetMapping("/veterinarios")
    public ResponseEntity<List<VeterinarioDTO>> listarVeterinarios() {
        List<VeterinarioDTO> veterinarios = new ArrayList<>();
        veterinarioRepository.findAll().forEach(veterinario -> veterinarios.add(new VeterinarioDTO(veterinario)));

        return ResponseEntity.ok(veterinarios);
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

    @PostMapping("/ongs")
    public ResponseEntity<ONG> adicionarONG(@RequestBody ONG ong) {
        ONG novaONG = ongRepository.save(ong);
        return new ResponseEntity<>(novaONG, HttpStatus.CREATED);
    }

    @PostMapping("/veterinarios")
    public ResponseEntity<Veterinario> adicionarVeterinario(@RequestBody Veterinario veterinario) {
        Veterinario novoVeterinario = veterinarioRepository.save(veterinario);
        return new ResponseEntity<>(novoVeterinario, HttpStatus.CREATED);
    }
}
