package dp.liabilitychain;

/**
 * Created by Mryang on 15-6-11.
 */
public class Client {

    public static void main(String[] args){
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        Handler h3 = new ConcreteHandler3();

        h1.setNextHandler(h2);
        h2.setNextHandler(h3);

        Response response = h1.handleRequest(new Request("test",Level.LOW_LEVEL));
        response.output();
    }
}
