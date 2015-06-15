package dp.decorator;

/**
 * Created by Mryang on 15-6-8.
 */
public class Client {

    public static void main(String[] args){
        Component com = new ConcreteComponent();
        com = new ConcreteDecorator1(com);
        com = new ConcreteDecorator2(com);
        com.operate();
        System.out.println(1/2);
    }
}
