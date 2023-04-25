package com.example.empleadoswebserver.Controllers;

import com.example.empleadoswebserver.DTO.EmpleadosDTO;
import com.example.empleadoswebserver.Repositories.EmpleadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/v1/empleados")
public class EmpleadosController {

    private final EmpleadoRepository service;

    public EmpleadosController(EmpleadoRepository service){

        this.service = service;
    }
    private int CalculoSalarioDia;
    private int CalculoSalarioSemana;
    private int CalculoSalarioMensual;
    private int CalculoSalarioAnual;

    @GetMapping("/ObtenerEmpleado")
    public List<EmpleadosDTO> GetEmpleados() {
        return service.findAll();
    }

    @PostMapping("/NuevoEmpleado")
    @ResponseBody
    public ResponseEntity<?> PostEmpleado(@RequestBody EmpleadosDTO empleado) {

        if (empleado.getHorasLaborales() == 0 || empleado.getSalarioPorHora() == 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{

            try{
                empleado.set_id((long) (Math.random()*100000));
                CalculoSalarioDia = (empleado.getSalarioPorHora() * empleado.getHorasLaborales());
                CalculoSalarioSemana = CalculoSalarioDia * 5;
                CalculoSalarioMensual = CalculoSalarioSemana * 4;
                CalculoSalarioAnual = CalculoSalarioMensual * 12;
                empleado.setSalarioMensual(CalculoSalarioMensual);
                empleado.setSalarioAnual(CalculoSalarioAnual);
                service.save(empleado);

                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (Exception errorGenerateGame){

                throw errorGenerateGame;
            }

        }


    }
}
