package prducerConsumerSemaphore;

class Consumer implements Runnable { 
    Buffer buffer; 
    
    Consumer(Buffer buffer) { 
    	this.buffer = buffer; 
        new Thread(this, "Consumer").start(); 
    } 
    
    public void run() {  
    	while (buffer.counter < buffer.stop || buffer.products.size() > 0) buffer.consume(); 
    } 
} 