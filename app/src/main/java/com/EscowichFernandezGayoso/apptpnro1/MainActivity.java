package com.EscowichFernandezGayoso.apptpnro1;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView labelDescuento;
    private EditText Titulo, Precio, textCategoria, Direccion_retiro, Email, Descripcion;
    private CheckBox Retiro_en_persona , Terminos_Condiciones;
    private Switch Descuento;
    private SeekBar Cantidad_descuento;
    private RelativeLayout layoutDescuento;
    private LinearLayout layoutRetiro;
    private Button buttonPublicar,buttonCategoria;
    private String emailPattern= "[a-zA-Z0-9._-]+@[a-z]{3,}+\\.+[a-z]+";
    private String validador= "[a-zA-Z0-9,. ]+";
    private String categoriaSeleccionada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Titulo=(EditText)findViewById(R.id.editTextTitulo);
        Precio=(EditText)findViewById(R.id.editTextPrecio);
        Retiro_en_persona=(CheckBox)findViewById(R.id.checkboxRetiro);
        Terminos_Condiciones =(CheckBox)findViewById(R.id.checkboxTerminos);
        layoutRetiro=(LinearLayout)findViewById(R.id.layoutRetiro);
        Direccion_retiro=(EditText)findViewById(R.id.editTextDireccion);
        Descuento=(Switch)findViewById(R.id.switchDescuento);
        Cantidad_descuento=(SeekBar)findViewById(R.id.seekbarDescuento);
        labelDescuento=(TextView)findViewById(R.id.textLabelPorcentajeDescuento);
        Email=(EditText)findViewById(R.id.editTextCorreo);
        Descripcion=(EditText) findViewById(R.id.editTextDescripcion);
        layoutDescuento=(RelativeLayout) findViewById(R.id.layoutDescuento);
        buttonPublicar = (Button) findViewById(R.id.buttonPublicar);
        buttonCategoria = (Button) findViewById(R.id.buttonCategoria);
        textCategoria=(EditText) findViewById(R.id.textCatSeleccionada);


        Descuento.setChecked(false);
        layoutDescuento.setVisibility(View.GONE);
        Terminos_Condiciones.setChecked(false);
        buttonPublicar.setEnabled(false);
        layoutRetiro.setVisibility(View.GONE);
        Retiro_en_persona.setChecked(false);


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Cantidad_descuento.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                labelDescuento.setText("El descuento es de : "+ seekBar.getProgress() + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        buttonCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCategoria = new Intent(MainActivity.this, paginados.class);
                startActivityForResult(intentCategoria,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(resultCode== Activity.RESULT_OK){
            if(requestCode==0){
                String categoriaSeleccionada=data.getExtras().getString("categoria");
                textCategoria.setText(categoriaSeleccionada);
            }
        }
    }

    public void updateSwitchDescuento(View V){
            if(Descuento.isChecked()){
                layoutDescuento.setVisibility(View.VISIBLE);
            }
            else{
                layoutDescuento.setVisibility(View.GONE);
            }
    }


    public void showDireccionRetiro(View V){
        if(Retiro_en_persona.isChecked()){
            layoutRetiro.setVisibility(View.VISIBLE);
        }
        else{
            layoutRetiro.setVisibility(View.GONE);
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
        if(textCategoria.getText().equals("Sin Seleccionar")){
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
        if(!Direccion_retiro.getText().toString().matches(validador) && Retiro_en_persona.isChecked()){
            Toast.makeText(this, "El campo Dirección de retiro contiene caracteres no permitidos", Toast.LENGTH_LONG).show();
            return;
        }
        if(!Descripcion.getText().toString().matches(validador) && !Descripcion.getText().toString().isEmpty()){
            Toast.makeText(this, "El campo Descripción contiene caracteres no permitidos", Toast.LENGTH_LONG).show();
            return;
        }

        Toast.makeText(this, "Publicación exitosa", Toast.LENGTH_LONG).show();

    }
}