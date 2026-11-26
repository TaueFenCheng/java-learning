package learning;
public class Demo {  public static void main(String[] args) throws Exception { var runtime = Runtime.getRuntime(); System.out.println("max heap: " + runtime.maxMemory()); System.out.println(java.lang.management.ManagementFactory.getGarbageCollectorMXBeans()); } }
