package com.example.usuario.actividad_8;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<Contacto> agenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agenda = new ArrayList<Contacto>();
    }

    public void agregar(View v) {
        Intent intent = new Intent(this, AgregarActivity.class);
        intent.putExtra("agenda", agenda);
        this.startActivityForResult(intent, 1);
    }

    public void buscar(View v) {
        Intent intent = new Intent(this, BuscarActivity.class);
        intent.putExtra("agenda", agenda);
        this.startActivity(intent);
    }

    public void ver(View v) {
        Intent intent = new Intent(this, ListadoActivity.class);
        intent.putExtra("agenda", agenda);
        this.startActivity(intent);
    }

   /* @Override
    public void onActivityResult(int cod, int result, Intent data) {
        agenda = (ArrayList<Contacto>) data.getSerializableExtra("miagenda");

    }*/
}