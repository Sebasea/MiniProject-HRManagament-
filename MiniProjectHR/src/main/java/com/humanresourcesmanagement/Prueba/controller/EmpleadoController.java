package com.humanresourcesmanagement.Prueba.controller;

import com.humanresourcesmanagement.Prueba.logica.EmpleadoLogica;
import com.humanresourcesmanagement.Prueba.modelo.Empleado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    private final EmpleadoLogica empleadoLogica;

    public EmpleadoController() {
        this.empleadoLogica = new EmpleadoLogica();
    }

    @GetMapping(path = "/empleado/{id}")
    public Empleado obtenerDatosEmpleadoPorID(@PathVariable int id) {
        return empleadoLogica.obtenerEmpleadoPorID(id);
    }

    @GetMapping(path = "/empleados")
    public List<Empleado> obtenerEmpleadosPorCargo(@RequestParam String rol, @RequestParam int cantidad) {
        return empleadoLogica.obtenerEmpleadosPorCargo(rol, cantidad);
    }

    @GetMapping(path = "/empleados/todos")
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoLogica.obtenerTodosLosEmpleados();
    }

    @PostMapping(path = "/empleado/agregar")
    public boolean agregarEmpleado(@RequestBody Empleado empleado) {
        return empleadoLogica.agregarEmpleado(empleado);
    }

    @PutMapping(path = "/empleado/modificar/{id}")
    public ResponseEntity<String> modificarEmpleado(@PathVariable int id, @RequestBody Empleado empleadoActualizado) {
        boolean modificado = empleadoLogica.modificarEmpleado(id, empleadoActualizado);
        if (modificado) {
            return ResponseEntity.ok("Empleado actualizado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
        }
    }

    @DeleteMapping(path = "/empleado/eliminar/{id}")
    public boolean eliminarEmpleado(@PathVariable int id) {
        return empleadoLogica.eliminarEmpleado(id);
    }
}
