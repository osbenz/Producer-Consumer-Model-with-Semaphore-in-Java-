package prducerConsumerSemaphore;

class Producer implements Runnable { 
    Buffer buffer; 
    
    Producer(Buffer buffer) { 
        this.buffer = buffer; 
        new Thread(this, "Producer").start(); 
    } 
  
    public void run() { 
    	while (buffer.counter < buffer.stop) buffer.produce("product n°" + (buffer.counter + 1)); 
    } 
} 
