# STEP SEM-3 · CodInClub | Powered by BridgeLabz
## Category C: Abstraction & Interfaces — Practice & Assignment Solutions

This repository contains fully tested, verified, and production-quality Java solutions for the **STEP SEM-3 Category C** module on **Abstraction, Abstract Classes, and Interfaces**.

Repository URL: `https://github.com/srujan1-creator/stepassignsem3.git`

---

## Repository Structure

```
stepassignsem3/
├── .gitignore
├── README.md
├── practice/                                     # PDF 1 — Practice Coding Problems
│   ├── MovieTicketCounter.java                  # Problem 1: Movie Ticket Counter
│   ├── ParcelShippingDesk.java                  # Problem 2: Parcel Shipping Desk
│   ├── CollegeFeeCounter.java                   # Problem 3: College Fee Counter
│   ├── CityCabFareMeter.java                    # Problem 4: City Cab Fare Meter
│   ├── HomeApplianceEnergyReport.java           # Problem 5: Home Appliance Energy Report
│   ├── Problem1_MovieTicketCounter/
│   │   └── MovieTicketCounter.java
│   ├── Problem2_ParcelShippingDesk/
│   │   └── ParcelShippingDesk.java
│   ├── Problem3_CollegeFeeCounter/
│   │   └── CollegeFeeCounter.java
│   ├── Problem4_CityCabFareMeter/
│   │   └── CityCabFareMeter.java
│   ├── Problem5_HomeApplianceEnergyReport/
│   │   └── HomeApplianceEnergyReport.java
│   └── README.md
│
└── assignment/                                   # PDF 2 — Assignment Coding & Theory
    ├── GardenPlotAreaReport.java                # Problem 1: Garden Plot Area Report
    ├── WeeklyStaffPay.java                      # Problem 2: Weekly Staff Pay
    ├── LibraryLateFineCounter.java              # Problem 3: Library Late Fine Counter
    ├── ElectricityConnectionBilling.java        # Problem 4: Electricity Connection Billing
    ├── TravelBookingWithCommonFee.java          # Problem 5: Travel Booking with a Common Fee
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
    ├── QLA_SOLUTIONS.md                         # Complete Part B Quiz & Part C Concept Answers
    └── README.md
```

---

## Part 1: Practice Problems Summary (PDF 1)

| Problem | Title | Key OOP Concepts | Core Abstractions / Interfaces |
| :--- | :--- | :--- | :--- |
| **Problem 1** | **Movie Ticket Counter** | Non-instantiable abstract ticket base class, shared convenience fee | `abstract class Ticket`, `RegularTicket`, `PremiumTicket`, `ReclinerTicket` |
| **Problem 2** | **Parcel Shipping Desk** | Capability segregation, optional insurance interface | `interface Insurable`, `abstract class Parcel`, `StandardParcel`, `ExpressParcel`, `FragileParcel` |
| **Problem 3** | **College Fee Counter** | Ability-based transport surcharge without checking type names | `interface BusTransportUser`, `abstract class Student`, `DayScholar`, `Hosteller`, `ScholarshipStudent` |
| **Problem 4** | **City Cab Fare Meter** | Universal minimum fare rule, capability-gated night service | `interface NightServiceCapable`, `abstract class Cab`, `MiniCab`, `SedanCab`, `SuvCab` |
| **Problem 5** | **Home Appliance Energy Report** | Energy calculation hierarchy, capability-supported saver mode | `interface SaverModeCapable`, `abstract class Appliance`, `Fridge`, `AirConditioner`, `Television`, `WashingMachine` |

---

## Part 2: Assignment Problems Summary (PDF 2)

| Problem | Title | Key OOP Concepts | Core Abstractions / Subclasses |
| :--- | :--- | :--- | :--- |
| **Problem 1** | **Garden Plot Area Report** | Open/Closed Principle, reporting closed for modification | `abstract class GardenPlot`, `CirclePlot`, `RectanglePlot`, `TrianglePlot` |
| **Problem 2** | **Weekly Staff Pay** | Non-instantiable base type, overtime policy encapsulation | `abstract class StaffMember`, `FullTimeStaff`, `HourlyStaff`, `InternStaff` |
| **Problem 3** | **Library Late Fine Counter** | Mandatory fine calculation contract, capped penalty | `abstract class LibraryItem`, `BookItem`, `DvdItem`, `MagazineItem` |
| **Problem 4** | **Electricity Connection Billing** | Slab & commercial pricing, industrial minimum bill | `abstract class ElectricityConnection`, `HomeConnection`, `ShopConnection`, `FactoryConnection` |
| **Problem 5** | **Travel Booking with Common Fee**| Template method pattern, single-source booking fee | `abstract class TravelBooking`, `BusBooking`, `TrainBooking`, `FlightBooking` |

---

## Part 3: Theory & Assessment (PDF 2 Parts B & C)

The comprehensive theoretical solutions are documented in [`assignment/QLA_SOLUTIONS.md`](assignment/QLA_SOLUTIONS.md):
- **Part B — Multiple Choice Quiz:** Q1 to Q10 with correct options and in-depth rationales.
- **Part C — Concept Questions:** Q1 to Q5 with detailed answers, real-life examples (ATM), differences between abstraction and encapsulation, abstract class constructors, prohibited abstract modifiers (`private`, `static`, `final`), and the diamond problem in Java.

---

## Build & Test Instructions

### Compile All Solutions
```bash
# Compile practice problems
javac practice/*.java

# Compile assignment problems
javac assignment/*.java
```

### Run Sample Verification
```bash
# Run Practice Problem 1
java -cp practice MovieTicketCounter

# Run Practice Problem 2
java -cp practice ParcelShippingDesk

# Run Assignment Problem 1
java -cp assignment GardenPlotAreaReport

# Run Assignment Problem 5
java -cp assignment TravelBookingWithCommonFee
```
