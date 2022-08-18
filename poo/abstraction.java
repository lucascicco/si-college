// BASIC ABSTRACTION
// We can use System.out.println("Hello") to write a string to the
// console without worrying about how the println method works.

// ABSTRACT CLASSES
// An abstract class only has method declarations. it is intended to be
// a superclass for other classes. It doesn't define how methods are
// implemented, only that they are implemented. Abstract classes cannot
// be instantiated and subclasses MUST implement abstract methods.

abstract class FlyingAnimal {
    public abstract void Fly();
}

class Bird extends FlyingAnimal {
    protected String name;
    protected int age;

    Bird(String nm, int newAge) {
        name = nm;
        age = newAge;
    }

    @Override
    public void Fly() {
        System.out.println("Flaps wings majestically.");
    }
}
