package com.example.appclinica1;

import java.util.ArrayList;
import java.util.List;

public interface MedicoDao {

    void insert(Medico obj);
    List<Medico> findAll();
    boolean autenticaMedico(Medico obj);
    Integer SetMedico(String email);


}
