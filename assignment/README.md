# STEP SEM-3 Category C: Coding Assignment Solutions

This directory contains complete, verified, and production-grade Java solutions for the **STEP SEM-3 CodInClub / BridgeLabz Category C Coding Assignment (Abstraction & Interfaces)**.

---

## Directory Structure

```
assignment/
├── GardenPlotAreaReport.java
├── WeeklyStaffPay.java
├── LibraryLateFineCounter.java
├── ElectricityConnectionBilling.java
├── TravelBookingWithCommonFee.java
├── Problem1_GardenPlotAreaReport/
│   └── GardenPlotAreaReport.java
├── Problem2_WeeklyStaffPay/
│   └── WeeklyStaffPay.java
├── Problem3_LibraryLateFineCounter/
│   └── LibraryLateFineCounter.java
├── Problem4_ElectricityConnectionBilling/
│   └── ElectricityConnectionBilling.java
├── Problem5_TravelBookingWithCommonFee/
│   └── TravelBookingWithCommonFee.java
├── QLA_SOLUTIONS.md
└── README.md
```

---

## Problem Summaries & OOP Principles

### Problem 1: Garden Plot Area Report
- **Concept:** Open/Closed Principle via Abstract Shape Base Class.
- **Design:** `abstract class GardenPlot` standardizes `calculateArea()` and `formatReport()`. Adding new geometric shapes in the future requires no modification to the reporting loop.
- **Subclasses:** `CirclePlot` ($\pi r^2$), `RectanglePlot` ($l \times w$), `TrianglePlot` ($\frac{1}{2} b \times h$).

### Problem 2: Weekly Staff Pay
- **Concept:** Non-instantiable Base Type with Enforced Pay Calculation.
- **Design:** `abstract class StaffMember` prohibits instantiation of a generic worker with no pay rule. Enforces polymorphic invocation of `calculatePay()`.
- **Subclasses:**
  - `FullTimeStaff`: Fixed weekly salary.
  - `HourlyStaff`: Base rate for first 40 hours; $1.5\times$ rate for overtime.
  - `InternStaff`: Fixed stipend.

### Problem 3: Library Late Fine Counter
- **Concept:** Base Item Contract with Polymorphic Fine Rules.
- **Design:** `abstract class LibraryItem` mandates `calculateFine()`.
- **Subclasses:**
  - `BookItem`: 2.0 per day late.
  - `DvdItem`: 5.0 per day late, capped at a maximum of 50.0.
  - `MagazineItem`: 1.0 per day late.

### Problem 4: Electricity Connection Billing
- **Concept:** Slab & Minimum Billing via Polymorphic Hierarchy.
- **Design:** `abstract class ElectricityConnection` encapsulates consumption `units` and delegates billing to concrete subtypes.
- **Subclasses:**
  - `HomeConnection`: Slab pricing (5/unit for first 100 units, 7/unit thereafter).
  - `ShopConnection`: Commercial rate (8/unit + fixed charge of 100).
  - `FactoryConnection`: Industrial rate (6/unit, minimum bill 1000).

### Problem 5: Travel Booking with a Common Fee
- **Concept:** Single Source of Truth for Shared Booking Fee.
- **Design:** `abstract class TravelBooking` defines `BOOKING_FEE = 50.0` in exactly one place. The template method `calculateTotalFare()` adds this fee to `calculateBaseFare()`.
- **Subclasses:**
  - `BusBooking`: 2.0/km.
  - `TrainBooking`: 1.5/km.
  - `FlightBooking`: 2500.0 flat + 4.0/km.

---

## Theoretical Assessment (Part B & C)

See [QLA_SOLUTIONS.md](QLA_SOLUTIONS.md) for complete answers to:
- **Part B — Multiple Choice Quiz:** Questions 1 through 10 with answer keys and technical rationales.
- **Part C — Concept Questions:** Questions 1 through 5 covering abstraction, encapsulation, abstract class constructors, illegal modifiers on abstract methods, and the diamond problem.

---

## Compilation & Verification

```bash
# Compile all assignment problems
javac assignment/*.java

# Run Problem 1
java -cp assignment GardenPlotAreaReport

# Run Problem 2
java -cp assignment WeeklyStaffPay

# Run Problem 3
java -cp assignment LibraryLateFineCounter

# Run Problem 4
java -cp assignment ElectricityConnectionBilling

# Run Problem 5
java -cp assignment TravelBookingWithCommonFee
```
