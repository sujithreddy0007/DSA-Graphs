# Number of Provinces (DFS Approach)

## Intuition

This problem asks for the number of "provinces," which are groups of directly or indirectly connected cities. In graph terminology, the cities are **vertices**, the connections are **edges**, and a province is a **connected component**. Our goal is to count the number of these separate, disconnected components in the graph.

The overall strategy is to iterate through each city. If we find a city that we haven't visited yet, we know it must belong to a new, undiscovered province. We then start an exploration from this city to find and mark every other city that belongs to the same province. The total number of times we have to **begin a new exploration** is our final answer.

This is like counting constellations in the sky. You pick an uncounted star, trace out the entire pattern connected to it, and label it as "one constellation." Then you find another uncounted star and repeat the process.

## Approach

This solution uses a Depth-First Search (DFS) traversal, which explores as far as possible down one path before backtracking. We use a `visited` array to keep track of cities that have already been assigned to a province.

1.  **Initialization**:
    * Get the total number of cities, `V`.
    * Create a `visited` array of size `V` to track which cities we have already explored.
    * Initialize a `provinceCount` to `0`.

2.  **Main Loop**:
    * Iterate through every city from `0` to `V-1`.
    * For each city `i`, check if `visited[i]` is `0`.

3.  **Discovering a New Province**:
    * If city `i` has **not** been visited, it signifies the start of a new province.
    * We **increment `provinceCount`** by one.
    * We then immediately call our recursive `dfs` function, starting from city `i`, to find and mark all cities in this newly discovered province.

4.  **Depth-First Search Logic (`dfs` function)**:
    * The `dfs` function is the core of our exploration. When called with a `start` city:
    * **Mark as Visited**: The very first step is to mark the `start` city as visited (`visited[start] = 1`). This is crucial to prevent infinite loops between connected cities.
    * **Explore Neighbors**: The function then iterates through all other cities (`i`) to find neighbors of the `start` city.
    * **Recursive Call**: If `city i` is a neighbor (`graph[start][i] == 1`) AND it has not been visited (`visited[i] == 0`), we make a **recursive call**: `dfs(graph, visited, i)`.
    * This recursive nature is what takes us "deep" into the graph, exploring one path completely before backtracking to explore another. The recursion naturally stops and unwinds once it runs out of unvisited neighbors.

5.  **Final Result**:
    * After the main loop has checked all cities, `provinceCount` will accurately store the number of provinces. We return this value.

### Complexity Analysis

* **Time Complexity**: $O(V^2)$, where $V$ is the number of cities. We iterate through each city in the main loop. The DFS function will visit each vertex and edge once over the entire execution. For an adjacency matrix, checking the edges for a single vertex requires scanning its entire row of `V` elements. This results in a total time complexity of $O(V^2)$.

* **Space Complexity**: $O(V)$. This is determined by the `visited` array, which takes $O(V)$ space, and the recursion call stack. In the worst-case scenario (e.g., a single line of connected cities), the recursion depth can be $V$, so the call stack also uses $O(V)$ space.