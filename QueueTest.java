public class QueueTest{
    public static void main(String []args){
        Queue testing = new Queue();
        
        testing.add(0);
        testing.add(1);
        testing.add(2);
        testing.add(3);
        testing.add(4);
        testing.add(5);
        testing.add(6);

        System.out.println(testing.remove());
        System.out.println(testing.remove());
        System.out.println(testing.remove());
        System.out.println(testing.remove());
        System.out.println(testing.remove());

        testing.add(100);

        System.out.println("front of queue " + testing.front.item);
        System.out.println("back of queue " + testing.back.item);

        System.out.println(testing.remove());
        System.out.println(testing.remove());
        System.out.println(testing.remove());

    }

}