package Lesson9;

public class BoxDemo5 {
    public static void main(String[] args) {
        Box myboxs1 = new Box();
        Box mybox2 = new Box();
        double vol;
        myboxs1.setDim(10, 20, 15);
        mybox2.setDim(3, 6, 9);
        vol = myboxs1.volume();
        System.out.println(vol);
        vol = mybox2.volume();
        System.out.println(vol);
    }
}
