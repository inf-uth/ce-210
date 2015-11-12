# Δημιουργώντας Αντικείμενα

Μέχρι τώρα αναφέραμε στην ["Εισαγωγή στον Αντικειμενοστραφή Προγραμματισμό"](http://gthanos.inf.uth.gr/~gthanos/CE210/doku.php?id=oop:introduction) ότι η κλάση είναι το βασικό σχέδιο μέσα από το οποίο δημιουργούνται επιμέρους αντικείμενα που φέρουν τα χαρακτηριστικά της κλάσης. Επίσης, δείξαμε πως ορίζουμε μία κλάση μέσα από παραδείγματα, αλλά δεν δείξαμε πως δημιουργούμε αντικείμενα από τις κλάσεις που ορίσαμε.

Το πως δημιουργούνται αντικείμενα θα το δείξουμε μέσα από ένα παράδειγμα. Παρακάτω δίνεται ένα πρόγραμμα που δημιουργεί συγκεκριμένα αντικείμενα και εκτυπώνει τα αποτελέσματα στην κονσόλα.

## Point.java
```java
public class Point {
  private int xCoord, yCoord;
 
  public Point(int x, int y) {
    xCoord = x;
    yCoord = y;
  }
  public void setX(int x) {
    xCoord = x;
  }
  public void setY(int y) {
    yCoord = y;
  }
  public int getX() {
    return xCoord;
  }
  public int getY() {
    return yCoord;
  }
  public String toString() {
    return "xCoord: "+xCoord+", yCoord: "+yCoord;
  }
}
```

## Rectangle.java

```java
public class Rectangle {
  private int width, height;
  private Point origin;
 
  public Rectangle(Point p, int w, int h) {
    origin = p;
    width = w;
    height = h;
  }
 
  public Rectangle(int x, int y, int w, int h) {
    origin = new Point(x,y);
    width = w;
    height = h;
  }
 
  public Rectangle(int w, int h) {
    this(0, 0, w, h);
  }
 
  public void setOrigin(Point p) {
    origin = p;
  }
 
  public void setHeight(int h) {
     height = h;
  }
 
  public void setWidth(int w) {
     width = w;
  }
 
  public Point getOrigin() {
     return origin;
  }
 
  public int getHeight() {
     return height;
  }
 
  public int getWidth() {
     return width;
  }
 
  public int getArea() {
     return width * height;
  }
 
  // Move rectangle origin by x,y
  public void move(int x, int y) {
     origin.setX( origin.getX() + x );
     origin.setY( origin.getY() + y );
  }
 
  public String toString() {
    String str = "height: "+height+", width: "+width+", area: "+getArea();
    return origin.toString() + str;
  }
}
```

## CreateObjectDemo.java

```java
public class CreateObjectDemo {
 
  public static void main(String[] args) {
 
    // Declare and create a point object and two rectangle objects.
    Point originOne = new Point(23, 94);
    Rectangle rectOne = new Rectangle(originOne, 100, 200);
    Rectangle rectTwo = new Rectangle(50, 100);
 
    // display rectOne's origin, width, height, and area
    System.out.println("Origin of reactOne: " + rectOne.getOrigin() );
    System.out.println("Width of rectOne: " + rectOne.getWidth() );
    System.out.println("Height of rectOne: " + rectOne.getHeight() );
    System.out.println("Area of rectOne: " + rectOne.getArea());    
 
    // set rectTwo's position
    rectTwo.setOrigin(originOne);
 
    // display rectTwo's origin, width, height, and area
    System.out.println("Origin of reactTwo: " + rectTwo.getOrigin() );
    System.out.println("Width of rectTwo: " + rectTwo.getWidth() );
    System.out.println("Height of rectTwo: " + rectTwo.getHeight() );
    System.out.println("Area of rectTwo: " + rectTwo.getArea());    
 
    // move rectTwo and display its new position
    rectTwo.move(40, -20);
    System.out.println("Origin of reactOne: " + rectTwo.getOrigin() );
  }
}
```

Για να μεταγλωτίσουμε τα παραπάνω πρόγραμμα αρκεί να γράψουμε

```bash
javac Point.java
javac Rectange.java
javac CreateObjectDemo.java
```

και για να το τρέξουμε γράφουμε

```bash
java CreateObjectDemo
```

Το παραπάνω πρόγραμμα τυπώνει τα εξής στην κονσόλα.

```
Origin of reactOne: xCoord: 23, yCoord: 94
Width of rectOne: 100
Height of rectOne: 200
Area of rectOne: 20000
Origin of reactTwo: xCoord: 23, yCoord: 94
Width of rectTwo: 50
Height of rectTwo: 100
Area of rectTwo: 5000
Origin of reactOne: xCoord: 63, yCoord: 74
```

Από τα πάραπάνω αξίζει να προσέξουμε τα εξής.

1. Εκτελούμε την κλάση η οποία περιέχει την μέθοδο main η οποία εκκινεί την εκτέλεση του προγράμματος
   ```
   public static void main(String[] args) { .... }
```
2. Η κλάση Rectangle έχει τρεις κατασκευαστές. Οι δύο από αυτούς καλούνται εναλλάξ στη συνάρτηση main προκειμένου να αρχικοποιήσουν τα αντικείμενα rectOne και rectTwo.
3. H συνάρτηση System.out.println() εκτυπώνει ένα αλφαριθμητικό (String) ακολουθούμενο από χαρακτήρα αλλαγής γραμμής.

## Ο τελεστής new

Προκειμένου να δημιουργηθούν νέα αντικείμενα χρησιμοποιείται ο τελεστής **new**. O τελεστής **new** χρησιμοποιείται συνήθως με τον κατασκευαστή μίας κλάσης προκειμένου να κάνει τα εξής:

1. Δέσμευση της απαραίτητης μνήμης και δημιουργία του αντικειμένου. Η αρχικά ορισμένη μεταβλητή δείχνει πλέον στην περιοχή μνήμης που έχει δεσμευτεί.
2. Αρχικοποίηση των εσωτερικών μεταβλητών (πεδίων) του αντικειμένου με κλήση του κατάλληλου κατασκευαστή της κλάσης. Εάν δεν έχει οριστεί κατασκευαστής τότε ο τελεστής new καλείται με χρήση του default κατασκευαστή (default constructor) που δεν έχει ορίσματα (π.χ. `MyObject obj = new MyObject();`, όπου για την κλάση MyObject δεν έχει οριστεί κανένας κατασκευατής).

> Κατά την χρήση primitive τύπων δεδομένων (int, float, double) δεν απαιτείται η χρήση του τελεστή new διότι η απαραίτητη μνήμη δεσμεύεται στο stack της μεθόδου που εκτελείται.

## Πολλαπλοί κατασκευαστές σε μία κλάση

Μία κλάση μπορεί να έχει πολλούς διαφορετικούς. Κάθε κατασκευαστής ορίζει μία διαφορετική αρχικοποίηση των εσωτερικών μεταβλητών των αντικειμένων που δημιουργούντια με βάση το “σχέδιο” της κλάσης. Το ποιός κατασκευαστής θα κληθεί εξαρτάται από τον τύπο, τη σειρά και τον αριθμό των ορισμάτων σε αναλογία με την υπερφόρτωση συναρτήσεων. Έτσι στη συνάρτηση main του παραδείγματος μας καλούνται δύο διαφορετικοί κατασκευαστές για δύο διαφορετικά αντικείμενα της ίδιας κλάσης.

```java
rectOne = new Rectangle(originOne, 100, 200);
rectTwo = new Rectangle(50, 100);
```

## Χρήση Αντικειμένων

Όταν φτιάξετε ένα αντικείμενο είναι σίγουρο ότι θα θέλετε να το χρησιμοποιήσετε προκειμένου να κάνετε μία εργασία όπως να γράψετε κάτι στα δεδομένα του, να διαβάσετε από αυτά ή να χρησιμοποιήσετε κάποια από τις μεθόδους του.

### Χρήση των πεδίων ενός αντικειμένου

Τα πεδία ενός αντικειμένου είναι προσβάσιμα με χρήση του ονόματος του αντικειμένου, μία τελεία '.' και το όνομα του πεδίου. Για παράδειγμα,

```java
                          // cadence, speed, gear
   Bicycle bicycle = new Bicycle(10, 20, 30);
   System.out.println("Bicycle speed is " + bicycle.speed);
```

> Απαραίτητη προϋπόθεση για να δουλέψει ο παραπάνω κώδικας είναι το πεδίο speed να είναι προσβάσιμο, δηλαδή να μην έχει προσδιοριστή τύπου **private**.

<br />

> Όπως προείπαμε μία καλή προγραμματιστική πρακτική είναι η [απόκρυψη των πεδίων της κλάσης](http://gthanos.inf.uth.gr/~gthanos/CE210/doku.php?id=java:class_fields#απόκρυψη_δεδομένων_και_εσωτερικής_υλοποίησης) και η δήλωση συναρτήσεων για την πρόσβαση στα δεδομένα της. Σε αυτή την περίπτωση η απευθείας πρόσβαση στα πεδία των αντικειμένων είναι μη επιτρεπτή (ο compiler δεν μεταγλωττίζει το πρόγραμμα). Η πρόσβαση σε μεταβλητές που έχουν τον προσδιοριστή **private** μπορεί να γίνει μόνο μέσω βοηθητικών συναρτήσεων (set/get) που έχουν το προσδιοριστή **public**.

### Χρήση των μεθόδων ενός αντικειμένου

Σε αναλογία με τα πεδία οι μέθοδοι ενός αντικειμένου είναι προσβάσιμες μέσω του ονόματος του αντικειμένου, μία τελεία '.' και το όνομα του πεδίου. Για παράδειγμα,

```java
   // cadence, speed, gear
   Bicycle bicycle = new Bicycle(10, 20, 30);
   System.out.println("Bicycle speed is " + bicycle.getSpeed() );
```

> Ισχύουν και για τις μεθόδους όσα αναφέρονται για τους προσδιοριστές τύπου **public**, **private** των πεδίων.

## Άσκηση 1

Δημιουργήστε την κλάση **RectangularCuboid** (κυβοειδές) η οποία έχει ως πεδία **3 private μεταβλητές** τύπου **int** (width, height και depth). H κλάση αυτή θα πρέπει να υλοποιεί τις μεθόδους:

- `int getWidth()`
- `int getHeight()`
- `int getDepth()`
- `void setWidth(int newWidth)`
- `void setHeight(int newHeight)`
- `void setDepth(int newDepth)`
- `int volume()` (υπολογίζει και επιστρέφει τον όγκο του κυβοειδούς).
- `String toString()` (επιστρέφει ένα String που εκτυπώνει, width, height, depth και volume).

Επίσης, η κλάση υλοποιεί τον κατασκευαστή RectangularCuboid(int w, int h, int d).

Στην συνέχεια φτιάξτε την κλάση **TryRectangularCuboid** η οποία διαθέτει μία συνάρτηση `static void main(String args[])`. Η συνάρτηση main φτιάχνει δύο αντικείμενα τύπου **RectangularCuboid**, το αντικείμενο **cub1** και το αντικείμενο **cub2** με αρχικές παραμέτρους που ορίζονται από τον προγραμματιστή (ορίστε ό,τι θέλετε εσείς). Με την βοήθεια της μεθόδου **toString** που υλοποιήσατε εκτυπώστε στην κονσόλα τις παραμέτρους των **cub1** και **cub2**.

Στη συνέχεια, ορίστε το ύψος *height* του **cub2** να είναι ίσο με το ύψος *height* του **cub1**. Αντίστοιχα, ορίστε το βάθος depth του cub1 να είναι ίσο με το βάθος depth του cub2 αυξημένο κατά 5 (συμβολικά *cub1.depth = cub2.depth+5*). Εκτυπώστε ξανά στην κονσόλα τις παραμέτρους των **cub1** και **cub2** μετά τις αλλαγές που κάνατε.
