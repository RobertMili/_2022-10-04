import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.jar.JarEntry;

public class Main {

    static  int counter = 0;
    public static void main(String[] args) {
        System.out.println(dayOfWeek());

        final String data = " Some random text";
        int[] arr = {1};

        higherOrderFunction(text -> System.out.println(text + " " + arr[0]));

    }
    public static void higherOrderFunction(Consumer<String> consumer){

        consumer.accept("Handling this using an implementation handed to us as argument");
    }
        public static int pureFunction(int a){
            return a * 2;
    }
    public static int sideEffects(int a){
        counter++;
        return a;
    }

    public static int nonPureFunction(int a){
        return (int) (a * Math.random());
    }

    public static int dayOfWeek(){
        return LocalDateTime.now().getDayOfWeek().getValue();
    }
    public static String firstMonthOfTheYear(){
        return "January";
    }

}

