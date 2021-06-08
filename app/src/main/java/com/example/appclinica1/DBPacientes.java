package com.example.appclinica1;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBPacientes extends SQLiteOpenHelper {

    private static final String NOME_BD = "pacientes";
    private static final int VERSAO_BD = 1;

    public DBPacientes(Context ctx) {
        super(ctx, NOME_BD, null, VERSAO_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table pacientes(id_paciente integer PRIMARY KEY autoincrement, nomePac text NOT NULL, emailPac text NOT NULL, enderecoPac text NOT NULL, fonePac text NOT NULL, sexPac text NOT NULL, nascPac text NOT NULL, cpfPac text NOT NULL, rgPac text NOT NULL, senhaPac text NOT NULL);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table pacientes;");
        onCreate(db);

    }
}


