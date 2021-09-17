package com.EscowichFernandezGayoso.apptpnro1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Titulo, Precio, Direccion_retiro, Email, Descripcion;
    private Spinner Categoria;
    private CheckBox Retiro_en_persona , Terminos_Condiciones;
    private Switch Descuento;
    private SeekBar Cantidad_descuento;
    private RelativeLayout layoutDescuento;
    private Button buttonPublicar;
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
        Terminos_Condiciones =(CheckBox)findViewById(R.id.checkboxTerminos);
        Direccion_retiro=(EditText)findViewById(R.id.editTextDireccion);
        Descuento=(Switch)findViewById(R.id.switchDescuento);
        Cantidad_descuento=(SeekBar)findViewById(R.id.seekbarDescuento);
        Email=(EditText)findViewById(R.id.editTextCorreo);
        Descripcion=(EditText) findViewById(R.id.editTextDescripcion);
        layoutDescuento=(RelativeLayout) findViewById(R.id.layoutDescuento);
        buttonPublicar = (Button) findViewById(R.id.buttonPublicar);
        Descuento.setChecked(false);
        Terminos_Condiciones.setChecked(false);
        buttonPublicar.setEnabled(false);


    }

    public void updateSwitchDescuento(View V){
            if(Descuento.isChecked()){
                layoutDescuento.setVisibility(View.VISIBLE);
            }
            else{
                layoutDescuento.setVisibility(View.GONE);
            }
    }
    public void updateButtonPublicarState(View V){
        if(Terminos_Condiciones.isChecked()){
            buttonPublicar.setEnabled(true);
        }
        else{
            buttonPublicar.setEnabled(false);
        }
    }
    public void Enviar(View V){
        if(Titulo.getText().toString().isEmpty()){
            Toast.makeText(this, "El campo Titulo es obligatorio", Toast.LENGTH_LONG).show();
            return;
        }
        if(Precio.getText().toString().isEmpty()){
            Toast.makeText(this, "El campo Precio es obligatorio", Toast.LENGTH_LONG).show();
            return;
        }
        if(Integer.parseInt(Precio.getText().toString())==0){
            Toast.makeText(this, "El precio del producto debe ser mayor a 0", Toast.LENGTH_LONG).show();
            return;
        }
        if(Categoria.getSelectedItem().equals(null)){
            Toast.makeText(this, "La categoria es obligatoria", Toast.LENGTH_LONG).show();
            return;
        }
        if(Retiro_en_persona.isChecked()) {
            if (Direccion_retiro.getText().toString().isEmpty()) {
                Toast.makeText(this, "La direccion de retiro es obligatoria", Toast.LENGTH_LONG).show();
                return;
            }
        }
        if(Descuento.isChecked()){
            if(Cantidad_descuento.getProgress()==0){
                Toast.makeText(this, "Por favor seleccione un porcentaje mayor a 0 o quite la opcion de ofrecer descuento de envio", Toast.LENGTH_LONG).show();
                return;
            }
        }
        if(!Email.getText().toString().trim().matches(emailPattern)){
            Toast.makeText(this, "Dirección de correo invalida", Toast.LENGTH_LONG).show();
            return;
        }
        if(!Titulo.getText().toString().matches(validador)){
            Toast.makeText(this, "El campo Titulo contiene caracteres no permitidos", Toast.LENGTH_LONG).show();
            return;
        }
        if(!Direccion_retiro.getText().toString().matches(validador)){
            Toast.makeText(this, "El campo Dirección de retiro contiene caracteres no permitidos", Toast.LENGTH_LONG).show();
            return;
        }
        if(!Descripcion.getText().toString().matches(validador)){
            Toast.makeText(this, "El campo Descripción contiene caracteres no permitidos", Toast.LENGTH_LONG).show();
            return;
        }

        Toast.makeText(this, "Publicación exitosa", Toast.LENGTH_LONG).show();

    }
}