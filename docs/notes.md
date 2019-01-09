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
