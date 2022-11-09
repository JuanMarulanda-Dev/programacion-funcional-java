package com.platzi.functional;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Lista<Integer> mainList = new Lista();
        mainList.addFirst(1);
        mainList.addFirst(2);
        mainList.addFirst(3);
        mainList.addLast(4);
        mainList.addLast(5);
        mainList.reverse();

        mainList.delete(4);
        mainList.delete(2);

        System.out.println("Listar Elementos");
        mainList.list();


        //--------

    }
}

class Nodo<T> {
    private T element;
    private Nodo next;

    public Nodo(T element, Nodo next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}

class Lista<T> {
    private Nodo first;
    private int count;

    public Lista() {
        first = null;
        count = 0;
    }

    public void addFirst(T element){
        first = new Nodo<T>(element, first);
        count++;
    }

    public void addLast(T element){
        Nodo newNodo = new Nodo(element, null);
        if(first == null){
            first = newNodo;
        }else{
            Nodo current = this.first;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNodo);
        }
        count++;
    }

    public void delete(T element){
        if(first == null){
            System.out.println("La lista esta vacia");
            return;
        }

        if(first.getElement() == element){
            first = first.getNext();
            count--;
            return;
        }

        Nodo current = first;
        Nodo before;
        while (current.getNext() != null){
            before = current;
            current = current.getNext();

            if(current.getNext() == null && current.getElement() != element){
                System.out.println("El valor no existe");
                return;
            }

            if(current.getElement() == element) {
                current = before;
                before.setNext(current.getNext().getNext());
                count--;
                return;
            }

        }
    }

    public void list() {
        Nodo current = first;
        while (current.getNext() != null){
            System.out.println(current.getElement());
            current = current.getNext();
        }
        System.out.println(current.getElement());
    }

    public void reverse() {
        Nodo current = first;
        Nodo newFirst = null;
        while (current.getNext() != null){
            newFirst = new Nodo((T) current.getElement() , newFirst);
            current = current.getNext();
        }
        newFirst = new Nodo((T) current.getElement() , newFirst);
        first = newFirst;
    }

}
