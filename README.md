# Process-Synchronization
A solution to the bounded-buffer problem using the producer and consumer processes written in Java.

## How to compile and run project:

Use NetBeans (Java IDE) to run the project. <br />
When you run the project (by clicking run or F6) the program will ask you to put in your parameters (Milliseconds, Producer threads, Consumer threads). <br />
For example if you wanted to run the program for 5 seconds, 2 Producer threads and 2 Consumer the input would go as follows: <br />

Enter the sleep time (in ms): <br />
5000 <br />
Enter the amount of producers: <br />
2 <br />
Enter the amount of consumers: <br />
2 <br />

After this the program will run based on your input, and the time consumed for the run will be displayed.

## Test Run

Entering these parameters; 3000 (3 seconds), 3 (Producer threads), 3 (Consumer threads) the running results are as follows:

run: <br />
Enter the sleep time (in ms): <br />
3000 <br />
Enter the amount of producers: <br />
3 <br />
Enter the amount of consumers: <br />
3 <br />

Producer produced 861<br />
Consumer consumed 861<br />
Producer produced 356<br />
Producer produced 934<br />
Producer produced 228<br />
Consumer consumed 356<br />
Consumer consumed 934<br />
Consumer consumed 228<br />
Producer produced 782<br />
Consumer consumed 782<br />
Producer produced 875<br />
Consumer consumed 875<br />
Producer produced 461<br />
Consumer consumed 461<br />
Producer produced 597<br />
Consumer consumed 597<br />
Producer produced 547<br />
Consumer consumed 547<br />
Producer produced 245<br />
Producer produced 792<br />
Consumer consumed 245<br />
Producer produced 387<br />
Producer produced 329<br />
Consumer consumed 792<br />
Consumer consumed 387<br />
Producer produced 928<br />
Producer produced 353<br />
Producer produced 452<br />
Time consumed: 3 seconds<br />
BUILD SUCCESSFUL (total time: 8 seconds)<br />

## Running Result Analysis

This result is the expected running result for this project. <br />
The producer thread is initialised and outputs a random number, the consumer thread is then initialised and "consumes" or removes this number. <br />
This number is stored in a buffer, which is only capable of holding 5 numbers. <br />
The defined sleep time is also the run time or the amount of time the program will continue to produce and consume numbers, in this case 2 seconds. <br />
The producer and consumer threads will continue to interact with the buffer continously due to while loops that let the code run until it reaches sleep/run time. <br />
The interval at which either producers or consumers interact with the buffer is random. <br />
Sometimes the producer will only create 1 number, other times 3, this is the same for the consumption of numbers. 

The mutex semaphore in the buffer class will ensure mutual exclusion of access to the buffer (array). <br />
This means that when either the producer or the consumer is accessing the buffer, the mutex semaphore will lock access to that process. <br />
Once the process is finished it will release the lock and allow the next process access. 

Empty and full semaphores will keep track of the amount of elements (or random numbers) in the buffer. <br />
When these semaphores are referenced from other classes it will make sure that removing or adding values to the buffer is possible. <br />
For example if the buffer already has 5 elements, the full semaphore will tell the producer class that they cannot add more elements until the consumer removes an element to make room.
