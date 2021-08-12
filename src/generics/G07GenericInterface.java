package generics;

public class G07GenericInterface {
    public static void main(String[] args) {
        usAlma<Float> floatUs = new usAlma<>();
        System.out.println(floatUs.usAl(5f, 2f));

        usAlma<Integer> intUs = new usAlma<>();
        System.out.println(intUs.usAl(2, 3));

        usAlma<Double> doubleUs = new usAlma<>();
        System.out.println(doubleUs.usAl(3.0, 100.0));

    }
}

// Generic interface tanımlaması
interface Matematik <T extends Number> {
    double usAl(T t, T u);
}

// Generic classımızı Matematik Interface'inin implament etti.
class usAlma <T extends Number> implements Matematik<T> {
    @Override
    public double usAl(T t, T u){
        return Math.pow(t.doubleValue(), u.doubleValue());
    }
}
