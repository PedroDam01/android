package pflorindo.tfg.buysales.ui;

import androidx.appcompat.app.AppCompatActivity;
import pflorindo.tfg.buysales.R;
import pflorindo.tfg.buysales.listView.ArticuloCompleto;
import pflorindo.tfg.buysales.listView.Decodificador;
import pflorindo.tfg.buysales.listView.NewArticuloAdapter;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MisArtActivity extends AppCompatActivity {
    ListView lista;
    ArrayList<ArticuloCompleto>ac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_art);
        lista=findViewById(R.id.mis_art);
    ac= Decodificador.listarArticulos(true,this);
        NewArticuloAdapter naa= new NewArticuloAdapter(this,R.layout.item_list,ac);
    }
}