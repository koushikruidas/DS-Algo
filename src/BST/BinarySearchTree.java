package com.koushik.BST;

//Java program to demonstrate
//insert operation in binary
//search tree
class BinarySearchTree {

	/* Class containing left
	and right child of current node
	* and key value*/
	class Node {
		int key;
		Node left, right;

		public Node(int item)
		{
			key = item;
			left = right = null;
		}
	}

	// Root of BST
	Node root;

	// Constructor
	BinarySearchTree() { root = null; }

	BinarySearchTree(int value) { root = new Node(value); }

	// This method mainly calls insertRec()
	void insert(int key) { root = insertRec(root, key); }

	/* A recursive function to
	insert a new key in BST */
	Node insertRec(Node root, int key)
	{

		/* If the tree is empty,
		return a new node */
		if (root == null) {
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	Node delete(Node root, int key) {
		Node keyNode = findNode(root, key);
        Node tempNode = keyNode;
        Node prevNode = keyNode;
        if(tempNode != null){
            if(tempNode.left == null || tempNode.right == null){
                tempNode = (tempNode.right != null) ? tempNode.right : tempNode.left;
            }
            else {
            	prevNode = tempNode;
                tempNode = tempNode.left;
                while(tempNode.right != null) {
                	prevNode = tempNode;
                    tempNode = tempNode.right;
                }
            }
            swap(keyNode,tempNode);
//            prevNode.left = tempNode.left;
//            prevNode.right = tempNode.right;
            tempNode = null;
        }
        return root;
	}
	
	public void swap(Node keyNode, Node tempNode) {
		int temp = tempNode.key;
		tempNode.key = keyNode.key;
		keyNode.key = temp;
	}
	
    public Node findNode(Node root, int key){
        if(key > root.key) return findNode(root.right, key);
        if(key < root.key) return findNode(root.left, key);
        if(key == root.key) return root;
        return null;
    }
	
	// This method mainly calls InorderRec()
	void inorder() { inorderRec(root); }

	// A utility function to
	// do inorder traversal of BST
	void inorderRec(Node root)
	{
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}

	// Driver Code
	public static void main(String[] args)
	{
		BinarySearchTree tree = new BinarySearchTree();

		/* Let us create following BST
			50
		/	 \
		30	 70
		/ \ / \
	20 40 60 80 */
		tree.insert(5);
		tree.insert(3);
		tree.insert(6);
		tree.insert(2);
		tree.insert(4);
		tree.insert(7);
//		tree.insert(80);

		// print inorder traversal of the BST
		tree.inorder();
		Node del = tree.delete(tree.root, 3);
		System.out.println("=======");
		inorder(del);
	}
	
	static void inorder(Node root) {
		if(root == null) return;
		if(root.left != null) inorder(root.left);
		System.out.println(root.key);
		if(root.right != null) inorder(root.right);
	}
}
//This code is contributed by Ankur Narain Verma

