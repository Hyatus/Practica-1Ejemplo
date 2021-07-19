
import java.util.Random;
import java.util.Scanner;

public class MainPractica {

    public static int buscarBodega(Bodega bodega[], int numeroBodega) {
        int indice = 0;
        boolean encontrado = false;
        for (int i = 0; i < bodega.length; i++) {
            if (bodega[i].getNumeroBodega() == numeroBodega) {
                encontrado = true;
                indice = i;
            }
            if (encontrado == false) {
                indice = -1;
            }

        }
        return indice;
    }

    public static void menuDatosActuales(Bodega bodega[]){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("\t.:MENU DATOS ACTUALES:.");
            System.out.println("1. Ver Inventario Actual ");
            System.out.println("2. Avisos ");
            System.out.println("3. Regresar menú principal");
            System.out.println("Ingrese una opción ");
            opcion = entrada.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("----------INVENTARIO ACTUAL------------");
                    for(int i = 0; i < bodega.length; i++){
                        System.out.println(bodega[i].mostrarDatosBodega());
                        bodega[i].getProductos();
                    }
                    System.out.println("---------FIN INVENTARIO ACTUAL----------");
                    break;
                case 2:
                    System.out.println("---------------AVISOS-------------------");
                    for(int i = 0; i < bodega.length; i++){
                        bodega[i].verificarInventario();
                    }
                    System.out.println("-------------FIN AVISOS-----------------");
                    break;
                default:
                    System.out.println("Ingrese una opción valida");
            }

        }while(opcion != 3);

    }

    public static void menuAcciones(Bodega bodega[]){
        Scanner entrada = new Scanner(System.in);
        int opcion, numeroBodega, indiceBodega, indiceBodega2, indiceProducto, cantidad;

        do{
            System.out.println("\t.:MENU DATOS ACCIONES:.");
            System.out.println("1. Sacar Mercadería ");
            System.out.println("2. Ingresar Mercadería ");
            System.out.println("3. Pasar Mercadería ");
            System.out.println("4. Regresar al menú principal ");
            System.out.println("Ingrese una opción ");
            opcion = entrada.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el número de bodega");
                    numeroBodega = entrada.nextInt();
                    indiceBodega = buscarBodega(bodega,numeroBodega);
                    if(indiceBodega == -1){
                        System.out.println("Bodega no fue encontrada");
                    }else{
                        System.out.println("Digite una de las siguientes opciones para elegir el articulo " +
                                "\n0. Cafe colombiano " +
                                "\n1. Café guatemalteco " +
                                "\n2. Café nicaraguense" +
                                "\n3. Café peruano ");
                        indiceProducto = entrada.nextInt();
                        if(indiceProducto == 0 ||
                                indiceProducto == 1 ||
                                indiceProducto == 2 ||
                                indiceProducto == 3){
                            System.out.println("Ingrese la cantidad que desea retirar ");
                            cantidad = entrada.nextInt();
                            if(cantidad > bodega[indiceBodega].getCantidadProducto(indiceProducto)){
                                System.out.println("La cantidad ingresada excede la cantidad en existencia");
                            }else{
                                bodega[indiceBodega].retirarProducto(indiceProducto,cantidad);
                            }
                        }else{
                            System.out.println("Opción invalida, articulo no existe");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el número de bodega");
                    numeroBodega = entrada.nextInt();
                    indiceBodega = buscarBodega(bodega,numeroBodega);
                    if(indiceBodega == -1){
                        System.out.println("Bodega no fue encontrada");
                    }else{
                        System.out.println("Digite una de las siguientes opciones para elegir el articulo " +
                                "\n0. Cafe colombiano " +
                                "\n1. Café guatemalteco " +
                                "\n2. Café nicaraguense" +
                                "\n3. Café peruano ");
                        indiceProducto = entrada.nextInt();
                        if(indiceProducto == 0 ||
                                indiceProducto == 1 ||
                                indiceProducto == 2 ||
                                indiceProducto == 3){
                            System.out.println("Ingrese la cantidad que desea agregar ");
                            cantidad = entrada.nextInt();
                            bodega[indiceBodega].agregarProducto(indiceProducto,cantidad);
                        }else{
                            System.out.println("Opción invalida, articulo no existe");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el número de bodega");
                    numeroBodega = entrada.nextInt();
                    indiceBodega = buscarBodega(bodega,numeroBodega);
                    if(indiceBodega == -1){
                        System.out.println("Bodega no fue encontrada");
                    }else{
                        System.out.println("Ingrese otro número de bodega");
                        numeroBodega = entrada.nextInt();
                        indiceBodega2 = buscarBodega(bodega,numeroBodega);
                        if(indiceBodega2 == -1){
                            System.out.println("Bodega no fue encontrada");
                        }else{
                            System.out.println("----------------ATENCIÓN!------------------");
                            System.out.println("Se hara la trasferencia de la bodega "
                                    + bodega[indiceBodega].getNumeroBodega() + " a la bodega " +
                                    bodega[indiceBodega2].getNumeroBodega());
                            System.out.println("Digite una de las siguientes opciones para elegir el articulo " +
                                    "\n0. Cafe colombiano " +
                                    "\n1. Café guatemalteco " +
                                    "\n2. Café nicaraguense" +
                                    "\n3. Café peruano ");
                            indiceProducto = entrada.nextInt();
                            if(indiceProducto == 0 ||
                                    indiceProducto == 1 ||
                                    indiceProducto == 2 ||
                                    indiceProducto == 3) {
                                System.out.println("Ingrese la cantidad que desea transferir ");
                                cantidad = entrada.nextInt();
                                if(cantidad > bodega[indiceBodega].getCantidadProducto(indiceProducto)){
                                    System.out.println("La cantidad ingresada excede la cantidad en existencia");
                                }else{
                                    bodega[indiceBodega].retirar(indiceProducto,cantidad);
                                    bodega[indiceBodega2].agregar(indiceProducto,cantidad);
                                    System.out.println("Transferencia realizada con éxito "
                                            + "se transfirió la cantidad de " + cantidad + " de la bodega " +
                                            bodega[indiceBodega].getNumeroBodega() +
                                            " a la bodega " + bodega[indiceBodega2].getNumeroBodega());
                                }
                            }

                        }

                    }
                default:
                    System.out.println("Ingrese una opción valida");
                    break;
            }

        }while(opcion != 4);
    }


    public static void menuReportes(Bodega bodega[]){
        Scanner entrada = new Scanner(System.in);
        int opcion, mayor = 0, menor = 0, numeroBodegaMa = 0, numeroBodegaMe = 0;

        do{
            System.out.println("\t.:MENU REPORTES:.");
            System.out.println("1. Bodega con Menor cantidad de productos ");
            System.out.println("2. Bodega con Mayor cantidad de productos ");
            System.out.println("3. Bodega con menor cantidad de productos separados por artículos");
            System.out.println("4. Bodega con Mayor cantidad de productos separados por artículos");
            System.out.println("5. Promedio de artículos por bodega");
            System.out.println("6. Mediana de unidades por artículo ");
            System.out.println("7. Moda de unidades por artículo ");
            System.out.println("8. Regresar al menú principal ");
            opcion = entrada.nextInt();
            switch (opcion){
                case 1:
                    int i = 0;
                    while(i < 9 ){
                        if( i == 1){
                            menor = bodega[i].getTotal();
                        }else{
                            if(bodega[i].getTotal() < menor ){
                                menor = bodega[i].getTotal();
                                numeroBodegaMe = bodega[i].getNumeroBodega();
                            }
                        }
                        i++;
                    }
                    System.out.println("El número menor es " + menor + " en la bodega " + numeroBodegaMe);
                    break;

                case 2:
                    int k = 0;
                    while(k < 9){
                        if( k == 1){
                            mayor = bodega[k].getTotal();
                        }else{
                            if(bodega[k].getTotal() > mayor ){
                                mayor = bodega[k].getTotal();
                                numeroBodegaMa = bodega[k].getNumeroBodega();
                            }
                        }
                        k++;
                    }
                    System.out.println("El número mayor es " + mayor + " en la bodega " + numeroBodegaMa);
                    break;

                case 3:
                    System.out.println(bodega[numeroBodegaMe-1].mostrarDatosBodega());
                    bodega[numeroBodegaMe].getProductos();
                    break;
                case 4:
                    System.out.println(bodega[numeroBodegaMa-1].mostrarDatosBodega());
                    bodega[numeroBodegaMa].getProductos();
                    break;
                case 5:
                    System.out.println("Opc 5");
                    break;
                case 6:
                    System.out.println("Opc 6");
                    break;
                case 7:
                    System.out.println("Opc 7");
                    break;
                default:
                    System.out.println("Ingrese una opción valida ");
            }

        }while(opcion != 8);

    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcion, contador2 = 0;

        //CARGA DE LOS DATOS
        Bodega bodega[] = new Bodega[9];
        Bodega bodegaCopia[] = new Bodega[9];
        Random randomObj = new Random();
        int contador = 0;
        for(int i = 0; i < bodega.length ; i++){
            contador = i+1;
            Producto producto[] = new Producto[4];
            Producto productoCopia[] = new Producto[4];
            int random1 = 100 + randomObj.nextInt(111-100);
            producto[0] = new Producto("Cafe colombiano",random1);
            productoCopia[0] = new Producto("Cafe colombiano",random1);
            int random2 = 90 + randomObj.nextInt(116-90);
            producto[1] = new Producto("Cafe guatemalteco" , random2);
            productoCopia[1] = new Producto("Cafe guatemalteco" , random2);
            int random3 = 100 + randomObj.nextInt(111-100);
            producto[2] = new Producto("Cafe nicaraguense" , random3);
            productoCopia[2] = new Producto("Cafe nicaraguense" , random3);
            int random4 = 90 + randomObj.nextInt(116-90);
            producto[3] = new Producto("Cafe peruano", random4);
            productoCopia[3] = new Producto("Cafe nicaraguense" , random4);
            bodega[i] = new Bodega(contador,producto);
            bodegaCopia[i] = new Bodega(contador,productoCopia);
        }

        //MENU PRINCIPAL
        do{
            System.out.println("\t.:MENU PRINCIPAL:.");
            System.out.println("1. Datos de prueba ");
            System.out.println("2. Datos Actuales ");
            System.out.println("3. Acciones ");
            System.out.println("4. Reportes ");
            System.out.println("5. SALIR ");
            System.out.println("Ingrese una opción ");
            opcion = entrada.nextInt();
            switch (opcion){
                case 1:
                    for (int i = 0; i < bodegaCopia.length; i++) {
                        System.out.println(bodegaCopia[i].mostrarDatosBodega());
                        bodegaCopia[i].getProductos();
                    }
                    break;

                case 2:
                    menuDatosActuales(bodega);
                    break;
                case 3:
                    menuAcciones(bodega);
                    break;
                case 4:
                    for(int j= 0; j < bodega.length; j++){
                        bodega[j].setTotal(0);
                    }
                    for(int j= 0; j < bodega.length; j++){
                        bodega[j].sumarInventario();
                    }
                    menuReportes(bodega);
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }

        }while(opcion != 5);

    }

}