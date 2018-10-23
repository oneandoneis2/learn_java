public class DomsFirstApp {
  public static void main (String[] args) {
    System.out.println("Yay!");
    System.out.println("It works!");
    for (int x = 0; x < 10; x++) {
      System.out.println("x is now " + x);
    }

    Dog fido = new Dog();
    fido.name = "Fido";
    fido.bark();
    fido.chase("cat");
  }
}

class Dog {
    String name;

    public void bark() {
        System.out.println(name + " goes woof!");
    }

    public void chase(String thing) {
        bark();
        System.out.println(name + " chases the " + thing);
    }
}
