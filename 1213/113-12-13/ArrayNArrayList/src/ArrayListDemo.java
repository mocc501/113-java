import java.util.ArrayList;
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");


        System.out.println("ArrayList: " + list);














        int size =  list .size();
        System.out.println("ArrayList大小" + size);

        boolean containsCheery = list.contains("Cheery");
        System.out.println("ArrayList是否包含Cheery" + containsCheery);

        if(!list.isEmpty()){
            System.out.println("使用迴圈訪問元素");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }

        else{
            System.out.println("ArrayList是空的");
        }
    }
}
