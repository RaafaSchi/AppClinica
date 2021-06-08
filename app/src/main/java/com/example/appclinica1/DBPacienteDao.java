package com.example.appclinica1;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;


public class DBPacienteDao implements PacienteDao {

    private SQLiteDatabase bd;
    private SQLiteDatabase bdr;

    public DBPacienteDao(Context context) {
        DBPacientes auxBd = new DBPacientes(context);
        bd = auxBd.getWritableDatabase();
        bdr = auxBd.getReadableDatabase();
    }


    @Override
    public void insert(Paciente obj) {

        ContentValues valores = new ContentValues();
        valores.put("nomePac", obj.getNome());
        valores.put("emailPac", obj.getEmail());
        valores.put("enderecoPac", obj.getEndereco());
        valores.put("fonePac", obj.getTelefone());
        valores.put("sexPac", obj.getSexo());
        valores.put("nascPac", obj.getNascimento());
        valores.put("cpfPac", obj.getCpf());
        valores.put("rgPac", obj.getRg());
        valores.put("senhaPac", obj.getSenha());

        bd.insert("pacientes", null, valores);


    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public List<Paciente> findAll() {
        List<Paciente> list = new ArrayList<Paciente>();
        String[] colunas = new String[]{"id_paciente", "nomePac", "emailPac", "enderecoPac", "fonePac", "sexPac", "nascPac", "cpfPac", "rgPac"};

        Cursor cursor = bd.query("pacientes", colunas, null, null, null, null,
                "nomePac");

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Paciente pac = new Paciente();
                pac.setId(cursor.getInt(0));
                pac.setNome(cursor.getString(1));
                pac.setEmail(cursor.getString(2));
                pac.setEndereco(cursor.getString(3));
                pac.setTelefone(cursor.getString(4));
                pac.setSexo(cursor.getString(5));
                pac.setNascimento(cursor.getString(6));
                pac.setCpf(cursor.getString(7));
                pac.setRg(cursor.getString(8));


            } while (cursor.moveToNext());
        }
        return (list);
    }

    @Override
    public boolean autenticaPaciente(Paciente obj) {
        String login = "SELECT * FROM pacientes WHERE emailPac = " + "'" + obj.getEmail() + "'";
        Cursor c = bdr.rawQuery(login, null);
        while (c.moveToNext()) {
            if (obj.getEmail().equals(c.getString(c.getColumnIndex("emailPac")))) {
                if (obj.getSenha().equals(c.getString(c.getColumnIndex("senhaPac")))) {
                    return true;
                }
            }
        }

        return false;
    }

    public Paciente setPaciente (String email){
        String data = "SELECT * FROM pacientes WHERE emailPac = " + "'" + email + "'";
        Cursor c = bdr.rawQuery(data, null);
        c.moveToFirst();

        Paciente p = new Paciente();
        p.setEmail(email);
        p.setNome(c.getString(c.getColumnIndexOrThrow("nomePac")));
        p.setCpf(c.getString(c.getColumnIndexOrThrow("cpfPac")));
        p.setEndereco(c.getString(c.getColumnIndexOrThrow("enderecoPac")));
        p.setId(c.getInt(c.getColumnIndexOrThrow("id_paciente")));
        p.setNascimento(c.getString(c.getColumnIndexOrThrow("nascPac")));
        p.setRg(c.getString(c.getColumnIndexOrThrow("rgPac")));
        p.setSexo(c.getString(c.getColumnIndexOrThrow("sexPac")));
        p.setTelefone(c.getString(c.getColumnIndexOrThrow("fonePac")));

        return p;
    }
}
