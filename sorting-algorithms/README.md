# STEP SEM-3 Category C: Sorting Algorithms Assignment Problems

This directory contains standalone, fully implemented Java solutions for the **STEP SEM-3 Category C Sorting Algorithms Assignment Problems**.

All sorting algorithms are written manually from first principles without calling `Arrays.sort`, adhering strictly to the assignment specifications and testing guidelines.

---

## Problems & Implementations

### Problem 1: The Height Line-Up (`HeightLineUp.java`)
- **Algorithm:** Bubble Sort with early termination.
- **Key Behavior:** Prints the whole array after every sweep (`Pass k: [...]`). If a pass yields 0 swaps, prints that pass and terminates early.
- **Time Complexity:** Worst/Average: $O(N^2)$, Best: $O(N)$.
- **Space Complexity:** $O(1)$.

### Problem 2: The Prize Table (`PrizeTable.java`)
- **Algorithm:** Selection Sort (Descending Order).
- **Key Behavior:** Finds the maximum among unplaced marks and swaps it into position. Counts only actual swaps where `maxIndex != i`.
- **Time Complexity:** $O(N^2)$.
- **Space Complexity:** $O(1)$.

### Problem 3: The Library Book Shelf (`LibraryBookShelf.java`)
- **Algorithm:** Insertion Sort.
- **Key Behavior:** Places each book one by one from the second book onwards, printing the state of the shelf after each insertion.
- **Time Complexity:** Worst/Average: $O(N^2)$, Best: $O(N)$.
- **Space Complexity:** $O(1)$.

### Problem 4: Is the Queue in Order? (`QueueInOrder.java`)
- **Algorithm:** Single-pass Linear Scan.
- **Key Behavior:** Checks if array is non-decreasing. Returns the index of the first inversion (`tokens[i] < tokens[i-1]`), or `-1` if sorted.
- **Time Complexity:** $O(N)$.
- **Space Complexity:** $O(1)$.

### Problem 5: The Dice Throw Tally (`DiceThrowTally.java`)
- **Algorithm:** Counting Sort (Non-comparative).
- **Key Behavior:** Tallies frequencies of faces $1$ through $6$ in $O(N)$ time without any pairwise element comparisons.
- **Time Complexity:** $O(N + K)$ where $K = 6$.
- **Space Complexity:** $O(K)$.

---

## Individual Problem Subfolders

- `Problem1_TheHeightLineUp/HeightLineUp.java`
- `Problem2_ThePrizeTable/PrizeTable.java`
- `Problem3_TheLibraryBookShelf/LibraryBookShelf.java`
- `Problem4_IsTheQueueInOrder/QueueInOrder.java`
- `Problem5_TheDiceThrowTally/DiceThrowTally.java`

---

## Compilation & Execution

```bash
# Compile all sorting problems
javac sorting-algorithms/*.java

# Run Problem 1
java -cp sorting-algorithms HeightLineUp

# Run Problem 2
java -cp sorting-algorithms PrizeTable

# Run Problem 3
java -cp sorting-algorithms LibraryBookShelf

# Run Problem 4
java -cp sorting-algorithms QueueInOrder

# Run Problem 5
java -cp sorting-algorithms DiceThrowTally
```
