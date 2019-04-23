Compile a Java app with `javac`
Run it with `java <class>`
JVM looks for the class given, then looks for its main() function
Every app has at least one class, and at least one main()
main() must be `public static void`

Variables are declared with a type, a name, and an optional initialization value
Classes have information & actions, aka instance variables & methods
All variables must have a type declared, and a name

Names must begins with a letter, underscore, or $

Variables are either primitive or object references

Primitives are built-in - boolean, char, int, float, etc

Everything that isn't a primitive is an object, and variables store references to them: an int variable contains an integer, but a Dog variable contains a reference to the Dog object, not the object itself.

The type of a variable can't be changed, the content can (unless marked final)

Array elements are variables, but an array is an object. A newly-created array of objects contains references of that type to null.

In a method, no reference to the object is needed: just call the method/variable as though native.

If a method takes a param, you must call it with an argument of the right type. If it has a type, it must return a value of that type.

Set variables to private to stop them being accessed except via getters & setters.

Uninitialized instance variables have a value - zero/false/null. Local variables (declared within a method) must be initialized or won't compile.

== is equivalent to eq - means "same primitive" or "same object". Have to use .equals() to find out if two different objects are equivalent.

For loops have two forms:
  for (int i = 0; i < 10; i++) {}
  for (String foo : ArrayOfStrings) {}

Casting: int foo = (int) floatValue;
When needing an array you can resize, take things out of, etc. you can use ArrayList instead

ArrayList<type> myList = new ArrayList<type>;
<type> is a Type Parameter so the compiler knows what type the ArrayList can contain

Methods include add,remove,contains,size,etc.

myList.add(thing);
myList.remove(thing);
myList.remove(0);

&& and || are short-circuiting versions of & and |

In the Java library, classes live in packages. Can either import a class: `import java.util.ArrayList` to import ArrayList from the java.util package; or use its full name wherever it's needed: `java.util.ArrayList<type> foo = new java.util.ArrayList<type>()`

Classes in the java.lang package are always included
Inheritance: subclasses inherit from/extend superclasses

Methods can override less-specific definitions; variables aren't over-ridden (they have no special behaviour) but subclasses can specify new ones.

Private methods are not inheritable

Variables can use superclass types instead of the specific type.
i.e.
Dog myDog = new Dog();        - valid
Animal myAnimal = new Dog();  - valid - a dog isa animal
Dog myDog = new Animal();     - not valid - an animal is not necessarily a dog

That's polymorphism ^
This allows, e.g. an array of pseudo-different types: a dog, a cat, a giraffe, etc. because you can just declare the array type as "animal"

Over-riding a method is when a subclass provides the same method with the same arguments & return types as the super
Over-loading a method is when you have two methods with the same name but different arguments. These can be declared in the same class - no inheritance/polymorphism required

Interfaces are abstract classes
Abstract classes can't be instantiated
e.g. a Dog should be a type of Animal, but one shouldn't be able to create an Animal object - so mark it as an abstract class. Animal is abstract, Dog is concrete.

Can also declare abstract methods. An abstract method can only exist in an abstract class. It must be supplied by over-riding it in the first concrete subclass.

All classes inherit from class Object, which supplies defaults like equals and toString.

Multiple inheritance isn't allowed. To finesse it, use interfaces - 100% abstract classes.
Define: public interface Name {}
Implement: public class Thing extends Parent implements Name {}

interfaces only allow abstract methods so no risk of two parents defining the same method - they can both demand that the subclass implement it, so all good. Basically Java equivalents of roles/mixins. Can implement multiple interfaces.

Create an object via a constructor:
public class Duck{
  public Duck() { // No return type needed
    // Constructor logic goes here
  }
}

The constructor is created automatically by the compiler, but can be manually specified to. Can have useful utilities, like keeping count of how many instances have been created, by adding this to the constructor.

Constructors can also be used to define arguments to be used in creating an object. If a constructor with args is defined, the constructor will not still auto-create the null-argument constructor.

When a new obejct is created, all the constructors in its inheritance tree are called: The first action of a constructor is to call super() - the compiler will insert this call itself unless you specify it yourself. This means that the subclass is always first to be invoked but last to complete. The compiler always calls super() with no arguments - specify it as the first line of the constructor to call super() with args.

Can also have a call to this() instead of super() to call another contructor, e.g. a no-arg constructor can call a one-arg constructor to specify a default value.

For classes that never have internal state - e.g. the Math class - there's no point instantiating an instance and taking up memory, so can just call the methods direct: Math.min(1,2); - its methods are static

To make a class that can't have objects instantiated, make its constructor private.

static methods can't use instance variables or call non-static methods (as these can use instance variables)

A static method can still be called on an object, but shouldn't be.

Setting an instance variable to static makes it a class variable instead - e.g. if you want to keep track of how many objects exist, define `private static int myCount = 0` and then have the constructor run `myCount++`
If it weren't static, mycount would be created for every instance - no good; by setting it static it becomes bound to the class itself - all instances share it

Static variables are always initialized before an instance can be created and before a static method can be run.

Setting a static variable to "final" is the closest thing to a const in java: public static final double PI = 3.141592653589793; Final can also be used to stop a normal variable being redefined; stop a method being over-ridden; and define a class that can't be extended (no subclasses)

Function/method declarations:
public|private [static] <return value> name([params]) [throws <exception name>] {<body>}

If a method throws an exception, it has to declare it via "throws". If you call that method, you have to wrap it in a try/catch or the compiler will fail.

public static void foo() throws Bar { do_thing(); throw new Bar() }
try { foo() }
catch (Bar ex) { // Handle the Bar Exception object stored in the ex variable }
finally { // Do stuff you have to do it either case }

Even if the try or catch block has a return, finally will still run - it *cannot* be bypassed.

A method can declare multiple exceptions it can throw, and they all have to be handled with their own catch block.

A method can declare multiple exceptions it can throw, and they all have to be handled with their own catch block. However, polymorphism applies: You can declare a superclass & it'll deal with all subclasses. e.g. a method that throws a `Dog` exception can be handled by a `catch Animal`; a method that can throw either a `Dog` or a `Cat` exception can declare `throws Animal` if it really wants. etc etc. Catch blocks must be declared from most to least specific.

You can also pass exception handling up the chain by ducking it - declare it in your method just like the method that throws the exception, and it's considered "handled" by the compiler. The method that calls your method will have to handle it - so long as you don't go all the way back up to main() it's all good.

Event-driven is done via listeners, sources and events - basically it's pub/sub. Your object registers itself with a source, e.g. a button. The button calls the object's event-handler when an event occurs & passes it info about the event.

An object that is a source of events will/should have an add<action>Listener() method.

If you declare an object to be a superclass Foo, you can't call a method on it that elongs to the subclass Bar.
e.g. if you have Animal a = new Dog(); you can't call a.bark() because Animals don't bark - dogs do. You have to cast to the right class:
Dog d = (Dog) a;
d.bark();

Classes can be declared within classes when you want scoping benefits - just declare it within the class's curly brackets. Not only useful for event handling - allowing multiple handlers - but also for when your inner class inherits from a different class that the outer.

For multithreading, create a Runnable object with a run() method defining what work it has to do; pass it to a Thread object and call its start() method

Threads can be running, runnable, or blocked. Putting a thread to sleep forces the scheduler to stop it being in the running state, so other threads get a go.
