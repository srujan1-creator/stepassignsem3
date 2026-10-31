# STEP SEM-3 Category C: Data Structure Assignment Solutions

This directory contains optimal Java solutions for the **STEP SEM-3 Category C Data Structure Assignment Problems**:

## Problem Overview

### Problem 4: Exam Score Band Counter (`ExamScoreBandCounter.java`)
- **Technique:** Binary Search (Lower & Upper Bound).
- **Time Complexity:** $O(\log N)$ (Strictly avoids $O(N)$ linear scanning over up to $10^6$ elements).
- **Space Complexity:** $O(1)$.

### Problem 6: Class Attendance Tracker (`ClassAttendanceTracker.java`)
- **Technique:** Single-pass streaming streak counter.
- **Time Complexity:** $O(N)$ single pass.
- **Space Complexity:** $O(1)$.

### Problem 7: Second-Best Score (`SecondBestScore.java`)
- **Technique:** Single-pass two-variable tracking (`highest`, `second`).
- **Rule:** Does not sort array (avoids $O(N \log N)$).
- **Time Complexity:** $O(N)$.
- **Space Complexity:** $O(1)$.

### Problem 8: Duty Roster Rotation (`DutyRosterRotation.java`)
- **Technique:** Modulo indexing `(i + (k % n)) % n` for $0 \le k \le 10^9$.
- **Time Complexity:** $O(N)$.
- **Space Complexity:** $O(N)$.

### Problem 10: Busiest Bus Row (`BusiestBusRow.java`)
- **Technique:** 2D matrix row reduction with strict inequality tie-breaking (smaller row index preserved).
- **Time Complexity:** $O(r \times c)$.
- **Space Complexity:** $O(1)$.
