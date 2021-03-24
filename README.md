# Producer-Consumer-Model-with-Semaphore-in-Java-
We have two concurrent threads (the producer and the consumer) that are executing in synchronization thanks to 2 semaphores.

We choose the buffer's size in which the producer produces a product, so the producer semaphore (named prodSema in the code) has a value which tells the 
producer how many products can be added to the buffer, this value sarts with the buffer's size.  every time the producer aquire this semaphore to produce, 
it decrementes its value by 1 after producing a product the consumer semaphore is released (it increments its value by 1) so the consumer can consume a 
product. 

With this model, the producer doesn't wait for the consumer in order to produce other products, it just checks if there's a remaining space in the buffer 
and the consumer keeps consuming a product as long as there's one available in the buffer.

We set a stop value which tells the maximum number of products that are produced, when the producer reaches this number of products, it stops. The consumer checks if
the maximum number of products is reached and if there's no remaining products in the buffer waiting to be consumed in order to stop.




