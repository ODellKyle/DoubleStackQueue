package exceptions;

public class EmptyStackQException extends Exception
{
	public EmptyStackQException() 
	{
		super("StackQ is empty!");
	}
}
