
import java.io.*;
import java.util.*;
 class Node{

    int data;
    Node rightChild;
    Node leftChild;

    public Node(int val){
        data = val;
        rightChild = null;
        leftChild = null;
    }
}

public class ValidBST_CTCI{
    Integer last_printed = null;
    public static void main(String args[]) throws IOException{
        ValidBST_CTCI v = new ValidBST_CTCI();
        System.out.println("Enter the no of elements");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrNode = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the no of elements");
            arrNode[i] = Integer.parseInt(br.readLine());
        }


        Node root =    v.createTree(arrNode,0,n-1);
        v.process(root);
        
        //TO find the tree is BST
        boolean check = v.checkBST(root);

        System.out.println("The BST valid is " + check);
    }

        //creating a createTree

        Node createTree(int arr[],int start, int end){

            if(start > end){
                return null;
            }
            
            int mid = (start + end) / 2;
            Node root = new Node(arr[mid]);
            root.leftChild  = createTree(arr,start,mid-1);
            root.rightChild  = createTree(arr,mid+1,end);
            return root;

        }

        //printing the Node
        void process(Node printNode){
            if(printNode == null){
                return;
            }
            System.out.println(printNode.data);
            process(printNode.leftChild);
            process(printNode.rightChild);
        }

        
        // Checking the BST tree
        boolean checkBST(Node root){

           /* if(root.leftChild == null || root.rightChild == null){
                return false;
            }
            int r = root.data;
            int left = root.leftChild.data;
            checkBST(root.leftChild);
            checkBST(root.rightChild);
            int right = root.rightChild.data;
            if( left <= r && right > r){
                return true;
            }
            else{
                return false;
            }*/
            if(root == null){
                return true;
            }

            if(!checkBST(root.leftChild)) return false;


            if(last_printed != null && root.data < last_printed){
                return false;
            }
            
            last_printed = root.data;
            if(!checkBST(root.rightChild)) return false;
            return true;
            
        }


        
    }

