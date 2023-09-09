package com.humanresourcesmanagement.Prueba.controller;

import com.humanresourcesmanagement.Prueba.logica.EmpleadoData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@RestController
public class    EmpleadoController {

    List<EmpleadoData> empleadoDataList= new ArrayList<>();

    public EmpleadoController (){
        empleadoDataList.add(new EmpleadoData(12345,"Daniel",32,"Gerente","daniel@gmail.com",315151255));
        empleadoDataList.add(new EmpleadoData(54321,"Allison",24,"Gerente","allison@gmail.com",312546852));
        empleadoDataList.add(new EmpleadoData(67890,"Hector",50,"Gerente","hector@gmail.com",310741654));
        empleadoDataList.add(new EmpleadoData(19876,"Gloria",38,"Gerente","gloria@gmail.com",313369332));

    }
    @GetMapping(path = "/empleado/{id}")
    public EmpleadoData obtenerDatosEmpleadoPorID(@PathVariable int id)
    {
        for (EmpleadoData empleadoData : empleadoDataList)
        {
            if (empleadoData.getCodigo() == id){
                return empleadoData;
            }
        }
        return null;
    }
    @GetMapping(path = "/empleados")
    public List<EmpleadoData> obtenerEmpleadosPorCargo(@RequestParam String rol, @RequestParam int cantidad)
    {
        List<EmpleadoData> filtro = new ArrayList<>();
        for (EmpleadoData empleadoData : empleadoDataList)
        {
            if (empleadoData.getRol().contains(rol) && filtro.size()<cantidad){
                filtro.add(empleadoData);
            }
        }
        return filtro;
    }
    @GetMapping(path = "/empleados/todos")
    public List<EmpleadoData> obtenerTodosLosEmpledos(){
        return empleadoDataList;
    }
    @PostMapping(path = "/empleado/agregar")
    public boolean agregarEmplados(@RequestBody EmpleadoData empleadoData)
    {
        empleadoDataList.add(empleadoData);
        return true;
    }
    @PutMapping(path = "/empleado/modificar/{id}")
    public ResponseEntity<String> modificarEmpleados(@PathVariable int id, @RequestBody EmpleadoData empleadoActualizado) {
        for (EmpleadoData empleadoData : empleadoDataList) {
            if (empleadoData.getCodigo() == id) {
                empleadoData.setNombre(empleadoActualizado.getNombre());
                empleadoData.setEdad(empleadoActualizado.getEdad());
                empleadoData.setRol(empleadoActualizado.getRol());
                empleadoData.setEmail(empleadoActualizado.getEmail());
                empleadoData.setNumeroTelefonico(empleadoActualizado.getNumeroTelefonico());

                return ResponseEntity.ok("Empleado actualizado correctamente");
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
    }
    @DeleteMapping(path = "/empleado/eliminar/{id}")
    public boolean eliminarEmpleado(@PathVariable int id) {
       boolean encontrado = false;
        for (EmpleadoData empleadoData : empleadoDataList){
            if (empleadoData.getCodigo() == id){
                encontrado = true;
                empleadoDataList.remove(empleadoData);
            }
        }
       return true;
    }
}
