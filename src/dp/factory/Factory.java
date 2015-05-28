package dp.factory;

/**
 * Created by Mryang on 15-5-1.
 */
public class Factory {

    public static <T extends Product> T createProduct(Class<T> c){
        Product product = null;

        try {
            product = (Product) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) product;
    }


}
