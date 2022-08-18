// INTERFACES
// Classes can only inherit from one superclass, but they can implement
// multiple interfaces. This expands our ability to make good use of
// abstraction. Classes that implement interfaces MUST implement the
// methods in the interface.

// Regular class
class Animal {
    private String name;
    private int age;

    public void identify() {
        System.out.println("I am an animal!");
    }

    public void rename(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void setAge(int newAge) {
        if(newAge > 0)
            age = newAge;
    }

    public int getAge() {
        return age;
    }
}

// Interface for things that fly. We don't care how they fly, just that
// they can fly.
public interface ICanFly {
    void Fly();
}

// Interface for things that swim. We don't care how they swim, just
// that they can swim.
public interface ICanSwim {
    void Swim();
}

// A Duck is an Animal that can fly and swim.
class Duck extends Animal implements ICanFly, ICanSwim {
    public void Quack() {
        System.out.println("QUACK!");
    }

    @Override
    public void Identify() {
        System.out.println("I am a duck!");
    }

    @Override
    public void Fly() {
        System.out.println("Flaps wings majestically.");
    }

    @Override
    public void Swim() {
        System.out.println("Kicks feet.");
    }
}

// A Fish is an Animal that can swim. Notice the implementation of the
// Swim method is different for a fish than a duck.
class Fish extends Animal implements ICanSwim {
    @Override
    public void Identify() {
        System.out.println("I am a fish!");
    }

    @Override
    public void Swim() {
        System.out.println("Wiggles fish-body");
    }
}

// An AirPlane is not an animal, but it can still fly.
class AirPlane implements ICanFly {
    protected String name;
    protected int mileage;

    @Override
    public void Fly() {
        System.out.println("Turns propeller");
    }
}
