package dp.decorator;

/**
 * Created by Mryang on 15-6-8.
 */
public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    private void doSomething(){
        System.out.println("ConcreteDecorator2 do something...");
    }

    @Override
    public void operate() {
        super.operate();
        doSomething();
    }
}
