import java.io.*;
import java.util.*;

public class manejocliente {
	/******************************************************************
	 * Metodo menu. 
	 * prototipo:public static int menu(). 
	 * entrada : nada salida: un entero. 
	 * precondicion: nada .
	 * postcondicion: el entero contendra la opcion del menu. 
	 * Descripcion: muestra el menu.
	 */
	public static int menu() {
		Scanner teclado = new Scanner(System.in);
		int resp;
		do {
			System.out
					.print("Bienvenido:\n1)Dar de alta a un cliente\n2)Buscar cliente\n3)Borrar cliente\n4)Modificar cliente\n5)Mostrar todos lo clientes\n6)Actualizar\n7)SALIR\n\n");
			resp = teclado.nextInt();
		} while (resp < 1 || resp > 7);
		return resp;
	}

	/*********************************
	 * Metodo altacliente 
	 * prototipo: public static OperacionCliente altacliente() 
	 * entrada : nada 
	 * salida: un objeto del tipo OperacionCliente
	 * precondicion: nada 
	 * postcondicion: el objeto contendra toda la informacion para el alta 
	 * Descripcion: Recoge los datos para dar un alta a un cliente
	 */
	public static OperacionCliente altacliente() {
		Scanner teclado = new Scanner(System.in);
		OperacionCliente alt = new OperacionCliente();
		System.out.print("Indica el nombre ");
		alt.setNombre(teclado.nextLine());
		System.out.print("Indica el apellido ");
		alt.setApellidos(teclado.nextLine());
		System.out.print("Indica el CIF ");
		alt.setCIF(teclado.nextLine());
		System.out.print("Indica la direccion");
		alt.setDireccion(teclado.nextLine());
		System.out.print("Indica la categoria");
		alt.setCategoria(teclado.nextInt());
		alt.setMetodo('a');
		return (alt);
	}
	

	/*********************************
	 * Metodo borrarcliente 
	 * prototipo: public static OperacionCliente borrarcliente() 
	 * entrada : nada 
	 * salida: un objeto del tipo OperacionCliente 
	 * precondicion: nada 
	 * postcondicion: el objeto contendra toda la informacion para el borrado 
	 * Descripcion: Recoge los datos para borrar un cliente
	 */
	public static OperacionCliente borrarcliente() {
		Scanner teclado = new Scanner(System.in);
		OperacionCliente clieborr = new OperacionCliente();
		clieborr.setNombre("nulo");
		clieborr.setApellidos("nulo");
		System.out.print("Indica el CIF del cliente para borrar ");
		clieborr.setCIF(teclado.nextLine());
		clieborr.setDireccion("nulo");
		clieborr.setCategoria(-1);
		clieborr.setMetodo('b');
		return (clieborr);
	}
	/*******************************************************************************
	 * Metodo Modificarclie
	 * Prototipo: public static OperacionCliente modificarclie ()
	 * Entrada: nada
	 * Salida: un objeto del tipo OperacionCliente
	 * Precondicion: nada
	 * Postcondicion: el objeto contendra el usuario modificado
	 * Descripcion: Recoge los datos modificados del cliente
	 *******************************************************************************/
	public static OperacionCliente modificarclie ()
	{ 
		Scanner teclado = new Scanner(System.in);
		OperacionCliente cliemod = new OperacionCliente();
		System.out.print("Indica el nombre ");
		cliemod.setNombre(teclado.nextLine());
		System.out.print("Indica el apellido ");
		cliemod.setApellidos(teclado.nextLine());
		System.out.print("Indica el CIF ");
		cliemod.setCIF(teclado.nextLine());
		System.out.print("Indica la direccion");
		cliemod.setDireccion(teclado.nextLine());
		System.out.print("Indica la categoria");
		cliemod.setCategoria(teclado.nextInt());
		cliemod.setMetodo('m');
		return(cliemod);
	}
	/********************************************************************************
	 * Metodo intertarop 
	 * prototipo:public static void insertarop(OperacionCliente prueba,String ruta) 
	 * entrada : un string, y un objeto del tipo OperacionCliente 
	 * salida: nada esc ribe en el fichero
	 * precondicion: nada 
	 * postcondicion: escribira en el fichero la imformacion
	 * Descripcion: Inseta los datos de operaciones en un fichero
	 */
	public static void insertarop(OperacionCliente prueba, String opera )
			throws IOException {
		int c;
		String a = prueba.toString();
		RandomAccessFile Fr = new RandomAccessFile(opera, "rw");
		Fr.seek(Fr.length());
		for (int i = 0; i < a.length(); i++) {
			c = a.charAt(i);
			Fr.write(c);
		}
		Fr.close();
	}

	/********************************************************************************
	 * Metodo buscarcliente 
	 * prototipo: public static void buscarcliente(String ruta) 
	 * entrada : Un string 
	 * salida: nada 
	 * precondicion: el String contendra el nombre del archivo 
	 * postcondicion: nada Descripcion: Muestra el contenido del archivo
	 * @throws IOException
	 * @throws ClassNotFoundException
	 ********************************************************************************/
	public static void buscarcliente(String clie) throws IOException {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Indique el CIF del cliente");
		int CIF = teclado.nextInt();
		FileReader fr = new FileReader(clie);
		BufferedReader entrada = new BufferedReader(fr);
		String tabla = entrada.readLine();
		while (tabla != null) {
			String array[] = tabla.split(" ");
			if (Integer.parseInt(array[2]) == CIF) {
				System.out.println("Cliente\n" + tabla.toString());
				tabla = null;
			} else {
				tabla = entrada.readLine();
			}
		}
		entrada.close();
	}

	/********************************************************************************
	 * Metodo mostrar 
	 * prototipo: public static void mostrar(String ruta) 
	 * entrada: Un string 
	 * salida: nada 
	 * precondicion: el String contendra el nombre del archivo 
	 * postcondicion: nada Descripcion: Muestra el contenido del archivo
	 * 
	 * @throws ClassNotFoundException
	 ********************************************************************************/
	public static void mostrar(String ruta) throws IOException,
			ClassNotFoundException {
		FileReader fr = new FileReader(ruta);
		BufferedReader entrada = new BufferedReader(fr);
		String tabla = entrada.readLine();
		if (ruta == "cliente.txt") {
			System.out.println("Clientes\nNombre Apellido CIF Categoria Direccion");
		} else {
			System.out.println("Operaciones\nNombre Apellido CIF Categoria Direccion Operacion");
		}
		while (tabla != null) {
			System.out.println(tabla.toString());
			tabla = entrada.readLine();
		}
		entrada.close();
	}

	/********************************************************************************
	 * Metodo actualizar 
	 * prototipo:public static void actualizar(String ruta,String ruta2) 
	 * entrada : dos string
	 * salida: nada 
	 * precondicion: los String contendra los nombre de los archivos 
	 * postcondicion: nada 
	 * Descripcion:Actualiza el fichero cliente
	 * 
	 * @throws IOException
	 ********************************************************************************/
	public static void actualizar(String cliente, String rutaop, String temp)
			throws IOException {
		FileReader fr = new FileReader(rutaop);
		BufferedReader entradaop = new BufferedReader(fr);
		for (int j = 0; j < contarlineas(rutaop); j++) 
		{
			String tablaop = entradaop.readLine();
			String arrayop[] = tablaop.split(" ");
			OperacionCliente opclie = new OperacionCliente(arrayop[0], arrayop[1],
					arrayop[2], Integer.parseInt(arrayop[3]), arrayop[4],
					arrayop[5].charAt(0));

			if((arrayop[5].charAt(0))=='a')
			{
				anadiralta(cliente,  rutaop, temp, opclie);
				volcado(cliente,temp);	
			}
			else if((arrayop[5].charAt(0))=='m')
			{
				modificar(cliente, rutaop,temp, opclie);
			}
			else if((arrayop[5].charAt(0))=='b')
			{
				relizarbajas(cliente,  rutaop, temp, opclie);
			}
			borrarfich(cliente);
			renombrarfich(cliente, temp);
		
		}
	fr.close();
	}
	/********************************************************************************
	 * Metodo realizarbajas
	 * prototipo:public static void relizarbajas(String ruta, String ruta2, String rutafin) 
	 * entrada : 3 string 
	 * salida: nada
	 * precondicion: los String contendra los nombre de los archivos
	 * postcondicion: nada 
	 * Descripcion: realiza las bajas de los clientes
	 * 
	 * @throws IOException
	 */
	public static void relizarbajas(String rutaclie, String rutaop, String temp, OperacionCliente opclie)
			throws IOException {
		boolean encontrado = false;
				FileReader fr1 = new FileReader(rutaclie);
				BufferedReader entradaclie = new BufferedReader(fr1);
				for (int i = 0; i < contarlineas(rutaclie) && encontrado == false; i++) {
					String tablaclie = entradaclie.readLine();
					String arrayclie[] = tablaclie.split(" ");
					cliente clie = new cliente(arrayclie[0], arrayclie[1], arrayclie[2],
							Integer.parseInt(arrayclie[3]), arrayclie[4]);
					encontrado = (opclie.compareTo(clie));
					if (encontrado == false) {
						insertarclie(clie, temp);
					} else {
						encontrado = false;
					}
				}
				fr1.close();
	}
	/********************************************************************************
	 * Metodo anadiraltas 
	 * prototipo:public static void anadiraltas(String ruta,String ruta2, String rutafin) 
	 * entrada : 3 string 
	 * salida: nada
	 * precondicion: los String contendra los nombre de los archivos
	 * postcondicion: nada 
	 * Descripcion: introduce las altas en el fichero final
	 * 
	 * @throws IOException
	 */
	public static void anadiralta(String ruta, String ruta2, String rutafin, OperacionCliente opclie)
			throws IOException {
		boolean encontrado = false;
				FileReader fr1 = new FileReader(ruta);
				BufferedReader entrada1 = new BufferedReader(fr1);
				for (int i = 0; i < contarlineas(ruta) && encontrado == false; i++) {
					String tabla1 = entrada1.readLine();
					String array1[] = tabla1.split(" ");
					cliente clie = new cliente(array1[0], array1[1], array1[2],
							Integer.parseInt(array1[3]), array1[4]);
					encontrado = (opclie.compareTo(clie));
				}
				if (encontrado == false) {
					insertar(opclie, rutafin);
				} else {
					encontrado = false;
				}
				fr1.close();
	}
	/********************************************************************************
	 * Metodo modificar
	 * prototipo:public static void modificar(String ruta, String ruta2, String rutafin) 
	 * entrada : 3 string 
	 * salida: nada
	 * precondicion: los String contendra los nombre de los archivos
	 * postcondicion: nada 
	 * Descripcion: realiza las bajas de los clientes
	 * @throws NumberFormatException 
	 * @throws IOException
	 */
	public static void modificar(String rutaclie, String rutaop, String temp, OperacionCliente opclie) throws NumberFormatException, IOException 
	{
		boolean encontrado = false;

				FileReader fr1 = new FileReader(rutaclie);
				BufferedReader entradaclie = new BufferedReader(fr1);
				for (int i = 0; i < contarlineas(rutaclie) && encontrado == false; i++) {
					String tablaclie = entradaclie.readLine();
					String arrayclie[] = tablaclie.split(" ");
					cliente clie = new cliente(arrayclie[0], arrayclie[1], arrayclie[2],
							Integer.parseInt(arrayclie[3]), arrayclie[4]);
					encontrado = (opclie.compareTo(clie));
					if (encontrado == false) {
						insertarclie(clie, temp);
					} else {
						insertar(opclie, temp);
						encontrado = false;
					}
				}	
				fr1.close();
	}
	/********************************************************************************
	 * Metodo volcado 
	 * prototipo:public static void volcado(String ruta, String rutafin)
	 * entrada : dos string
	 * salida: nada 
	 * precondicion: los String contendra los nombre de los archivos 
	 * postcondicion: nada 
	 * Descripcion:Mueve todos los clientes al segundo fichero
	 * 
	 * @throws IOException
	 ********************************************************************************/
	public static void volcado(String rutaclie, String rutafin)
			throws IOException {
		FileReader fr = new FileReader(rutaclie);
		BufferedReader entrada = new BufferedReader(fr);
		for (int j = 0; j < contarlineas(rutaclie); j++) {
			String tabla = entrada.readLine();
			String array[] = tabla.split(" ");
			cliente clie = new cliente(array[0], array[1], array[2],
					Integer.parseInt(array[3]), array[4]);
			insertarclie(clie, rutafin);
		}
		fr.close();
		
	}

	/********************************************************************************
	* Metodo contaroperacion
	* prototipo:public static int contaroperacion(String ruta)
	* entrada : un string
	* salida: un entero
	* precondicion: El String contendra el nombre del archivo
	* postcondicion: nada
	* Descripcion: Cuenta el la cantidad de operaciones que hay dependiendo del tipo que sea
	*/
	public static int contaroperacion(String ruta, char tipo) throws IOException{
		 int cont=0;
		 BufferedReader entrada = new BufferedReader( new FileReader(ruta));
		 String tabla=entrada.readLine();
		 while(tabla!=null){
		  String array[]=tabla.split(" ");
		  if(array[5].charAt(0)==tipo)
			 {
			  cont++;
			 }
		  tabla=entrada.readLine();
		 }
		 entrada.close();
		 return cont;	 
	}
	/********************************************************************************
	 * Metodo intertar 
	 * public static void insertar(OperacionCliente prueba, String ruta)
	 * entrada : un string, y un objeto del tipo OperacionCliente 
	 * salida: nada escribe en el fichero
	 * precondicion: nada 
	 * postcondicion: escribira en el fichero la imformacion
	 * Descripcion: Inseta los datos de operaciones en un fichero
	 */
	public static void insertar(OperacionCliente prueba, String ruta)
			throws IOException {
		int c;
		String a = prueba.alta();
		RandomAccessFile Fr = new RandomAccessFile(ruta, "rw");
		Fr.seek(Fr.length());
		for (int i = 0; i < a.length(); i++) {
			c = a.charAt(i);
			Fr.write(c);
		}
		Fr.close();
	}
	/********************************************************************************
	 * Metodo intertarclie 
	 * prototipo:public static void insertarclie(cliente prueba, String ruta) 
	 * entrada : un string, y un objeto del tipo OperacionCliente 
	 * salida: nada escribe en el fichero
	 * precondicion: nada 
	 * postcondicion: escribira en el fichero la imformacion
	 * Descripcion: Inseta los datos de los clientes en el fichero
	 */
	public static void insertarclie(cliente prueba, String ruta)
			throws IOException {
		int c;
		String a = prueba.toString();
		RandomAccessFile Fr = new RandomAccessFile(ruta, "rw");
		Fr.seek(Fr.length());
		for (int i = 0; i < a.length(); i++) {
			c = a.charAt(i);
			Fr.write(c);
		}
		Fr.close();
	}
	/********************************************************************************
	 * Metodo contarlineas 
	 * prototipo: public static int contarlineas(String ruta) 
	 * entrada : Un string 
	 * salida: un entero 
	 * precondicion: el String contendra el nombre del archivo 
	 * postcondicion: el entero contendra las lineas del fichero 
	 * Descripcion: cuenta las lineas que contiene el fichero
	 * 
	 * @throws ClassNotFoundException
	 ********************************************************************************/
	public static int contarlineas(String ruta) throws IOException {
		int cont = 0;
		BufferedReader entrada = new BufferedReader(new FileReader(ruta));
		String tabla = entrada.readLine();
		while (tabla != null) {
			cont++;
			tabla = entrada.readLine();
		}
		entrada.close();
		return cont;
	}

	/********************************************************************************
	 * Metodo borrarfich 
	 * prototipo:public static void borrarfich(String ruta)
	 * entrada : un string 
	 * salida: nada 
	 * precondicion: el String contendra la ruta del archivo 
	 * postcondicion: nada 
	 * Descripcion: borra el fichero indicado
	 * 
	 * @throws IOException
	 */
	public static void borrarfich(String ruta) throws IOException {
		File fichero = new File(ruta);
		if (fichero.delete())
			System.out.println("El fichero ha sido borrado satisfactoriamente");
		else
			System.out.println("El fichero no puede ser borrado");
	}

	/********************************************************************************
	 * Metodo renombrarfich 
	 * prototipo:public static void renombrarfich(String ruta, String rutafin) 
	 * entrada : dos string 
	 * salida: nada 
	 * precondicion: los String contendra el nombre para los archivos 
	 * postcondicion: nada
	 * Descripcion: renombrara un archivo con otro nombre
	 * 
	 * @throws IOException
	 */
	public static void renombrarfich(String ruta, String rutafin)
			throws IOException {
		File f1 = new File(ruta);
		File f2 = new File(rutafin);
		boolean correcto = f2.renameTo(f1);
		if (correcto)
			System.out.println("El renombrado ha sido correcto");
		else
			System.out.println("El renombrado no se ha podido realizar");
	}

	/********
	 * Main
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		String cliente = "cliente.txt", opera = "clienteop.txt", rutafin = "temp.txt";
		int resp;
		do {
			System.out.println("Mola");
			System.out.println("Mol0");
			resp = menu();
			switch (resp) {
			case 1:
				insertarop(altacliente(), opera);
				break;
			case 2:
				buscarcliente(cliente);
				break;
			case 3:
				mostrar(cliente);
				insertarop(borrarcliente(), opera);
				break;
			case 4:
				buscarcliente(cliente);
				insertarop(modificarclie(), opera);
				break;
			case 5:
				mostrar(cliente);
				break;
			case 6:
				mostrar(cliente);
				mostrar(opera);
				actualizar(cliente, opera, rutafin);
				cliente datos[]=rellenarArray(cliente);
				Arrays.sort(datos);
				insertarfich(rutafin,datos);
				borrarfich(cliente);
				renombrarfich(cliente, rutafin);
				mostrar(cliente);
				break;
			case 7:
				System.out.println("Adios");
				break;
			}
		} while (resp != 7);
	}
	/********************************************************************************
	 * Metodo rellenarArray 
	 * prototipo:public static cliente [] rellenarArray(String ruta)
	 * entrada : un string 
	 * salida: un array del tipo cliente 
	 * precondicion: el String contendra el nombre del archivo 
	 * postcondicion: el array contendra todo los clientes del fichero
	 * Descripcion: Carga en un array del tipo cliente todos los clientes
	 * 
	 * @throws IOException
	 */
	public static cliente [] rellenarArray(String ruta) throws ClassNotFoundException, IOException 
	{
		
		FileReader fr = new FileReader(ruta);
		BufferedReader entrada = new BufferedReader(fr);
		cliente arrayobj[]= new cliente[contarlineas(ruta)];
		 for(int i=0;i<arrayobj.length;i++){
			 String  tabla=entrada.readLine();
			 String array[]=tabla.split(" ");
			 cliente cliente = new cliente(array[0],array[1],array[2],Integer.parseInt(array[3]),array[4]);
			 arrayobj[i]=cliente;
		 }
		 entrada.close();
		 return(arrayobj);
	}
	/********************************************************************************
	 * Metodo insertarfich 
	 * prototipo:public static void insertarfich(String ruta, cliente array[])
	 * entrada : un string , un array del tipo cliente
	 * salida: nada
	 * precondicion: el String contendra el nombre del archivo final, el array contendra los datos de los clientes  
	 * postcondicion: nada
	 * Descripcion: Inserta en el fichero los datos de los clientes
	 * 
	 * @throws IOException
	 */
	public static void insertarfich(String ruta, cliente array[]) throws IOException
	{
	
		FileWriter fw = new FileWriter(ruta);
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i=0;i<array.length;i++)
		{
			if(array[i]!=null)
			{
			bw.write(array[i].toString());
			}
		}
		  bw.close();
	}

	
}
