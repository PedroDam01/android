package pflorindo.tfg.buysales.listView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.google.gson.Gson;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import pflorindo.tfg.buysales.ui.MainActivity;
import pflorindo.tfg.buysales.utils.AsyncHttpLauncher;
import pflorindo.tfg.buysales.utils.Constantes;

public class Decodificador {
public static ArrayList<ArticuloCompleto>articulos;
public static ArrayList<Category>datos;
    public static Bitmap decode(String encode){
        byte[] decodedString = Base64.decode(encode, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }
    public static ArrayList<ArticuloCompleto> listarArticulos(boolean pertenece, AppCompatActivity activity){
        ArrayList<Articulo>lista=new ArrayList<>();
        Gson gson=new Gson();
        if (pertenece){
            AsyncHttpLauncher ahl=new AsyncHttpLauncher(activity, Constantes.URL_MIS_ARTICULOS, MainActivity.usu.getEmail());
            String json= (String) ahl.getFinishedData();
            Articulo[] array=gson.fromJson(json,Articulo[].class);
            for(Articulo a:array){
                lista.add(a);
            }
        }else{
            AsyncHttpLauncher ahl=new AsyncHttpLauncher(activity, Constantes.URL_LISTAR_ARTICULOS);
            String json= (String) ahl.getFinishedData();
            Articulo[] array=gson.fromJson(json,Articulo[].class);
            for(Articulo a:array){
                lista.add(a);
            }
        }
        completarArticulos(lista,activity);
        return articulos;
    }
    public static void completarArticulos( ArrayList<Articulo>array,AppCompatActivity activity){

        articulos = new ArrayList<>();
        Gson gson = new Gson();
        for (Articulo array1 : array) {

            MapaBit[] binario = null;
            AsyncHttpLauncher ahl=new AsyncHttpLauncher(activity, Constantes.URL_LISTA_IMAGENES, String.valueOf(array1.getId()));
            String cadenabinario = (String) ahl.getFinishedData();
            binario = gson.fromJson(cadenabinario, MapaBit[].class);
            ArrayList<Bitmap> imagenes = new ArrayList<>();
            if (binario.length > 0) {
                for (MapaBit binario1 : binario) {
                    Bitmap bytes =decode(binario1.getBinario());

                    imagenes.add(bytes);
                }

            }
            ArticuloCompleto galeria = new ArticuloCompleto(array1, imagenes);
            articulos.add(galeria);

        }

    }
    public static void completarLista(Context cont,int layout){
        for(ArticuloCompleto ac:articulos){
            datos.add(new Category(ac.getIdArticulo().titulo,ac.getImagenes().get(0)));

        }
        AdapterCategory ac=new AdapterCategory(cont,layout,datos);
    }
}
