package com.example.appclinica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;

public class Cadastrof extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrof);
    }

    private EditText nome, email, endereco, telefone, cpf, rg, nascimento, senha;
    private CheckBox masc, fem, paciente, medico;
    private String sexo;
    private int user;


    public void onCheckboxClickedSex(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkBoxM:
                if (checked) {
                    sexo = "M";
                }
                break;
            case R.id.checkBoxF:
                if (checked) {
                    sexo = "F";
                }
                break;
        }
    }

    public void onCheckboxClickedUsuario(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkBoxPaciente:
                if (checked) {
                    user = 1;
                }
                break;
            case R.id.checkBoxMedico:
                if (checked) {
                    user = 2;
                }
                break;
        }
    }


    public void btCadastrarOnClick(View view) throws ParseException {


        nome = (EditText) findViewById(R.id.txtNome);
        email = (EditText) findViewById(R.id.txtEmail);
        endereco = (EditText) findViewById(R.id.txtEndereco);
        telefone = (EditText) findViewById(R.id.txtTelefone);
        cpf = (EditText) findViewById(R.id.txtCPF);
        rg = (EditText) findViewById(R.id.txtRG);
        nascimento = (EditText) findViewById(R.id.editTextDate);
        senha = (EditText) findViewById(R.id.txtSenha);


        if (user == 1) {

            Paciente pac = new Paciente();
            DBPacienteDao db = new DBPacienteDao(this);
            pac.setNome(nome.getText().toString());
            pac.setEmail(email.getText().toString());
            pac.setEndereco(endereco.getText().toString());
            pac.setSexo(sexo);
            pac.setTelefone(telefone.getText().toString());
            pac.setCpf(cpf.getText().toString());
            pac.setRg(rg.getText().toString());
            pac.setNascimento(nascimento.getText().toString());
            pac.setSenha(senha.getText().toString());
            db.insert(pac);


        }
        if (user == 2) {

            Medico med = new Medico();
            DBMedicoDao db = new DBMedicoDao(this);
            med.setNome(nome.getText().toString());
            med.setEmail(email.getText().toString());
            med.setEndereco(endereco.getText().toString());
            med.setSexo(sexo);
            med.setTelefone(telefone.getText().toString());
            med.setCpf(cpf.getText().toString());
            med.setRg(rg.getText().toString());
            med.setNascimento(nascimento.getText().toString());
            med.setSenha(senha.getText().toString());
            db.insert(med);
        }

        Toast.makeText(this, "Usuário inserido com sucesso!",
                Toast.LENGTH_SHORT).show();
        Intent telainicial = new Intent(this, MainActivity.class);
        startActivity(telainicial);

    }


}
