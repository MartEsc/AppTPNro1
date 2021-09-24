package com.EscowichFernandezGayoso.apptpnro1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class paginados extends AppCompatActivity  {

    CategoryViewHolder adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paginados);

        // data to populate the RecyclerView with
        ArrayList<String> categorias = new ArrayList<>();
        categorias.add("Accesorios para Vehículos");
        categorias.add("Agro");
        categorias.add("Alimentos y Bebidas");
        categorias.add("Animales y Mascotas");
        categorias.add("Antigüedades y Colecciones");
        categorias.add("Arte, Librería y Mercería");
        categorias.add("Autos, Motos y Otros");
        categorias.add("Bebés");
        categorias.add("Belleza y Cuidado Personal");
        categorias.add("Cámaras y Accesorios");
        categorias.add("Celulares y Teléfonos");
        categorias.add("Computación");
        categorias.add("Consolas y Videojuegos");
        categorias.add("Construcción");
        categorias.add("Deportes y Fitness");
        categorias.add("Electrodomésticos y Aires Ac.");
        categorias.add("Electrónica, Audio y Video");
        categorias.add("Entradas para Eventos");
        categorias.add("Herramientas");
        categorias.add("Hogar, Muebles y Jardín");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CategoryViewHolder(this, categorias);
        recyclerView.setAdapter(adapter);

    }


}