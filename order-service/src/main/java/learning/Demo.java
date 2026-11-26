package learning;
public class Demo {  public static void main(String[] args) throws Exception { var stock = new java.util.concurrent.atomic.AtomicInteger(1); boolean reserved = stock.compareAndSet(1,0); if (!reserved) throw new IllegalStateException("sold out"); System.out.println("reserved"); } }
