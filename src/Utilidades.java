
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lupita
 */
public class Utilidades {
    static Scanner stdin = new Scanner(System.in);
    static int opc = -1;
    ArbolBin arbolA;
    static ArbolBinBusq arbolB;
    BTree arbolC;
    public void menu(){
         while(opc!=0){
            try{
                System.out.println(" Seleccione la opcion deseada ");
                System.out.println(" 1. Arboles binarios ");
                System.out.println(" 2. Arboles binarios de busqueda ");
                System.out.println(" 3. Arboles B ");
                System.out.println(" 0. Salir ");
                int p = stdin.nextInt();
                switch(p){
                    case 1:
                        subMenu1(arbolA);
                        break;
                    case 2: 
                        subMenu2(arbolB);
                        break;
                    case 3: 
                        subMenu3(arbolC);
                        break;
                    case 0: 
                        System.out.println("Saliendo... Muchas gracias, regrese pronto. ");
                        opc=0;
                        break;
                    default:
                         System.out.println("Ups, opción inválida, intente nuevamente ");
                         break;
                }
            }catch(InputMismatchException e){
                System.out.println(" Ups, opción inválida ");
                stdin.next();
            }
         }
    }
    public void subMenu1(ArbolBin arbolA){
        int oc=-1;
        int opt=0;
        while(oc!=0){
            try{
                System.out.println(" Seleccione la accion a realizar ");
                System.out.println(" 1. Crear Arbol ");
                System.out.println(" 2. Agregar dato ");
                System.out.println(" 3. Eliminar Dato ");
                System.out.println(" 4. Imprimir Arbol (BFS) ");
                System.out.println(" 5. Notacion Prefija (Preorden) ");
                System.out.println(" 6. Notacion Infija (Inorden) ");
                System.out.println(" 7. Notacion Posfija (Postorden) ");
                System.out.println(" 0. Regresar ");
                opt = stdin.nextInt();
                switch(opt){
                    case 1:
                        System.out.println("Ingrese el valor deseado para el nodo raiz ");
                        Scanner clave= new Scanner(System.in);
                        int val=clave.nextInt();
                        arbolA=new ArbolBin(val);
                        break;
                    case 2: 
                        if(arbolA==null){
                            System.out.println("El arbol no existe cree uno");
                        }
                        else{
                            System.out.println("Ingrese el valor deseado para nuevo nodo ");
                            Scanner nodo= new Scanner(System.in);
                            int nval=nodo.nextInt();
                            Nodo nhijo=new Nodo(nval);                            
                            Nodo npadre =new Nodo();
                            System.out.println("Ingrese el valor del nodo padre ");
                            npadre=arbolA.buscar();
                            if(npadre==null){
                                System.out.println("El nodo no existe intente nuevamente ");
                            }
                            else{
                                System.out.println("Ingrese el lugar que desea que tome el nuevo nodo ");
                                System.out.println("0 .-Hijo izquierdo");
                                System.out.println("1 .-Hijo derecho ");
                                Scanner hijo= new Scanner(System.in);
                                int hijoVal=hijo.nextInt();
                                arbolA.add(npadre,nhijo,hijoVal);
                            }
                        }
                        break;
                    case 3:
                        if(arbolA==null){
                            System.out.println("El arbol esta vacio");
                        }
                        else{
                        arbolA.eliminar();
                        }
                        break;
                    case 4:
                        if(arbolA==null){
                            System.out.println("El arbol esta vacio");
                        }
                        else{
                            System.out.println("El arbol es:");
                            arbolA.breadthFrist();            
                        }
                        break;
                    case 5:
                        if(arbolA==null){
                            System.out.println("El arbol esta vacio");
                        }
                        else{
                            System.out.println("La notación prefija es ");
                            arbolA.prefija(arbolA.root);
                        }
                        break;
                    case 6:
                        if(arbolA==null){
                            System.out.println("El arbol esta vacio");
                        }
                        else{
                            System.out.println("La notación infija es ");
                            arbolA.infija(arbolA.root);
                        }
                        break;
                    case 7:
                        if(arbolA==null){
                            System.out.println("El arbol esta vacio");
                        }
                        else{
                            System.out.println("La notación postfija es ");
                            arbolA.posfija(arbolA.root);
                        }
                        break;
                    case 0: 
                        System.out.println(" Regresando al menú anterior... ");
                        
                        oc=0;
                        break;
                    default:
                         System.out.println("Ups, opción inválida, intente nuevamente ");
                         break;
                }
            }catch(InputMismatchException e){
                System.out.println(" Ups, opción inválida ");
                stdin.next();
            }
        }
    }
    public void subMenu2(ArbolBinBusq arbolB){
        int oc=-1;
        int opt=0;
        while(oc!=0){
            try{
                System.out.println(" Seleccione la accion a realizar ");
                System.out.println(" 1. Crear Arbol ");
                System.out.println(" 2. Agregar dato ");
                System.out.println(" 3. Eliminar Dato ");
                System.out.println(" 4. Buscar ");    
                System.out.println(" 5. Imprimir Arbol(BFS) ");
                System.out.println(" 0. Regresar ");
                opt = stdin.nextInt();
                switch(opt){
                    case 1:
                        System.out.println("Ingrese el valor deseado para el nodo raiz ");
                        Scanner clave= new Scanner(System.in);
                        int val=clave.nextInt();
                        arbolB = new ArbolBinBusq(val);
                        break;
                    case 2: 
                        if(arbolB==null){
                            System.out.println("El arbol no existe cree uno");
                        }
                        else{
                            System.out.println("Ingrese el valor deseado para nuevo nodo ");
                            Scanner nodo= new Scanner(System.in);
                            int nval=nodo.nextInt();
                            arbolB.add(nval);
                        }
                        break;
                    case 3:
                        if(arbolB==null){
                            System.out.println("El arbol esta vacio");
                        }
                        else{
                            System.out.println("Ingrese el valor del nodo que desea eliminar");
                            Scanner nodo= new Scanner(System.in);
                            int busca=nodo.nextInt();
                            Nodo a;
                            a=arbolB.eliminar(arbolB.root, busca);
                            if(a==null){
                            }
                            else{
                                System.out.println("El nodo "+busca+" sera eliminado si se encuentra en el arbol");
                            }
                        }
                        break;
                    case 4:
                        if(arbolB==null){
                            System.out.println("El arbol esta vacio");
                        }
                        else{
                            arbolB.buscar();
                        }
                        break;
                    case 5:
                        if(arbolB==null){
                            System.out.println("El arbol esta vacio");
                        }
                        else{
                            System.out.println("El arbol es: ");
                            arbolB.breadthFrist(arbolB.root);
                        }
                        break;
                    case 0: 
                        System.out.println(" Regresando al menú anterior... ");
                        
                        oc=0;
                        break;
                    default:
                         System.out.println("Ups, opción inválida, intente nuevamente ");
                         break;
                }
            }catch(InputMismatchException e){
                System.out.println(" Ups, opción inválida ");
                stdin.next();
            }
        }
    }
    public void subMenu3(BTree arbolC){
        int oc=-1;
        int opt=0;
        while(oc!=0){
            try{
                System.out.println(" Seleccione la accion a realizar ");
                System.out.println(" 1. Crear Arbol ");
                System.out.println(" 2. Agregar un valor ");
                System.out.println(" 3. Buscar valor");    
                System.out.println(" 4. Imprimir Arbol");
                System.out.println(" 0. Regresar ");
                opt = stdin.nextInt();
                switch(opt){
                    case 1:
                        System.out.println("Ingrese el nivel del arbol ");
                        Scanner niv= new Scanner(System.in);
                        int nivel=niv.nextInt();
                        arbolC=new BTree(nivel);
                        ArrayList<Integer> list=new ArrayList<>();
                        int i=0;
                        for(i=0;i<nivel;i++){
                            System.out.println("Ingrese el valor deseado para el nodo raiz ");
                            Scanner clave= new Scanner(System.in);
                            int val=clave.nextInt();
                            list.add(val);
                       }
                            arbolC.root.setKeys(list);
                        break;
                    case 2: 
                        if(arbolC==null){
                            System.out.println("El arbol no existe cree uno");
                        }
                        else{
                            System.out.println("Ingrese el valor deseado para nuevo nodo ");
                            Scanner nodo= new Scanner(System.in);
                            int nval=nodo.nextInt();
                            arbolC.add(nval);
                            
                        }
                        break;
                    case 3:
                        if(arbolC==null){
                            System.out.println("El arbol esta vacio");
                        }
                        else{
                            System.out.println("Ingrese el valor del nodo que desea buscar");
                            Scanner nodo= new Scanner(System.in);
                            int busca=nodo.nextInt();
                            boolean encontrado;
                            encontrado=arbolC.find(busca);
                            if(encontrado==true){
                                System.out.println("El valor "+busca+" se encuentra en el arbol");
                            
                            }
                            else{
                                System.out.println("El valor "+busca+" NO se encuentra en el arbol");
                            }
                        }
                        break;
                    case 4:
                        if(arbolC==null){
                            System.out.println("El arbol esta vacio");
                        }
                        else{
                            System.out.println("El arbol es");
                            //Scanner nodo= new Scanner(System.in);
                            //int busca=nodo.nextInt();
                            arbolC.mostrarArbol();
                        }
                        break;
                    case 0: 
                        System.out.println(" Regresando al menú anterior... ");
                        
                        oc=0;
                        break;
                    default:
                         System.out.println("Ups, opción inválida, intente nuevamente ");
                         break;
                }
            }catch(InputMismatchException e){
                System.out.println(" Ups, opción inválida ");
                stdin.next();
            }
        }
    }
}
