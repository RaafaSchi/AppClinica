package com.example.appclinica1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PagamentoPlanoDeSaude extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_plano_de_saude);
    }

    public void btEfetuarPagmento (View view){
        String emailPaciente = null;
        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                emailPaciente = bundle.getString("emailPaciente");
            }
        }

        Toast.makeText(this, "Solicitação eviada ao Plano de Saúde!", Toast.LENGTH_SHORT).show();
        Bundle parametros = new Bundle();
        parametros.putString("emailPaciente", emailPaciente);
        Intent intent = new Intent(getBaseContext(), InicialPaciente.class);
        intent.putExtras(parametros);
        startActivity(intent);
    }
}