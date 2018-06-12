package com.example.usuario.actividad_8;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class AgregarActivity extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
    }
    public void guardar(View v){

        //recogemos los datos introducidos
        String nombre=((EditText)this.findViewById(R.id.edtNombre)).getText().toString();
        String email=((EditText)this.findViewById(R.id.edtEmail)).getText().toString( );
        int edad=Integer.parseInt(((EditText) this.findViewById(R.id.edtEdad)).getText().toString());

        //creamos objeto contacto
        Contacto c=new Contacto(nombre, email, edad);

        //creamos un DBContactos y añadimos el nuevo contacto
        DBContactos gestion=new DBContactos(this);
        gestion.guardarContacto(c);

        //cerramos la base de datos
        gestion.close();

        //finalizamos la actividad
        this.finish();
    }
}