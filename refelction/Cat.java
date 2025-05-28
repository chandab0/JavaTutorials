
public class Cat{
    private final String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private void thisIsPrivate() {
        System.out.println("This is a private method in Cat class.");
    }

    private static void thisIsStaticPrivate() {
        System.out.println("This is a static private method in Cat class.");
    }

    //To test private field access
    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
