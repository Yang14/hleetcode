package dp.liabilitychain;

/**
 * Created by Mryang on 15-6-11.
 */
public class Request {
    private String name;
    private int level;
    public Request(String name, int level){
        this.level = level;
        this.name = name;
    }
    public int getRequestLevel(){
        return this.level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
