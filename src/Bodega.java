public class Bodega {
    private int numeroBodega;
    private Producto producto[];
    private int total;

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public Bodega(int numeroBodega, Producto[] producto) {
        this.numeroBodega = numeroBodega;
        this.producto = producto;
    }

    public int getNumeroBodega() {
        return numeroBodega;
    }


    public String mostrarDatosBodega(){
        return "\nNumero Bodega: " + numeroBodega;
    }

    public void getProductos() {
        for(int j = 0; j < producto.length; j++){
            System.out.println(producto[j].mostrarDatosProducto());
        }
    }

    public void retirarProducto(int indiceProducto, int cantidad){
        producto[indiceProducto].retirarCantidad(cantidad);
        System.out.println("Se retiró la cantidad de " + cantidad + " del Articulo " +
                producto[indiceProducto].getArticulo() + " en la bodega " + numeroBodega);
    }

    public void agregarProducto(int indiceProducto, int cantidad){
        producto[indiceProducto].agregarCantidad(cantidad);
        System.out.println("Se agregó la cantidad de " + cantidad + " del Articulo " +
                producto[indiceProducto].getArticulo() + " en la bodega " + numeroBodega);
    }

    //RETIRAR Y AGREGAR SE UTILIZAN SÓLO PARA LA TRANSFERENCIA
    public void retirar(int indiceProducto, int cantidad){
        producto[indiceProducto].retirarCantidad(cantidad);
    }
    public void agregar(int indiceProducto, int cantidad){
        producto[indiceProducto].agregarCantidad(cantidad);
    }


    public int getCantidadProducto(int indiceProducto){
        return producto[indiceProducto].getCantidad();
    }

    public void sumarInventario(){
        for(int i = 0; i < producto.length; i++){
            total += producto[i].getCantidad();
        }
    }

    public void verificarInventario(){
        float p1, p2, p3, p4;
        float cant1, cant2, cant3, cant4;
        cant1 = producto[0].getCantidad();
        cant2 = producto[1].getCantidad();
        cant3 = producto[2].getCantidad();
        cant4 = producto[3].getCantidad();

        p1 = (100 - ((1 - cant1/110)*100));
        p2 = (115 - ((1 - cant2/115)*100));
        p3 = (100 - ((1 - cant3/110)*100));
        p4 = (115 - ((1 - cant4/115)*100));

        if(p1 > 50 &&
                p2 > 50 &&
                p3 > 50
                && p4 > 50){
            System.out.println("La bodega número " + numeroBodega + " Se encuentra bien ");
        }

        if((p1 > 20) && (p1 < 50)){
            System.out.println("La bodega número " + numeroBodega
                    + " se le está agotando el articulo " + producto[0].getArticulo());
        }
        if(p1 < 20){
            System.out.println("El producto " + producto[0].getArticulo() +
                    " de la bodega " + numeroBodega +
                    " está a punto de acabarse");
        }
        if(cant1 == 0){
            System.out.println("El producto " + producto[0].getArticulo() +
                    " de la bodega " + numeroBodega +
                    " está agotado");
        }


        if((p2 > 20) && (p2 < 50)){
            System.out.println("La bodega número " + numeroBodega
                    + " se le está agotando el articulo " + producto[1].getArticulo());
        }
        if(p2 < 20){
            System.out.println("El producto " + producto[1].getArticulo() +
                    " de la bodega " + numeroBodega +
                    " está a punto de acabarse");
        }
        if(cant2 == 0){
            System.out.println("El producto " + producto[1].getArticulo() +
                    " de la bodega " + numeroBodega +
                    " está agotado");
        }


        if((p3 > 20) && (p3 < 50)){
            System.out.println("La bodega número " + numeroBodega
                    + " se le está agotando el articulo " + producto[2].getArticulo());
        }
        if(p3 < 20){
            System.out.println("El producto " + producto[2].getArticulo() +
                    " de la bodega " + numeroBodega +
                    " está a punto de acabarse");
        }
        if(cant3 == 0){
            System.out.println("El producto " + producto[2].getArticulo() +
                    " de la bodega " + numeroBodega +
                    " está agotado");
        }


        if((p4 > 20) && (p4 < 50)){
            System.out.println("La bodega número " + numeroBodega
                    + " se le está agotando el articulo " + producto[3].getArticulo());
        }
        if(p4 < 20){
            System.out.println("El producto " + producto[3].getArticulo() +
                    " de la bodega " + numeroBodega +
                    " está a punto de acabarse");
        }
        if(cant4 == 0){
            System.out.println("El producto " + producto[3].getArticulo() +
                    " de la bodega " + numeroBodega +
                    " está agotado");
        }

    }

}
