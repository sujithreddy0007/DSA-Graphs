# DSA Journey: Graph Algorithms 📊

Welcome to my **Graph Algorithms** repository! This collection contains my solutions and detailed explanations for various graph-based problems from platforms like LeetCode, GeeksforGeeks, and others. The goal of this repository is to serve as a personal log of my progress and to help others understand these complex topics.

Each problem is organized into its own folder, containing the source code and a dedicated `intuition.md` file explaining the approach.

---

## 📚 Table of Contents

This repository is structured by topic, covering the foundational algorithms and data structures for graphs.

1.  [**Traversal Algorithms (BFS & DFS)**](#--traversal-algorithms-bfs--dfs)
    * Essential for exploring graphs and forming the basis for many other algorithms.

2.  [**Topological Sort**](#--topological-sort)
    * Used for ordering nodes in a Directed Acyclic Graph (DAG).

3.  [**Shortest Path Algorithms**](#--shortest-path-algorithms)
    * Algorithms like Dijkstra's, Bellman-Ford, and Floyd-Warshall for finding the shortest path between nodes.

4.  [**Minimum Spanning Trees & DSU**](#--minimum-spanning-trees--disjoint-set-union)
    * Algorithms like Kruskal's and Prim's for finding the MST, often optimized with the Disjoint Set Union (DSU) data structure.

---

## 🗺️ Traversal Algorithms (BFS & DFS)

This section covers problems that can be solved using fundamental graph traversal techniques.

* **Breadth-First Search (BFS)**: Explores the graph level by level. Perfect for finding the shortest path in unweighted graphs.
* **Depth-First Search (DFS)**: Explores the graph by going as deep as possible down one path before backtracking. Useful for problems involving connectivity, cycles, and pathfinding.

**Problems Solved:**
* [Number of Provinces](<link-to-your-folder>)
* *(...add more as you complete them)*

---

## ⛓️ Topological Sort

Topological Sort provides a linear ordering of vertices in a Directed Acyclic Graph (DAG) such that for every directed edge `u -> v`, vertex `u` comes before vertex `v` in the ordering. This is commonly solved using Kahn's Algorithm (BFS-based) or a DFS-based approach.

**Problems Solved:**
* *(...add links to your problems here)*

---

## 📍 Shortest Path Algorithms

This section is dedicated to finding the most efficient route between vertices in a weighted graph.

* **Dijkstra's Algorithm**: Finds the shortest path from a single source to all other nodes in a graph with non-negative edge weights.
* **Bellman-Ford Algorithm**: Handles graphs with negative edge weights.
* **Floyd-Warshall Algorithm**: Finds the shortest paths between all pairs of vertices.

**Problems Solved:**
* *(...add links to your problems here)*

---

## 🌳 Minimum Spanning Trees & Disjoint Set Union

* A **Minimum Spanning Tree (MST)** is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.
* **Disjoint Set Union (DSU)**, also known as Union-Find, is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets. It's highly efficient for detecting cycles and is used to optimize Kruskal's algorithm.

**Problems Solved:**
* *(...add links to your problems here)*

---

## 🚀 How to Use

1.  **Clone the repository**:
    ```bash
    git clone [https://github.com/sujeethreddy0007/DSA-Graphs.git](https://github.com/sujithreddy0007/DSA-Graphs)
    ```
2.  **Navigate to a problem folder**:
    ```bash
    cd "Problem Name Folder"
    ```
3.  **Review the Code**: Check out the `.java` solution file.
4.  **Understand the Approach**: Read the `intuition.md` file for a detailed breakdown of the logic and complexity analysis.