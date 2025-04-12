# Classwork

## demo05 - Daemon threads
// thread is by default non-daemon thread (foreground)
// daemon (background) threads are for giving services to non-daemon (foreground) threads.
// when all non-daemon threads in a java process are terminated, the JVM exits.
// due to this all daemon threads are automatically (forcefully) terminated.
* setDaemon()

## demo06 - Thread args
* Print table 
* join() and priority
*// calling thread i.e. main will wait for completion given thread i.e. th2 
*// calling thread i.e. main will wait for completion given thread i.e. th1 

## demo07 - Thread Priority
* MAX_PRIORITY = 10
* MIN_PRIORITY = 1

## demo08 - Thread states
* getState()

## demo09 - Synchronization () 


* Race condition (// race condition -- when deposit() and withdraw() methods are not declared synchronized)
* synchronized block(// avoid race condition -- when deposit() and withdraw() methods are not declared synchronized
		     // using "synchronized" block
* synchronized method// avoid race condition -- declare deposit() and withdraw() methods are as synchronized

## Inter-Thread communication
#class SunbeamThread extends Thread

