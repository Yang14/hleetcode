package dp.liabilitychain;

/**
 * Created by Mryang on 15-6-11.
 */
public class ConcreteHandler2 extends Handler {
    @Override
    protected int getHandlerLevel() {
        return Level.MID_LEVEL;
    }

    @Override
    protected Response echo(Request request) {
        return new Response(request.getName(),getHandlerLevel());
    }
}
