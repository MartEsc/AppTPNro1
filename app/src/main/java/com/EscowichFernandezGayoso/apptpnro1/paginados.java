package com.EscowichFernandezGayoso.apptpnro1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class paginados extends AppCompatActivity implements CategoryViewHolder.categoriaClickListener {

    CategoryViewHolder adapter;
    ArrayList<String> categorias = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paginados);
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CategoryViewHolder(this, categorias, this);
        this.crearCategorias();
        recyclerView.setAdapter(adapter);


    }
    private void crearCategorias(){
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
        adapter.notifyDataSetChanged();
    }
    @Override
    public void categoriaClick(int posicion) {
        Intent intentResultado = new Intent();
        intentResultado.putExtra("categoria", categorias.get(posicion));
        setResult(Activity.RESULT_OK, intentResultado);
        finish();
    }

}