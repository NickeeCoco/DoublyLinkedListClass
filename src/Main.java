public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        System.out.println(dll.size());
        System.out.println(dll.isEmpty());
        System.out.println(dll.first());
        System.out.println(dll.last());
        dll.addFirst(5);
        System.out.println(dll);
        System.out.println(dll.first());
        dll.addFirst(8);
        System.out.println(dll.first());
        System.out.println(dll);
        System.out.println(dll.last());;
        dll.addLast(1);
        System.out.println(dll.last());
        System.out.println(dll);
        System.out.println(dll.removeFirst());
        System.out.println(dll);
        System.out.println(dll.size());
        System.out.println(dll.isEmpty());
        System.out.println(dll.removeLast());
        System.out.println(dll);
    }
}
