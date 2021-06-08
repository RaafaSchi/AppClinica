package com.example.appclinica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TelaPagamento extends AppCompatActivity {

    String emailPaciente = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pagamento);

        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                emailPaciente = bundle.getString("emailPaciente");
            }
        }
    }

    public void btParticularOnClick(View View) {
        Button particular = (Button) findViewById(R.id.buttonParticular);
        Button plano = (Button) findViewById(R.id.buttonPlano);

        particular.setText("Cartão de Crédito");
        plano.setText("Boleto");

        particular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Bundle parametros = new Bundle();
                parametros.putString("emailPaciente", emailPaciente);
                Intent intent = new Intent(getBaseContext(), PagamentoCartaoCredito.class);
                intent.putExtras(parametros);
                startActivity(intent);
            }
        });


        plano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Toast.makeText(getBaseContext(), "O Boleto foi enviado para: " + emailPaciente, Toast.LENGTH_SHORT).show();
                Bundle parametros = new Bundle();
                parametros.putString("emailPaciente", emailPaciente);
                Intent intent = new Intent(getBaseContext(), InicialPaciente.class);
                intent.putExtras(parametros);
                startActivity(intent);
            }
        });

    }

    public void btPlanoOnClick(View View) {
        Button particular = (Button) findViewById(R.id.buttonParticular);
        Button plano = (Button) findViewById(R.id.buttonPlano);

        plano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Bundle parametros = new Bundle();
                parametros.putString("emailPaciente", emailPaciente);
                Intent intent = new Intent(getBaseContext(), PagamentoPlanoDeSaude.class);
                intent.putExtras(parametros);
                startActivity(intent);
            }
        });
    }
}