import java.util.ArrayList;
//Thread1 reads from 0 to 7848
public class MyThread1 implements Runnable{
    ArrayList<String> A = null;
    float minSize;
    float maxSize;

    public MyThread1(ArrayList<String> a, float minSize, float maxSize) {
        A = a;
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        System.out.println("Thread started");
        readFileChunk(A,minSize,maxSize);
            }

     public ArrayList<String> readFileChunk(ArrayList<String> Data,float minsize,float maxSize){
        for(int i = (int) minsize; i<maxSize; i++){
            System.out.println(Data.get((int) i));

        }

         return Data;
     }
}
