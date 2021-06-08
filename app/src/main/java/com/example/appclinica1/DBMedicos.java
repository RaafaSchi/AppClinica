package com.example.appclinica1;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBMedicos extends SQLiteOpenHelper {

    private static final String NOME_BD = "medicos";
    private static final int VERSAO_BD = 2;

    public DBMedicos(Context ctx) {
        super(ctx, NOME_BD, null, VERSAO_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table medicos(id_medico integer PRIMARY KEY autoincrement, nomeMed text NOT NULL, emailMed text NOT NULL, enderecoMed text NOT NULL, foneMed text NOT NULL, sexMed text NOT NULL, nascMed text NOT NULL, cpfMed text NOT NULL, rgMed text NOT NULL, senhaMed text NOT NULL);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table medicos;");
        onCreate(db);

    }
}


