# Data Structure and Algorithm II Assignments

## Project Overview

This repository contains a comprehensive collection of advanced data structure and algorithm implementations developed as part of Data Structure and Algorithm II coursework. The project demonstrates the implementation of seven fundamental algorithmic concepts in Java, each contained within dedicated modules that showcase both theoretical understanding and practical application of complex computational problems.

## Project Structure

The repository is organized into seven distinct modules, each focusing on a specific algorithmic domain:

```
Data_Structure_and_Algorithm_II_Assignments_2-2/
├── Advanced_Heaps/
├── All_Pair_Shortest_Path/
├── Balanced_BST/
├── Hashing/
├── Max_Flow/
├── Minimum_Spanning_Tree/
├── Single_Source_Shortest_Path/
└── README.md
```

## Module Descriptions

### 1. Advanced Heaps
**Location**: `Advanced_Heaps/`

Implements advanced heap data structures with focus on binomial heaps, demonstrating efficient priority queue operations.

**Key Components**:
- `binomialHeap.java`: Complete implementation of binomial heap with insert, extract-min, find-min, and union operations
- `heapNode.java`: Node structure for binomial tree implementation with order tracking and child management
- `linkedList.java`: Custom linked list implementation for managing binomial trees in ascending order of their orders
- `Main.java`: Interactive command processor supporting operations: Insert (I), Print (P), Union (U), Find-Min (F), Extract-Min (E)
- `arr.java`: Generic dynamic array implementation with automatic resizing
- `queueArr.java`: Queue implementation used for level-order traversal in heap visualization

**Features**:
- Efficient union operation in O(log n) time
- Automatic heap balancing and tree merging
- Comprehensive heap visualization with level-by-level printing
- Support for arbitrary key insertion and batch operations

### 2. All Pair Shortest Path
**Location**: `All_Pair_Shortest_Path/`

Implements algorithms for finding shortest paths between all pairs of vertices in weighted directed graphs.

**Key Components**:
- `Floyd.java`: Floyd-Warshall algorithm implementation for all-pairs shortest paths
- `MatrixMultiplication.java`: Matrix multiplication-based approach for shortest path computation
- `Main.java`: Driver program that reads graph input and generates output files
- Graph infrastructure (`arr.java`, `Edge`, `node`, `graph` classes)

**Algorithms Implemented**:
- **Floyd-Warshall Algorithm**: Dynamic programming approach with O(V³) complexity
- **Matrix Multiplication Method**: Recursive matrix multiplication for shortest path calculation

**Input Format**:
- First line: number of vertices (n) and edges (m)
- Following m lines: edge definitions (source, destination, weight)
- Supports negative edge weights (Floyd-Warshall handles negative cycles)

**Output**:
- `Floyd.txt`: Results from Floyd-Warshall algorithm
- `MatrixMultiplication.txt`: Results from matrix multiplication approach
- Both files contain shortest distance matrices with "INF" for unreachable pairs

### 3. Balanced BST
**Location**: `Balanced_BST/`

Implements AVL (Adelson-Velsky and Landis) tree, a self-balancing binary search tree.

**Key Components**:
- `AVLTree.java`: Complete AVL tree implementation with automatic balancing
- `Main.java`: Command processor with performance measurement
- `in.txt`: Input file with operations (Insert, Delete, Find, Traversal)

**Features**:
- **Automatic Balancing**: Maintains height-balanced property through rotations
- **Rotation Operations**: Left rotation, right rotation, and double rotations
- **Height Calculation**: Recursive height computation with balance factor tracking
- **Performance Monitoring**: Execution time measurement for all operations
- **Operations Supported**:
  - Insert (I): Add new key with automatic rebalancing
  - Delete (D): Remove key while maintaining AVL property
  - Find (F): Search for key existence
  - Traversal (T): In-order traversal output

**Output Files**:
- `out_avl.txt`: Results of all operations and tree states
- `report_avl.txt`: Performance metrics with execution times

### 4. Hashing
**Location**: `Hashing/`

Comprehensive implementation of hash table variants with different collision resolution strategies.

**Key Components**:
- `HashTableSeparateChaining.java`: Chaining-based collision resolution
- `HashTableDoubleHashing.java`: Double hashing for open addressing
- `HashTableCustomProbing.java`: Custom quadratic probing implementation
- `Main.java`: Performance comparison framework with statistical analysis
- `2005090_Report.pdf`: Detailed performance analysis report

**Hash Functions**:
- **Hash1**: Primary hash function using character codes and bit operations
- **Hash2**: Alternative hash function for double hashing with different coefficients
- **Auxiliary Hash**: Secondary hash function for probe sequence generation

**Collision Resolution Methods**:
1. **Separate Chaining**: Linked list at each bucket for collision handling
2. **Double Hashing**: Secondary hash function determines probe sequence
3. **Custom Probing**: Quadratic probing with auxiliary hash function

**Performance Metrics**:
- Collision count tracking for each resolution method
- Average probe count measurement during search operations
- Comparative analysis across different table sizes (5000, 10000, 20000)
- Load factor impact on performance

### 5. Max Flow
**Location**: `Max_Flow/`

Implements maximum flow algorithms with application to baseball elimination problem.

**Key Components**:
- `maxFlow.java`: Ford-Fulkerson algorithm with BFS for maximum flow computation
- `Main.java`: Baseball elimination problem solver
- Graph infrastructure with flow network modeling

**Algorithm Implementation**:
- **Ford-Fulkerson Method**: Iterative augmenting path approach
- **BFS Path Finding**: Breadth-first search for finding augmenting paths
- **Residual Graph**: Dynamic residual capacity management

**Application Domain**:
- **Baseball Elimination**: Determines which teams are mathematically eliminated from championship
- **Network Flow Modeling**: Converts elimination problem to maximum flow formulation
- **Certificate Generation**: Provides proof of elimination through flow analysis

**Input Format**:
- Team count followed by team statistics
- Each team: name, wins, losses, games remaining, head-to-head matrix

**Output Analysis**:
- Elimination status for each team
- Mathematical proof showing why teams are eliminated
- Win scenario analysis with constraint satisfaction

### 6. Minimum Spanning Tree
**Location**: `Minimum_Spanning_Tree/`

Implements classical algorithms for finding minimum spanning trees in weighted undirected graphs.

**Key Components**:
- `kruskal.java`: Kruskal's algorithm using union-find data structure
- `prim.java`: Prim-Jarnik algorithm with priority queue optimization
- Graph infrastructure with edge weight management

**Algorithms Implemented**:
1. **Kruskal's Algorithm**:
   - Edge sorting by weight
   - Union-find for cycle detection
   - Greedy edge selection
   
2. **Prim-Jarnik Algorithm**:
   - Priority queue for edge selection
   - Vertex-based tree construction
   - Color-coding for vertex states

**Features**:
- **Weight Optimization**: Finds minimum total weight spanning tree
- **Cycle Avoidance**: Prevents cycles while maintaining connectivity
- **Output Generation**:
  - `kruskal.txt`: Results from Kruskal's algorithm
  - `prim.txt`: Results from Prim-Jarnik algorithm
  - Both files include total weight and edge listings

### 7. Single Source Shortest Path
**Location**: `Single_Source_Shortest_Path/`

Implements algorithms for finding shortest paths from a single source vertex to all other vertices.

**Key Components**:
- `BellmanFord.java`: Bellman-Ford algorithm handling negative edge weights
- `Dijkstras.java`: Dijkstra's algorithm for non-negative edge weights
- `Main.java`: Dual algorithm execution with comparison

**Algorithm Implementations**:
1. **Bellman-Ford Algorithm**:
   - Handles negative edge weights
   - Detects negative weight cycles
   - Relaxation-based approach with V-1 iterations
   
2. **Dijkstra's Algorithm**:
   - Priority queue optimization
   - Greedy approach for non-negative weights
   - Efficient shortest path computation

**Input Format**:
- Graph specification (vertices, edges)
- Edge definitions with weights
- Source and destination vertex specification

**Output Features**:
- Path reconstruction using parent tracking
- Distance calculation for optimal paths
- Negative cycle detection and reporting
- Comparative analysis between algorithms

## Common Infrastructure

### Shared Utility Classes

**Dynamic Array (`arr.java`)**:
- Generic dynamic array with automatic resizing
- Iterator-like functionality with position tracking
- Support for sorting and element manipulation
- Copy construction and array merging capabilities

**Queue Implementation (`queueArr.java`)**:
- Generic queue with dynamic capacity management
- FIFO operations with automatic memory management
- Used extensively in graph traversal algorithms

**Stack Implementation (`stackArr.java`)**:
- Generic stack with dynamic resizing
- LIFO operations for depth-first operations
- Path reconstruction in shortest path algorithms

**Graph Infrastructure**:
- **Node Class**: Vertex representation with adjacency lists and coloring
- **Edge Class**: Weighted edge implementation with comparison capabilities
- **Graph Class**: Complete graph representation with connectivity tracking
- **Union-Find**: Efficient disjoint set operations for cycle detection

## Installation and Setup

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Java compiler (javac)
- Text editor or IDE for Java development

### Compilation Instructions

Each module can be compiled independently. Navigate to the desired module directory and compile:

```bash
# Example for Single Source Shortest Path
cd Single_Source_Shortest_Path
javac *.java

# Example for Hashing
cd Hashing
javac *.java
```

### Execution Guidelines

**For modules with input files**:
```bash
# Ensure input.txt is present in the module directory
java Main
```

**For interactive modules (Advanced Heaps)**:
```bash
# Prepare input.txt with commands
java Main
```

**For performance analysis (Hashing)**:
```bash
# Run with automatic test data generation
java Main
```

## Input Specifications

### Graph-Based Modules
Most graph-based modules follow this input format:
```
n m
v1 w1 weight1
v2 w2 weight2
...
vm wm weightm
[additional parameters]
```

Where:
- `n`: number of vertices
- `m`: number of edges
- `vi wi weighti`: edge from vertex vi to vertex wi with given weight

### Command-Based Modules
**AVL Tree Operations**:
```
I value    # Insert value
D value    # Delete value
F value    # Find value
T          # Traverse (in-order)
```

**Binomial Heap Operations**:
```
I value           # Insert single value
U val1 val2 ...   # Union with multiple values
F                 # Find minimum
E                 # Extract minimum
P                 # Print heap structure
```

## Output Formats

### Performance Reports
Several modules generate performance analysis:
- **Hashing**: Collision counts and average probe measurements
- **AVL Tree**: Operation execution times in milliseconds
- **Graph Algorithms**: Distance matrices and path reconstructions

### Algorithm Results
- **Shortest Path**: Distance values and optimal path sequences
- **Spanning Tree**: Total weight and edge listings
- **Flow Networks**: Flow values and elimination certificates

## Configuration Options

### Hash Function Parameters
In the Hashing module, several parameters can be modified:
- `N`: Hash table size (automatically set to next prime)
- `C1`, `C2`: Coefficients for custom probing (default: 29, 37)
- Hash function selection via `markerHash` variable

### Graph Representation
- Adjacency list representation for sparse graphs
- Support for both directed and undirected graphs
- Automatic edge weight handling (integer and floating-point)

## Development Guidelines

### Adding New Algorithms
1. Create new module directory following existing structure
2. Implement core algorithm class with required methods
3. Add `Main.java` for input/output handling
4. Include appropriate data structure utilities
5. Add input/output file specifications

### Extending Existing Modules
1. Maintain compatibility with existing input formats
2. Add new methods to existing classes rather than modifying core functionality
3. Include comprehensive testing with provided input files
4. Document any parameter changes or new features

### Code Style Conventions
- Class names use PascalCase
- Method and variable names use camelCase
- Comprehensive error handling for edge cases
- Memory-efficient implementations with automatic resizing
- Clear separation between algorithm logic and I/O operations

## Testing and Validation

### Test Data
Each module includes representative test data:
- **Graph Modules**: Various graph topologies with different edge weights
- **Tree Modules**: Sequences of operations testing all functionality
- **Hashing Module**: Randomly generated string keys for collision analysis

### Validation Approach
- **Correctness**: Compare outputs with known optimal solutions
- **Performance**: Measure execution times for different input sizes
- **Edge Cases**: Test with empty inputs, single elements, and maximum constraints
- **Memory Usage**: Monitor dynamic array resizing and memory efficiency

### Expected Outputs
All modules generate output files demonstrating:
- Correct algorithm execution
- Optimal solution identification
- Performance characteristics
- Error handling for invalid inputs

## Contributing

### Code Contribution Guidelines
1. Follow existing code structure and naming conventions
2. Include comprehensive comments for complex algorithms
3. Test thoroughly with provided input files
4. Document any new dependencies or requirements
5. Maintain backward compatibility with existing interfaces

### Bug Reporting
When reporting issues, include:
- Module name and specific file
- Input data that causes the problem
- Expected vs. actual output
- Java version and compilation environment

## Performance Characteristics

### Time Complexities
- **AVL Tree**: O(log n) for all operations
- **Binomial Heap**: O(log n) for insert/extract, O(1) for find-min
- **Dijkstra's Algorithm**: O((V + E) log V) with priority queue
- **Bellman-Ford Algorithm**: O(VE) for general case
- **Floyd-Warshall**: O(V³) for all-pairs shortest paths
- **Kruskal's Algorithm**: O(E log E) for edge sorting
- **Prim's Algorithm**: O((V + E) log V) with priority queue

### Space Complexities
- **Graph Representation**: O(V + E) for adjacency lists
- **Dynamic Arrays**: O(n) with automatic resizing
- **Hash Tables**: O(n) with linear probing or chaining
- **Heap Structures**: O(n) for element storage

### Scalability Considerations
- All implementations handle moderate input sizes efficiently
- Memory management through automatic resizing prevents overflow
- Algorithm selection based on input characteristics (sparse vs. dense graphs)
- Performance monitoring capabilities for empirical analysis

## License

This project is developed for educational purposes as part of Data Structure and Algorithm II coursework. The implementations demonstrate fundamental algorithmic concepts and are intended for learning and academic use.

---

**Note**: This repository represents a comprehensive exploration of advanced data structures and algorithms, providing both theoretical understanding and practical implementation experience across multiple algorithmic domains.