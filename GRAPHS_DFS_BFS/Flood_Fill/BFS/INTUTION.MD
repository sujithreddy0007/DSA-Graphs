# Flood Fill

## Intuition

The "Flood Fill" problem is a classic graph traversal exercise disguised as an image manipulation task. The goal is to select a starting pixel and change its color, along with the color of all connected pixels that share the same original color.

We can think of the grid of pixels as a graph where each pixel is a **node**. An **edge** exists between two nodes if they are adjacent (4-directionally) and have the same color. The problem then becomes: "Find the connected component containing the starting node and change the color of all nodes in this component."

This is a perfect scenario for a traversal algorithm like **Breadth-First Search (BFS)** or Depth-First Search (DFS). BFS is a natural fit as it explores outwards from the start point, layer by layer, much like paint spreading or a flood filling an area.



The core idea is to start a BFS from the given pixel `(sr, sc)`. The traversal will only visit neighbors that have the same color as the starting pixel's original color. Any pixel we visit gets its color changed.

## Approach

This solution uses a queue to implement a Breadth-First Search. A key detail in this specific implementation is that we create a **copy** of the image to modify, which allows us to safely check against the original pixel values while we are filling.

1.  **Preparation**:
    * Store the `originalColor` of the starting pixel `image[sr][sc]`.
    * **Edge Case**: If the `originalColor` is already the same as the new `color`, no work is needed. The user's code implicitly handles this, but an early exit is a good optimization.
    * Create a new grid (`vist` in the code) as a copy of the original `image`. We will perform all color changes on this copy.

2.  **BFS Initialization**:
    * Create a `Queue` to store the coordinates of pixels that need to be processed.
    * Immediately change the color of the starting pixel `(sr, sc)` in our copied grid.
    * Add the starting pixel's coordinates to the queue to kick off the traversal.

3.  **BFS Traversal Loop**:
    * While the queue is not empty, perform the following steps:
        * Dequeue a pixel `(row, col)`.
        * For each of its four neighbors `(nrow, ncol)` (up, down, left, right):
            * **Check Conditions**:
                1.  Is the neighbor within the grid's boundaries?
                2.  Does the neighbor in the **original `image`** have the `originalColor`?
                3.  Has the neighbor in our **copied `vist` grid** not already been changed to the new `color`? (This serves as our "visited" check).
            * **Act**: If all three conditions are true, it means we've found a new pixel to fill.
                1.  Update the neighbor's color in our `vist` grid: `vist[nrow][ncol] = color`.
                2.  Enqueue the neighbor's coordinates so we can explore from it later.

4.  **Return Result**:
    * Once the queue is empty, all connected pixels with the `originalColor` have been visited and changed.
    * Return the modified `vist` grid.

### Complexity Analysis

* **Time Complexity**: $O(N \times M)$, where `N` is the number of rows and `M` is the number of columns. In the worst case, we might have to visit every pixel.

* **Space Complexity**: $O(N \times M)$. This is determined by the space required for the `vist` grid copy and the queue. In the worst-case scenario (a grid of a single color), the queue could potentially hold all `N * M` pixels.