package prducerConsumerSemaphore;

class Test { 
    public static void main(String args[]) 
    { 
        Buffer buffer = new Buffer(5); 
        new Consumer(buffer); 
        new Producer(buffer); 
    } 
} 
