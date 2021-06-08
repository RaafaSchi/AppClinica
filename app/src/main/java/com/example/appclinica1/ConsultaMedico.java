package com.example.appclinica1;

public class ConsultaMedico {

    private int id_agenda;
    private int id_medico;
    private String especialidade;
    private String endereco;
    private String data;
    private int hora8, hora9, hora10, hora11, hora13, hora14, hora15, hora16, hora17, hora18;

    public ConsultaMedico(){

    }

    public ConsultaMedico(int id_consulta, int id_medico, String especialidade, String endereco, String data, int hora8, int hora9, int hora10, int hora11, int hora13, int hora14, int hora15, int hora16, int hora17, int hora18) {
        this.id_agenda = id_consulta;
        this.id_medico = id_medico;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.data = data;
        this.hora8 = hora8;
        this.hora9 = hora9;
        this.hora10 = hora10;
        this.hora11 = hora11;
        this.hora13 = hora13;
        this.hora14 = hora14;
        this.hora15 = hora15;
        this.hora16 = hora16;
        this.hora17 = hora17;
        this.hora18 = hora18;
    }

    public int getId_consulta() {
        return id_agenda;
    }

    public void setId_consulta(int id_consulta) {
        this.id_agenda = id_consulta;
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

    public int getHora8() {
        return hora8;
    }

    public void setHora8(int hora8) {
        this.hora8 = hora8;
    }

    public int getHora9() {
        return hora9;
    }

    public void setHora9(int hora9) {
        this.hora9 = hora9;
    }

    public int getHora10() {
        return hora10;
    }

    public void setHora10(int hora10) {
        this.hora10 = hora10;
    }

    public int getHora11() {
        return hora11;
    }

    public void setHora11(int hora11) {
        this.hora11 = hora11;
    }

    public int getHora13() {
        return hora13;
    }

    public void setHora13(int hora13) {
        this.hora13 = hora13;
    }

    public int getHora14() {
        return hora14;
    }

    public void setHora14(int hora14) {
        this.hora14 = hora14;
    }

    public int getHora15() {
        return hora15;
    }

    public void setHora15(int hora15) {
        this.hora15 = hora15;
    }

    public int getHora16() {
        return hora16;
    }

    public void setHora16(int hora16) {
        this.hora16 = hora16;
    }

    public int getHora17() {
        return hora17;
    }

    public void setHora17(int hora17) {
        this.hora17 = hora17;
    }

    public int getHora18() {
        return hora18;
    }

    public void setHora18(int hora18) {
        this.hora18 = hora18;
    }
}