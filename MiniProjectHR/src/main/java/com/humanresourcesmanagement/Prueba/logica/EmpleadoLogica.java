package com.humanresourcesmanagement.Prueba.logica;

import com.humanresourcesmanagement.Prueba.modelo.Empleado;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoLogica {

    private final List<Empleado> empleadoList = new ArrayList<>();

    public EmpleadoLogica() {
        empleadoList.add(new Empleado(12345, "Daniel", 32, "Gerente", "daniel@gmail.com", 315151255));
        empleadoList.add(new Empleado(54321, "Allison", 24, "Gerente", "allison@gmail.com", 312546852));
        empleadoList.add(new Empleado(67890, "Hector", 50, "Gerente", "hector@gmail.com", 310741654));
        empleadoList.add(new Empleado(19876, "Gloria", 38, "Gerente", "gloria@gmail.com", 313369332));
    }

    public Empleado obtenerEmpleadoPorID(int id) {
        for (Empleado empleado : empleadoList) {
            if (empleado.getCodigo() == id) {
                return empleado;
            }
        }
        return null;
    }

    public List<Empleado> obtenerEmpleadosPorCargo(String rol, int cantidad) {
        List<Empleado> filtro = new ArrayList<>();
        for (Empleado empleado : empleadoList) {
            if (empleado.getRol().contains(rol) && filtro.size() < cantidad) {
                filtro.add(empleado);
            }
        }
        return filtro;
    }

    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoList;
    }

    public boolean agregarEmpleado(Empleado empleado) {
        return empleadoList.add(empleado);
    }

    public boolean modificarEmpleado(int id, Empleado empleadoActualizado) {
        for (Empleado empleado : empleadoList) {
            if (empleado.getCodigo() == id) {
                empleado.setNombre(empleadoActualizado.getNombre());
                empleado.setEdad(empleadoActualizado.getEdad());
                empleado.setRol(empleadoActualizado.getRol());
                empleado.setEmail(empleadoActualizado.getEmail());
                empleado.setNumeroTelefonico(empleadoActualizado.getNumeroTelefonico());
                return true;
            }
        }
        return false;
    }

    public boolean eliminarEmpleado(int id) {
        for (Empleado empleado : empleadoList) {
            if (empleado.getCodigo() == id) {
                return empleadoList.remove(empleado);
            }
        }
        return false;
    }
}
