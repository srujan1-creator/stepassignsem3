# STEP SEM-3 · CodInClub | Powered by BridgeLabz
## Comprehensive Category C Practice & Assignment Repository

This repository contains fully tested, verified, and production-quality Java solutions for the **STEP SEM-3 Category C** modules covering **Abstraction & Interfaces, Data Structures, and Sorting Algorithms**.

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
├── data-structure-assignment/                    # Module 2: Data Structures (Assignment)
│   ├── ExamScoreBandCounter.java                # Problem 4: Exam Score Band Counter (Binary Search)
│   ├── ClassAttendanceTracker.java              # Problem 6: Class Attendance Tracker (Streaming Streak)
│   ├── SecondBestScore.java                     # Problem 7: Second-Best Score (O(N) Non-Sorting)
│   ├── DutyRosterRotation.java                  # Problem 8: Duty Roster Rotation (Modulo Shift)
│   ├── BusiestBusRow.java                       # Problem 10: Busiest Bus Row (2D Matrix Search)
│   ├── Problem4_ExamScoreBandCounter/
│   ├── Problem6_ClassAttendanceTracker/
│   ├── Problem7_SecondBestScore/
│   ├── Problem8_DutyRosterRotation/
│   ├── Problem10_BusiestBusRow/
│   └── README.md
│
└── sorting-algorithms/                           # Module 3: Sorting Algorithms (Assignment)
    ├── HeightLineUp.java                        # Problem 1: The Height Line-Up (Bubble Sort with Early Stop)
    ├── PrizeTable.java                          # Problem 2: The Prize Table (Selection Sort Descending)
    ├── LibraryBookShelf.java                    # Problem 3: The Library Book Shelf (Insertion Sort)
    ├── QueueInOrder.java                        # Problem 4: Is the Queue in Order? (Linear Scan)
    ├── DiceThrowTally.java                      # Problem 5: The Dice Throw Tally (Counting Sort)
    ├── Problem1_TheHeightLineUp/
    ├── Problem2_ThePrizeTable/
    ├── Problem3_TheLibraryBookShelf/
    ├── Problem4_IsTheQueueInOrder/
    ├── Problem5_TheDiceThrowTally/
    └── README.md
```

---

## Module 3 Overview: Sorting Algorithms

All sorting algorithms are implemented from scratch without using `Arrays.sort`.

| Problem | Algorithm | Strategy & Highlights | Time Complexity | Auxiliary Space |
| :--- | :--- | :--- | :--- | :--- |
| **Problem 1: Height Line-Up** | Bubble Sort | Sweeps adjacent pairs; prints every pass; terminates early if 0 swaps occur | Best: $O(N)$, Worst: $O(N^2)$ | $O(1)$ |
| **Problem 2: Prize Table** | Selection Sort | Sorts marks descending; swaps maximum into place; returns count of actual swaps | $O(N^2)$ | $O(1)$ |
| **Problem 3: Library Book Shelf** | Insertion Sort | Inserts each incoming book into its sorted partition; prints state after each placement | Best: $O(N)$, Worst: $O(N^2)$ | $O(1)$ |
| **Problem 4: Queue In Order** | Order Scan | Identifies the first inversion index where `tokens[i] < tokens[i-1]`, or returns -1 | $O(N)$ | $O(1)$ |
| **Problem 5: Dice Throw Tally** | Counting Sort | Counts occurrences of values 1–6; reconstructs sorted array with zero element comparisons | $O(N + K)$ ($K=6$) | $O(K)$ |

---

## Build & Test Instructions

```bash
# Compile all modules
javac practice/*.java assignment/*.java data-structure-practice/*.java data-structure-assignment/*.java sorting-algorithms/*.java
```
