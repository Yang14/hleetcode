package dp.decorator;

/**
 * Created by Mryang on 15-6-8.
 */
public abstract class Decorator extends Component{
    private Component component = null;

    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void operate() {
        this.component.operate();
    }
}
