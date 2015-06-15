package dp.liabilitychain;

/**
 * Created by Mryang on 15-6-11.
 */
public abstract class Handler {
    private Handler nextHandler;

    public final Response handleRequest(Request request){
        Response response = null;

        if (this.getHandlerLevel() == (request.getRequestLevel())){
            response = this.echo(request);
        }else {
            if (this.nextHandler != null){
                response = this.nextHandler.handleRequest(request);
            }else {
                System.out.println("no handler can handle this request");
            }
        }
        return response;
    }

    public void setNextHandler(Handler handler){
        this.nextHandler = handler;
    }

    protected abstract int getHandlerLevel();

    protected abstract Response echo(Request request);

}
