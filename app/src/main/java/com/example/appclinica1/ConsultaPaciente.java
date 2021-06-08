package com.example.appclinica1;

public class ConsultaPaciente {

    private Paciente paciente;
    private int id_consulta;
    private int id_consultaMedico;
    private int id_medico;
    private String especialidade;
    private String endereco;
    private String data;
    private String horario;

    public ConsultaPaciente() {
    }

    public ConsultaPaciente(Paciente paciente, int id_consulta, int id_consultaMedico, int id_medico, String especialidade, String endereco, String data, String horario) {
        this.paciente = paciente;
        this.id_consulta = id_consulta;
        this.id_consultaMedico = id_consultaMedico;
        this.id_medico = id_medico;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.data = data;
        this.horario = horario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getId_consultaMedico() {
        return id_consultaMedico;
    }

    public void setId_consultaMedico(int id_consultaMedico) {
        this.id_consultaMedico = id_consultaMedico;
    }
}
