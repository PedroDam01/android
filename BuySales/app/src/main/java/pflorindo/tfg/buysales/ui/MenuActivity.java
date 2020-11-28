package pflorindo.tfg.buysales.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pflorindo.tfg.buysales.R;

public class MenuActivity extends AppCompatActivity {

    private Button articulos=null;
    private Button chat=null;
    private Button datos=null;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        articulos= findViewById(R.id.artcImBt);
        chat= findViewById(R.id.chatImBt);
        datos= findViewById(R.id.usersImBt);
        articulos.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                articulosClicked();
            }
        });
        datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datosClicked();
            }
        });
    }

    private void articulosClicked(){
        startActivity(new Intent(this, ArticActivity.class));
    }
    private void datosClicked(){
        startActivity(new Intent(this, UserActivity.class));
    }
}