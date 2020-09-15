/**
 * Example GenericPair: our pair structure, but now with type parameters
 * to enforce consistency of the usage of a given instance of the class.
 *
 * @author Jim Teresco, The College of Saint Rose, CSC 523, Summer 2014
 * CSIS 210, Siena College, Fall 2016, Fall 2017
 * @version Fall 2019
 *
 */

// First, notice that we now have "type parameters" after our class name.
// These tell us what kinds of objects we will use for the first (U), and
// second (V) values in our pair.
public class GenericPair<U,V> {

    // our instance variables will be the generic types U and V
    // which will be filled in with actual types when we create an
    // instance of the class, much like an actual parameter gives
    // a value to a formal parameter when a method is called.
    private U first;
    private V second;

    // our constructor for a new GenericPair
    // note that the formal parameter types are now
    // the U and V types
    /**
     * Construct a new GenericPair
     * 
     * @param first the first item in the pair
     * @param second the second item in the pair
     */
    public GenericPair(U first, V second) {

        this.first = first;
        this.second = second;
    }

    // accessors and mutators below also now use the generic types

    /**
     * Get the first item in the pair
     *
     * @return the first item in the pair
     */
    public U getFirst() {

        return first;
    }

    /**
     * Get the second item in the pair
     *
     * @return the second item in the pair
     */
    public V getSecond() {

        return second;
    }

    /**
     * Modify the first item in the pair
     *
     * @param newFirst the new first item in the pair
     */
    public void setFirst(U newFirst) {

        first = newFirst;
    }

    /**
     * Modify the second item in the pair
     *
     * @param newSecond the new first item in the pair
     */
    public void setSecond(V newSecond) {

        second = newSecond;
    }

    /**
     * Modify the second item in the pair
     *
     * @param newSecond the new first item in the pair
     */
    public void setValues(U newFirst, V newSecond) {

        first = newFirst;
        second = newSecond;
    }

    /**
     * Return a String to make this look like a coordinate pair (seems as
     * good as anything and likely to be useful in many contexts).
     * Note that we are implcitly using the toString methods of the
     * objects we encapsulate.
     *
     * @return the objects in the pair, in parentheses separated by a comma
     */
    @Override
    public String toString() {

        return "(" + first + ", " + second + ")";
    }

    /**
     * Check for equality of this GenericPair with another, defined by both
     * items in the pair being equal to those in the other pair.
     *
     * @param o the other GenericPair
     * @return whether this GenericPair is equal to o
     */
    @Override
    public boolean equals(Object o) {

        GenericPair<U,V> other = (GenericPair<U,V>)o;
        return other.first.equals(first) && other.second.equals(second);
    }

    /**
     * main method to run some test cases.
     *
     * @param args not used.
     */
    public static void main(String args[]) {

        // we'll create a few GenericPair objects and print them out
        // note that we need to specify the actual types we
        // intend to use for the first and second now, and where
        // we want a primitive type, we must specify the "boxed"
        // equivalent object type
        GenericPair<String,Double> a = new GenericPair<String,Double>("Bob", 9.1);
        GenericPair<String,Double> b = new GenericPair<String,Double>("Alice", 0.0);
        
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        
        // try out the accessors
        System.out.println("a.getFirst(): " + a.getFirst());
        System.out.println("a.getSecond(): " + a.getSecond());
        System.out.println("b.getFirst(): " + b.getFirst());
        System.out.println("b.getSecond(): " + b.getSecond());
        
        // are they equal?
        System.out.println("a.equals(b): " + a.equals(b));
        
        // mutators!
        a.setFirst("Charlie");
        a.setSecond(-23.5);
        b.setValues("Charlie", -23.5);
        
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        
        // are they equal now?  Hope so!
        System.out.println("a.equals(b): " + a.equals(b));
        
        // and we can use other types too
        GenericPair<Integer,String> c = new GenericPair<Integer,String>(2, "Jeter");
        
        // uncomment the following to see what happens if we send
        // the wrong type of object to the equals method
        //System.out.println("a.equals(\"hi there\"): " + a.equals("high there"));


    }
}
