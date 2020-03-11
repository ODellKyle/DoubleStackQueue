package driver;

import java.util.InputMismatchException;
import java.util.Scanner;

import data.DataClass;
import exceptions.EmptyStackQException;
import stackqueue.StackQ;
public class Driver 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int input = 0, datagen = 0;
		boolean menuActive = true;
		StackQ<DataClass> que = new StackQ<DataClass>();
		
		
		do {
			System.out.println("User Menu:\n");
			System.out.println("Input Choice:\n");
			System.out.println("\t1. Enqueue in the queue");
			System.out.println("\t2. Dequeue from the queue");
			System.out.println("\t3. Peek from the Queue");
			System.out.println("\t4. Display the queue");
			System.out.println("\t5. Display enQStack and deQStack");
			System.out.println("\t6. Display size of the queue");
			System.out.println("\t7. Exit\n");
			
			// Error handling for input. Input must be an integer, else throws exception.
			try {
				input = in.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Input error! Input must be an integer.");
				in.next();
				input = 0;
			}
			
			if(input == 1) 
			{
				//TODO: modify based off professors desire
				DataClass data = new DataClass("Data Class " + datagen, datagen);
				que.enQ(data);
				System.out.println("Enqueued: " + data.toString());
				datagen++;
			}
			else if(input == 2) 
			{
				try {
					if(que.peek() != null)
						System.out.println("Dequeued: " + que.deQ());
					else 
						throw new EmptyStackQException();
				} catch (EmptyStackQException e) {
					System.out.println("Queue is empty!");
				}
			}
			else if(input == 3)
			{
				try {
					if(que.peek() != null)
						System.out.println("Peeked: " + que.peek());
					else 
						throw new EmptyStackQException();
				} catch (EmptyStackQException e) {
					System.out.println("Queue is empty!");
				}
			}
			else if(input == 4)
				System.out.println(que.toString());
			else if(input == 5) 
			{
				System.out.println("deQStack: " + que.getdeQStack());
				System.out.println("enQStack: " + que.getenQStack());
			}
			else if(input == 6) 
				System.out.println("Queue size: " + que.getQueueSize());
			else if(input == 7) // Exits menu
				menuActive = false;
			else
				System.out.println("Please try an input 1 - 7.\n");
			} while(menuActive);
		
		System.out.println("Have a great day!");
	}
}
