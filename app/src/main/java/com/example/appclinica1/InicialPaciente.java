package com.example.appclinica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InicialPaciente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial_paciente);
    }

    public void btNovaConsulta(View view) {
        String email_paciente = null;

        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                email_paciente = bundle.getString("emailPaciente");
            }
        }

        Intent intent = new Intent(this, NovaConsultaPaciente.class);
        Bundle parametros = new Bundle();
        parametros.putString("emailPac", email_paciente);
        intent.putExtras(parametros);
        startActivity(intent);
    }

    public void btExcluirConsulta(View view) {
        String email_paciente = null;
        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                email_paciente = bundle.getString("emailPaciente");
            }
        }

        Intent intent = new Intent(this, ExcluirConsultaPaciente.class);
        Bundle parametros = new Bundle();
        parametros.putString("emailPac", email_paciente);
        intent.putExtras(parametros);
        startActivity(intent);
    }


}
