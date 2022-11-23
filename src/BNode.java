

import java.util.ArrayList;

public class BNode {
    static int m;
    ArrayList<Integer> key;//Arreglo de enteros que representa las claves
    ArrayList<BNode> child;//arreglo de objetod BNode que representa los hijos 
    BNode parent;//nodo padre
    boolean leaf;//indicacion de si es nodo hoja o no
    //metodo constructor
    public BNode() {
        key = new ArrayList();
        child = new ArrayList();
        leaf = true;
        parent = null;
    }
    //Metodo para acceder al valor de un indice específico
    public int getKey( int i ){
        return this.key.get(i);
    }
    //metodo para acceder a un nodo hijo
    public BNode getChild( int i ){
        try{
            this.child.get(i);
        }catch(Exception e){
            return null;
        }
        return this.child.get(i);
    }
    //metodo para poner el valor del nivel del arbol
    public void setM( int m ){
        this.m = m;
    }
    //metodo para ingresar las claves del nodo 
    public void setKeys( ArrayList<Integer> list ){
        this.key = list;
    }
    //metodo para establecer los nodos hijos a través de un arraylist de nodos 
    public void setChildren( ArrayList<BNode> list  ){
        this.child = list;
    }
    //metodo para obtener los índices de los nodos hijos,
    public int getChildIndex(){
        if( parent == null ){
            return -1;
        }
        else{
            BNode padre = parent;
            for( int i = 0 ; i < padre.child.size() ; i++ ){
                if( padre.child.get(i) == this )
                    return i;
            }     
            return -1;
        }
    }
    //método para imprimir todos los valores de las claves del nodo.
    public void mostrarLlaves(){
        for( int i = 0 ; i < key.size() ; i++ )
            System.out.print( key.get(i) + " " );
    }
   
    
    
    
}
