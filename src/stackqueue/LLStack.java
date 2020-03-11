package stackqueue;

import interfaces.StackSpecs;

public class LLStack<E> implements StackSpecs<E>
{
	private Node<E> top;
	private int stackSize;
	
	public LLStack()
	{
		top = null;
		stackSize = 0;
	}
	
	public LLStack(E obj) 
	{
		this.top = new Node<E>(obj);
		this.stackSize = 1;
	}
	public void setTop(Node<E> top) 
	{
		this.top = top;
	}
	public Node<E> getTop()
	{
		return this.top;
	}
	
	public void setStackSize(int stackSize) 
	{
		this.stackSize = stackSize;
	}
	public int getStackSize() 
	{
		return this.stackSize;
	}

	
	@Override
	public boolean isEmpty() 
	{
		boolean isEmpty = false;
		
		if(stackSize == 0)
			isEmpty = true;
		
		return isEmpty;
	}

	@Override
	public void emptyStack() 
	{
		while(!this.isEmpty()) 
		{
			this.pop();
		}
	}

	@Override
	public void push(E obj) 
	{
		Node<E> node = new Node<E>(obj);
		if(stackSize == 0)
			top = node;
		else 
		{
			node.setNextNode(top);
			top = node;
		}
		
		stackSize++;
	}

	@Override
	public E pop() 
	{
		E removed = null;
		Node<E> temp;
		if(!this.isEmpty()) 
		{
			if(stackSize == 1) 
			{
				removed = top.getData();
				top = null;
			}
			else 
			{
				removed = top.getData();
				temp = top.getNextNode();
				top = null;
				top = temp;
				temp = null;
			}
			
			stackSize--;
		}
		
		return removed;
	}

	@Override
	public E peek() 
	{
		E peeked = null;
		if(top != null)
			peeked = top.getData();
		return peeked;
	}
	
	public String toString() 
	{
		LLStack<E> temp = new LLStack<E>();
		
		String contents = "[(Bottom) ";
		
		while(!this.isEmpty()) 
		{
			temp.push(this.pop());
		}
		
		while(!temp.isEmpty()) 
		{
			contents += temp.peek();
			this.push(temp.pop());
			if(!temp.isEmpty())
				contents += ", ";
		}
		
		contents += " (Top)]";
		
		return contents;
		
	}
}
