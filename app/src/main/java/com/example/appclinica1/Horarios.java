package com.example.appclinica1;

public class Horarios {

    String email_paciente;
    Integer id_consulta;
    String horario;

    public Horarios() {
    }

    public Horarios(String email_paciente, Integer id_consulta, String horario) {
        this.email_paciente = email_paciente;
        this.id_consulta = id_consulta;
        this.horario = horario;
    }


    public Integer getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(Integer id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEmail_paciente() {
        return email_paciente;
    }

    public void setEmail_paciente(String email_paciente) {
        this.email_paciente = email_paciente;
    }
}
