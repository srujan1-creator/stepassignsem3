# STEP SEM-3 · CodInClub | Powered by BridgeLabz
## Comprehensive Category C Practice & Assignment Repository

This repository contains fully tested, verified, and production-quality Java solutions for the **STEP SEM-3 Category C** modules covering **Abstraction, Abstract Classes, Interfaces, and Data Structures**.

Repository URL: `https://github.com/srujan1-creator/stepassignsem3.git`

---

## Repository Structure

```
stepassignsem3/
├── .gitignore
├── README.md
│
├── practice/                                     # Module 1: Abstraction & Interfaces (Practice)
│   ├── MovieTicketCounter.java                  # Problem 1: Movie Ticket Counter
│   ├── ParcelShippingDesk.java                  # Problem 2: Parcel Shipping Desk
│   ├── CollegeFeeCounter.java                   # Problem 3: College Fee Counter
│   ├── CityCabFareMeter.java                    # Problem 4: City Cab Fare Meter
│   ├── HomeApplianceEnergyReport.java           # Problem 5: Home Appliance Energy Report
│   ├── Problem1_MovieTicketCounter/
│   ├── Problem2_ParcelShippingDesk/
│   ├── Problem3_CollegeFeeCounter/
│   ├── Problem4_CityCabFareMeter/
│   ├── Problem5_HomeApplianceEnergyReport/
│   └── README.md
│
├── assignment/                                   # Module 1: Abstraction & Interfaces (Assignment)
│   ├── GardenPlotAreaReport.java                # Problem 1: Garden Plot Area Report
│   ├── WeeklyStaffPay.java                      # Problem 2: Weekly Staff Pay
│   ├── LibraryLateFineCounter.java              # Problem 3: Library Late Fine Counter
│   ├── ElectricityConnectionBilling.java        # Problem 4: Electricity Connection Billing
│   ├── TravelBookingWithCommonFee.java          # Problem 5: Travel Booking with a Common Fee
│   ├── Problem1_GardenPlotAreaReport/
│   ├── Problem2_WeeklyStaffPay/
│   ├── Problem3_LibraryLateFineCounter/
│   ├── Problem4_ElectricityConnectionBilling/
│   ├── Problem5_TravelBookingWithCommonFee/
│   ├── QLA_SOLUTIONS.md                         # Complete Part B Quiz & Part C Concept Answers
│   └── README.md
│
├── data-structure-practice/                      # Module 2: Data Structures (Practice)
│   ├── VowelConsonantCounter.java               # Problem 1: Vowel and Consonant Counter
│   ├── WordReverserPalindrome.java              # Problem 2: Word Reverser & Palindrome Checker
│   ├── EvenOddCounter.java                      # Problem 3: Even and Odd Numbers in a List
│   ├── InPlaceArrayReversal.java                # Problem 4: In-Place Array Reversal
│   ├── DigitSumAndReversal.java                 # Problem 5: Digit Sum & Number Reversal
│   ├── PrimeNumberChecker.java                  # Problem 6: Prime Number Checker
│   ├── FactorialCalculation.java                # Problem 7: Factorial Calculation
│   ├── StudentGradeAssignment.java              # Problem 8: Student Grade Assignment
│   ├── LeapYearDetector.java                    # Problem 9: Leap Year Detector
│   ├── StudentResultCardGenerator.java          # Problem 10: Student Result Card Generator
│   ├── QLA_SOLUTIONS.md                         # Quiz (Q1–Q20) & Concept Answers (Q1–Q10)
│   └── README.md
│
└── data-structure-assignment/                    # Module 2: Data Structures (Assignment)
    ├── ExamScoreBandCounter.java                # Problem 4: Exam Score Band Counter (Binary Search)
    ├── ClassAttendanceTracker.java              # Problem 6: Class Attendance Tracker (Streaming Streak)
    ├── SecondBestScore.java                     # Problem 7: Second-Best Score (O(N) Non-Sorting)
    ├── DutyRosterRotation.java                  # Problem 8: Duty Roster Rotation (Modulo Shift)
    ├── BusiestBusRow.java                       # Problem 10: Busiest Bus Row (2D Matrix Search)
    └── README.md
```

---

## Module Overview

### 1. Abstraction & Interfaces (`practice/` and `assignment/`)
- Demonstrates clean polymorphic hierarchies, abstract class contracts, capability interfaces (`Insurable`, `BusTransportUser`, `NightServiceCapable`, `SaverModeCapable`), and the Open/Closed Principle.
- Includes theoretical evaluation answers in `assignment/QLA_SOLUTIONS.md`.

### 2. Data Structures (`data-structure-practice/` and `data-structure-assignment/`)
- Features 10 practice problems and 5 core assignment problems spanning arrays, two-pointer algorithms, number theory, binary search, and 2D matrix transformations.
- Optimal time & space complexities adhered to (e.g., $O(\log N)$ binary search, $O(1)$ auxiliary space without sorting).
- Comprehensive theoretical assessment covering String immutability, pass-by-value, memory models, and encapsulation in `data-structure-practice/QLA_SOLUTIONS.md`.

---

## Compilation

```bash
# Compile all modules
javac practice/*.java assignment/*.java data-structure-practice/*.java data-structure-assignment/*.java
```
