import java.util.*;  // for built-in Stack class
//Binary Search Tree Class

public class BST_D{

	private BSTNode root;
	private boolean useSuccessor;


	public BST_D(){
		root = null;
		useSuccessor=true;
	}


	public BSTNode getRoot(){
		return root;
	}

	//getMin()
	//returns Node with smallest key value in the tree c rooted at v
	//assumes v is not null
	public BSTNode getMin(BSTNode v){
		if(v.left()==null){
			return v;
		}
		else{
			return getMin(v.left());
		}
	}


	//getMax()
	//returns
	public BSTNode getMax(BSTNode v){
		if(v.right()==null){
			return v;
		}
		else{
			return getMax(v.right());
		}
	}

	//returns Node with key k in the tree rooted at v
	//returns null if k not found
	public BSTNode find(int k, BSTNode v){
		if(v==null){
			return null;
		}
		else if(v.k()==k){
			return v;
		}
		else if(v.k()>k){
			return find(k,v.left());
		}
		else{
			return find(k,v.right());
		}
	}


	//insert new key into the subtree rooted at node v
	//when v is not null
	public void recInsert(int k, BSTNode v){
		if(k>v.k()){
			if(v.right()!=null){
				recInsert(k,v.right());
			}
			else{
				v.setRight(new BSTNode(v, k,null,null));
			}
		}else if(k<=v.k()){
			if(v.left()!=null){
				recInsert(k,v.left());
			}else{
				v.setLeft(new BSTNode(v, k, null, null));
			}
		}
	}


	public void insert(int k){
		if(root==null){
			root=new BSTNode(null, k, null, null);
		} else{
			recInsert(k,root);
		}
	}

	public void replace(BSTNode v, BSTNode w){
		if(v==root){
			root=w;
		}else{
			if(v.parent().right()==v){
				v.parent().setRight(w);
			}
			else{
				v.parent().setLeft(w);
			}
		}
	}

	public BSTNode delete(int k){
		BSTNode toBeDeleted=find(k,root);
		if(toBeDeleted==null){
			return null;
		}
		else if(toBeDeleted.left()==null&&toBeDeleted.right()==null){
			replace(toBeDeleted,null);

		}
		else if(toBeDeleted.left()!=null&&toBeDeleted.left()!=null){  //if two children
			if(useSuccessor){
				BSTNode s=getMin(toBeDeleted.right());
				toBeDeleted.setKey(s.k());
				replace(s,s.right());
			}
			else{
				BSTNode s=getMax(toBeDeleted.left());
				toBeDeleted.setKey(s.k());
				replace(s,s.right());

			}
			useSuccessor=!useSuccessor;   //switching to false
		}
		else{   //one child
			if(toBeDeleted.left()!=null){
				replace(toBeDeleted,toBeDeleted.left());
			}
			else{
				replace(toBeDeleted,toBeDeleted.right());
			}

		}
		return toBeDeleted;
	}



	// preOrder(BSTNode v)
	// Prints out the keys of the tree in a preorder traversal
	public void preOrder(BSTNode v){
		System.out.println(v.k());
		if(v.left()==null){
			preOrder(v.left());
		}
		if(v.right()!=null){
			preOrder(v.right());
		}
	}
		
	// inOrder(BSTNode v)
	// Prints out the keys of the tree in a inorder traversal
	public void inOrder(BSTNode v){
		if(v.left()!=null){
			inOrder(v.left());
			System.out.print(v.k());
		if(v.right()!=null){
			inOrder(v.right());
		}
		}
	}
	// postOrder(BSTNode v)
	// Prints out the keys of the tree in a postorder traversal
	public void postOrder(BSTNode v){
		if(v.left()!=null){
			postOrder(v.left());
		}
		if(v.right()!=null){
			postOrder(v.right());
		}
		System.out.println(v.k());
	
	}



	public void displayTree()
	{
		Stack<BSTNode> globalStack = new Stack<BSTNode>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
		"......................................................");
		while(isRowEmpty==false)
		{
			Stack<BSTNode> localStack = new Stack<BSTNode>();
			isRowEmpty = true;

			for(int j=0; j<nBlanks; j++)
			System.out.print(' ');

			while(globalStack.isEmpty()==false)
			{
				BSTNode temp = globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.k());
					localStack.push(temp.left());
					localStack.push(temp.right());

					if(temp.left()!= null ||
							temp.right()!= null)
					isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<nBlanks*2-2; j++)
				System.out.print(' ');
			}  // end while
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
			globalStack.push( localStack.pop() );
		}  // end while isRowEmpty is false
		System.out.println(
		"......................................................");
	}  // end displayTree()



	public void traverse(char traverseType)
	{
		switch(traverseType)
		{
			case 'p': System.out.print("\nPreorder traversal: ");
				preOrder(root);
				break;
			case 'i': System.out.print("\nInorder traversal:  ");
				inOrder(root);
				break;
			case 't': System.out.print("\nPostorder traversal: ");
				postOrder(root);
				break;
		}
		System.out.println();
	}



}
