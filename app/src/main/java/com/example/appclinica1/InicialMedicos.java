package com.example.appclinica1;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InicialMedicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial_medicos);
    }


    public void btCadastarNovaAgenda(View view) {
        String email_medico = null;

        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                email_medico = bundle.getString("emailMedico");
            }
        }

        Intent intent = new Intent(this, CadastrarAgenda.class);
        Bundle parametros = new Bundle();
        parametros.putString("emailMedico2", email_medico);
        intent.putExtras(parametros);
        startActivity(intent);
    }

    public void btExcluirAgendas(View view){

        String email_medico = null;

        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                email_medico = bundle.getString("emailMedico");
            }
        }

        Intent intent = new Intent(this, ExcluirAgendaMedico.class);
        Bundle parametros = new Bundle();
        parametros.putString("emailMedico2", email_medico);
        intent.putExtras(parametros);
        startActivity(intent);

    }

    public void btProximasConsultas(View view){
        String email_medico = null;

        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                email_medico = bundle.getString("emailMedico");
            }
        }

        Intent intent = new Intent(this, ProximasConsultasMedico.class);
        Bundle parametros = new Bundle();
        parametros.putString("emailMedico2", email_medico);
        intent.putExtras(parametros);
        startActivity(intent);

    }
}