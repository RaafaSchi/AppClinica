package com.example.appclinica1;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;


public class DBMedicoDao implements MedicoDao {

    private SQLiteDatabase bd;
    private SQLiteDatabase bdr;

    public DBMedicoDao(Context context) {
        DBMedicos auxBd = new DBMedicos(context);
        bd = auxBd.getWritableDatabase();
        bdr = auxBd.getReadableDatabase();
    }


    @Override
    public void insert(Medico obj) {
        ContentValues valores = new ContentValues();
        valores.put("nomeMed", obj.getNome());
        valores.put("emailMed", obj.getEmail());
        valores.put("enderecoMed", obj.getEndereco());
        valores.put("foneMed", obj.getTelefone());
        valores.put("sexMed", obj.getSexo());
        valores.put("nascMed", obj.getNascimento());
        valores.put("cpfMed", obj.getCpf());
        valores.put("rgMed", obj.getRg());
        valores.put("senhaMed", obj.getSenha());

        bd.insert("medicos", null, valores);


    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public List<Medico> findAll() {
        List<Medico> list = new ArrayList<Medico>();
        String[] colunas = new String[]{"id_medico", "nomeMed", "emailMed", "enderecoMed", "foneMed", "sexMed", "nascMed", "cpfMed", "rgMed"};

        Cursor cursor = bd.query("medicos", colunas, null, null, null, null,
                "nomeMed");

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Medico med = new Medico();
                med.setId(cursor.getInt(0));
                med.setNome(cursor.getString(1));
                med.setEmail(cursor.getString(2));
                med.setEndereco(cursor.getString(3));
                med.setTelefone(cursor.getString(4));
                med.setSexo(cursor.getString(5));
                med.setNascimento(cursor.getString(6));
                med.setCpf(cursor.getString(7));
                med.setRg(cursor.getString(8));


            } while (cursor.moveToNext());
        }
        return (list);
    }

    @Override
    public boolean autenticaMedico(Medico obj) {
        String login = "SELECT * FROM medicos WHERE emailMed = " + "'" + obj.getEmail() + "'";
        Cursor c = bdr.rawQuery(login, null);
        while (c.moveToNext()) {
            if (obj.getEmail().equals(c.getString(c.getColumnIndex("emailMed")))) {
                if (obj.getSenha().equals(c.getString(c.getColumnIndex("senhaMed")))) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Integer SetMedico(String email) {
        String setMedico = "SELECT * FROM medicos WHERE emailMed = " + "'" + email + "'";
        Cursor cursor = bdr.rawQuery(setMedico, null);

        Integer id = null;
        if(cursor != null && cursor.moveToFirst()){
            id = cursor.getInt(cursor.getColumnIndexOrThrow("id_medico"));
        }

        return id;
    }

    public String nomeMed (Integer id){
        Medico med = new Medico();

        String setMedico = "SELECT * FROM medicos WHERE id_medico = " + "'" + id + "'";
        Cursor cursor = bdr.rawQuery(setMedico, null);

        cursor.moveToFirst();
        String nomeMed = cursor.getString(cursor.getColumnIndexOrThrow("nomeMed"));
        return nomeMed;
    }

}