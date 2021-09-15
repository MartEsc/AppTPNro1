package com.EscowichFernandezGayoso.apptpnro1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText Titulo, Precio, Direccion_retiro, Email, Descripcion;
    private Spinner Categoria;
    private CheckBox Retiro_en_persona;
    private Switch Descuento;
    private SeekBar Cantidad_descuento;
    private String emailPattern= "[a-zA-Z0-9._-]+@[a-z]{3,}+\\.+[a-z]+";
    private String validador= "[a-zA-Z0-9,. ]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Titulo=(EditText)findViewById(R.id.editTextTitulo);
        Precio=(EditText)findViewById(R.id.editTextPrecio);
        Categoria=(Spinner)findViewById(R.id.spinnerCategoria);
        Retiro_en_persona=(CheckBox)findViewById(R.id.checkboxRetiro);
        Direccion_retiro=(EditText)findViewById(R.id.editTextDireccion);
        Descuento=(Switch)findViewById(R.id.switchEnvio);
        Cantidad_descuento=(SeekBar)findViewById(R.id.seekbarDescuento);
        Email=(EditText)findViewById(R.id.editTextCorreo);
        Descripcion=(EditText) findViewById(R.id.editTextDescripcion);
    }

    public void Enviar(View V){
        Boolean es_valido=true;
        if(Titulo.getText().toString().isEmpty()){
            Toast.makeText(this, "El campo Titulo es obligatorio", Toast.LENGTH_LONG).show();
            es_valido=false;
        }
        if(Precio.getText().toString().isEmpty()){
            Toast.makeText(this, "El campo Precio es obligatorio", Toast.LENGTH_LONG).show();
            es_valido=false;
        }
        if(Integer.parseInt(Precio.getText().toString())==0){
            Toast.makeText(this, "El precio del producto debe ser mayor a 0", Toast.LENGTH_LONG).show();
            es_valido=false;
        }
        if(Categoria.getSelectedItem().equals(null)){
            Toast.makeText(this, "La categoria es obligatoria", Toast.LENGTH_LONG).show();
            es_valido=false;
        }
        if(Retiro_en_persona.isChecked()) {
            if (Direccion_retiro.getText().toString().isEmpty()) {
                Toast.makeText(this, "La direccion de retiro es obligatoria", Toast.LENGTH_LONG).show();
                es_valido=false;
            }
        }
        if(Descuento.isChecked()){
            if(Cantidad_descuento.getProgress()==0){
                Toast.makeText(this, "Por favor seleccione un porcentaje mayor a 0 o quite la opcion de ofrecer descuento de envio", Toast.LENGTH_LONG).show();
                es_valido=false;
            }
        }
        if(!Email.getText().toString().trim().matches(emailPattern)){
            Toast.makeText(this, "Dirección de correo invalida", Toast.LENGTH_LONG).show();
            es_valido=false;
        }
        if(!Titulo.getText().toString().matches(validador)){
            Toast.makeText(this, "El campo Titulo contiene caracteres no permitidos", Toast.LENGTH_LONG).show();
            es_valido=false;
        }
        if(!Direccion_retiro.getText().toString().matches(validador)){
            Toast.makeText(this, "El campo Dirección de retiro contiene caracteres no permitidos", Toast.LENGTH_LONG).show();
            es_valido=false;
        }
        if(!Descripcion.getText().toString().matches(validador)){
            Toast.makeText(this, "El campo Descripción contiene caracteres no permitidos", Toast.LENGTH_LONG).show();
            es_valido=false;
        }
        if(es_valido){
            Toast.makeText(this, "Publicación exitosa", Toast.LENGTH_LONG).show();
        }
    }
}