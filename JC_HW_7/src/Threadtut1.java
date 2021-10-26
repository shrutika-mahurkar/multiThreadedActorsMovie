public class Threadtut1 {
    public static void main(String args[]){
        System.out.println(Thread.currentThread().getName());
        Thradtut2 myth1 = new Thradtut2();
        myth1.start();

       myth1.setName("tortoise");
        System.out.println(myth1.getName());
        System.out.println("done");
    }
}
