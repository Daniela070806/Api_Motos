package com.puce.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "motos")
@Data
public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String color;
    private String cilindraje;
}