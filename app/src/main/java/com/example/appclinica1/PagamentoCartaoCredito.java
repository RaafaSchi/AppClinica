package com.example.appclinica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PagamentoCartaoCredito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_cartao_credito);
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

        Toast.makeText(this, "Pagamento efetuado !", Toast.LENGTH_SHORT).show();
        Bundle parametros = new Bundle();
        parametros.putString("emailPaciente", emailPaciente);
        Intent intent = new Intent(getBaseContext(), InicialPaciente.class);
        intent.putExtras(parametros);
        startActivity(intent);
    }
}