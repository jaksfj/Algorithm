import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        int result = 0;
        if(!first.equals("Fizz") && !first.equals("Buzz") && !first.equals("FizzBuzz")){
            result = Integer.parseInt(first) + 3;
        }else if(!second.equals("Fizz") && !second.equals("Buzz") && !second.equals("FizzBuzz")){
            result = Integer.parseInt(second) + 2;
        }else if(!third.equals("Fizz") && !third.equals("Buzz") && !third.equals("FizzBuzz")) {
            result = Integer.parseInt(third) + 1;
        }

        if(result%3==0 && result%5==0){
            System.out.println("FizzBuzz");
        }else if(result%3==0){
            System.out.println("Fizz");
        }else if(result%5==0){
            System.out.println("Buzz");
        }else{
            System.out.println(result);
        }
    }
}
