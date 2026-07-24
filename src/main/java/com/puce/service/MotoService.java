package com.puce.service;

import com.puce.entity.Moto;
import com.puce.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    @Autowired
    private MotoRepository MotoRepository;

    // LEER - SELECT * FROM MOTOS
    public List<Moto> mostrarMotos() {
        return MotoRepository.findAll();
    }

    // BUSCAR MOTO POR ID
    public Optional<Moto> buscarMotoPorId(Long id) {
        return MotoRepository.findById(id);
    }

    // GUARDAR - INSERT INTO MOTOS
    public Moto guardarMoto(Moto moto) {
        return MotoRepository.save(moto);
    }

    // ACTUALIZAR - UPDATE MOTOS SET MARCA=... WHERE ID = ...
    public Moto actualizarMoto(Moto moto, Long id) {
        Moto motoEncontrada = buscarMotoPorId(id)
                .orElseThrow(() -> new RuntimeException("Moto no encontrada"));

        // Mapeamos los nuevos campos simples que te piden:
        motoEncontrada.setMarca(moto.getMarca());
        motoEncontrada.setColor(moto.getColor());
        motoEncontrada.setCilindraje(moto.getCilindraje());

        return MotoRepository.save(motoEncontrada);
    }

    // ELIMINAR - DELETE FROM MOTOS WHERE ID = ...
    public void eliminarMoto(Long id) {
        Moto moto = buscarMotoPorId(id)
                .orElseThrow(() -> new RuntimeException("La moto no existe"));
        MotoRepository.delete(moto);
    }
}