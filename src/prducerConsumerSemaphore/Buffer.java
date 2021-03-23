package prducerConsumerSemaphore;

import java.util.ArrayList;
import java.util.concurrent.Semaphore; 

public class Buffer {
	int size;
	int counter = 0; //it keeps counting every time a product is produced, when the counter reaches 
				     //a specified value the program will stop with a successful termination
	
	int stop =20;
	ArrayList<String> products = new ArrayList<String>();
	Semaphore consSema = new Semaphore(0); // semaphore that controls the consumer access to the shared data (items) 
	Semaphore prodSema; // semaphore that controls the producer access to the shared data (items)  
	  
	public Buffer(int size) {
		this.size = size;
		prodSema = new Semaphore(size);
	}
	
	void produce(String product) { 
		try { 
			prodSema.acquire();  
			System.out.println("Producer produces: " + product);
			products.add(product);
			counter++;
		} 
		catch (InterruptedException e) { 
			e.printStackTrace();
		}
		consSema.release();  
	} 
	
	void consume() { 
		try { 
			consSema.acquire(); 
			System.out.println("Consumer consumes: " + products.get(0));
			products.remove(0);
		} 
		catch (InterruptedException e) { 
			e.printStackTrace(); 
		} 
		prodSema.release(); 
	} 
}
