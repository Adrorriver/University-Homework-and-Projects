
public class Driver
{
   /**
     * Main entry point
     */
    public static void main(String[] args)
    {
       String str="{d([])r{g[gt]()}}      (( ) [ ] )     ( ( ( ) [ ] ) )          public static void main (String [] args)\n{\n\t int n = -2;"+
"\n\t if ( n < 0 )\n\t{\n\t\t System.out.println(negative)"+
";\n\t}\n\t else \n\t {\n\t\t System.out.println(positive);"+
"\n\t}\n}\n"+ " ;                   ( ( { [ ] } ) )";
       System.out.println("your method returns " + Compiler.compilation(str) + " ==> the result should be true");
       
       str=" {{}{((())";
       System.out.println("your method returns " + Compiler.compilation(str) + " ==> the result should be false");
       
       System.out.println();
       // creating a tree
        Node node = new Node(3);
        Node leftNode = new Node(1);
        Node rightNode = new Node(4);
        node.setLeftSon(leftNode);
        node.setRightSon(rightNode);
       
        // checking maxInTree
        int res = BinaryTree.maxInTree(node);
        System.out.println ("max in tree is " + res); // should return 4
        // checking maxInSearchTree
        res =  BinaryTree.maxInSearchTree(node);
        System.out.println ("max in search tree is " + res); // should return 4
        // checking sizeOfTree
        res =  BinaryTree.sizeOfTree(node);
        System.out.println ("size of tree is " + res); // should return 3
         // checking kElement
        res =  BinaryTree.kElement(node,2);
        System.out.println ("kElement (root,2) is " + res); // should return 3       
        
    }
}