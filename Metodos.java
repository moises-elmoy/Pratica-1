/**
 Universidad De Guadalajara
 Ingenieria en Computacion
 * Seminario de Traductores del Lenguaje I
 * Pratica 1
 * Héctor Aguirre González y Moisés Iñiguez Ortega
 * Metodos
 */
package practica1_ensamblador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Metodos {
    //Atributo
    private List<String> Estructura = new ArrayList<String>();
    
    //Constructor de la clase metodos
    Metodos(String Direccion){
        try
        {
            Estructura = Files.readAllLines(Paths.get(Direccion));
        }
        catch (IOException e)
        {
            System.out.println("No se pudo abrir el archivo...");
            System.exit(0);
        }
        
    }
    
    
    /*Metodo para procesar la entrada de lineas del txt y clasifica si es Operando,CODOP o Etiqueta*/
    public void Resultado(){
        if (Estructura.size() == 0){
            System.out.println("Null");
        }
        
        
        String cadena = Estructura.get(0);
        vComentario(cadena);
        Estructura.remove(0);
        String auxiliar; // Almacena la entrada pero sin espacios al inicio
        String[] Arreglo; 
                          
        // Separar la linea actual en tokens
        auxiliar = cadena.trim();
        cadena = cadena.replace("\t", " "); // Reemplaza los tabuladores por espacios 
        Arreglo = auxiliar.split("\\s+");
        
        
        
        //En este if si el arreglo mide solamente 1 eso nos indica que Es CODOP
        if (Arreglo.length == 1)
        {
            System.out.println("ETIQUETA = null"  + "\n" + "CODOP = " + vCODOP(Arreglo[0]) + "\n" + "OPERANDO = null\n");    
        }

        //if que indica si 
        if (Arreglo.length == 2)
        {
            //Es etiqueta - CODOP 
            if (cadena.charAt(0) != ' ')
            {
                System.out.println("ETIQUETA = " + vEtiqueta(Arreglo[0]) + "\n" + "CODOP = " + vCODOP(Arreglo[1]) + "\n" + "OPERANDO = null\n"); 
            }
            //Es CODOP - Operando 
            else
            {
                System.out.println("ETIQUETA = null" + "\n" + "CODOP = " + vCODOP(Arreglo[0]) + "\n" + "OPERANDO = " + vOperando(Arreglo[1])+"\n"); 
            }
        }

        //En este if se muestran las tres opciones
        if (Arreglo.length == 3)
        {
            if (cadena.charAt(0) != ' ')
            {
                System.out.println("ETIQUETA = " + vEtiqueta(Arreglo[0]) + "\n" + "CODOP = " + vCODOP(Arreglo[1]) + "\n" + "OPERANDO = " + vOperando(Arreglo[2])+"\n"); 
            }
            
        }
        
    }
    
    
    /*Metodo que determina si la entrada es un comentario*/
    private void vComentario (String comentario){
            if(comentario.charAt(0) == ';' && comentario.length() < 80){
                System.out.println("Comentario");
                
            }
        
       
    }
    
    /*Metodo para validar la etiqueta*/
    private String vEtiqueta(String etiqueta)
    {
        if (etiqueta.charAt(0) < 65 || etiqueta.charAt(0) > 122)
            return etiqueta + " -> ERROR: La etiqueta debe de comenzar con una letra";
        if (etiqueta.length() > 8)
            return etiqueta + " -> ERROR: El tamaño de la etiqueta debe ser menor o igual a 8";
        for (int i = 0; i < etiqueta.length(); i++)
        {
            if (etiqueta.charAt(i) != '_' && (etiqueta.charAt(i) < 48 || etiqueta.charAt(i) > 57) && (etiqueta.charAt(i) < 65 || etiqueta.charAt(i) > 122))
            {
                return etiqueta + " -> ERROR: La etiqueta no puede contener caracteres no alfanuméricos";
            }
        }
        return etiqueta;
    }

    /*Metodo para validar el Codigo de operacion*/
    private String vCODOP(String codop)
    {
        if (codop.charAt(0) < 65 || codop.charAt(0) > 122)
            return codop + " -> ERROR: El CODOP debe de comenzar con una letra";
        if (codop.length() > 5)
            return codop + " -> ERROR: El tamaño del CODOP debe ser menor o igual a 5";
        int pointCount = 0;
        for (int i = 0; i < codop.length(); i++)
        {
            if (codop.charAt(i) == '.')
            {
                pointCount++;
            }
            if (codop.charAt(i) != '.' && (codop.charAt(i) < 65 || codop.charAt(i) > 122) || pointCount > 1)
            {
                return codop + " -> ERROR: El CODOP solo puede contener letras y un máximo de un punto";
            }
        }
        return codop;
    }

    /**Método que nos devuelve el operando*/
    private String vOperando(String operando)
    {
        return operando;
    }
    
    
    
   
    
}
