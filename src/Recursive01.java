public class Recursive01 {
   public static void printNumber(int number){
       if(number<=10){
           System.out.println(number);
           number++;
           printNumber(number);
       }
   }

    public static void main(String[] args) {
        printNumber(0);
    }

    }

