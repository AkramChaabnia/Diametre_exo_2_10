<p align="center">
  <a href="" rel="noopener">
    <img src="" alt="Project logo">
  </a>
</p>
<h3 align="center">Connected Components Diameter</h3>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![GitHub Issues](https://img.shields.io/github/issues/AkramChaabnia/ConnectedComponentsDiameter.svg)](https://github.com/AkramChaabnia/ConnectedComponentsDiameter/issues)
[![GitHub Pull Requests](https://img.shields.io/github/issues-pr/AkramChaabnia/ConnectedComponentsDiameter.svg)](https://github.com/AkramChaabnia/ConnectedComponentsDiameter/pulls)
[![University](https://img.shields.io/badge/University-Paris%20Cité%20Université-%23A6192E)](https://u-paris.fr)

</div>

---

<p align="center">Connected Components Diameter is a Java project that computes the diameter of each connected component in a graph using the Dijkstra algorithm. This project was developed as part of an assignment at Université de Paris Cité.
  <br> 
</p>

## 📝 Table of Contents

- [About](#about)
- [Code Structure](#code_structure)
- [Algorithm Complexity](#algorithm_complexity)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting_started)
- [Usage](#usage)
- [Built Using](#built_using)
- [Authors](#authors)
- [Acknowledgements](#acknowledgement)
- [Contact](#contact)

## 🧐 About <a name = "about"></a>

The goal of this project is to implement an algorithm that determines the diameter of each connected component in a graph using the Dijkstra algorithm. The project consists of a Java implementation that computes the diameter of connected components.

## 🚀 Code Structure <a name = "code_structure"></a>

The project includes the following files:

- `App.java`: Contains the main algorithm that computes the diameter of each connected component using the Dijkstra algorithm.
  - `findDiameter(Graph graph, int num_v)`: Finds the diameter of connected components in the graph.
  - `calculateComponentDiameter(Graph graph, int start, int num_v)`: Calculates the diameter of a specific component.
  - `calculatePathDistance(Graph graph, LinkedList<Integer> path)`: Calculates the distance of a path in the graph.
  - `resetGraph(Graph graph)`: Resets the graph's vertices.
  - `Dijkstra(Graph graph, int start, int end, int numberV)`: Implements Dijkstra's algorithm to find the shortest path.
- `WeightedGraph.java`: Defines classes to represent a weighted graph, including vertices and edges.

## 📈 Algorithm Complexity <a name="algorithm_complexity"></a>

The algorithm used in this project, based on Dijkstra's algorithm to determine the diameter of each connected component, showcases varying complexities influenced by multiple factors:

Vertices (V): The algorithm traverses each vertex to identify connected components, contributing to a runtime proportional to the number of vertices.

Edges (E): During graph exploration, the algorithm computes shortest paths between vertices, where the number of edges affects distance calculations within connected components.

Graph Structure: The connectivity and density of the graph significantly impact the algorithm's performance. Dense graphs or those with a high number of vertices may increase computational complexity.

Considering these factors, the estimated complexity is O(V _ (V + E) _ log V), reflecting the traversal of vertices and edges while determining the diameter of connected components using Dijkstra's algorithm. This complexity accounts for the algorithm's operations specific to computing connected component diameters in the given graph structure.

## 🛠️ Prerequisites <a name = "prerequisites"></a>

To run the project, you need to have Java installed on your machine. You can download Java from [here](https://www.java.com/en/download/).

## 🏁 Getting Started <a name = "getting_started"></a>

To compile and execute the project:

1. Clone the repository or download the project files.

### Using an IDE (Eclipse, VSCode, etc.)

2. Set up the JavaFX environment in your IDE.
3. Run the `App.java` file.

### Using Command Line

2. Compile the Java code using the command: `javac App.java`.
3. Run the compiled code using the command: `java App`.

## 🎈 Usage <a name="usage"></a>

To use the project, follow these steps:

- Enter the number of vertices.
- Enter the edges in the format: source destination weight. Enter `-1` to stop.
- The project will compute and display the diameter of each connected component.

## ⛏️ Built Using <a name = "built_using"></a>

- [Java](https://www.java.com/) - Programming Language

## ✍️ Authors <a name = "authors"></a>

- [@AkramChaabnia](https://github.com/AkramChaabnia) - Implementation

## 🎉 Acknowledgements <a name = "acknowledgement"></a>

- This project was developed as part of an assignment at Université de Paris Cité.

## 📞 Contact <a name = "contact"></a>

For any questions or inquiries, feel free to contact:

- Email: akram.chaabnia25@gmail.com
- LinkedIn: [Akram CHAABNIA](https://www.linkedin.com/in/akram-chaabnia-43b7941b0/)
- GitHub: [@AkramChaabnia](https://github.com/AkramChaabnia)

Please feel free to reach out!
