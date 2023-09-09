package com.humanresourcesmanagement.Prueba.modelo;

import lombok.Data;


@Data
public class Empleado {
    int codigo;
    String nombre;
    int edad;
    String rol;
    String email;
    int numeroTelefonico;

    public Empleado(int codigo, String nombre, int edad, String rol, String email, int numeroTelefonico) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.rol = rol;
        this.email = email;
        this.numeroTelefonico = numeroTelefonico;
    }
}
