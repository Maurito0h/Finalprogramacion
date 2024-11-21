
package inventario;

import inventario.entidades.Categoria;
import inventario.entidades.Producto;
import inventario.entidades.Proveedor;
import inventario.entidades.Stock;
import inventario.entidades.Sucursal;
import inventario.entidades.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {

    public static void main(String[] args) {
        
        // crear un stock inicial
        
        // crear categorias
            ArrayList<Categoria> categorias = new ArrayList<Categoria>();
            Categoria c1 = new Categoria (1, "Electrodomesticos");
            categorias.add(c1);
            Categoria c2 = new Categoria (2, "Muebles");
            categorias.add(c2);
            Categoria c3 = new Categoria (3, "Tecnologia");
            categorias.add(c3);
            
            // crear proveedores
            ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
            Proveedor p1 = new Proveedor (1, "Lucas", "2615898989");
            proveedores.add(p1);
            Proveedor p2 = new Proveedor (2, "Martin", "2615252525");
            proveedores.add(p2);
            Proveedor p3 = new Proveedor (3, "Diego", "2613454542");
            proveedores.add(p3);
            
            // crear sucursales 
            ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
            Sucursal suc1 = new Sucursal(1,"Mendoza","calle Colon 1715");
            sucursales.add(suc1);
            Sucursal suc2 = new Sucursal(2,"Tunuyan","calle San Martin 283");
            sucursales.add(suc2);
            Sucursal suc3 = new Sucursal(3,"San Martin","calle Estrada 27");
            sucursales.add(suc3);
            
            // crear productos
            ArrayList<Producto> productos = new ArrayList<Producto>();
            Producto prod1 = new Producto(1,"Tablet",(Double)142.00,c3, p3);
            productos.add(prod1);
            Producto prod2 = new Producto(2,"Heladera",(Double)724.00,c1, p2);
            productos.add(prod2);
            Producto prod3 = new Producto(3,"Auriculares",(Double)22.00,c3, p1);
            productos.add(prod3);
            Producto prod4 = new Producto(4,"Mesa",(Double)184.00,c2, p3);
            productos.add(prod4);
            Producto prod5 = new Producto(5,"Silla",(Double)32.00,c2, p2);
            productos.add(prod5);

            // crear stock
            ArrayList<Stock> stocks = new ArrayList<Stock>();
            Stock s1 = new Stock (1,12,prod1,suc1);
            stocks.add(s1);
            Stock s2 = new Stock (2,6,prod2,suc1);
            stocks.add(s2);
            Stock s3 = new Stock (3,3,prod5,suc1);
            stocks.add(s3);
            Stock s4 = new Stock (4,2,prod3,suc1);
            stocks.add(s4);
            Stock s5 = new Stock (5,9,prod1,suc2);
            stocks.add(s5);
            Stock s6 = new Stock (6,5,prod2,suc2);
            stocks.add(s6);
            Stock s7 = new Stock (7,8,prod4,suc2);
            stocks.add(s7);
            Stock s8 = new Stock (8,1,prod5,suc2);
            stocks.add(s8);
            Stock s9 = new Stock (9,7,prod2,suc3);
            stocks.add(s9);
            Stock s10 = new Stock (10,16,prod3,suc3);
            stocks.add(s10);
            Stock s11 = new Stock (11,1,prod4,suc3);
            stocks.add(s11);
            Stock s12 = new Stock (12,10,prod5,suc3);
            stocks.add(s12);
            
            // crear usuario
            ArrayList<Usuario> usuarios = new ArrayList <Usuario>();
            Usuario u1 = new Usuario(1,"juan12", "123456", "Juan", suc3);
            usuarios.add(u1);
            Usuario u2 = new Usuario(2,"marta23","123456","Marta",suc1);
            usuarios.add(u2);
            Usuario u3 = new Usuario(3,"mateo99","123456","Mateo",suc2);
            usuarios.add(u2);
        
        Scanner scanner = new Scanner(System.in);
        
        Boolean sesionIniciada = iniciarSesion(scanner, usuarios);
        
        if(sesionIniciada){
            
            int opcion;

            do {
                System.out.println("---------------------------------------------");
                System.out.println("---------------------------------------------");
                System.out.println("1. Ver todos los productos en stock");
                System.out.println("2. Buscar producto por nombre");
                System.out.println("3. Buscar producto por precio");
                System.out.println("4. Buscar producto por categoría");
                System.out.println("5. Realizar venta");
                System.out.println("6. Registrar orden de compra");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        verTodosLosProductos(stocks);
                        break;
                    case 2:
                        buscarProductoPorNombre(scanner, stocks);
                        break;
                    case 3:
                        buscarProductoPorPrecio(scanner, stocks);
                        break;
                    case 4:
                        buscarProductoPorCategoria(scanner, stocks);
                        break;
                    case 5:
                        realizarVenta(scanner, stocks);
                        break;
                    case 6:
                        registrarOrdenCompra(scanner, stocks, proveedores, categorias);
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } while (opcion != 0);

            scanner.close();
        
        }
             
   
    }
    
    public static Boolean iniciarSesion(Scanner scanner,ArrayList<Usuario> usuarios){
        System.out.println("Bienvenido");
                Boolean existente = false;
        while (!existente){
            System.out.println("Ingrese su usuario a continuación: ");
            String usuarioString = scanner.next();
            Usuario usuarioEncontrado ;
            Boolean usuarioCorrecto = false;
            for (Usuario usuario : usuarios) {
                if(usuario.getUsuario().equals(usuarioString)){
                    usuarioEncontrado = usuario;
                    usuarioCorrecto = true;
                    System.out.println(usuarioEncontrado.getNombre()+" ingrese su contraseña por favor: ");
                    String contrasenia = scanner.next();
                    if (usuarioEncontrado.getContrasenia().equals(contrasenia)){
                        System.out.println("Acceso correcto");
                        existente = true;
                        return true;
                    } else {
                        System.out.println("Contraseña incorrecta");
                    }
                }
            } 
            if (!usuarioCorrecto){
                System.out.println("Usuario inexistente");
                
            }
            
        }
        
        
        return true;
    }
    
        // Mostrar todos los productos en stock
    public static void verTodosLosProductos(ArrayList<Stock> stocks) {
        for (Stock stock : stocks) {
            System.out.println("sucursal: "+stock.getSucursal().getNombre()+", producto: "+ stock.getProducto().getNombre()+" , cantidad:"+ stock.getCantidad()+" .Pecio por unidad: "+stock.getProducto().getPrecio());
        }
    }
    
    public static void buscarProductoPorNombre(Scanner scanner, ArrayList<Stock> stocks) {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombre = scanner.nextLine().toLowerCase();

        boolean encontrado = false;
        for (Stock stock : stocks) {
            if (stock.getProducto().getNombre().toLowerCase().contains(nombre)) {
                System.out.println("sucursal: "+stock.getSucursal().getNombre()+", producto: "+ stock.getProducto().getNombre()+" , cantidad:"+ stock.getCantidad()+" .Pecio por unidad: "+stock.getProducto().getPrecio());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún producto con ese nombre.");
        }  
    
    }
    
    public static void buscarProductoPorPrecio(Scanner scanner, ArrayList<Stock> stocks) {
        System.out.print("Ingrese el precio máximo a buscar: ");
        double precio = scanner.nextDouble();

        boolean encontrado = false;
        for (Stock stock : stocks) {
            if (stock.getProducto().getPrecio() <= precio) {
                System.out.println("sucursal: "+stock.getSucursal().getNombre()+", producto: "+ stock.getProducto().getNombre()+" , cantidad:"+ stock.getCantidad()+" .Pecio por unidad: "+stock.getProducto().getPrecio());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún producto en ese rango de precio.");
        }
    }
    
    public static void buscarProductoPorCategoria(Scanner scanner, ArrayList<Stock> stocks) {
        System.out.print("Ingrese el nombre de la categoría a buscar: ");
        String nombreCategoria = scanner.nextLine().toLowerCase();

        boolean encontrado = false;
        for (Stock stock : stocks) {
            if (stock.getProducto().getCategoria().getNombre().toLowerCase().contains(nombreCategoria)) {
                System.out.println("sucursal: "+stock.getSucursal().getNombre()+", producto: "+ stock.getProducto().getNombre()+" , cantidad:"+ stock.getCantidad()+" .Pecio por unidad: "+stock.getProducto().getPrecio());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún producto en esa categoría.");
        }
    }

    public static void realizarVenta(Scanner scanner, ArrayList<Stock> stocks) {
        System.out.print("Ingrese el nombre del producto a vender: ");
        String nombreProducto = scanner.next();
        System.out.print("Ingrese la cantidad a vender: ");
        int cantidad = scanner.nextInt();

        boolean encontrado = false;
        for (Stock stock : stocks) {
            if (stock.getProducto().getNombre().equalsIgnoreCase(nombreProducto)) {
                if (stock.getCantidad() >= cantidad) {
                    stock.actualizarCantidad(cantidad);
                    System.out.println("Venta realizada. Stock actualizado.");
                } else {
                    System.out.println("No hay suficiente stock disponible.");
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún producto con ese ID.");
        }
    }

    public static void registrarOrdenCompra(Scanner scanner, ArrayList<Stock> stocks,ArrayList<Proveedor> proveedores,ArrayList<Categoria> categorias) {
        System.out.print("Ingrese el ID del producto a registrar en la orden de compra: ");
        int idProducto = scanner.nextInt();
        System.out.print("Ingrese la cantidad a agregar al stock: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        boolean encontrado = false;
        for (Stock stock : stocks) {
            if (stock.getProducto().getId() == idProducto) {
                stock.setCantidad(stock.getCantidad() + cantidad);
                System.out.println("Orden de compra registrada. Stock actualizado.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún producto con ese ID. Desea ingresar un producto nuevo?: ");
            String rta = scanner.next();
            if(rta.equalsIgnoreCase("si")){
                System.out.println("Ingrese id del producto: ");
                int id = scanner.nextInt();
                System.out.println("Ingrese nombre del producto: ");
                String nombre = scanner.next();
                System.out.println("Ingrese precio del producto: ");
                Double precio = scanner.nextDouble();
                
                Producto prod = new Producto(id, nombre, precio);
                
                System.out.println("Ingrese nombre de la categoría a la que pertenece el producto (Electrodomesticos, tecnologia, muebles): ");
                String categ = scanner.next();
                for (Categoria categoria : categorias) {
                    if(categoria.getNombre().equalsIgnoreCase(categ)){
                        prod.setCategoria(categoria);
                    }                    
                }
                System.out.println("Ingrese Id del proveedor del producto (1, 2, 3): ");
                int pro = scanner.nextInt();
                for (Proveedor proveedor : proveedores) {
                    if(proveedor.getId() == pro){
                        prod.setProveedor(proveedor);
                    }                    
                }             
                
            }
        }
    }

    
}
