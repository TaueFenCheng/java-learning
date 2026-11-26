package learning;
import org.springframework.context.annotation.*;
@Configuration public class Demo { @Bean String greeting(){return "Hello IoC";} public static void main(String[] args){try(var ctx=new AnnotationConfigApplicationContext(Demo.class)){System.out.println(ctx.getBean(String.class));}} }
