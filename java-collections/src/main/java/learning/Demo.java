package learning;
public class Demo {  public static void main(String[] args) throws Exception { var counts = new java.util.HashMap<String,Integer>(); for (String s : java.util.List.of("a","b","a")) counts.merge(s,1,Integer::sum); System.out.println(counts); } }
