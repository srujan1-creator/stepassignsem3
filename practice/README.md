# STEP SEM-3 Category C: Practice Coding Assignment Solutions

This directory contains complete, production-grade Java solutions for the **STEP SEM-3 CodInClub / BridgeLabz Category C Practice Coding Assignment**.

The problems in this practice set focus on fundamental **Object-Oriented Programming (OOP)** design concepts:
- **Abstract Classes vs. Interfaces:** Modeling core hierarchies with shared state and behavior while isolating optional capabilities via interfaces.
- **Encapsulation & Single Source of Truth:** Ensuring constants such as convenience fees, minimum fares, and transport charges are declared in exactly one place.
- **Capability Separation (Interface Segregation):** Using interfaces (e.g., `Insurable`, `BusTransportUser`, `NightServiceCapable`, `SaverModeCapable`) so that extending capabilities does not pollute un-featured subtypes.
- **Polymorphism & Clean Extensibility (Open/Closed Principle):** Processing heterogeneous collections uniformly without error-prone conditional type-checking (`if-else` / `switch` on type names).

---

## Directory Layout

```
practice/
├── MovieTicketCounter.java
├── ParcelShippingDesk.java
├── CollegeFeeCounter.java
├── CityCabFareMeter.java
├── HomeApplianceEnergyReport.java
├── Problem1_MovieTicketCounter/
│   └── MovieTicketCounter.java
├── Problem2_ParcelShippingDesk/
│   └── ParcelShippingDesk.java
├── Problem3_CollegeFeeCounter/
│   └── CollegeFeeCounter.java
├── Problem4_CityCabFareMeter/
│   └── CityCabFareMeter.java
├── Problem5_HomeApplianceEnergyReport/
│   └── HomeApplianceEnergyReport.java
└── README.md
```

---

## Problem Summaries & Design Details

### Problem 1: Movie Ticket Counter
- **Core Concept:** Abstract Base Class with Single-Location Convenience Fee.
- **Design:** `abstract class Ticket` stores `seatType`, `count`, and `CONVENIENCE_FEE = 20.0`. It forces subclasses (`RegularTicket`, `PremiumTicket`, `ReclinerTicket`) to implement `getPricePerTicket()`.
- **Pricing:**
  - Regular: 150 per ticket
  - Premium: 250 per ticket
  - Recliner: 400 per ticket
  - Formula: `(price + 20) * count`

### Problem 2: Parcel Shipping Desk
- **Core Concept:** Capability Interface (`Insurable`) with Abstract Hierarchy.
- **Design:** Base `abstract class Parcel` implements shipping charge calculation. Only `ExpressParcel` and `FragileParcel` implement `Insurable`, allowing 2% insurance on declared value without touching `StandardParcel`.
- **Pricing:**
  - Standard: `40 + 10 * weightKg`, Insurance = 0.00
  - Express: `80 + 15 * weightKg`, Insurance = 2% of declared value
  - Fragile: `(40 + 10 * weightKg) + 50`, Insurance = 2% of declared value

### Problem 3: College Fee Counter
- **Core Concept:** Capability Interface for Shared Transport Fee.
- **Design:** Base `abstract class Student` calculates tuition. `BusTransportUser` defines `TRANSPORT_FEE = 12000.0`. `DayScholar` and `ScholarshipStudent` implement `BusTransportUser`, whereas `Hosteller` does not.
- **Fee Rules:**
  - Day Scholar: Tuition 40,000 + Transport 12,000 = 52,000
  - Hosteller: Tuition 40,000 + Hostel 60,000 = 100,000 (No Bus)
  - Scholar: Tuition 20,000 (50%) + Transport 12,000 = 32,000

### Problem 4: City Cab Fare Meter
- **Core Concept:** Shared Minimum Fare with Capability Interface.
- **Design:** `abstract class Cab` enforces `MINIMUM_FARE = 100.0`. `NightServiceCapable` interface is implemented only by `SedanCab` and `SuvCab`. Requesting night service on `MiniCab` throws an exception, outputting `MINI: night service not available` without incrementing total.
- **Rates & Night Policy:**
  - Mini: 10/km (Night rejected)
  - Sedan: 14/km (Night +20% on fare)
  - SUV: 18/km (Night +20% on fare)

### Problem 5: Home Appliance Energy Report
- **Core Concept:** Power Calculation Hierarchy with Capability-Gated Saver Mode.
- **Design:** `abstract class Appliance` encapsulates wattage and energy calculation (`power * hours / 1000 * 8`). Subclasses with saver mode (`AirConditioner`, `WashingMachine`) implement `SaverModeCapable` (25% reduction). Unsupported requests for `Fridge` or `Television` output `saver mode not supported` and are omitted from total cost.
- **Wattage:**
  - Fridge: 150 W
  - AC: 1500 W (Saver supported)
  - TV: 100 W
  - Washer: 500 W (Saver supported)

---

## Compilation & Execution

```bash
# Compile all practice problems
javac practice/*.java

# Run Problem 1
java -cp practice MovieTicketCounter

# Run Problem 2
java -cp practice ParcelShippingDesk

# Run Problem 3
java -cp practice CollegeFeeCounter

# Run Problem 4
java -cp practice CityCabFareMeter

# Run Problem 5
java -cp practice HomeApplianceEnergyReport
```
