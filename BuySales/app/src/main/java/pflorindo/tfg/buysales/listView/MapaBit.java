package pflorindo.tfg.buysales.listView;

public class MapaBit {
    String binario;
    int idArticulo;
    public MapaBit( String binario,int idArticulo) {
        this.binario = binario;
        this.idArticulo=idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }


    public int getIdArticulo() {
        return idArticulo;
    }

    public  String getBinario() {
        return binario;
    }

    public void setBinario( String binario) {
        this.binario = binario;
    }


}