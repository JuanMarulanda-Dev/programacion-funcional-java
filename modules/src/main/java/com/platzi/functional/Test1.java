package com.platzi.functional;

public class Test1 {
    public static void main(String[] args) {
        Lista<Integer> lista = new Lista<>();
        lista.addFirst(1);
        lista.addFirst(2);
        lista.addFirst(3);
        lista.addLast(4);
        lista.reverse();
        lista.list();
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

    class lista<T> {
        private Nodo first;

        public void addFirst(T element){
            first = new Nodo(element, first);
        }

        public void addLast(T element) {
            Nodo current = first;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(new Nodo(element, null));

        }

        public void reverse() {
            Nodo current = first;
            Nodo newNodo = null;
            while (current.getNext() != null) {
                current = current.getNext();
                newNodo = new Nodo(current.getElement(), newNodo);
            }
            newNodo = new Nodo(current.getElement(), newNodo);
            first = newNodo;
        }

        public void list(){
            Nodo current = first;
            while (current.getNext() != null){
                System.out.println(current.getElement());
                current = current.getNext();
            }
            System.out.println(current.getElement());
        }

    }
}
