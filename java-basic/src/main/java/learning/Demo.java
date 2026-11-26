package learning;
public class Demo { record User(String name, int age) {} public static void main(String[] args) throws Exception { var user = new User("Alice", 20); System.out.println(user.name()); } }
