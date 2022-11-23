
import java.util.LinkedList;
import java.util.Queue;
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
public class ArbolBin {
    Nodo root;
   //Metodo constructor de un árbol binario vacío 
    public ArbolBin(){
        root=null;
    }
    //Método constructor de un árbol binario que construye el nodo raiz a partir de un valor entero
    public ArbolBin(int val){
        root=new Nodo(val);
    }
    //Método constructor de un árbol binario que recibe como parámetro el nodo raíz 
    public ArbolBin(Nodo root){
        this.root=root;
    }
    //Método para determinar la relación de herencia entre los nodos del árbol binario
    public void add(Nodo padre, Nodo hijo, int lado){
	if(lado==0)
            padre.setIzq(hijo);//instauración del nodo hijo izquierdo
	else
            padre.setDer(hijo);//instauración del nodo hijo derecho
    }
    //método que recibe como parámetro un objeto tipo nodo e imprime el valor de su clave
    protected void visit(Nodo n){
        System.out.println(n.valor+" ");
    }	
    //método para recorrer el grafo por niveles 
    public void breadthFrist(){
        Nodo r = root;
	Queue<Nodo> queue = new LinkedList();
        //condicion para asegurarse de que el grafo no esté vacío
	if(r!=null){
            queue.add(r);
            //ciclo que trabajará mientras la lista ligada contenga elementos 
            while(!queue.isEmpty()){
                //método que extrae el primer nodo de la queue
                r =(Nodo)queue.poll();
                //invocación del método visit para imprimir el valor del nodo actual
		visit(r);
                //condicionales que añaden a los hijos izquierdo y derecho a la queue
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
                    queue.add(r.der);
            }
	}
    }
    //Funcion para ir recorriendo los valores de los nodos hijos hacia el nodo padre
    public Nodo recorrer(Nodo r){
        //condicion para considerar que el nodo r tiene un hijo izquierdo
        if(r.izq!=null){
            r.valor=r.izq.valor;//reemplazo del valor del nodo r por el valor de su hijo
            if(r.izq!=null && r.izq.izq==null && r.izq.der==null){//condicion al llegar a un nodo hoja
                r.izq=null;
            }
           return r.izq;
        }
        //condicion que considera que el hijo izquierdo no existe y el hijo derecho sí
        if(r.izq==null && r.der!=null){
            r.valor=r.der.valor;//reemplazo del valor de r por el hijo derecho
            if(r.der!=null  && r.der.der==null && r.der.izq==null){//condicion al llegar a un nodo hoja
                r.der=null;
            }
            return r.der;
        }
    r=null;
    return r;
    }
    public void eliminar(){
        System.out.println("Ingrese el valor del nodo que desea eliminar");
        Scanner n= new Scanner(System.in);
        int busca=n.nextInt();
        Nodo r = root;
	Queue<Nodo> queue = new LinkedList();
        //condicion para asegurarse de que el grafo no esté vacío
	if(r!=null){
            queue.add(r);
            //ciclo que trabajará mientras la lista ligada contenga elementos 
            while(!queue.isEmpty()){
                //método que extrae el primer nodo de la queue
                r =(Nodo)queue.poll();
                //condicional que se cumple cuando el número buscado coincide con el valor del nodo analizado
                if(busca==r.valor){
                    System.out.println("El valor "+busca +" se eliminará del arbol");
                    Nodo a=new Nodo();
                    a=r;
                    while(a!= null){
                        a=recorrer(a);//funcion que recorre los nodos y va intercambiando sus valores
                    }
                    break;
                }
                //condiciones para realizar la búsqueda del valor en todos los nodos del árbol
                if(r.izq!=null){
                    queue.add(r.izq);
                }
                if(r.der!=null){
                    queue.add(r.der);
                }
                //Condiciones para eliminar los valores de nodos hoja a partir de sus nodos padres
                if(r.izq!=null && busca ==r.izq.valor && r.izq.izq==null && r.izq.der==null){
                    System.out.println("El valor "+busca +" se eliminará del arbol");
                    r.izq=null;
                    break; 
                }
                if(r.der!=null && busca ==r.der.valor && r.der.der==null && r.der.izq==null){
                    System.out.println("El valor "+busca +" se eliminará del arbol");
                    r.der=null;
                    break; 
                }
                if(queue.isEmpty()){
                    System.out.println("El valor a eliminar no existe");
                }
            }
        }
        else{
        System.out.println("El arbol esta vacio, no se puede realizar la busqueda");
        }
    }
    public Nodo buscar(){
        System.out.println("Ingrese el valor del nodo que desea buscar");
        Scanner n= new Scanner(System.in);
        int busca=n.nextInt();
        Nodo r = root;
	Queue<Nodo> queue = new LinkedList();
        //condicion para asegurarse de que el grafo no esté vacío
	if(r!=null){
            queue.add(r);
            //ciclo que trabajará mientras la lista ligada contenga elementos 
            while(!queue.isEmpty()){
                //método que extrae el primer nodo de la queue
                r =(Nodo)queue.poll();
                if(busca==r.valor){
                    System.out.println("El valor si se encuentra en el arbol");
                    System.out.println("Los valores de los hijos del nodo seleccionado son: ");
                    if(r.izq==null&&r.der!=null){
                        System.out.println("Hijo izquierdo: "+r.izq);
                        System.out.println("Hijo derecho: "+r.der.valor);
                    }
                    if(r.der==null&&r.izq!= null){
                        System.out.println("Hijo izquierdo: "+r.izq.valor);
                        System.out.println("Hijo derecho: "+r.der);
                    }
                    if(r.der==null && r.izq==null){
                        System.out.println("Hijo izquierdo: "+r.izq);
                        System.out.println("Hijo derecho: "+r.der);
                    }
                    if(r.der!=null && r.izq!=null){
                    System.out.println("Hijo izquierdo: "+r.izq.valor);
                    System.out.println("Hijo derecho: "+r.der.valor);
                    }
                    return r;
                }
                if(r.izq!=null){
                    queue.add(r.izq);
                }
                if(r.der!=null){
                    queue.add(r.der);
                }
                if(queue.isEmpty()){
                    System.out.println("El valor buscado no se encuentra");
                }
            }
        }
        else{
        System.out.println("El arbol esta vacio, no se puede realizar la busqueda");
        }
      r=null;
      return r;
    }
    public void prefija(Nodo r){ 
        //condicion para asegurarse de que el grafo no esté vacío
	if(r!=null){
            //inpresion del nodo actual
            visit(r);
            //recursividad para el subárbol izquierdo
            prefija(r.izq);
            //recursividad para el árbol derecho
            prefija(r.der);
        }
        else{
            return;  
        }
    }
    public void infija(Nodo r){
        //condicion para asegurarse de que el grafo no esté vacío
	if(r!=null){
            //recursividad para el subárbol izquierdo
            infija(r.izq);
            //inpresion del nodo actual
            visit(r);
            //recursividad para el árbol derecho
            infija(r.der);
        }
        else{
            return;  
        }
    }
    public void posfija(Nodo r){
        //condicion para asegurarse de que el grafo no esté vacío
	if(r!=null){
            //recursividad para el subárbol izquierdo
            posfija(r.izq);
            //recursividad para el árbol derecho
            posfija(r.der);
            //inpresion del nodo actual
            visit(r);
        }
        else{
            return;  
        }
    }
}
