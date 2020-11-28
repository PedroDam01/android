package pflorindo.tfg.buysales.listView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import pflorindo.tfg.buysales.R;

public class NewArticuloAdapter extends ArrayAdapter<ArticuloCompleto> {

    Context context;
    int resource;
    ArrayList<ArticuloCompleto>ac;
    public NewArticuloAdapter(@NonNull Context context, int resource, ArrayList<ArticuloCompleto> ac) {
        super(context, resource,ac);
    this.ac=ac;
    this.resource=resource;
    this.context=context;
    }

    public View getView(int position,View convertView, ViewGroup parent){
        View row=convertView;
        articuloHolder holder=null;
        if (row==null){
            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            row=inflater.inflate(resource,parent,false);
            holder=new articuloHolder();
            holder.image=row.findViewById(R.id.imagen);
            holder.text=row.findViewById(R.id.texto);
            row.setTag(holder);
        }else{
            holder=(articuloHolder)row.getTag();
        }
        ArticuloCompleto ac_aux = ac.get(position);
        holder.text.setText(ac_aux.getIdArticulo().getTitulo());
        holder.image.setImageBitmap(ac_aux.getImagenes().get(0));

        return row;
    }
    static class articuloHolder{
        ImageView image;
        TextView text;
    }
}
