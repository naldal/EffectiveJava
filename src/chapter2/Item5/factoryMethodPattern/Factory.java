package chapter2.Item5.factoryMethodPattern;

// 여기가 팩토리 메소드
abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProject(p);
        return p;
    }

    protected abstract Product createProduct(String owner);
    protected abstract void registerProject(Product p);
}
