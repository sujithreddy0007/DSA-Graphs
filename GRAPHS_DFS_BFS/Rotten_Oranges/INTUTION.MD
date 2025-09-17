# Rotting Oranges

## Intuition

The problem describes a process where rotting spreads from rotten oranges to their adjacent fresh neighbors simultaneously with each passing minute. This "simultaneous" or "layer-by-layer" progression is a tell-tale sign that **Breadth-First Search (BFS)** is the perfect algorithm for the job.



Think of the initial set of rotten oranges as the starting points (level 0). All the fresh oranges they rot in the first minute are level 1. The oranges *they* rot in the next minute are level 2, and so on. BFS naturally explores a graph in this exact level-by-level manner.

Our goal is to find the time it takes for the very last reachable orange to become rotten. In BFS terms, this is simply the "time" or "level" of the last node we process. If, after the process ends, there are still fresh oranges left, it means they were isolated and could never be reached.

## Approach

Our BFS algorithm will use a queue to keep track of the rotten oranges we need to process. Crucially, each element in the queue must store not only the orange's coordinates (`row`, `col`) but also the `time` at which it became rotten.

1.  **Initialization**:
    * Create a queue to hold `Pair` objects, where each `Pair` stores `{row, col, time}`.
    * Create a `visited` grid of the same dimensions to prevent processing the same orange multiple times.
    * Iterate through the entire grid once to find all the initially rotten oranges (`grid[i][j] == 2`).
    * For each initial rotten orange, add a new `Pair(i, j, 0)` to the queue and mark it as visited.

2.  **BFS Traversal**:
    * Start a `while` loop that continues as long as the queue is not empty.
    * Initialize a variable `maxTime = 0` to track the answer.
    * Inside the loop, dequeue a `Pair`. Let its time be `t`.
    * Update our answer: `maxTime = max(maxTime, t)`.
    * Explore the 4-directional neighbors (up, down, left, right) of the dequeued orange.
    * For each neighbor, check if it is:
        * Within the grid boundaries.
        * A fresh orange (`grid[value] == 1`).
        * Not already visited.
    * If all conditions are met, it means this fresh orange now becomes rotten. Mark it as visited and enqueue it as a new `Pair` with an incremented time of `t + 1`.

3.  **Final Check for Unreachable Oranges**:
    * After the BFS loop finishes, the queue will be empty. This means the rotting process has stopped.
    * We must now check if any fresh oranges remain. Iterate through the grid one last time.
    * If you find any cell that is still a fresh orange (`grid[i][j] == 1`), it means it was impossible for the rot to reach it. In this case, return `-1`.

4.  **Return the Result**:
    * If the final check passes (no fresh oranges are left), the `maxTime` variable holds the time it took for the last orange to rot. Return `maxTime`.

### Complexity Analysis

* **Time Complexity**: $O(N \times M)$, where `N` is the number of rows and `M` is the number of columns. Each cell is visited at most a constant number of times (during the initial scan and the BFS traversal).

* **Space Complexity**: $O(N \times M)$. In the worst-case scenario, the queue could hold all `N * M` cells (e.g., a grid full of oranges). The `visited` grid also requires $O(N \times M)$ space.