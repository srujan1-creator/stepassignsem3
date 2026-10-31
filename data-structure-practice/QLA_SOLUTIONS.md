# STEP SEM-3 Category C: Data Structure Practice QLA Solutions
## Quiz, Lab & Concept Solutions

---

## Part B — Multiple Choice Quiz

### Q1. Consider two String objects, `s1` and `s2`, created as follows:
```java
String s1 = new String("hello");
String s2 = new String("hello");
```
**Which of the following statements is true regarding the comparison of s1 and s2 in Java?**
- **Correct Answer:** **D** (`s1 == s2` is false, and `s1.equals(s2)` is true)
- **Explanation:** The `==` operator compares object references (memory addresses). Since `s1` and `s2` were created using the `new` keyword, they reside at separate heap addresses, making `s1 == s2` false. The `.equals()` method compares the actual character contents, which are identical ("hello"), evaluating to true.

---

### Q2. Given the following sequence of operations on a StringBuilder object:
```java
StringBuilder sb = new StringBuilder();
sb.append("Java");
sb.append(" Lab");
sb.reverse();
```
**What will be the content of the StringBuilder object sb after these operations?**
- **Correct Answer:** **B** ("baL avaJ")
- **Explanation:** Appending "Java" and " Lab" produces "Java Lab". Invoking `.reverse()` reverses all characters, resulting in "baL avaJ".

---

### Q3. Consider a Student class with constructor overloading. If `new Student("Ravi")` is executed:
- **Correct Answer:** **B** (`public Student(String name)`)
- **Explanation:** The constructor matching the exact parameter signature `(String)` is invoked directly. Inside its body, it delegates via `this(name, "Not assigned")` to the two-argument constructor.

---

### Q4. Consider a Wallet class with a balance field and `add(int amount)`. If `w1 = new Wallet(500); w2 = w1; w2.add(200);`:
- **Correct Answer:** **D** (`w1 balance: 700, w2 balance: 700`)
- **Explanation:** In Java, object variables store references. Assigning `w2 = w1` copies the reference, meaning both `w1` and `w2` point to the identical object in memory. Mutating via `w2` affects the object visible through `w1`.

---

### Q5. Consider a Visitor class with a static variable `count`. If three Visitor objects are created:
- **Correct Answer:** **C** (`3`)
- **Explanation:** A `static` variable is shared globally across all instances of the class. Every constructor call increments the single class-level counter from 0 to 1, 2, and finally 3.

---

### Q6. Array iteration from index 0 to length - 1 printing `[45, 78, 92, 60, 85]`:
- **Correct Answer:** **A** (`45 78 92 60 85`)
- **Explanation:** The standard loop visits indices sequentially from 0 to 4 in order.

---

### Q7. For loop from 1 to 5 with `if (i == 3) continue;`:
- **Correct Answer:** **B** (`1 2 4 5`)
- **Explanation:** The `continue` statement skips the remainder of the iteration when `i == 3`. Hence, 3 is not printed.

---

### Q8. Pass-by-value of primitive int `change(x)` where `change(int n) { n = 10; }`:
- **Correct Answer:** **A** (`5`)
- **Explanation:** Java passes primitive arguments strictly by value (copying the bit value). Mutating parameter `n` inside the method has zero effect on caller variable `x`.

---

### Q9. `int total = 250; double count = 3; double avg = total / count;`:
- **Correct Answer:** **C** (`83.33333333333333`)
- **Explanation:** In binary numeric promotion, `total` is implicitly widened to double `250.0`. Floating-point division yields `83.33333333333333`.

---

### Q10. `Payment p = new Card(); p.pay(500);` where `Card` adds 2% fee:
- **Correct Answer:** **B** (`Paid 510.0 by card`)
- **Explanation:** Polymorphic method dispatch executes `Card`'s overridden `pay()` method: fee = 500 * 0.02 = 10.0; total = 510.0.

---

### Q11. `String name = "java"; String upperName = name.toUpperCase();`:
- **Correct Answer:** **B** (The name object's value remains "java", and a new String object "JAVA" is created for upperName)
- **Explanation:** Strings are immutable in Java. Methods that transform strings never modify the original object; they instantiate and return a new String object.

---

### Q12. String pool allocation:
```java
String s1 = "hello";
String s2 = "hello";
String s3 = new String("hello");
```
- **Correct Answer:** **B** (`2`)
- **Explanation:** `"hello"` creates one string object inside the String Constant Pool (shared by `s1` and `s2`). `new String("hello")` explicitly creates a separate second object in regular heap memory.

---

### Q13. `Word myWord = new Word();` with `text = "Campus"`. `getTextLength()` and `letterAt(2)`:
- **Correct Answer:** **A** (`6 / m`)
- **Explanation:** "Campus" has 6 characters. 0-based indexing: index 0='C', 1='a', 2='m'.

---

### Q14. `String email = "user@domain.com"; email.indexOf("@");`:
- **Correct Answer:** **A** (`4`)
- **Explanation:** The '@' character is located at index 4 ('u'=0, 's'=1, 'e'=2, 'r'=3, '@'=4).

---

### Q15. `Book` with default constructor (`title = "Unknown", price = 0.0`):
- **Correct Answer:** **B** (`Title: Unknown, Price: 0.0`)
- **Explanation:** Default constructor initializes title to "Unknown" and price to 0.0.

---

### Q16. `Book b = new Book("Java Programming", 450.0);`:
- **Correct Answer:** **A** (`Title: Java Programming, Price: 450.0`)
- **Explanation:** Parameterized constructor assigns the arguments directly to fields.

---

### Q17. How many `Wallet` objects exist in memory?
```java
Wallet w1 = new Wallet(500);
Wallet w2 = w1;
Wallet w3 = new Wallet(500);
```
- **Correct Answer:** **B** (`2`)
- **Explanation:** The `new` keyword was executed exactly twice (`w1` and `w3`). `w2` merely copies `w1`'s reference.

---

### Q18. Calling `w2.add(200)` after `w2 = w1` where initial balance was 500:
- **Correct Answer:** **C** (`w1 balance: 700 / w2 balance: 700`)
- **Explanation:** Both references point to the same wallet object.

---

### Q19. `s1 = new Student("Asha"); s2 = new Student("Ravi"); s1.setName("Anu");`:
- **Correct Answer:** **C** (`s1 name: Anu / s2 name: Ravi`)
- **Explanation:** `s1` and `s2` refer to distinct objects. Mutating `s1` modifies only `s1`.

---

### Q20. Static `visitorCount`:
- **Correct Answer:** **C** (`Total visitors: 3`)
- **Explanation:** Static variables are shared by all instances. Three instantiations increment it to 3.

---

## Part C — Concept Questions

### Question 1: String Immutability & Mitigation
**Answer:**
String immutability means once a `java.lang.String` object is created in memory, its character sequence cannot be altered. When performing repeated string concatenation (`s += ...`) inside a loop, each iteration creates a brand new String object and copies all previous characters, resulting in $O(N^2)$ time complexity and excessive garbage collection overhead.
**Mitigation:** Use mutable text builders such as `StringBuilder` (non-thread-safe, high performance) or `StringBuffer` (synchronized, thread-safe), which append characters in-place using a dynamic internal char buffer in amortized $O(1)$ time per operation.

---

### Question 2: Resolving Parameter Shadowing with `this`
**Answer:**
When a method or constructor parameter has the exact same name as an instance variable, the parameter *shadows* the instance variable within that scope. The `this` keyword is a reference to the current object. Prefixing the variable with `this.` (e.g., `this.name = name;`) explicitly directs Java to write to the instance field rather than reassigning the parameter to itself.

---

### Question 3: Object vs Reference Variable in Memory
**Answer:**
- An **object** is a block of allocated heap memory containing state (instance fields) and behavior defined by its class.
- A **reference variable** is a variable residing on the thread stack (or within an object) that stores the memory address pointing to the heap object.
- When reference `w2` is assigned the value of `w1` (`w2 = w1`), only the memory address is copied. No new object is instantiated. Both variables now point to the identical heap object; any modification through one reference is immediately visible through the other.

---

### Question 4: Static vs Instance Variables
**Answer:**
- **Static variables** belong to the class itself and have exactly one copy shared across all instances. Use cases include class-wide constants (`Math.PI`), global sequence counters, or shared caches.
- **Instance variables** belong to an individual object instance, and each object possesses its own distinct copy. Use cases include entity attributes such as `studentId`, `accountBalance`, or `userName`.

---

### Question 5: Loop Comparisons (`for`, `while`, `do-while`)
**Answer:**
- **`for` loop:** Best suited when the exact number of iterations is known in advance (e.g., iterating through an array or collection with fixed bounds).
- **`while` loop:** Pre-test loop best suited when iterating depends on an indeterminate boolean condition that must be verified before the first execution (e.g., reading lines from a network stream until EOF).
- **`do-while` loop:** Post-test loop that guarantees at least one execution before condition evaluation. Ideal for menu-driven CLI apps or user prompt retry validation.

---

### Question 6: Java Pass-by-Value Mechanics
**Answer:**
Java is strictly **pass-by-value** in all scenarios.
- For **primitives**, the actual literal value is copied into the method parameter. Any modifications to the parameter have no impact on the original caller variable.
- For **object references**, the reference (address value) itself is copied. The method cannot rebind the caller's original reference to a different object, but it *can* mutate the internal state of the shared object referenced by the copied address.

---

### Question 7: Integer Division & Explicit Type Casting
**Answer:**
When both operands in a division expression are integers (`int / int`), Java performs truncated integer division, discarding any fractional portion (e.g., `5 / 2 = 2`, not `2.5`). To retain precision, at least one operand must be explicitly cast to a floating-point type (e.g., `(double) a / b` or `a / (double) b`), which triggers binary numeric promotion and executes IEEE 754 floating-point division.

---

### Question 8: Encapsulation & Data Integrity
**Answer:**
Encapsulation binds data and the methods that operate on that data into a single unit while restricting direct outside access to internal state. By declaring instance variables `private` and exposing controlled `public` getter and setter methods, a class enforces validation rules, prevents illegal state transitions (e.g., negative bank balances), maintains invariants, and shields internal data structures from external tampering.

---

### Question 9: `==` Operator vs `.equals()` Method
**Answer:**
- `==` compares reference identity (whether both variables point to the exact same memory address).
- `.equals()` is a method designed to compare logical equivalence / state equality.
- By default, `Object.equals()` simply performs `==`. When a class overrides `.equals()`, it defines custom business logic for value equality (e.g., comparing field values), allowing two distinct objects with identical content to evaluate as equal.

---

### Question 10: Method Overloading vs Overriding
**Answer:**
- **Method Overloading:** Same method name with different parameter signatures within the same class. Resolved statically at **compile-time** (Static Polymorphism). Example: `add(int, int)` vs `add(double, double)`.
- **Method Overriding:** Subclass redefines an inherited method with identical signature and return type. Resolved dynamically at **run-time** based on the actual object type (Dynamic Polymorphism). Example: `Animal.makeSound()` overridden by `Dog.makeSound()`.
