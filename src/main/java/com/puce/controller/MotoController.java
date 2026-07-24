package com.puce.controller;

import com.puce.entity.Moto;
import com.puce.repository.MotoRepository;
import com.puce.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motos")
@CrossOrigin(origins = "*")
public class MotoController {

    @Autowired
    private MotoService motoService; // 👈 Inyectas el servicio que acabamos de crear

    @GetMapping
    public List<Moto> leerMotos() {
        return motoService.mostrarMotos(); // 👈 Llama al método corregido
    }

    @PostMapping("/guardarMoto")
    public Moto guardarMoto(@RequestBody Moto moto) {
        return motoService.guardarMoto(moto);
    }

    @PutMapping("/actualizarMoto/{id}")
    public Moto actualizarMoto(@PathVariable Long id, @RequestBody Moto moto) {
        return motoService.actualizarMoto(moto, id);
    }

    @DeleteMapping("/eliminarMoto/{id}")
    public void eliminarMoto(@PathVariable Long id) {
        motoService.eliminarMoto(id);
    }
}