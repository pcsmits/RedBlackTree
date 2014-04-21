
public class RedBlackNode 
{
	private int value;
	private RedBlack color;
	private RedBlackNode left;
	private RedBlackNode right;
	private RedBlackNode parent;
	private RedBlackNode successor;
	private RedBlackNode predecessor;
	

	// Used on Root node
	public RedBlackNode(RedBlack color)
	{
		this.color = color;
		val = Integer.MAX_VALUE;
		left = null;
		right = null;
		parent = null;
		successor = null;
		predecessor = null;
	}

	public RedBlackNode(int val, RedBlack color, RedBlackNode node)
	{
		this.setValue(val);
		this.setColor(color);
		left = node;
		right = node;
		parent = node;
		successor = node;
		predecessor = node;
	}

	public RedBlackNode(int val, RedBlackNode node)
	{
		this.setValue(val);
		left = node;
		right = node;
		parent = node;
		successor = node;
		predecessor = node;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int val) {
		this.value = val;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public RedBlackNode getLeft() {
		return left;
	}

	public void setLeft(RedBlackNode left) {
		this.left = left;
	}

	public RedBlackNode getRight() {
		return right;
	}

	public void setRight(RedBlackNode right) {
		this.right = right;
	}

	public RedBlackNode getParent() {
		return parent;
	}

	public void setParent(RedBlackNode parent) {
		this.parent = parent;
	}

	public RedBlackNode getSucc() {
		return successor;
	}

	public void setSucc(RedBlackNode successor) {
		this.successor = successor;
	}

	public RedBlackNode getPred() {
		return predecessor;
	}

	public void setPred(RedBlackNode predecessor) {
		this.predecessor = predecessor;
	}
}
