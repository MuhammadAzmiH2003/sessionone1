package BubbleSort;

public class Bubblesort {

    private String[] data;

    public Bubblesort(){

    }
    public String[] getData() { return data; }

    public void setData(String [] data) {
        this.data = data;
    }

    public void sortData() {
        int lenData = data.length;
        for (int i = 0; i<lenData;i++){
            for (int j=i+1;j<lenData;j++){
                if (this.data[j].compareTo(this.data[j])>0){
                    String temp = this.data[i];
                    this.data[i] = this.data[j];
                    this.data[j] = temp;
                }
            }

        }

    }
    public void PrintData(){
        for (String datum : this.data) {
            System.out.println(datum+" ");
        }
    }

    public static void main(String[] args) {
        // int[] S = new int[]{10,35,32,13,26};
        String[] nama = {"spiderman","superman","batman","wonderwoman","gundala"};
        Bubblesort _myBubble = new Bubblesort();
        _myBubble.setData(nama);
        _myBubble.sortData();
        _myBubble.PrintData();



    }
}
