package com.example.appclinica1;

import java.util.List;

public interface PacienteDao {

    void insert(Paciente obj);
    List<Paciente> findAll();
    boolean autenticaPaciente(Paciente obj);

}

