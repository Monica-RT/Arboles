
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class Pruebas {
    
    public static void main(String args[]){
        ArbolBin arbol;//declaración de un objeto de tipo albol binario
        //Instanciación de objetos tipo nodo que reciben como parámetro
        //su valor correspondiente
        Nodo n =new Nodo();
        Nodo n7 = new Nodo(7);
        Nodo n9 = new Nodo(9);
        Nodo n1 = new Nodo(1,n7,n9);
        Nodo n15 = new Nodo(15);
        Nodo n8 = new Nodo(8);
        Nodo n4 = new Nodo(4);
        Nodo n2 = new Nodo(2);
        Nodo n16 = new Nodo(16);
        Nodo n3 = new Nodo(3);
        //inicialización de objeto de tipo ArbolBin
        arbol = new ArbolBin(n1);
        //Establecimiento del orden jerarquico del arbol binario
        arbol.add(n7,n15,0);
        arbol.add(n7,n8,1);
        arbol.add(n9,n4,0);
        arbol.add(n9,n2,1);
        arbol.add(n15,n16,1);
        arbol.add(n8,n3,0);
        //Recorrido del grafo por método BFS
       // arbol.breadthFrist();
        //Metodo de busqueda
        //arbol.buscar();
        //Metodo de eliminacion
        //arbol.eliminar();
        //arbol.breadthFrist();
        //Recorrido en preorden con notacion prefija
        /*System.out.println("La notación prefija es ");
        arbol.prefija(n1);*/
        //Recorrido en inorden con notacion infija
        //System.out.println("La notación infija es ");
        //arbol.infija(n7);
        //Recorrido en postorden con notacion posfija
        /*System.out.println("La notación posfija es ");
        arbol.posfija(n1);
        */
        /*
        ArbolBinBusq abb = new ArbolBinBusq(1);
        
        abb.add(7);
        abb.add(5);
        abb.add(9);
        abb.add(15);
        abb.add(8);
        abb.add(4);
        abb.add(2);
        abb.add(6);
        
        abb.breadthFrist(abb.root);
        System.out.println("Ingrese el valor del nodo que desea eliminar");
        Scanner nodo= new Scanner(System.in);
        int busca=nodo.nextInt();
        Nodo a;
        a=abb.eliminar(abb.root, busca);
        if(a==null){
        }else{
        System.out.println("El nodo "+busca+" sera eliminado si se encuentra en el arbol");
        }
        System.out.println("El arbol es: ");
        abb.breadthFrist(abb.root);*/
        Utilidades m =new Utilidades();
        m.menu();
    }

    
}
