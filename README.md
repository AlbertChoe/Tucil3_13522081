<h1 align="center">Tugas Kecil 3 IF2211 Strategy Algorithm</h1>
<h3 align="center">Wiki Ladder Solver</p>

## Table of Contents

- [Overview](#overview)
- [Abstraction](#abstraction)
- [Built With](#built-with)
- [Installation With GUI](#installation-with-GUI)
- [Installation With CLI](#installation-with-CLI)
- [Links](#links)

## Overview

<!-- ![messageImage_1714108706482](https://github.com/ChaiGans/Tubes2_BarengApin/assets/113753352/453096df-c257-49e0-8908-b5c0fb78b91f)
![messageImage_1714107805613](https://github.com/ChaiGans/Tubes2_BarengApin/assets/113753352/9535b50a-8b2f-4b03-83a8-ccb9209e47a2)
![messageImage_1714107894930](https://github.com/ChaiGans/Tubes2_BarengApin/assets/113753352/b3b19bc4-93ab-4db1-aa80-29bca324417a) -->

<p>Lecturer : Dr. Ir. Rinaldi Munir, M.T.</p>

Here is the purpose of making this project :

- To fulfill project assignment for the IF2211 Strategy Algorithm course.
- To implement Uniform Cost Search(UCS), Greedy Best First Search(GBFS) and AStar(A\*) search algorithms to find the shortest path from one word to another word by changing only 1 letter.
- To provide developers with the opportunity to learn Java programming languange and SwingFX for creating desktop applications.
- To serve as a platform for developers to explore desktop app development, including the creation of algorithms and logic using the Java programming language.
- To contribute to technological advancement, particularly in the field of optimizing pathfinding.

## Abstraction

## Problem Solving Steps with UCS Algorithm

## Problem Solving Steps with GBFS Algorithm

<!-- 1. Receive the initial and target URLs for the search, treated as the starting and goal nodes, respectively.
2. Scrape the starting node and generate child nodes, consisting of links found on the parent node. Each generation adds one depth level.
3. Check if the generated child node contains the target URL. There are two possible outcomes:
4. If the child node is the goal node, the algorithm stops and returns the result.
5. If the child node is not the goal node, the search continues to explore sibling nodes at the same depth level.
6. Child generation (steps 2 and 3) continues repeatedly with a limited depth, such as depth n (DLS with depth n).
7. IDS iterates child generation, progressively increasing depth, until a solution is found by repeatedly performing DLS with incremental depth levels. -->

## Problem Solving Steps with AStar Algorithm

<!-- ## Key Differences between BFS and IDS Algorithms

1. BFS focuses on finding the first valid path from the starting node to the target. It stops the search immediately upon finding the first match, making it efficient when only one solution is needed.
2. IDS aims to identify all possible paths from the starting node to the target at the same depth level. It continues the search to gather all potential paths at the same depth, providing a comprehensive view but requiring more resources and time to execute. -->

## Built With

- [Java](https://www.java.com/en/)
- [JavaFX](https://openjfx.io/)

## Prerequisites

To run this project, you will need to perform several installations, including:

- `Java 20` : This application requires Java 20, which is the main programming language used to create this project.
- `Java FX` : This is a software platform used to create and deliver desktop applications, as well as rich internet applications that can run across a wide variety of devices. JavaFX is crucial for the GUI components of this project. Since JavaFX was decoupled from the JDK starting from Java 11, you'll need to download and configure it separately.
- `Integrated Development Environment (IDE)` : An IDE that supports Java and JavaFX is recommended for ease of development(This project is developed using VSCode IDE).

<!-- **NOTE : It is recommended to have docker to run this project. So, download [Docker](https://www.docker.com/products/docker-desktop/) in the internet first, before continuing to the program** -->

## Installation With GUI

Make sure JavaFX is installed on your system. If not, install [JavaFX](https://gluonhq.com/products/javafx/). For reference in installing JavaFX, you can use this youtube video [Tutorial on installing JavaFX](https://youtu.be/AubJaosfI-0?si=taFNsn2QVd0nHRxq). If JavaFX is already installed, follow these steps:

1. Clone this repository :

```shell
git clone https://github.com/AlbertChoe/Tucil3_13522081.git
```

2. Navigate to the root directory of the program by running the following command in the terminal:

```shell
cd ./Tucil3_13522081
```

3. Open the project in IDE(Preferably VSCode):

```shell
code .
```

5. If you havent set up your IDE settings.json then follow this steps:

```shell
click ctrl + shift + p

```

then add this to you settings.json

```shell
"java.project.referencedLibraries": [
		"lib/**/*.jar",
		" < Your path when downloading the javaFX SDK >/lib/*"
	]
```

dont forget to change the path to your own JavaFX downloaded path.

4. Open launch.json file and change the path to your JavaFX SDK path you donwloaded:

![launch.json](image/image.png)

```shell
change the  < Your path when donwloading the javaFX SDK > into your own path where you donwloaded the JavaFX
```

5. If done then you can directly click F5 to run the project.
6. After successfully launching the application, users can choose the search algorithm, either using UCS, GBFS or AStar. Once the user selects the search algorithm, they need to enter the start word and the end word for the word ladder game. The program will display the result, along with execution time, and the number of nodes visited.

## Installation With CLI

Follow these steps:

1. Clone this repository :

```shell
git clone https://github.com/AlbertChoe/Tucil3_13522081.git
```

2. Navigate to the src directory of the program by running the following command in the terminal:

```shell
cd ./Tucil3_13522081/src
```

3. Run the following command:

```shell
javac Main.java
java Main
```

4. After successfully launching the application, users can choose the search algorithm, either using UCS, GBFS or AStar. Once the user selects the search algorithm, they need to enter the start word and the end word for the word ladder game. The program will display the result, along with execution time, and the number of nodes visited.

## Links

- Repository : [https://github.com/AlbertChoe/Tucil3_13522081/](https://github.com/AlbertChoe/Tucil3_13522081)
