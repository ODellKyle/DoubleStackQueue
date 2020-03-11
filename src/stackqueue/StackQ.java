package stackqueue;

import interfaces.QueueSpecs;

public class StackQ<E> implements QueueSpecs<E> 
{
	private LLStack<E> enQStack;
	private LLStack<E> deQStack;
	
	public StackQ()
	{
		this(new LLStack<E>(), new LLStack<E>());
	}
	
	public StackQ(LLStack<E> es, LLStack<E> ds) 
	{
		this.enQStack = es;
		this.deQStack = ds;
	}
	
	
	@Override
	public boolean isEmpty() 
	{
		boolean isEmpty = false;
		
		if(this.enQStack.isEmpty() && this.deQStack.isEmpty())
			isEmpty = true;
		
		return isEmpty;
	}

	@Override
	public void emptyQueue() 
	{
		this.enQStack.emptyStack();
		this.deQStack.emptyStack();
	}

	@Override
	public void enQ(E obj) 
	{
		this.enQStack.push(obj);
	}

	@Override
	public E deQ() 
	{
		E deQd = null;
		
		if(this.deQStack.isEmpty()) 
		{
			while(!this.enQStack.isEmpty())
				this.deQStack.push(this.enQStack.pop());
		}
		
		deQd = this.deQStack.pop();
		
		return deQd;
	}

	@Override
	public E peek() 
	{
		E peeked = null;
		
		if(this.deQStack.isEmpty()) 
		{
			while(!this.enQStack.isEmpty())
				this.deQStack.push(this.enQStack.pop());
		}
		
		peeked = this.deQStack.peek();
		
		return peeked;
	}
	
	public LLStack<E> getdeQStack() 
	{
		return this.deQStack;
	}
	
	public void setdeQStack(LLStack<E> deQStack) 
	{
		this.deQStack = deQStack;
	}
	
	public LLStack<E> getenQStack()
	{
		return this.enQStack;
	}
	
	public void setenQStack(LLStack<E> enQStack) 
	{
		this.enQStack = enQStack;
	}
	
	public int getQueueSize() 
	{
		return this.enQStack.getStackSize() + this.deQStack.getStackSize();
	}

	@Override
	public String toString() 
	{
		StackQ<E> temp = new StackQ<E>();
		String contents = "[(Front) ";
		
		while(!this.isEmpty()) 
		{
			temp.enQ(this.deQ());
		}
		
		while(!temp.isEmpty()) 
		{
			
			contents += temp.peek();
			this.enQ(temp.deQ());
			if(!temp.isEmpty())
				contents += ", ";
		}
		
		contents += " (Rear)]";
		
		return contents;	
	}
}
