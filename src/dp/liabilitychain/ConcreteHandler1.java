package dp.liabilitychain;

/**
 * Created by Mryang on 15-6-11.
 */
public class ConcreteHandler1 extends Handler {
    @Override
    protected int getHandlerLevel() {
        return Level.HIGH_LEVEL;
    }

    @Override
    protected Response echo(Request request) {
        return new Response(request.getName(),getHandlerLevel());
    }
}
