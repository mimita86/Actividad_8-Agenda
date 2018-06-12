package com.example.usuario.actividad_8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

// Clase del modelo que encapsula el acceso a la base de datos y que será utilizada por las actividades
public class DBContactos {
    //Atributos
    private SQLiteDatabase db=null;
    private DatabaseHelper dbhelper=null;

    //Contexto
    Context context;

    public DBContactos(Context contexto){
        this.context=contexto;

        //crea una instancia del helper
        dbhelper=new DatabaseHelper(context);

        //crea un objeto SQLiteDatabase para operar
        // contra la base de datos
        db=dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public long guardarContacto(Contacto c ){
        ContentValues initialValues=new ContentValues();
        initialValues.put("nombre", c.getNombre());
        initialValues.put("email", c.getEmail());
        initialValues.put("edad", c.getEdad());
        return db.insert("contactos", null, initialValues);
    }

    public Cursor recuperarContactos(){
        return db.query("contactos", new String[]{"_id","nombre","email","edad"},null, null, null,null,null);
    }
    public Contacto buscarPorEmail(String email){
        Contacto con=null;
        Cursor c=db.query("contactos", new String[]{"_id", "nombre","email","edad"},"email=?", new String[]{email}, null,null,null);
        if(c.moveToNext()){
            con=new Contacto(c.getString(1),c.getString(2),c.getInt(3));
        }
        return con;
    }

}
