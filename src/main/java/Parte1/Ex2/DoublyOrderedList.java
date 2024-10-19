package Parte1.Ex2;

<<<<<<< HEAD
import Interfaces.ListADT;

public abstract class OrderedList {

=======
import Interfaces.OrderedListADT;

public class DoublyOrderedList<T> extends DoublyLinkedList<T> implements OrderedListADT<T> {

    public DoublyOrderedList() {
        super();
    }

    /**
     * Metodo para adicionar um elemento a lista duplamente ligada em ordem
     *
     * @param element Elemento a ser adicionado
     *                @throws IllegalArgumentException se o elemento não for comparável
     *                @throws NullPointerException se o elemento for nulo
     * */
    @Override
    public void add(T element) throws IllegalArgumentException, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }

        if (!(element instanceof Comparable)) {
            throw new IllegalArgumentException("Element must be comparable");
        }

        Comparable<T> comparableElement = (Comparable<T>) element;
        DoubleNode<T> newNode = new DoubleNode<>(element);

        // Caso a lista esteja vazia
        if (this.count == 0) {
            this.first = this.last = newNode;
        } else {
            DoubleNode<T> current = first;

            // Encontrar a posição correta para inserir o elemento
            while (current != null && comparableElement.compareTo(current.getElement()) > 0) {
                current = current.getNext();
            }

            if (current == first) {
                // Inserir no início
                newNode.setNext(first);
                first.setPrevious(newNode);
                first = newNode;
            } else if (current == null) {
                // Inserir no final
                last.setNext(newNode);
                newNode.setPrevious(last);
                last = newNode;
            } else {
                // Inserir no meio
                newNode.setNext(current);
                newNode.setPrevious(current.getPrevious());
                if (current.getPrevious() != null) {
                    current.getPrevious().setNext(newNode);
                }
                current.setPrevious(newNode);
            }
        }

        this.count++;
        this.modCount++;
    }
>>>>>>> 6bca961 (fix push)
}
