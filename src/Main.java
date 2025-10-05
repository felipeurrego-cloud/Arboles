
import java.util.Scanner;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class Tree {
    Node root;

    Tree() {
        root = null;
    }

    // Insertar número en el árbol
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    // Buscar número en el árbol
    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // Mostrar recorrido inorden
    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree tree = new Tree();
        int option;

        do {
            System.out.println("\n--- MENÚ ÁRBOL BINARIO ---");
            System.out.println("1. Insertar número");
            System.out.println("2. Mostrar recorrido inorden");
            System.out.println("3. Buscar número");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el número a insertar: ");
                    int num = sc.nextInt();
                    tree.insert(num);
                    System.out.println("Número insertado correctamente.");
                    break;

                case 2:
                    System.out.println("Recorrido inorden del árbol:");
                    tree.inorder();
                    break;

                case 3:
                    System.out.print("Ingrese el número a buscar: ");
                    int searchNum = sc.nextInt();
                    if (tree.search(searchNum))
                        System.out.println("El número " + searchNum + " SÍ existe en el árbol.");
                    else
                        System.out.println("El número " + searchNum + " NO existe en el árbol.");
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (option != 4);

        sc.close();
    }
}