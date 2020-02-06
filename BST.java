import java.io.*;
import java.util.Scanner;
class BST{
    //creating the node
   class Node {
       int key;
       Node left, right;

       public Node(int item){
           key = item;
           left = right = null;
       }
   }

   //setting up a root
   Node root;
   //initializing the root
   BST(){
       root = null;
   }

   //inserting the node, called function
   void insert(int key){
       root = insertRecursivley(root, key);
   }
   //inserting the node, workload function
   //WHAT IF IT EQUALS??
   Node insertRecursivley(Node root, int key){
       //if tree is empty return a new node
       if(root == null){
           root = new Node(key);
           return root;
       }
       //if tree !empty move down tree
       if(key < root.key){
           root.left = insertRecursivley(root.left, key);
       }
       else if(key > root.key){
           root.right = insertRecursivley(root.right, key);
       }

       return root;
   }

   //calling for an inorder traversal & print
   void printTree(){
       inorder(root);
   }
   void inorder(Node root){
       if(root != null){
            inorder(root.left);
            System.out.println(root.key);
            inorder(root.right);
       }
    //    else if(root == null){
    //        System.out.println("Empty tree\n");
    //    }
   }
   //MAIN PROGRAM
   public static void main(String[] args) throws FileNotFoundException{
        //creating a new tree
        BST tree = new BST();
        
        //getting file name from command input
        String infile = args[0];
        Scanner scnr = new Scanner(new File(infile));

        char command = '0';
       
        //looping through .txt infile
        while(scnr.hasNext()){
            command = scnr.next().charAt(0);

            if(command == 'i'){
                tree.insert(scnr.nextInt());
            }
                          
        }

        scnr.close();
        tree.printTree();
   }

}