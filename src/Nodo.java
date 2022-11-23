/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class Nodo {
    
    int valor;
    Nodo izq = null;
    Nodo der = null;
    //Uso de sobrecarga de métodos para el método constructor de la clase 
    //Metodo constructor que crea un objeto Nodo vacío 
    public Nodo(){
        izq=der=null;
    }
    //metodo constructor que crea un objeto Nodo con una clave de tipo entero
    public Nodo(int data){
        this(data,null,null);
    }
    //Metodo constructor que crea un ojeto Nodo con una clave de tipo entero
    //y que adicionalmente recibe como parametro los nodos hijos derecho e izquierdo
    public Nodo(int data, Nodo lt, Nodo rt){
        valor=data;
        izq = lt;
        der = rt;
    }   
    //método setter para agregar un nodo hijo izquierdo
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    //método setter para agregar un nodo hijo derecho
    public void setDer(Nodo der) {
        this.der = der;
    }
    /*public void eliminarNodo(Nodo a){
        //a= new Nodo();
        //a=null;
    }
    */
}
