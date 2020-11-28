package pflorindo.tfg.buysales.listView;

import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

public class Category {

    private String title;

    private Bitmap imagen;

    public Category() {
        super();
    }

    public Category(String title,Bitmap imagen) {
        super();
        this.title = title;

        this.imagen = imagen;

    }


    public String getTitle() {
        return title;
    }

    public void setTittle(String title) {
        this.title = title;
    }



    public Bitmap getImage() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }


}