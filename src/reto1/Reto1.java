/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto1;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author cerpa
 */
public class Reto1 {

    /**
     * @param args the command line arguments
     */
     String txtauxiliar;
    ArrayList<String> lineasTextoIn =new ArrayList<String>();
    
    public static void main(String[] args) throws IOException  {
        // TODO code application logic here
     int valormedio;
     boolean estadopar;
    Reto1 Inicio =new Reto1();
   
    int intReto =  Inicio.introducirReto();
    if (intReto==1)
    {
         int intAltura =  Inicio.introducirAltura();
    int intAncho  =  Inicio.introducirAncho();
    int menor =0;
    int mayor =0;
    valormedio =intAncho/2;
    if(intAltura<intAncho)
    {
        menor=intAltura;
        mayor=intAncho;
    }
    else
    {
        menor=intAncho;
        mayor=intAltura;
    }
    int cantidadnumero=0;
    if(menor%2==0)
    {
     cantidadnumero=menor/2;
    }
    else
    {
     cantidadnumero=(menor/2)+1;   
    }
    
        ArrayList<Integer> colNumeber =new ArrayList<Integer>();
        for (int i = 0; i < cantidadnumero; i++) {
            colNumeber.add(mayor-i);
        }
        System.err.println(colNumeber.toString());
        
        System.out.println("valor medio : " +valormedio);
        int posx=0;
        int posy=0;
     
        
        Hashtable<Integer,Integer> listaX =new Hashtable<Integer,Integer>();
        Hashtable<Integer,Integer> listaY =new Hashtable<Integer,Integer>();
        for (int i = 0; i < colNumeber.size(); i++) {
            listaY.put(posy+i,colNumeber.get(i));
            listaX.put(posx+i,colNumeber.get(i));
            System.out.println((posy+i)+","+(posx+i)+"="+colNumeber.get(i));
        }
        for (int j = 0; j < colNumeber.size(); j++) {
           // valordto.setPosion(posx+i, colNumeber.get(i).toString());
            listaY.put(intAltura-(j+1),colNumeber.get(j));
            listaX.put(intAncho-(j+1),colNumeber.get(j));
            System.out.println((intAltura-(j+1))+","+(intAncho-(j+1))+" = "+colNumeber.get(j));
        }
        for (int x = 0; x < intAltura; x++) {
            for (int y = 0; y <intAncho ; y++) {
            if(listaX.get(y)==null)
            {
                System.out.print(listaY.get(x));
                continue;
            }
            if(listaY.get(x)==null)
            {
                System.out.print(listaX.get(y));
                continue;
            }
            if (listaX.get(y)<listaY.get(x))
                System.out.print(listaY.get(x));
            else
                System.out.print(listaX.get(y));
            }
            System.out.println("");
            
        }
        Inicio.main(args);
    }
    if (intReto==2)
    {
        ArrayList<String> textoIn=new ArrayList<>();
        ArrayList<String> textoOn=new ArrayList<>();
        Hashtable<Integer,Integer> intSpace=new Hashtable<Integer,Integer>();
        int mayorCatidadChar=0;
        int contLinea=0;
        textoIn=Inicio.introducirTexto();
        System.out.println("Jutificar Texto : ");
        for (String line :  textoIn) {
            contLinea=contLinea+1;
                     
            if (mayorCatidadChar<line.length())
                mayorCatidadChar=line.length();
            int contarspace=0;
            for (int n=0; n <line.length(); n++)
            {     
                  if(line.charAt(n)==' ')
                  {
                      contarspace=contarspace+1;
                  }
            }
            intSpace.put(contLinea,contarspace);
        }
        
        int contarLine2=0;
         for (String line :  textoIn) {
             contarLine2=contarLine2+1;
            // if(intSpace.get(contarLine2)){} 
             if (line.length()<mayorCatidadChar) {
                  int difresta=mayorCatidadChar-line.length();
                 // System.out.println("linea "+contarLine2 +"  diferencia:"+difresta+"  catidad de espacios"+intSpace.get(contarLine2));
                     
                  if (difresta<=intSpace.get(contarLine2))
                  {
                     textoOn.add(Inicio.Calcularspace(line,difresta));
                  }
                  else
                  {
                    textoOn.add(line); 
                  }
             }
             else
             {
                   textoOn.add(line); 
             }
        }
        for (String result : textoOn) {
        System.out.println(result);
        }
        Inicio.main(args);
    } 
   
    }
    public int introducirAncho()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introducir Ancho: ");
        try {
            String txtAncho = reader.readLine();
            try{
           return Integer.parseInt(txtAncho);
            }
            catch(Exception e)
            {
            System.out.print("Por favor Ingrese un numero entero");  
            introducirAncho();
            }
        } 
        catch (IOException e) {
       System.out.print("Por favor Ingrese un numero entero");  
            introducirAncho();
        }
        return  0;
    }
    
 public int introducirAltura()
 {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introducir Altura: ");
        try {
            String txtAltura = reader.readLine();
            try{
           
            return Integer.parseInt(txtAltura);
            
            }catch(Exception e)
            {
            System.out.println("Por favor Ingrese un numero entero");       
            introducirAltura();
            }
        } 
        catch (IOException e) {
            System.out.println("Por favor Ingrese un numero entero");     
            introducirAltura();
        }
        return 0;
 }
 public ArrayList<String> introducirTexto() throws IOException 
 {
    Scanner scanner = new Scanner (System.in);
    System.out.println("Introducir Texto: "); 
    String leerTexto = scanner.nextLine();
    lineasTextoIn.add(leerTexto);
    while(leerTexto!=null) {
        //System.out.println(leerTexto);

        if (leerTexto.isEmpty()) {
            System.out.println("Read Enter Key.");
            System.out.println("---------------------------------------------");
                 return lineasTextoIn;
        }

        if (scanner.hasNextLine()) {
            leerTexto = scanner.nextLine();
            lineasTextoIn.add(leerTexto);
        } else {
            leerTexto = null;
        }
    }
    return  null;
 }
 public int introducirReto()
 {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("============================================="); 
       System.out.println("Introducir Reto(solo hay opcion 1 y 2 ): ");
       System.out.println("=============================================");
        try {
            String txtReto = reader.readLine();
            try{
           
            return Integer.parseInt(txtReto);
            
            }catch(Exception e)
            {
            System.out.println("Por favor Ingrese un numero Reto correcto las opciones es 1 o 2");       
            introducirReto();
            }
        } 
        catch (IOException e) {
            System.out.println("Por favor Ingrese un numero entero");     
            introducirReto();
        }
        return 0;
 }
 //dife 1 si la diferencia es mayor a los epacios en blanco
 //dife 2 si la diferencia es maenor a los epacios en blanco
 public String Calcularspace(String line,int difspace)
    {
                StringBuilder sb = new StringBuilder(line); 
                int contadorspaciotexto =0;
                if(difspace!=0){
                          for (int i = 0; i <line.length(); i++) {
                                                        
                                if(line.charAt(i)==' ')
                                {
                                    contadorspaciotexto=contadorspaciotexto+1;
                                    if(contadorspaciotexto<=difspace)
                                        sb.replace(i, i, " ");
                                    else
                                    break;
                                }
                         }
                }
                
         return sb.toString();
    }
}
