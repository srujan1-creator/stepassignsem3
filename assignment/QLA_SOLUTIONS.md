# STEP SEM-3 Category C: Assignment QLA Solutions
## Quiz, Lab & Concept Solutions: Abstraction, Abstract Classes & Interfaces

---

## Part B — Multiple Choice Quiz

### Q1. Which of the following best describes abstraction in object-oriented programming?
- **Options:**
  - A. Showing all internal details of an object to the user
  - B. Protecting data inside an object from unauthorized access
  - **C. Hiding how an object performs its operations and showing only what it does**
  - D. Allowing a class to inherit from multiple parent classes
- **Correct Answer:** **C**
- **Explanation:** Abstraction focuses on the essential external behavior of an entity while concealing the low-level implementation mechanics. Option B describes encapsulation, and Option D refers to multiple inheritance.

---

### Q2. Which statement about an abstract class in Java is true?
- **Options:**
  - A. It must contain at least one abstract method
  - B. It can be instantiated if it has no abstract methods
  - **C. It cannot be instantiated directly**
  - D. It can extend multiple other classes
- **Correct Answer:** **C**
- **Explanation:** In Java, declaring a class `abstract` immediately prevents direct instantiation using `new AbstractClass()`, regardless of whether it contains zero or many abstract methods. Java does not allow multiple class inheritance (ruling out D).

---

### Q3. If a concrete class extends an abstract class but fails to implement an inherited abstract method, what is the consequence?
- **Options:**
  - A. Java automatically provides an empty implementation for the method
  - **B. The class must be declared abstract, or the code will not compile**
  - C. A runtime error will occur only when the unimplemented method is called
  - D. The compiler will issue a warning but still allow compilation
- **Correct Answer:** **B**
- **Explanation:** If a subclass does not provide concrete method bodies for all inherited abstract methods, it is inherently incomplete. Therefore, the Java compiler requires the subclass itself to be declared `abstract`; otherwise, a compile-time error occurs.

---

### Q4. Which of the following modifiers is NOT allowed for an abstract method in Java?
- **Options:**
  - A. protected
  - B. public
  - **C. private**
  - D. default (package-private)
- **Correct Answer:** **C**
- **Explanation:** An abstract method is an explicit mandate that a subclass must override and implement the method. A `private` method is invisible to subclasses and cannot be overridden, making `private abstract` contradictory and illegal in Java.

---

### Q5. Fields declared within a Java interface are implicitly:
- **Options:**
  - A. private and static
  - B. protected and final
  - **C. public, static, and final**
  - D. public and instance-specific
- **Correct Answer:** **C**
- **Explanation:** Every field defined in a Java interface is automatically `public static final` (constants). Interfaces cannot maintain mutable per-instance state.

---

### Q6. How many interfaces can a single Java class implement?
- **Options:**
  - A. Only one interface at a time
  - B. At most two interfaces
  - **C. Any number of interfaces**
  - D. None, if the class already extends another class
- **Correct Answer:** **C**
- **Explanation:** Java supports multiple interface implementation via a comma-separated list (`implements InterfaceA, InterfaceB, InterfaceC`). There is no limit on the number of interfaces a class may implement.

---

### Q7. If a class implements an interface, what access modifier must it use for the implemented methods?
- **Options:**
  - A. default (package-private)
  - B. private
  - C. protected
  - **D. public**
- **Correct Answer:** **D**
- **Explanation:** All methods declared in an interface are implicitly `public` (unless private helper methods in Java 9+). In Java, when overriding a method, you cannot reduce its visibility. Hence, the implementing class must explicitly declare the method as `public`.

---

### Q8. Why does Java allow a class to implement multiple interfaces but only extend a single class?
- **Options:**
  - A. Implementing interfaces makes the code run faster
  - B. Classes are unable to contain any methods
  - **C. Interfaces carry no instance state, avoiding the 'diamond problem' ambiguity with conflicting data inheritance**
  - D. Interfaces are compiled independently from classes
- **Correct Answer:** **C**
- **Explanation:** The classic "diamond problem" in multiple class inheritance causes ambiguity regarding duplicate or conflicting instance fields/state from different paths. Because interfaces cannot hold instance fields (state), multiple interface implementation avoids memory layout and state resolution conflicts.

---

### Q9. What happens if a class implements two interfaces that both provide a default method with the same signature, and the class does not override this method?
- **Options:**
  - A. The method from the first interface listed in the implements clause is used
  - B. The method from the last interface listed in the implements clause is used
  - C. A runtime exception occurs when the method is called
  - **D. A compile-time error occurs until the class overrides the method**
- **Correct Answer:** **D**
- **Explanation:** When two implemented interfaces declare default methods with identical signatures, Java refuses to guess which default implementation to execute. The compiler issues an error demanding that the concrete class explicitly override the conflicting method and resolve the ambiguity (e.g. by delegating via `InterfaceA.super.methodName()`).

---

### Q10. Which of the following is true regarding constructors in Java?
- **Options:**
  - A. Concrete classes cannot have constructors
  - **B. Abstract classes can have constructors that run when a subclass object is created**
  - C. Interfaces must have at least one constructor
  - D. Constructors in abstract classes are used to create objects of the abstract class directly
- **Correct Answer:** **B**
- **Explanation:** Even though abstract classes cannot be instantiated with `new AbstractClass()`, they have constructors that are invoked via `super(...)` during subclass object instantiation to initialize common inherited state. Interfaces cannot have constructors.

---

## Part C — Concept Questions

### Question 1
**Explain abstraction in your own words. Provide a real-life example, different from those mentioned in the material, detailing what is shown to the user and what details are hidden.**

**Answer:**
**Abstraction** is the object-oriented design technique of isolating the **essential capability or contract** of a system from its internal, operational details. It presents a clean, predictable interface to the client while hiding internal complexity, volatile algorithms, and data structures.

**Real-Life Example: An Automated Teller Machine (ATM)**
- **What is shown to the user (The Abstraction):**
  - The screen options: `Insert Card`, `Enter PIN`, `Select Account Type`, `Withdraw Cash`, and `Take Cash / Receipt`.
  - The customer needs only to understand this simplified contract to withdraw money.
- **What is hidden from the user (The Implementation Details):**
  - High-speed encrypted network packets communicating with the banking switch via ISO 8583 protocols.
  - Verification of account balances across distributed banking databases.
  - Optical sensors, motorized rollers, and bill-dispensing mechanical validation units that count physical currency notes.
  - Hardware encryption modules (HSM) protecting the cryptographic master keys.

The client interacts solely with the clean interface, shielded from changes in mechanical components or backend banking protocol versions.

---

### Question 2
**Describe the primary difference between abstraction and encapsulation. Explain how these two concepts work together within a single class to manage complexity and data protection.**

**Answer:**
- **Primary Difference:**
  - **Abstraction** is about **hiding complexity**: it defines *what* an object does (the conceptual model, public interface, abstract contracts).
  - **Encapsulation** is about **hiding data & grouping mechanics**: it binds state and behavior together while restricting direct access to internal fields (`private` fields accessed via validated getters/setters or methods).

- **How They Work Together in a Single Class:**
  Within a class like `BankAccount`:
  1. **Encapsulation** ensures the internal field `private double balance;` cannot be corrupted or directly modified by outside code (`account.balance = -999999;` is prohibited).
  2. **Abstraction** exposes a clean, intuitive public contract: `public boolean withdraw(double amount)` and `public void deposit(double amount)`.
  3. Together, abstraction gives the caller a simple mental model (deposit/withdraw money), while encapsulation protects the internal invariants (checking sufficient funds, auditing transactions, updating ledger entries).

---

### Question 3
**An abstract class cannot be instantiated, yet it can define a constructor. Explain why an abstract class might have a constructor and describe when this constructor is executed.**

**Answer:**
- **Why an Abstract Class Defines a Constructor:**
  An abstract class frequently possesses common member fields that every subclass must possess (e.g. `protected final String id;` or `protected final double baseRate;`). Rather than duplicating validation and assignment logic across every concrete subclass constructor, the abstract class encapsulates this shared initialization inside its constructor. Furthermore, it enforces immutability or mandatory arguments across all subclasses.

- **When the Constructor is Executed:**
  The constructor of an abstract class is executed **during the instantiation of a concrete subclass**. When `new ConcreteSubclass(...)` is invoked, the subclass constructor's first statement is an explicit or implicit call to `super(...)`. This executes constructor chaining up the inheritance hierarchy, initializing the abstract class fields before the subclass body executes.

---

### Question 4
**Explain why an abstract method cannot be declared with the `private`, `static`, or `final` modifiers. Provide a reason for each of these restrictions.**

**Answer:**
1. **`private abstract` is illegal:**
   - *Reason:* An abstract method is a contract requiring a subclass to override it. However, `private` members are completely hidden from subclasses and cannot be overridden. These two modifiers directly contradict each other.
2. **`static abstract` is illegal:**
   - *Reason:* `static` methods belong to the class definition and are resolved statically at compile time (method hiding), whereas abstract methods rely on dynamic method dispatch (runtime polymorphism) through an object instance. You cannot instantiate an abstract class to invoke an abstract instance method, nor can static methods be polymorphically overridden.
3. **`final abstract` is illegal:**
   - *Reason:* `final` explicitly forbids any subclass from overriding the method, while `abstract` mandates that a subclass *must* override the method to provide an implementation. They are mutually exclusive and logically impossible to fulfill simultaneously.

---

### Question 5
**What is the 'diamond problem' in the context of inheritance? Explain how Java's design, allowing a class to implement multiple interfaces but extend only one class, addresses or avoids this problem.**

**Answer:**
- **The Diamond Problem:**
  The diamond problem occurs in multiple class inheritance when a class $D$ extends two classes $B$ and $C$, both of which inherit from a common ancestor $A$. If class $A$ has an instance field `int value;` and both $B$ and $C$ override a method `foo()`, class $D$ faces two major ambiguities:
  1. *State Ambiguity:* Does $D$ contain two separate copies of `value` (one via $B$ and one via $C$), and which one does it access?
  2. *Behavioral Ambiguity:* When calling `d.foo()`, which implementation should execute—$B$'s or $C$'s?

- **How Java's Design Resolves/Avoids It:**
  1. **Single Class Inheritance:** Java restricts class extension to a single superclass (`extends SuperClass`). This guarantees a single, linear ancestry chain for instance variables and memory layout, completely eliminating state-level diamond conflicts.
  2. **Multiple Interface Implementation:** Java permits implementing multiple interfaces because traditional interfaces carry **no mutable instance state**.
  3. **Default Method Collision Resolution:** In Java 8+, if two interfaces declare conflicting `default` methods with identical signatures, Java requires the implementing class to explicitly override the method and resolve the ambiguity at compile time (e.g., calling `InterfaceA.super.method()` or providing a custom implementation). If not overridden, the compiler halts compilation with an error.
