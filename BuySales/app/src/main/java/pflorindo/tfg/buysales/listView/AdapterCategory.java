package pflorindo.tfg.buysales.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pflorindo.tfg.buysales.R;

public class AdapterCategory extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Category> names;

    public AdapterCategory(Context context, int layout, ArrayList<Category> names) {
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // Copiamos la vista
        View v = convertView;

        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v = layoutInflater.inflate(R.layout.item_list, null);
        // Valor actual según la posición

        String currentName = names.get(position).getTitle();

        // Referenciamos el elemento a modificar y lo rellenamos
        TextView textView = (TextView) v.findViewById(R.id.texto);
        textView.setText(currentName);
        ImageView image=v.findViewById(R.id.imagen_lista);
        image.setImageBitmap(names.get(position).getImage());
        //Devolvemos la vista inflada
        return v;
    }
}