package com.example.appclinica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_tela);

        DBMedicoDao dbMedicoDao = new DBMedicoDao(this);
        DBPacienteDao dbPacienteDao = new DBPacienteDao(this);
        DBCadastroAgendaDAO dbCadastroAgendaDAO = new DBCadastroAgendaDAO(this);
        DBConsultaPacienteDAO dbConsultaPacienteDAO = new DBConsultaPacienteDAO(this);

    }


    public void btNovoUsuOnClick(View view) {
        Intent telaCadastro = new Intent(this, Cadastrof.class);
        startActivity(telaCadastro);
    }

    public void btEntrarOnClick(View view) {


        EditText login = (EditText) findViewById(R.id.textViewLogin);
        EditText senha = (EditText) findViewById(R.id.textViewSenha);


        String logintxt = login.getText().toString();


        String senhatxt = senha.getText().toString();
        Paciente p = new Paciente();
        Medico m = new Medico();
        p.setEmail(logintxt);
        p.setSenha(senhatxt);
        m.setEmail(logintxt);
        m.setSenha(senhatxt);
        DBPacienteDao DBP = new DBPacienteDao(this);
        DBMedicoDao DBM = new DBMedicoDao(this);

        if (DBP.autenticaPaciente(p) == true) {
            Bundle parametros = new Bundle();
            parametros.putString("emailPaciente", logintxt);
            Intent intent = new Intent(this, InicialPaciente.class);
            intent.putExtras(parametros);
            startActivity(intent);

        } else if (DBM.autenticaMedico(m) == true) {
            Bundle parametros = new Bundle();
            parametros.putString("emailMedico", logintxt);
            Intent intent = new Intent(this, InicialMedicos.class);
            intent.putExtras(parametros);
            startActivity(intent);

        } else {
            Toast.makeText(this, "O E-mail e/ou Senha estão incorretos. Por favor, tente novamente!",
                    Toast.LENGTH_LONG).show();
        }


    }


}

