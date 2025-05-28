
import java.lang.reflect.*;

class ReflectionTutorial {
    public static void main(String[] args) {
        try {
            // Load the class dynamically   
            Class<?> catClass = Class.forName("Cat");
            // Create an instance of the class

            Object catInstance = catClass.getDeclaredConstructor(String.class, int.class)
                                          .newInstance("Whiskers", 3);
            // Print the class name
            System.out.println("Class Name: " + catInstance.getClass().getName());  
            System.out.println(catInstance);

            Cat cat = new Cat("Test", 1);
            System.out.println("Cat before reflection: " + cat);

            // Access the private field 'name' using reflection
            Field[] fields = cat.getClass().getDeclaredFields();
            for(Field field: fields){
                if(field.getName().equals("name"))
                {
                    field.setAccessible(true);
                    field.set(cat,"Test2");
                    System.out.println("Updated Cat after reflection: " + cat);
                }
                
            }

            Method[] methods = cat.getClass().getDeclaredMethods();
            for(Method method : methods){
                //System.out.println("Method Name: " + method.getName());
                
                if(method.getName().equals("thisIsPrivate")){
                    method.setAccessible(true);
                    method.invoke(cat);
                }

                if(method.getName().equals("thisIsStaticPrivate")){
                    method.setAccessible(true);
                    method.invoke(null); // Static method, so pass null
                }

                if(method.getName().equals("setAge")){
                    method.setAccessible(true);
                    method.invoke(cat, 5); // Set age to 5
                    System.out.println("Updated Cat after setting age: " + cat);
                }
            }

        }
        catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        } catch (InstantiationException e) {
            System.err.println("Could not instantiate class: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.err.println("Illegal access: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            System.err.println("No such method: " + e.getMessage());
        } catch (java.lang.reflect.InvocationTargetException e) {
            System.err.println("Invocation target exception: " + e.getMessage());
        }
    }
}