# Παραμετρικοί τύποι δεδομένων (Generics)

Ένας παραμετρικός (generic) τύπος δεδομένων είναι ένας τύπος δεδομένων ο οποίος μπορεί να λαμβάνει ως παραμέτρους άλλους τύπους δεδομένων. Γενικότερα όταν θέλουμε να χρησιμοποιήσουμε κλάσεις που μπορούν να αποθηκεύσουν αντικείμενα οποιασδήποτε κλάσης (π.χ. για αν δημιουργήσουμε μία διασυνδεδεμένη λίστα) τότε θα πρέπει τις κλάσεις αυτές να τις κάνουμε τόσο γενικές ώστε να μπορούν να λαμβάνουν ως όρισμα οποιονδήποτε τύπο δεδομένων. Η υιοθέτηση γενικών κλάσεων έχει το πλεονέκτημα ότι μπορεί να αποθηκεύσει οποιαδήποτε κλάση, όμως απαιτεί αρκετά type-casts και ενέχει κινδύνους ως προς την ορθή διαχείριση των δεδομένων από τους προγραμματιστές.

Δείτε το παρακάτω παράδειγμα της κλάσης Box, η οποία θέλουμε να μπορεί να αποθηκεύσει οποιονδήποτε τύπο δεδομένων.

## Box.java

```java
public class Box {
  private Object object;
 
  public void set(Object object) { this.object = object; }
  public Object get() { return object; }
}
```

Στο παραπάνω παράδειγμα επειδή όλες οι κλάσεις στη Java κληρονομούν την κλάση [java.lang.Object](http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html), μπορείτε να περάσετε ως όρισμα στις μεθόδους της συγκεκριμένης κλάσης οποιοδήποτε τύπο δεδομένων. Δείτε το παρακάτω παράδειγμα κώδικα που χρησιμοποιεί την κλάση Box.

## BoxUsage.java

```java
public class BoxUsage {
   public static void main(String args[]) {
     Box b = new Box();
     Integer n = new Integer(5);
     b.set(n);
     String s = (String)b.get();
   }
}
```

Ο παραπάνω κώδικας αφού μεταγλωττιστεί και επιχειρήσουμε να το τρέξουμε παράγει το παρακάτω exception καθώς επιχειρούμε να αναθέσουμε μία μεταβλητή τύπου String ένα αντικείμενο τύπου Integer.

```
Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        at BoxUsage.main(BoxUsage.java:7)
```

Παρατηρήστε επίσης, ότι στην τελευταία γραμμή είμαστε υποχρεωμένοι να κάνουμε cast την επιστρεφόμενη τιμή της μεθόδου get() από Object σε String. Προκειμένου να αποφύγουμε τα παραπάνω προβλήματα και να είμαστε σίγουροι ότι ο κώδικας που γράφουμε δεν περιέχει λάθη στη χρήση τύπων δεδομένων η Java εισάγει τους παραμετρικούς τύπους δεδομένων, γνωστούς ως Generics. Η κλάση Box με χρήση Generics θα μπορούσε να γραφεί ως εξής:

### GenericBox.java
```java
/**
 * Generic version of the Box class.
 * @param <T> the type of the value being boxed
 */
public class Box<T> {
  // T stands for "Type"
  private T t;
 
  public void set(T t) { this.t = t; }
  public T get() { return t; }
}
```

Η παραπάνω δήλωση της κλάσης *Box* σημαίνει ότι κατά τον ορισμό αντικειμένων της κλάσης αυτά θα πρέπει να προσδιορίζεται ανάμεσα στους χαρακτήρες '<', ΄>' ένας επιπλέον reference τύπος δεδομένων, δηλ μπορούμε να γράψουμε

```java
Box<String> b1 = new Box<String>();
Box<Integer> b2  = new Box<Integer>();
Box<Student> b3 = new Box<Student>(); // όπου Student μία κλάση που έχουμε κατασκευάσει. 
```

Ο τύπος δεδομένων που χρησιμοποιούμε ανάμεσα στους χαρακτήρες '<', ΄>' είναι ο τύπος δεδομένων που επιτρέπεται να αποθηκευθεί στην κλάση *Box* κάθε φορά.

## Δημιουργία και χρήση αντικειμένων ενός γενικού τύπου δεδομένων

```java
Box<Integer> integerBox = new Box<Integer>();
```

Εναλλακτικά μπορείτε να γράψετε

```java
Box<Integer> integerBox = new Box<>();
```

Εδώ ο compiler αντιλαμβάνεται ότι δημιουργείται μία μεταβλητή τύπου `Box<Integer>` και δημιουργεί ένα αντικείμενο αυτού του τύπου

**Προσοχή**: το παραπάνω δεν είναι ίδιο με το παρακάτω.

```java
Box<Integer> integerBox = new Box();
```
Στο τελευταίο ο compiler θα εκδώσει το παρακάτω warning.

```
Note: BoxUsage.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
```

## Παραμετρικοί τύποι δεδομένων με πολλές παραμέτρους

Πριν προχωρήσουμε σε ένα παράδειγμα παραμετρικών τύπων με πολλές παραμέτρους είναι χρήσιμο να πούμε ότι παραμετρικούς τύπους μπορούν να ορίζουν εκτός από κλάσεις και Interfaces. Δείτε το παρακάτω παράδειγμα.

### Pair.java

```java
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
    public void setKey(K key);
    public void setValue(V value);
}
```

### OrderedPair.java
```java
public class OrderedPair<K, V> implements Pair<K,V> {
 
    private K key;
    private V value;
 
    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }
 
    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    public K getKey()   { return key; }
    public V getValue() { return value; }
}
```

Με βάση τον παραπάνω κώδικα μπορείτε να δημιουργήσετε αντικείμενα επιμέρους τύπων ως εξής:

### OrderedPairUsage.java

```java
public class OrderedPairUsage {
  public static void main(String args[]) {
    Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
    Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");
    OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>());
    // the following is not allowed
    Pair<String, Integer> p1 = new OrderedPair<>("hello", "world");
  }
}
```

## Άσκηση 4

Υλοποιείστε την παραμετρική κλάση **`TwoDShape<T>`** η οποία δημιουργεί ένα παραμετρικο τύπο δεδομένων με παράμετρο **Τ**. Η παραπάνω κλάση έχει ένα πεδίο τύπου **Τ** με όνομα **shape** και ένα πεδίο τύπου **String** με όνομα **name**. Και τα δύο πεδία είναι *private*. Δημιουργήστε τον κατάλληλο κατασκευαστή και τις απαραίτητες **set** και **get** μεθόδους για τα παραπάνω δύο πεδία (σε αναλογία με την κλάση **Box** παραπάνω).

Επίσης, υλοποιείστε την μέθοδο **`public String toString()`** για την κλάση **`TwoDShape<T>`**, ως συνένωση του String name με το String που εκτυπώνεται από κάθε αντικείμενο τύπου T. (προτεινόμενη μορφή “[name]” + T.toString()).

Στην συνέχεια χρησιμοποιήστε την παρακάτω κλάση **TwoDShapeUsage** για να δοκιμάσετε τον κώδικα σας.

### TwoDShapeUsage.java

```java
public class TwoDShapeUsage {
  public static void main(String [] args) {
    Rectangle rect = new Rectangle(10,20);
    TwoDShape<Rectangle> shape1 = new TwoDShape<Rectangle>(rect, "Rectangle(10x20)");
    Circle circle = new Circle(10);
    TwoDShape<Circle> shape2 = new TwoDShape<Circle>(circle, "Circle(radius 10)");
    System.out.println("shape1 is "+ shape1.toString());
    System.out.println("shape2 is "+ shape2.toString());
  }
}
```
