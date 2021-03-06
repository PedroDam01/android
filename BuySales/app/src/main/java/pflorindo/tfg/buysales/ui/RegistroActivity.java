package pflorindo.tfg.buysales.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pflorindo.tfg.buysales.R;
import pflorindo.tfg.buysales.utils.AsyncHttpLauncher;

public class RegistroActivity extends AppCompatActivity {

    private EditText fieldNombre = null;
    private EditText fieldApellido = null;
    private EditText fieldUsuario = null;
    private EditText fieldPass = null;
    private Button btnRegistro = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        fieldNombre = findViewById(R.id.nombreField);
        fieldApellido = findViewById(R.id.apellidoField);
        fieldUsuario = findViewById(R.id.userField);
        fieldPass = findViewById(R.id.passField);
        btnRegistro = findViewById(R.id.registroBtn);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registroClickado();
            }
        });
    }

    private void registroClickado(){
boolean bandera=true;
       if (fieldNombre.getText().toString().isEmpty()){
           fieldNombre.setBackgroundColor(Color.MAGENTA);
           bandera=false;
       }if (fieldApellido.getText().toString().isEmpty()){
            fieldApellido.setBackgroundColor(Color.MAGENTA);
            bandera=false;

        }if (fieldPass.getText().toString().isEmpty()){
            fieldPass.setBackgroundColor(Color.MAGENTA);
            bandera=false;

        }if (fieldUsuario.getText().toString().isEmpty()){
            fieldUsuario.setBackgroundColor(Color.MAGENTA);
            bandera=false;

        }
    if (bandera){
        new AsyncHttpLauncher(this, AsyncHttpLauncher.ACTION_REGISTRO,
                fieldNombre.getText().toString(),
                fieldPass.getText().toString(),
                fieldApellido.getText().toString(),
                fieldUsuario.getText().toString());
    }else Toast.makeText(this,"Rellena todos los campos",Toast.LENGTH_LONG);

    }

    public void registroFallido(){
        Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_LONG).show();
    }

    public void registroCorrecto(){
        startActivity(new Intent(this, MainActivity.class));
    }

}