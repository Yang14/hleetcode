package dp.decorator;

/**
 * Created by Mryang on 15-6-8.
 */
public class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    private void doSomething(){
        System.out.println("ConcreteDecorator1 do something...");
    }

    @Override
    public void operate() {
        doSomething();
        super.operate();
    }
}
