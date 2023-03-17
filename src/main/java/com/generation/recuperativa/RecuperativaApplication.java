package com.generation.recuperativa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.generation.recuperativa.models.Producto;

@SpringBootApplication
public class RecuperativaApplication {

	// 1. Función para calcular la ganancia por venta de un producto.
	
	public static Double ganancia(ArrayList<Double>listaPrecio_arraysDoubles){
		
		Double precioDelProveedor;
		Double precioAlPublico;

		precioAlPublico = listaPrecio_arraysDoubles.get(1);
		precioDelProveedor=listaPrecio_arraysDoubles.get(0);
		
		return precioAlPublico - precioDelProveedor;

	}

	// 2. Ingresar productos con su cantidad en el inventario

	public static void ingresar(Integer numeroProducto){
		
		Scanner teclado = new Scanner(System.in);
		// Creamos nuestro HashMap para almacenar el nombre del producto juntos a sus precios
		HashMap <String,Integer> inventario = new HashMap<>();

		// inicializamos el objeto producto
		Producto productoIngresado = new Producto();

		for(int i = 0; i < numeroProducto; i++){
			//teclado.nextLine();

			System.out.println("Ingresa el nombre del Producto");
			// seteamos el nombre del producto
			productoIngresado.setNombreProducto(teclado.nextLine());

			System.out.println("¿Cuántas unidades de este producto agregarás?");
			productoIngresado.setCantidad(teclado.nextInt());

			// Guardamos el nombre del producto + la cantidad en el hashmap	inventario
			inventario.put(productoIngresado.getNombreProducto(), productoIngresado.getCantidad());	

			teclado.nextLine();
			
		}
		System.out.println("------------------------------");
		System.out.println("¡Registro Exitoso!");
		for(String y : inventario.keySet()){					
			System.out.println("Del Producto " + y + " hay en stock: " + inventario.get(y));								
		}

	}
	
	
	// 3. Función para calcula el producto mas caro y el precio mas barato.
	
	public static void evaluacion(HashMap <String,ArrayList<Double>> hm_evaluar){
		
		//Double precioDelProveedor;
		//Double precioAlPublico;
		Double mayor_proveedor = 0.0;
		Double menor_proveedor = 1000000.0;
		Double mayor_venta = 0.0;
		Double menor_venta = 1000000.0;
		String nombreProductoCaro = null;
		String nombreProductoBarato = null;
		String nombreProductoCaroVenta = null;
		String nombreProductoBaratoVenta = null;
		
		Double ganancia = 0.0;
		Double gananciaTotal = 0.0;
		
		for(String y : hm_evaluar.keySet()){
			
			ArrayList<Double> evaluarPrecioArrayList = new ArrayList<Double>(); 
			evaluarPrecioArrayList = hm_evaluar.get(y);
			
			Double evaluarPrecioProveedor = evaluarPrecioArrayList.get(0);
			Double evaluarPrecioVenta = evaluarPrecioArrayList.get(1);

			// Proveedor: producto mas caro
			if(evaluarPrecioProveedor > mayor_proveedor){
				nombreProductoCaro = y;
				mayor_proveedor = evaluarPrecioProveedor;
				
			}
			// Proveedor: producto mas barato
			if(evaluarPrecioProveedor < menor_proveedor){
				nombreProductoBarato = y;
				menor_proveedor = evaluarPrecioProveedor;
				
			}
			// Venta: producto mas caro
			if(evaluarPrecioVenta > mayor_venta){
				nombreProductoCaroVenta = y;
				mayor_venta = evaluarPrecioVenta;
				
			}
			// Venta: producto mas barato
			if(evaluarPrecioVenta < menor_venta){
				nombreProductoBaratoVenta = y;
				menor_venta = evaluarPrecioVenta;				
			}
			
			ganancia = ganancia(hm_evaluar.get(y));
			gananciaTotal += ganancia;
			System.out.println("la ganancia de " + y + " es: " + ganancia);	
						
		}
		System.out.println("\n");
		System.out.println("La 'GANANCIA TOTAL' es: " + gananciaTotal + '\n');
		System.out.println("   | PRODUCTOS: PRECIO DEL PROVEEDOR | " + '\n');
		System.out.println("El más caro es: " + nombreProductoCaro + " y el más barato es: " + nombreProductoBarato + '\n');
		System.out.println("   | PRODUCTOS: PRECIOS AL PÚBLICO | " + '\n');
		System.out.println("El más caro es: " + nombreProductoCaroVenta + " , el más barato es: " + nombreProductoBaratoVenta);

	}


	public static void main(String[] args) {
	
		Scanner teclado = new Scanner(System.in);

		Integer seleccion;

		do{

			System.out.println("------------------------------------");
			System.out.println(" MINIMARKET: Seleccione su opción	");
			System.out.println("------------------------------------");
			System.out.println("	1. 'VER' ganancia por venta");
			System.out.println("	2. 'INGRESAR' producto(s) a inventario");
			System.out.println("	3. 'EVALUAR' Productos");
			System.out.println("	0. SALIR");
		
			seleccion = teclado.nextInt();

			if(seleccion == 1){

				// Creamos nuestro HashMap para almacenar el nombre del producto juntos a sus precios
				HashMap <String,ArrayList<Double>> productosPrecios = new HashMap<>();

				// inicializamos el objeto producto
				Producto producto = new Producto();
				
				teclado.nextLine();

				System.out.println("Ingresa el nombre del Producto");
				// seteamos elnombre del producto
				producto.setNombreProducto(teclado.nextLine());
				
				// Creamos el arreglo que guardará los precios de los productos
				ArrayList<Double> listaPrecio_array = new ArrayList<Double>();

				System.out.println("Ingrese el Precio del Proveedor");
				// Seteamos el precio del proveedor
				producto.setPrecioProveedor(teclado.nextDouble());
				// añadimos el precio del proveedor al arreglo
				listaPrecio_array.add(producto.getPrecioProveedor());

				System.out.println("Ingrese el Precio de Venta");
				//Seteamos el precio de venta
				producto.setPrecioVenta(teclado.nextDouble());
				// añadimos el precio del venta al arreglo
				listaPrecio_array.add(producto.getPrecioVenta());

				// Guardamos el nombre del producto + el array de precios en el hashmap	productosPrecios
				productosPrecios.put(producto.getNombreProducto(), listaPrecio_array);	
				

				for(String i : productosPrecios.keySet()){
					//llamamos a la funcion ganancia y le pasamos el valor de la key, que en este caso son de tipo array
					Double ganancia = ganancia(productosPrecios.get(i));

					if(ganancia > 0){
						System.out.println("---------------------------------------------------");
						System.out.println("La 'GANANCIA' del producto " + i + " es de: " + ganancia);
					}else if(ganancia == 0){
						System.out.println("-------------------------------------");
						System.out.println("No tienes GANANCIA ni Pérdidas");
					}else {
						System.out.println("------------------------------------------------------------------");
						System.out.println("¡¡¡PERDIDA!!! El Precio de Venta es menor que el Precio de Compra");
					}
				}

			} // fin de la opción 1


			if(seleccion == 2){
				
				Integer cantidadProducto;
				System.out.println("¿Cuántos productos agregarás?");
				cantidadProducto = teclado.nextInt();

				ingresar(cantidadProducto);

			}
			
			if(seleccion == 3){

				Integer cantidadProducto;
	

				// Creamos nuestro HashMap para almacenar el nombre del producto juntos a sus precios
				HashMap <String,ArrayList<Double>> hm_productosPrecios = new HashMap<>();

				// inicializamos el objeto producto
				Producto productosConsultas = new Producto();

				teclado.nextLine();

				System.out.println("¿Cuántos productos evaluarás?");
				cantidadProducto = teclado.nextInt();

				for(int i=0; i < cantidadProducto; i++){

					//ganancia = 0.0;
					teclado.nextLine();

					System.out.println("Ingresa el nombre del Producto");
					// seteamos elnombre del producto
					productosConsultas.setNombreProducto(teclado.nextLine());
					
					// Creamos el arreglo que guardará los precios de los productos
					ArrayList<Double> listaPrecio_array = new ArrayList<Double>();
	
					System.out.println("Ingrese el Precio del Proveedor");
					// Seteamos el precio del proveedor
					productosConsultas.setPrecioProveedor(teclado.nextDouble());
					// añadimos el precio del proveedor al arreglo
					listaPrecio_array.add(productosConsultas.getPrecioProveedor());
	
					System.out.println("Ingrese el Precio de Venta");
					//Seteamos el precio de venta
					productosConsultas.setPrecioVenta(teclado.nextDouble());
					// añadimos el precio del venta al arreglo
					listaPrecio_array.add(productosConsultas.getPrecioVenta());
	
					// Guardamos el nombre del productosConsultas + el array de precios en el hashmap	hm_productosPrecios
					hm_productosPrecios.put(productosConsultas.getNombreProducto(), listaPrecio_array);	
										
				}
				evaluacion(hm_productosPrecios);
				
			} // fin de opción 3

			if(seleccion == 0){

				System.out.println("---------------------------");
				System.out.println("¡Gracias, hasta pronto!");
				System.out.println("---------------------------");
			}

			if(seleccion< 0 || seleccion > 3){
				System.out.println("--------------------------------------");
				System.out.println("Opción inválidad, vuelva a intentar");
				//System.out.println("------------------------------------");

			}


		}while(seleccion != 0);
	
	
	
	
	
	
	
	
	
	
	
	} // fin del void main

} // fin de la clase
