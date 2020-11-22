package pflorindo.tfg.buysales.ui;

import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import pflorindo.tfg.buysales.R;
import pflorindo.tfg.buysales.data.Usuario;
import pflorindo.tfg.buysales.data.UsuarioConvert;
import pflorindo.tfg.buysales.utils.AsyncHttpLauncher;

public class MainActivity extends AppCompatActivity {

    private Button registryBtn = null;
    private Button loginBtn = null;
    private EditText mailText = null;
    private EditText passText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define IU elements
        registryBtn = findViewById(R.id.registryBtn);
        loginBtn = findViewById(R.id.loginBtn);
        mailText = findViewById(R.id.loginMailText);
        passText = findViewById(R.id.loginPassText);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        registryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registry();
            }
        });
    }

    private void login(){
        Log.e("method: login()", "login clicked");

        String mailValue = mailText.getText().toString();
        String passValue = passText.getText().toString();
        if (mailValue.trim().isEmpty())
            mailText.setBackgroundColor(Color.MAGENTA);
        else if (passValue.trim().isEmpty())
            passText.setBackgroundColor(Color.MAGENTA);
        else {
            AsyncHttpLauncher task = new AsyncHttpLauncher(this, AsyncHttpLauncher.ACTION_LOGIN, mailValue);
        }
    }

    public void loginOK(boolean isOk) {
        if (isOk) {
            // TODO lanzar otra actividad
            startActivity(new Intent(this, MenuActivity.class));
            mailText.setBackgroundColor(Color.GREEN);
        } else {
            mailText.setBackgroundColor(Color.YELLOW);
            passText.setBackgroundColor(Color.YELLOW);

            Toast.makeText(this, "Usuario o contraseña incorrecto", Toast.LENGTH_LONG).show();
        }}

    private void registry(String[] value){
        AsyncHttpLauncher task = new AsyncHttpLauncher(this, AsyncHttpLauncher.ACTION_INSERTAR, );
    }

}