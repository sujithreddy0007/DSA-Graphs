# Flood Fill (DFS Approach)

## Intuition

The Flood Fill problem requires us to find and recolor a connected area of pixels, starting from a given point. This can be modeled as a graph problem where pixels are nodes and adjacent pixels of the same color are connected by edges. Our goal is to traverse a connected component and modify its nodes.

While Breadth-First Search (BFS) explores layer by layer, **Depth-First Search (DFS)** offers another powerful way to solve this. DFS explores as far as possible down one path before backtracking. You can visualize this like a person walking through a maze: they follow one corridor until they hit a dead end, then they backtrack to the last junction and try a different path.



We'll use a recursive function for our DFS. The function will "visit" a pixel, change its color, and then immediately call itself for any valid neighbors. This chain of recursive calls is what takes us "deep" into the component.

## Approach

This solution uses a recursive `dfs` helper function to traverse and color the pixels. It operates on a copy of the image and uses a separate `visited` grid to keep track of which pixels have already been processed.

1.  **Preparation**:
    * Store the `originalColor` of the starting pixel `image[sr][sc]`. If this color is already the same as the new `color`, we could return immediately.
    * Create a `res` grid by copying the input `image`. This is the grid we will modify and eventually return.
    * Create a `vist` (visited) grid of the same dimensions, initialized to `0`, to prevent infinite loops and re-processing pixels.

2.  **Initiating the Traversal**:
    * The main `floodFill` function starts the process by calling the recursive `dfs` helper function on the starting coordinates `(sr, sc)`.

3.  **Recursive DFS Logic (`dfs` function)**:
    * The `dfs` function is called for a pixel `(row, col)`. This is the core of the algorithm.
    * **Base Case**: The recursion implicitly stops when a pixel has no valid neighbors to visit (i.e., neighbors that are out of bounds, have a different color, or have already been visited).
    * **Action**:
        1.  Change the color of the current pixel in the `res` grid to the new `color`.
        2.  Mark the current pixel as visited in the `vist` grid (`vist[row][col] = 1`).
    * **Recursive Exploration**:
        1.  Iterate through the four neighbors of the current pixel (up, down, left, right).
        2.  For each neighbor, check if it meets all the required conditions: it's within the grid, it has the `originalColor`, and it has **not** been visited yet.
        3.  If all conditions are true, make a **recursive call** to `dfs` for that neighbor. This continues the "deep" exploration along that path.

4.  **Return Result**:
    * Once the initial `dfs` call in the `floodFill` function returns, the entire connected component has been traversed and recolored.
    * Return the modified `res` grid.

### Complexity Analysis

* **Time Complexity**: $O(N \times M)$, where `N` is the number of rows and `M` is the number of columns. In the worst-case scenario, DFS will visit every pixel exactly once.

* **Space Complexity**: $O(N \times M)$. This is due to the space used for the `res` and `vist` grids. Furthermore, the recursion call stack can, in the worst case (e.g., a long, winding path of same-colored pixels), grow to a depth of $N \times M$.