package homework4.task26;

/**
 * Created by koval on 24.11.2016.
 */
public class BacteriumColonyFactory {

    private static final BacteriumColonyFactory instance = new BacteriumColonyFactory();

    public static BacteriumColonyFactory getInstance() {
        return instance;
    }

    public BacteriaColony createBacteriaColony(final Bacteria bacteria) {
        ValidationFactory.getInstance().validate(bacteria);
        return new BacteriaColony(bacteria);
    }


}
