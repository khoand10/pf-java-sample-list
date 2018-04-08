import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayListImpl<Integer> list = new ArrayListImpl<Integer>(10);
        list.add(1);
        list.add(2);
        list.add(3);
        for (Integer a:list.elements) {
            System.out.println(a+"-");
        }
    }
}
