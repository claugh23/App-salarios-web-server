package com.example.empleadoswebserver.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadosDTO {

    private Long _id;

    private String Nombre;

    private String Apellidos;

    private String Correo;

    private String PosicionActual;

    private String Departamento;

    private int HorasLaborales;

    private int SalarioPorHora;

    private int SalarioMensual;

    private int SalarioAnual;

}
