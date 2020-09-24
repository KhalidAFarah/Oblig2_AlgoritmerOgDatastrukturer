package no.oslomet.cs.algdat;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;



public class DobbeltLenketListe<T> implements Liste<T> {


    public static void main(String[] args){
        String[] strings = {"kd","pe", "dt"};
        DobbeltLenketListe<String> liste = new DobbeltLenketListe<>(strings);
        System.out.println(liste.antall() + " " + liste.tom());
        // Utskrift: 3 false


        System.out.println(liste);
        System.out.println(liste.omvendtString());

        String[] s1 = {}, s2 = {"A"}, s3 = {null,"A",null,"B",null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);
        System.out.println(l1.toString() + " " + l2.toString()
                + " " + l3.toString() + " " + l1.omvendtString() + " "
                + l2.omvendtString() + " " + l3.omvendtString());
        // Utskrift: [] [A] [A, B] [] [A] [B, A]

        l2.leggInn("A");
        l3.leggInn("C");
        System.out.println(l1.toString() + " " + l2.toString()
                + " " + l3.toString() + " " + l1.omvendtString() + " "
                + l2.omvendtString() + " " + l3.omvendtString());

        DobbeltLenketListe<Integer> liste5 = new DobbeltLenketListe<>();
        System.out.println(liste5.toString() + " " + liste5.omvendtString());
        for (int i = 1; i <= 3; i++)
        {
            liste5.leggInn(i);
            System.out.println(liste5.toString() + " " + liste5.omvendtString());
        }
        // Utskrift:
        // [] []
        // [1] [1]
        // [1, 2] [2, 1]
        // [1, 2, 3] [3, 2, 1]

    }

    /**
     * Node class
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    public Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        //throw new UnsupportedOperationException();
        //this((T[]) new  Object[10]);
    }

    public DobbeltLenketListe(T[] a) {
        if (a == null)
            throw new NullPointerException("Tabellen a er null!");
        else if (a.length > 0) {
            boolean first = true;
            antall = 0;
            int i = 0;for(; first && i < a.length; i++){
                if(a[i] != null && first){
                    hode = new Node<>(a[i], null, null);
                    antall++;
                    first = false;
                }
            }
            Node<T> CurrentNode = hode;
            Node<T> PreviousNode = hode;
            for(; i < a.length; i++){
                if(a[i] != null){
                    CurrentNode.neste = new Node<>(a[i], PreviousNode, null);
                    PreviousNode = CurrentNode;
                    CurrentNode = CurrentNode.neste;
                    CurrentNode.forrige = PreviousNode;
                    antall++;
                }
            }
            hale = CurrentNode;
        }

    }
    private Node<T> finnNode(int index){
        
    }

    public Liste<T> subliste(int fra, int til){
        throw new UnsupportedOperationException();
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() { return antall==0; }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi);

        if (hode == null && hale == null && antall == 0) {
            hode = new Node<T>(verdi, null, null);
            hale = hode;
            antall++;
            endringer++;
            return true;
        } else if (antall > 0 && hale != null) {
            Node<T> newNode = new Node<>(verdi, hale, null);
            hale.neste = newNode;
            hale = newNode;
            antall++;
            endringer++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T hent(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder ut = new StringBuilder();
        if(hode != null) {
            ut.append("[" + hode.verdi);

        Node<T> currentNode = hode;
        for(int i = 0; i <= antall; i++){
            if(currentNode.neste != null){
                currentNode = currentNode.neste;
                ut.append(", " + currentNode.verdi);
            }
        }
        }else{
            ut.append("[");
        }
        ut.append("]");

        return ut.toString();
    }

    public String omvendtString() {
        StringBuilder ut = new StringBuilder();
        if(hale != null) {
            ut.append("[" + hale.verdi);

            Node<T> currentNode = hale;
            for (int i = antall; i >= 0; i--) {
                if (currentNode.forrige != null) {
                    currentNode = currentNode.forrige;
                    ut.append(", " + currentNode.verdi);
                }
            }
        }else{
            ut.append("[");
        }
        ut.append("]");

        return ut.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator(){
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks){
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }

        @Override
        public T next(){
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


