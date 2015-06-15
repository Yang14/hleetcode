package dp.liabilitychain;

/**
 * Created by Mryang on 15-6-11.
 */
public class Response {

    private String requestName;
    private int level;

    public Response(String requestName,int level){
        this.requestName = requestName;
        this.level = level;
    }

    public void output(){
        System.out.println("handle the request:" + requestName +" and level is :" + level);
    }

}
