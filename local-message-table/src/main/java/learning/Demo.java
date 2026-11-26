package learning;
public class Demo { record Event(String id, String payload) {} public static void main(String[] args) throws Exception { var outbox = new java.util.ArrayList<Event>(); outbox.add(new Event("order-1", "created")); var seen = new java.util.HashSet<String>(); for(var e: outbox) if(seen.add(e.id())) System.out.println(e.payload()); } }
