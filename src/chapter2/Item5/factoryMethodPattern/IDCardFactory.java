package chapter2.Item5.factoryMethodPattern;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {
    private List<String> owner = new ArrayList<>();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProject(Product p) {
        owner.add(((IDCard)p).getOwner());
    }

    public List<String> getOwner() {
        return owner;
    }
}
