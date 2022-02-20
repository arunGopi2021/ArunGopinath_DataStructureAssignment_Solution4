public class testBST {
    
    // Inner Class
    class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Instance Variable of testBST class
    Node root;
    // Instance variables for Skewed Right BST Conversion
    Node prevNode = null;
    Node currentNode = null;
    boolean lowestValFlagSet = false;

    // Constructor of BST
    testBST(){
        root = null; // This tells that the BST has no nodes yet. Its an empty BST
    }




    // Insert Method
    public void insertNodeToBST(int data){
        Node n = new Node(data);
        if(root==null){
            // add the node at the root if BST is empty
            root = n;
            return;
        }else{
            // Initiate two nodes, One to track the Current Node and 
            // Second Node to track the parent of the current Node.
            Node currentNode = root;
            Node parentNode = null;

            while(true){
                parentNode = currentNode;
                if(data<currentNode.data){
                    currentNode = currentNode.left;
                    if(currentNode == null){
                        parentNode.left = n;
                        return;
                    }// left tree if block
                }else{
                    currentNode = currentNode.right;
                    if(currentNode==null){
                        parentNode.right = n;
                        return;
                    }
                }// if-else block

            }// while loop - To check through the Nodes of the tree to place the new node.
            
        }
    }// Insert method



    public void inorderTraversal(Node n){
       

        if(root==null){
            System.out.println("The Tree is empty!");
        }else{
            if(n.left != null){
                inorderTraversal(n.left);
            }
    
            System.out.println(n.data);        

            if(n.right != null){
                inorderTraversal(n.right);
            }
        }
    }// inorderTraversal method






    public void convertToSkewedRightTree(Node n){
            

       
    
        if(root==null){
            System.out.println("The Tree is empty!");
        }else{
                if(n.left != null){
                    convertToSkewedRightTree(n.left);
                }

                if(!(lowestValFlagSet) && n.left==null){

                    root = n;
                    lowestValFlagSet = true;
                    prevNode = n;
                    currentNode = n;

                }else{

                    currentNode = n;
                    prevNode.left = null;
                    prevNode.right = n;
                    prevNode = prevNode.right;
                }

                System.out.print(currentNode.data+" ");
                

                if(currentNode.right != null){
                    convertToSkewedRightTree(currentNode.right);
                }
            }
        
        }// convertToSkewedRightTree method


   
        

    public static void main(String[] args) {
        testBST t1 = new testBST();
        t1.insertNodeToBST(50);
        t1.insertNodeToBST(30);
        t1.insertNodeToBST(60);
        t1.insertNodeToBST(10);
        t1.insertNodeToBST(55);
        t1.insertNodeToBST(90);

        System.out.println("\n");
        System.out.println("Root data in the original binary tree "+t1.root.data+"\n");
        t1.convertToSkewedRightTree(t1.root);

        System.out.println("\n\nCreated the right skewed tree!");

        System.out.println("Root data in the Skewed right binary tree "+t1.root.data+"\n");


        System.out.println(t1.root.data);
        System.out.println(t1.root.right.data);
        System.out.println(t1.root.right.right.data);
        System.out.println(t1.root.right.right.right.data);
        System.out.println(t1.root.right.right.right.right.data);
        System.out.println(t1.root.right.right.right.right.right.data);


    }// Main Method
}