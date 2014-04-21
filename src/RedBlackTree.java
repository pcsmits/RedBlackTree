
public class RedBlackTree 
{
	private RedBlackNode root;
	private RedBlackNode min;
	private RedBlackNode max;
	private RedBlackNode nil;
	
	public RedBlackTree(RedBlackNode nil)
	{
		this.nil = nil;
		this.root = nil;
		this.min = nil;
		this.max = nil;

	}
	
	/*public RedBlackTree(RedBlackNode root)
	{
		this.root = root;
		this.min = root;
		this.max = root;
	}*/
	
	public void insert(RedBlackNode z)
	{
		RedBlackNode y = nil;
		RedBlackNode x = root;
		while(x!=nil)
		{
			y = x;
			if(z.getKey() < x.getKey())
			{
				x = x.getLeft();
			}
			else
			{
				x = x.getRight();
			}
		}
		
		z.setParent(y);
		
		if(y == nil)
		{
			root = z;
		}
		else if(z.getKey() < y.getKey())
		{
			y.setLeft(z);
		}
		else
		{
			y.setRight(z);
		}
		
		z.setLeft(nil);
		z.setRight(nil);
		z.setColor(Color.RED);
		
		//fixing succ
		if (z.getParent() != nil)
		{
			RedBlackNode t = z;
			while (t != t.getParent().getRight() && t.getParent() != nil) 
			{
				t = t.getParent();
			}
			t.getParent().setSucc(z);
		}
		
		//fixing pred
		if (z.getParent() != nil)
		{
			RedBlackNode t = z;
			while (t != t.getParent().getLeft() && t.getParent() != nil) 
			{
				t = t.getParent();
			}
			t.getParent().setPred(z);
		}
		
		
		insertFixup(z);
		min = findMin();
		max = findMax();
		

		
	}
	
	public RedBlackNode findMin()
	{
		RedBlackNode x = root;
		while(x.getLeft() != nil)
		{
			x = x.getLeft();
		}
		return x;
	}
	
	public RedBlackNode findMax()
	{
		RedBlackNode x = root;
		while(x.getRight() != nil)
		{
			x = x.getRight();
		}
		return x;
	}
	
	public void insertFixup(RedBlackNode z)
	{
		RedBlackNode y;
		while(z.getParent().getColor() == Color.RED)
		{
			if(z.getParent() == z.getParent().getParent().getLeft())
			{
				y = z.getParent().getParent().getRight();
				if(y.getColor() == Color.RED)
				{
					z.getParent().setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					z.getParent().getParent().setColor(Color.RED);
					z = z.getParent().getParent();
				}
				else if(z == z.getParent().getRight())
				{
					z = z.getParent();
					leftRotate(z);
					z.getParent().setColor(Color.BLACK);
					z.getParent().getParent().setColor(Color.RED);
					rightRotate(z.getParent().getParent());
				}
				else
				{
					z.getParent().setColor(Color.BLACK);
					z.getParent().getParent().setColor(Color.RED);
					rightRotate(z.getParent().getParent());
				}
			}
			else // same as THEN with right and left exchanged. it is symmetric
			{
				y = z.getParent().getParent().getLeft();
				if(y.getColor() == Color.RED)
				{
					z.getParent().setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					z.getParent().getParent().setColor(Color.RED);
					z = z.getParent().getParent();
				}
				else if(z == z.getParent().getLeft())
				{
					z = z.getParent();
					rightRotate(z);
					z.getParent().setColor(Color.BLACK);
					z.getParent().getParent().setColor(Color.RED);
					leftRotate(z.getParent().getParent());
				}
				else
				{
					z.getParent().setColor(Color.BLACK);
					z.getParent().getParent().setColor(Color.RED);
					leftRotate(z.getParent().getParent());
				}
			}
		}
		root.setColor(Color.BLACK);
	}

	public void leftRotate(RedBlackNode x)
	{
		RedBlackNode y = x.getRight();
		x.setRight(y.getLeft());
		if(y.getLeft() != nil)
		{
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent());
		if(x.getParent() == nil)
		{
			root = y;
		}
		else if(x == x.getParent().getLeft())
		{
			x.getParent().setLeft(y);
		}
		else
		{
			x.getParent().setRight(y);
		}
		y.setLeft(x);
		x.setParent(y);
		x.setSucc(successor(x));
		y.setPred(predecessor(y));
	}
	
	public void rightRotate(RedBlackNode x)
	{
		RedBlackNode y = x.getLeft();
		x.setLeft(y.getRight());
		if(y.getRight() != nil)
		{
			y.getRight().setParent(x);
		}
		y.setParent(x.getParent());
		if(x.getParent() == nil)
		{
			root = y;
		}
		else if(x == x.getParent().getRight())
		{
			x.getParent().setRight(y);
		}
		else
		{
			x.getParent().setLeft(y);
		}
		y.setRight(x);
		x.setParent(y);
		
		y.setSucc(successor(y));
		x.setPred(predecessor(x));
	}

	public RedBlackNode find(int k)
	{
		RedBlackNode x = root;
		while(x!=nil && x.getKey()!=k)
		{
			if(x.getKey() > k)
			{
				x = x.getLeft();
			}
			else
			{
				x = x.getRight();
			}
		}
		return x;
	}
	
	public void printTree(RedBlackNode node)
	{
		if(node == nil)
		{
			return;
		}
		printTree(node.getLeft());
		node.printNode();
		/*System.out.printf("Key: %d\nLeft: %d\nRight: %d\nColor: %s\n\n", node.getKey(), node.getLeft().getKey(),
				node.getRight().getKey(), node.getColor().name());*/
		printTree(node.getRight());
		
		
		
		
	}
	
	
	
	public RedBlackNode getRoot() {
		return root;
	}

	public void setRoot(RedBlackNode root) {
		this.root = root;
	}

	public RedBlackNode getMin() {
		return min;
	}

	public void setMin(RedBlackNode min) {
		this.min = min;
	}

	public RedBlackNode getMax() {
		return max;
	}

	public void setMax(RedBlackNode max) {
		this.max = max;
	}

	public RedBlackNode successor(RedBlackNode current_node)
	{
		if(current_node.getRight() == nil || current_node == nil)
		{
			return nil;
		}
		
		RedBlackNode x = current_node.getRight();
		if(x.getLeft() == nil)
		{
			return x;
		}
		while(x.getLeft() != nil)
		{
			x = x.getLeft();
		}
		return x;
	}

	public RedBlackNode predecessor(RedBlackNode current_node)
	{
		if(current_node.getLeft() == nil || current_node == nil)
		{
			return nil;
		}
		
		RedBlackNode x = current_node.getLeft();
		if(x.getRight() == nil)
		{
			return x;
		}
		while(x.getRight() != nil)
		{
			x = x.getRight();
		}
		return x;
	}
}
