package com.example.appclinica1;

import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Medico {

    private Integer Id;
    private String nome;
    private String email;
    private String endereco;
    private String sexo;
    private String telefone;
    private String cpf;
    private String rg;
    private String nascimento;
    private String senha;



    public Medico() {

    }

    public Medico(Integer Id, String nome, String email, String endereco, String sexo, String telefone, String cpf, String rg, String nascimento, String senha) {
        this.Id = Id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.sexo = sexo;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
        this.nascimento = nascimento;
        this.senha = senha;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {Id = id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



}