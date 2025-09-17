# Number of Provinces

## Intuition

The problem asks us to find the number of "provinces" from a list of city connections. A province is a group of cities where every city in the group is connected to every other city, either directly or indirectly. If we think about this problem from a graph theory perspective, the cities are the **nodes (vertices)** and a direct connection is an **edge**.

A "province" is therefore just another name for a **connected component** of a graph.



The core idea is to count how many separate, disconnected groups of cities exist. We can do this by systematically visiting every city. We'll start a traversal (like BFS or DFS) from an unvisited city, and this traversal will find and mark every single city belonging to that same province. Once the traversal is done, we know we've fully explored one province. We then look for another unvisited city and repeat the process. The number of times we have to **start** a new traversal is our answer.

Imagine you have a map of islands. To count them, you would:
1.  Pick a random starting point on the land.
2.  Explore the entire island connected to that point, coloring it in.
3.  Count this as "1 island".
4.  Look for any part of the map that isn't colored yet.
5.  If you find one, repeat the process.

This is exactly the logic we'll apply to the graph of cities.

## Approach

Our algorithm uses a Breadth-First Search (BFS) traversal to find all cities in a single province. We'll use a `visited` array to keep track of the cities we've already assigned to a province.

1.  **Initialization**:
    * Get the total number of cities, `V`, which is the length of the input matrix.
    * Create a `visited` array of size `V`, initialized to `0` (or `false`), to track which cities have been visited.
    * Initialize a `provinceCount` variable to `0`.

2.  **Iterate Through Cities**:
    * We will loop through every city, from index `0` to `V-1`.
    * Inside the loop, for each city `i`, we check if it has been visited (`visited[i] == 0`).

3.  **Discovering and Exploring a New Province**:
    * If city `i` has **not** been visited, it means we have found a new, unexplored province.
    * First, we **increment `provinceCount`**.
    * Then, we start a **BFS traversal** from city `i` to find all the cities connected to it.

4.  **BFS Traversal Logic (`bfs` function)**:
    * Create a queue and add the starting city `i` to it.
    * Mark the starting city `i` as visited (`visited[i] = 1`).
    * While the queue is not empty:
        * Dequeue a city (let's call it `currentCity`).
        * Look at the row for `currentCity` in the adjacency matrix. Iterate through all other cities (let's call them `neighbor`).
        * If `mat[currentCity][neighbor] == 1` and `neighbor` has not been visited (`visited[neighbor] == 0`), it means we've found a new city in the current province.
        * Mark this `neighbor` as visited and add it to the queue to explore its connections later.

5.  **Final Result**:
    * After the main loop finishes, the `provinceCount` will hold the total number of times we initiated a traversal, which is exactly the number of provinces. Return `provinceCount`.

### Complexity Analysis

* **Time Complexity**: $O(V^2)$, where $V$ is the number of cities. The main loop runs $V$ times. The BFS traversal, in the worst case for an adjacency matrix representation, visits each vertex and for each vertex, it scans a whole row of `V` elements to find its neighbors. Since every vertex is visited only once across all BFS calls, the total time complexity is dominated by scanning the matrix, leading to $O(V^2)$.

* **Space Complexity**: $O(V)$. We use a `visited` array of size $V$ and a queue for BFS which can, in the worst case (a line graph), hold up to $V$ vertices.