/**
 Universidad De Guadalajara
 Ingenieria en Computacion
 * Seminario de Traductores del Lenguaje I
 * Pratica 1
 * Héctor Aguirre González y Moisés Iñiguez Ortega
 * Clase Principal
 */
package practica1_ensamblador;

/**
 *
 * @author Héctor Aguirre González
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;//libreria para escaner las entradas del teclado 


public class Practica1_Ensamblador {

    
    public static void main(String[] args) throws IOException {
        //La ruta se pone por defecto en el codigo, la que esta aqui es la de mi computadora
        String Direccion = "C:\\Users\\Moisés\\desktop\\P1ASM.txt"; 
        Scanner sc = new Scanner(System.in);// se manda a llamar el metodo para escanear datos 
        
        //System.out.println("Inserte aqui la direccion de su Archivo .txt -> ");
        //Direccion = sc.nextLine();
        Metodos mt = new Metodos(Direccion);
        
        FileReader fr = new FileReader(Direccion);
                        BufferedReader bf = new BufferedReader(fr);
                        String Cadena = " ";
                        while ((Cadena = bf.readLine())!=null) {
                            mt.Resultado();
                            
                        }   
        }
    
    
}


