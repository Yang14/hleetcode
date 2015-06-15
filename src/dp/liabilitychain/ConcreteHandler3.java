package dp.liabilitychain;

/**
 * Created by Mryang on 15-6-11.
 */
public class ConcreteHandler3 extends Handler {
    @Override
    protected int getHandlerLevel() {
        return Level.LOW_LEVEL;
    }

    @Override
    protected Response echo(Request request) {
        return new Response(request.getName(),getHandlerLevel());
    }
}
