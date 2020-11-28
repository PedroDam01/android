package pflorindo.tfg.buysales.listView;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.ArrayList;

public class ArticuloCompleto {
    Articulo articulo;
    ArrayList<Bitmap> imagenes;

    public Articulo getIdArticulo() {
        return articulo;
    }

    public void setIdArticulo(Articulo idArticulo) {
        this.articulo = idArticulo;
    }

    public  ArrayList<Bitmap> getImagenes() {
        return imagenes;
    }

    public void setImagenes( ArrayList<Bitmap> imagenes) {
        this.imagenes = imagenes;
    }

    public ArticuloCompleto(Articulo idArticulo, ArrayList<Bitmap>imagenes) {
        this.articulo = idArticulo;
        this.imagenes = imagenes;
    }

}