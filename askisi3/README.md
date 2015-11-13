# Διεπαφές (Interfaces)

Τα interfaces στην Java λειτουργούν ως προ-συμφωνημένες διεπαφές για τους προγραμματιστές. Κάθε interface περιέχει ένα σύνολο μεθόδων (μόνο τα prototypes τους) οι οποίες προδιαγράφουν την συμπεριφορά των κλάσεων που υλοποιούν το συγκεκριμένο interface. Αν δύο κλάσεις υλοποιούν το ίδιο interface υλοποιούν ΟΛΕΣ τις μεθόδους που υλοποιεί το συγκεκριμένο interface. Η συγκεκριμένη ιδιότητα μπορεί να είναι πολύ χρήσιμη όταν επιθυμούμε να προτυποποιήσουμε κοινές μεθόδους (συμπεριφορές) μεταξύ κλάσεων.

Ένα interface συνήθως δεν περιέχει υλοποίηση μεθόδων (υπάρχουν κάποιες εξαιρέσεις στην Java 8, με τις οποίες δεν θα ασχοληθούμε), αλλά μόνο τα πρωτότυπα αυτών (abstract μεθόδους).

## Ορίζοντας ένα Interface

Παρακάτω δίνεται το παράδειγμα ορισμού ενός Interface ως εξής:

```java
public interface MyInterface extends Interface1, Interface2, Interface3 {
 
    // constant declarations    
    // base of natural logarithms
    double E = 2.718282;
    double PI = 3.14159;
 
    // method signatures
    public void interfaceMethod(int i, double x);
    public int interfaceMethod2(String s);
}
```

- **public ή κανένας προσδιοριστής πρόσβασης**: Αν οριστεί public τότε το interface είναι ορατό από όλες τις κλάσεις και όλα τα πακέτα στην Java. Αν δεν οριστεί κάτι (package private) τότε το interface είναι ορατό μόνο μέσα στο πακέτο στο οποίο δηλώνεται.
- **interface**: δεσμευμένη λέξη
- **το όνομα του interface**: στο παράδειγμα μας MyInterface.
- **extends**: ένα ή περισσότερα interfaces τα οποία επεκτείνει το συγκεκριμένο interface (comma seperated).

Τόσο στις κλάσεις όσο και στα interfaces ορίζεται η ιδιότητα της κληρονομικότητας. **Η διαφορά είναι ότι ενώ στην κλάση μπορούμε να έχουμε μόνο μία γονική κλάση, στα interfaces μπορούμε να έχουμε περισσότερα του ενός γονικά interfaces**.

> Ακριβώς όπως και οι κλάσεις κάθε interface πρέπει να βρίσκεται σε ξεχωριστό αρχείο, όπου το όνομα του αρχείου ταυτίζεται με το όνομα του interface και έχει κατάληξη **.java**. Για παράδειγμα το interface με όνομα **MyInterface** θα βρίσκεται σε ένα αρχείο με όνομα **MyInterface.java**.

### Το σώμα του interface

Ένα interface μπορεί να περιέχει πεδία όπως στο παραπάνω παράδειγμα.

```java
double E = 2.718282;
double PI = 3.14159;
```

Τα πεδία αυτά εξ ορισμού (by default) `public, static, final`, δηλ είναι **σταθερές** που ανήκουν στις κλάσεις που θα υλοποιήσουν το interface στο οποίο δηλώνονται.

Οι μέθοδοι σε ένα interface κατά κανόνα είναι **abstract**, δηλαδή περιέχεται μόνο η δήλωση της μεθόδου χωρίς σώμα (δηλ. υλοποίηση). Επίσης, όλες οι μέθοδοι σε ένα interface είναι εξ ορισμού public, κατά συνέπεια ο προσδιορισστής public μπορεί να παραληφθεί δηλ

```java
public interface MyInterface extends Interface1, Interface2, Interface3 {
 
    // constant declarations    
    // base of natural logarithms
    double E = 2.718282;
    double PI = 3.14159;
 
    // method signatures
    public void interfaceMethod(int i, double x);
    public int interfaceMethod2(String s);
}
```

## Υλοποιώντας ένα Interface

Ας υποθέσουμε ότι για τις ανάγκες αυτής της παραγράφου ορίζουμε ένα interface το οποίο ορίζει ένα τρόπο για να συγκρίνουμε το μέγεθος επιμέρους αντικειμένων.

### StrictlyComparable.java

```java
public interface StrictlyComparable {
        
    // this (object calling isLargerThan)
    // and other must be instances of 
    // the same class returns 1, 0, -1 
    // if this is greater than, 
    // equal to, or less than other
    public int isLarger(StrictlyComparable other);
}
```

Εάν θέλουμε να συγκρίνουμε το μέγεθος αντικειμένων του ιδίου τύπου (ανεξάρτητα με το τι αντικείμενα είναι αυτά), οι κλάσεις που υλοποιούν τα αντικείμενα αυτά μπορούν να υλοποιούν το interface `StrictlyComparable`. Για παράδειγμα, εάν πρόκειται για Strings μπορούμε να τα συγκρίνουμε λεξικογραφικά μεταξύ τους, αν πρόκειται για δι-διάστατα σχήματα θα μπορούσαμε να συγκρίνουμε το εμβαδό τους, ενώ αν πρόκειται για τρισδιάστατα σχήματα θα μπορούσαμε να συγκρίνουμε τον όγκο τους.

Ας υποθέσουμε ότι υλοποιούμε την κλάση Rectangle όπως παρακάτω:

### Rectangle.java

```java
public class Rectangle 
    implements StrictlyComparable {
    public int width = 0;
    public int height = 0;
    public Point origin;

    // four constructors
    public Rectangle() {
        origin = new Point(0, 0);
    }
    public Rectangle(Point p) {
        origin = p;
    }
    public Rectangle(int w, int h) {
        origin = new Point(0, 0);
        width = w;
        height = h;
    }
    public Rectangle(Point p, int w, int h) {
        origin = p;
        width = w;
        height = h;
    }

    // a method for moving the rectangle
    public void move(int x, int y) {
        origin.setX(x);
        origin.setY(y);
    }

    // a method for computing
    // the area of the rectangle
    public int getArea() {
        return width * height;
    }
    
    // a method required to implement
    // the Relatable interface
    public int isLarger(StrictlyComparable other) {
        Rectangle otherRect = (Rectangle)other;
        if (this.getArea() < otherRect.getArea())
            return -1;
        else if (this.getArea() > otherRect.getArea())
            return 1;
        else
            return 0;               
    }
    
    public static void main(String args[]) {
	Point p = new Point(10,20);
	Rectangle rec1 = new Rectangle(p, 30, 40);
	Rectangle rec2 = new Rectangle(p, 30, 20);
	if( rec1.isLarger(rec2) > 0 ) {
		System.out.println("rec1 is larger!");
	}
	else if( rec1.isLarger(rec2) < 0 ) {
		System.out.println("rec2 is larger!");
	}
	else {
		System.out.println("req1 is equal to req2");
	}
		
    }
}
```

> **Σημείωση**: Αν παραλείψετε την γραμμή
>
> `Rectangle otherRect = (Rectangle)other;`
> ο compiler δεν γνωρίζει ότι η μεταβλητή `other` ανήκει στην κλάση `Rectangle` και η προσπάθεια μεταγλώτισσης θα εμφανίσει λάθος (δοκιμάστε το!).

Για να εκτελέσετε το παράδειγμα κατεβάστε την κλάση `Point`, από [εδώ](../askisi1/README.md).

## Χρησιμοποιώντας ένα interface ως τύπο δεδομένων

Μπορείτε να χρησιμοποιήσετε ένα Java Interface ως ένα reference τύπο δεδομένων. Μπορείτε να χρησιμοποιήσετε το όνομα ενός interface ως τον τύπο μιας παραμέτρου σε μία Java μέθοδο ή τύπο μιας τοπικής μεταβλητής στο σώμα μίας μεθόδου. Προϋπόθεση είναι οι τιμές των μεταβλητών να δείχνουν σε αντικείμενα των οποίων οι κλάσεις υλοποιούν το συγκεκριμένο interface. Δείτε το παρακάτω παράδειγμα.

### FinestComparator.java

```java
public class FinestComparator {

    public StrictlyComparable findLarger(StrictlyComparable obj1, StrictlyComparable obj2) {
        if ((obj1).isLarger(obj2) > 0)
            return obj1;
        else 
            return obj2;
    }
    
    public StrictlyComparable findSmaller(StrictlyComparable obj1, StrictlyComparable obj2) {
        if ((obj1).isLarger(obj2) < 0)
            return obj1;
        else 
            return obj2;
    }
    
    public boolean isEqual(StrictlyComparable obj1, StrictlyComparable obj2) {
        if ( (obj1).isLarger(obj2) == 0)
            return true;   
        else
            return false;
    }
    
    public static void main(String args[]) {
        Point p = new Point(10,20);
        Rectangle rec1 = new Rectangle(p, 30, 40);
        Rectangle rec2 = new Rectangle(p, 30, 40);
        FinestComparator comp = new FinestComparator();
    
        System.out.println("rec1 is "+rec1.toString());
        System.out.println("rec2 is "+rec2.toString());
    
        if( !comp.isEqual(rec1,rec2) ) {
            System.out.println( comp.findLarger(rec1, rec2).toString()+"  is larger!");
            System.out.println( comp.findSmaller(rec1, rec2).toString()+"  is smaller!");
        } else {
            System.out.println("Objects are equal!");
        }
    }
}
```

Οι παραπάνω μέθοδοι δουλεύουν για οποιοδήποτε αντικείμενο η κλάση του υλοποιεί το παραπάνω interface, ώστε να μπορεί να κληθεί εσωτερικά η μέθοδος `isLarger()`. Παρατηρήστε τις δύο διαφορετικές αλλά ισοδύναμες εκδοχές της μεθόδου `isEqual`.

## Άσκηση 3

Δημιουργήστε το interface **TwoDimensionalShape** που περιέχει τις παρακάτω abstract μεθόδους:

- **double getArea()**: επιστρέφει το εμβαδό του συγκεκριμένου σχήματος.
- **int compare(TwoDimensionalShape shape)**: συγκρίνει το εμβαδό του τρέχοντος σχήματος με το εμβαδό του σχήματος που δίνεται ως όρισμα. Επιστρέφει -1, 0, 1 εάν το εμβαδό του τρέχοντος αντικειμένου είναι μικρότερο, ίσο ή μεγαλύτερο από το εμβαδό του σχήματος που δίνεται ως όρισμα.

Στην συνέχεια δημιουργήστε τις κλάσεις **Rectangle** (ορθογώνιο παραλληλόγραμμο, ύψους height και πλάτους width) και **Circle** (κύκλος ακτίνας radius) που και οι δύο υλοποιούν το παραπάνω interface. Τόσο για την κλάση **Rectangle** όσο και την κλάση **Circle** αρκεί να ορίσετε ως πεδία τις παραμέτρους εκείνες που επιτρέπουν τον υπολογισμό του εμβαδού τους. Αφού δημιουργήσετε τις κλάσεις φτιάξτε την κλάση **PlayWith2DShapes** η οποία έχει μία μέθοδο **public static void main(String args[])**, η οποία κάνει τα εξής:

1. Δημιουργεί ένα ορθογώνιο παραλληλόγραμμο με πλευρές μεγέθους **5.5** x **4.**3 και <span style="color: red">εκτυπώνει τις διαστάσεις του με την βοήθεια της μεθόδου</span> `public String toString()`.
2. Δημιουργεί ένα κύκλο με ακτίνα μεγέθους **2.7** και <span style="color: red">εκτυπώνει τις διαστάσεις του με την βοήθεια της μεθόδου</span> `public String toString()`.
3. Με την βοήθεια της μεθόδου **compare** που ορίζει το interface συγκρίνει τα σχήματα μεταξύ τους για να βρεί εκείνο με το μεγαλύτερο εμβαδό. Στην συνέχεια, εκτυπώνει το εμβαδό του μεγαλύτερου σχήματος.

<span style="color: red">(*)</span> Με <span style="color: red">κόκκινο</span> σημείωνονται οι αλλαγές στην εκφώνιση της άσκησης.