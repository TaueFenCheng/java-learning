package learning;
public class Demo {  public static void main(String[] args) throws Exception { var lock = new java.util.concurrent.locks.ReentrantLock(); lock.lock(); try { System.out.println("local critical section; not a distributed lock"); } finally { lock.unlock(); } } }
