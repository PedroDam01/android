package pflorindo.tfg.buysales.listView;

public class Articulo {
    String titulo, descripcion,provincia;

    int id;
    int vendedor;


    public Articulo(int id,String titulo, String descripcion,String provincia, int vendedor) {

        this.id=id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.provincia=provincia;
        this.vendedor = vendedor;
    }


    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Articulo{" + "titulo=" + titulo + ", descripcion=" + descripcion + ", provincia=" + provincia + ", id=" + id + ", vendedor=" + vendedor + '}';
    }



    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getVendedor() {
        return vendedor;
    }


}
