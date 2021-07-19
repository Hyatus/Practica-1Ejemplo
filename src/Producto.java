public class Producto {
    private String articulo;
    private int cantidad;

    public Producto(String articulo, int cantidad) {
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    public String getArticulo() {
        return articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void retirarCantidad(int cantidad) {
        this.cantidad -= cantidad;
    }

    public void agregarCantidad(int cantidad){
        this.cantidad += cantidad;
    }

    public String mostrarDatosProducto(){
        return "|| Articulo: " + articulo +
                " || Cantidad: " + cantidad + " || ";
    }


}
