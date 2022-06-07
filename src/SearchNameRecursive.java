import java.util.Scanner;

public class SearchNameRecursive {
    static int index = 0;
    static String status;

    static void FindName(String searchtext, String[] data) {
        if (index < data.length) {
            if (data[index].equals(searchtext)) {
                status = "Data Match";
                System.out.println(searchtext + " is on  position index = " + index + " of array " + data[index] + "  " + status);
                System.out.println(0);
            } else {
                if (index < 6) {
                    index++;
                    FindName(searchtext, data);
                    status = "Bot match";
                    System.out.println(searchtext + " " + data[index] + " " + status);
                }
            }
        }
    }
    static String inputName(){
        try {
            String name;
            Scanner nameInput = new Scanner(System.in);
            System.out.println("Masukan Nama Yang dicari = ");
            name = nameInput.nextLine();
            nameInput.close();
            return name;
        }catch (Exception e){
        }
        return null;
    }

    public static void main(String[] args) {
        String[] people = {"Rudi","Agus","Putri","ika","Rizki","summacher"};
        String nameSearch = inputName();
        FindName(nameSearch,people);
    }
}


