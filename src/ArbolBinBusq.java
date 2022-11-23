
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
 * @author Lupita
 */
public class ArbolBinBusq extends ArbolBin{
    Nodo root;
   //Metodo constructor de un árbol binario vacío 
    public ArbolBinBusq(){
        root=null;
    }
    //Método constructor de un árbol binario que construye el nodo raiz a partir de un valor entero
    public ArbolBinBusq(int val){
        root=new Nodo(val);
    }
    //Método constructor de un árbol binario que recibe como parámetro el nodo raíz 
    public ArbolBinBusq(Nodo root){
        this.root=root;
    }
    //funcion para añadir un nuevo nodo con un valor ingresado por el usuario
    void add(int val){
        root=insertar(root,val);
        }
    //Método para determinar la relación de herencia entre los nodos del árbol binario
    public Nodo insertar(Nodo raiz,int hijo){
	
        if(raiz==null){//condicional para crear un nodo raiz en caso de que el árbol esté vacío
            root=new Nodo (hijo);
            return raiz;
        }
        if(hijo<raiz.valor){
            //condicion para insertar un nodo hijo izquierdo si éste está vacío
            if(raiz.izq==null){
                Nodo n=new Nodo(hijo);
                raiz.setIzq(n);//instauración del nodo hijo izquierdo  
                return raiz;
            }
            raiz.izq=insertar(raiz.izq,hijo);//Uso de la recursividad para avanzar en los valores del subárbol izquierdo
        }
           
        else if(hijo>raiz.valor){
             //condicion para insertar un nodo hijo derecho si éste está vacío
            if(raiz.der==null){
                Nodo n=new Nodo(hijo);
                raiz.setDer(n);  //instauración del nodo hijo derecho
                return raiz;
            }
            raiz.der= insertar(raiz.der,hijo);//Uso de la recursividad para avanzar en los valores del subárbol derecho
        }
        return raiz;
    }
    public void breadthFrist(Nodo r){
        
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
    //metodo que recibe el nodo raiz y devuelve los nodos hijos de dicho nodo
    public Nodo minimoNodo(Nodo raiz){
        if(raiz.izq==null){
            return raiz;
        }
        else{
            return minimoNodo(raiz.izq);
        }
    }
    public Nodo maximoNodo(Nodo raiz){
        if(raiz.der==null){
            return raiz;
        }
        else{
            return maximoNodo(raiz.der);
        }
    }
    //Funcion para eliminar el nodo hoja del subarbol izquierdo que reemplaza al nodo raiz
    public Nodo recorroMax(Nodo a){
        if(a.der.der==null){
            a.der=null;
            return a;
        }
        else{
            return recorroMax(a.der);
        }
    }
    //Funcion para eliminar el nodo hoja del subarbol derecho que reemplaza al nodo raiz
   
    public Nodo recorroMin(Nodo a){
        if(a.izq.izq==null){
            a.izq=null;
            return a;
        }
        else{
            return recorroMin(a.izq);
        }
    }
    //método que recibe un nodo raiz y un 
    public Nodo eliminar(Nodo n, int val){
        //Condicional que regresa un valor nulo en caso de que el nodo raiz no exista
        if(n==null){
        return null;
        }
        //Condicional que se cumple si el valor buscado es mayor que el valor del nodo
        if(val<n.valor){
            n.izq=eliminar(n.izq,val);
        }
        //Condicional en caso de que el valor buscado sea mayor que el valor del nodo
        else if(val>n.valor){
            n.der=eliminar(n.der,val);
        }
         else{
            //condicional para eliminar la raiz del arbol
            if(n.valor==root.valor){
                Nodo e=root;
                //condicional para obtener el valor maximo del subarbol izquierdo
                if(n.izq!=null&&n.der==null){
                    e=maximoNodo(root.izq);
                    root.valor=e.valor;
                    recorroMax(root.izq);
                    
                }
            ///condicional para obtener el valor minimo del subarbol derecho
                else if(n.der!=null&&n.izq==null){
                    e=minimoNodo(root.der);
                    root.valor=e.valor;
                    recorroMin(root.der);
                }
                
            }
            //Caso que se cumple si el nodo a eliminar tiene dos hijos
            else if(n.izq != null && n.der!=null){
                
                Nodo a=n;
                //Para encontrar el maximo elemento en el subarbol izquierdo
                Nodo maxIzq=maximoNodo(a.izq);
                //reemplazo del nodo actual con el maximo nodo del subarbol izquierdo
                n.valor=maxIzq.valor;
                //Eliminando el nodo que acaba de ser reemplazado
                n.izq=eliminar(n.izq,maxIzq.valor);
            }
            //si el nodo a eliminar tiene solo un hijo izquierdo
            else if(n.izq!=null){
                n=n.izq;
            }
            //Si el nodo a eliminar tiene solo un hijo derecho
            else if(n.der!=null){
                n=n.der;
            }
            //condicion para eliminar nodos hoja
            else{
                n=null;
            }
            
        }
        return n;
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
   
}