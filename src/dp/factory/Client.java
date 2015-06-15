package dp.factory;

/**
 * Created by Mryang on 15-5-1.
 */
public class Client {

    public static void main(String[] args){
        Product product = Factory.createProduct(ConcreteProd1.class);
        product.method1();
        product.method2();

        product = Factory.createProduct(ConcreteProd2.class);
        product.method1();
        product.method2();
    }
}
