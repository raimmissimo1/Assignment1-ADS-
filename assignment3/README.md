# Assignment 3: Sorting and Searching Algorithm Analysis System

## Project Overview

Selected algorithms:
- Selection Sort
- Merge Sort
- Binary Search

Purpose:
- Compare a basic sorting algorithm with an advanced sorting algorithm.
- Measure execution time with `System.nanoTime()`.
- Show how input size and input order affect performance.

## Project Structure

```text
assignment3/
├── src/
│   ├── Sorter.java
│   ├── Searcher.java
│   ├── Experiment.java
│   └── Main.java
├── docs/
│   └── screenshots/
├── README.md
└── .gitignore
```

## Algorithm Descriptions

### Selection Sort
- Repeatedly selects the smallest element and moves it to the front.
- Time complexity: `O(n^2)`.

### Merge Sort
- Splits the array into halves, sorts each half, then merges them.
- Time complexity: `O(n log n)`.

### Binary Search
- Repeatedly halves a sorted array until the target is found.
- Time complexity: `O(log n)`.

## Experiment Design

- Array sizes: `10`, `100`, `1000`
- Input types: random and sorted arrays
- Measurements:
  - Selection Sort
  - Merge Sort
  - Binary Search

## How to Run

```bash
javac src/*.java
java -cp src Main
```

