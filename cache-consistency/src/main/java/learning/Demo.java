package learning;
public class Demo {  public static void main(String[] args) throws Exception { var db = new java.util.HashMap<String,String>(); var cache = new java.util.HashMap<String,String>(); db.put("id","old"); cache.put("id","old"); db.put("id","new"); cache.remove("id"); System.out.println(cache.computeIfAbsent("id", db::get)); } }
