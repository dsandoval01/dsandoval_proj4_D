
public class BSTNode {

	private BSTNode parent;
	private int key;
	private BSTNode left;
	private BSTNode right;

	public BSTNode(BSTNode p,int k,BSTNode l, BSTNode r) {
		parent=p;
		key=k;
		left=l;
		right=r;
	}

	public int k(){
		return key;
	}

	public BSTNode left(){
		return left;
	}

	public BSTNode right(){
		return right;
	}

	public BSTNode parent(){
		return parent;
	}

	public void setLeft(BSTNode v){
		left=v;
	}

	public void setRight(BSTNode v){
		right=v;
	}

	public void setKey(int k){
		key=k;
	}

	public void setParent(BSTNode v){
		parent=v;
	}

	public void displayNode(){ //method that simply prints out key value
		System.out.println(key);
	}
}