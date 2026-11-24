===============================
       DRAGON'S OATH
===============================

Project Type:
JavaFX 2D Mini Game

Description:
Dragon's Oath is a simple JavaFX-based
2D obstacle avoidance game.

The player enters their name and controls
a dragon. The dragon continuously runs
while different obstacles appear.

The player can press SPACE to make the
dragon jump and avoid obstacles.

Obstacles:
- Rock
- Tree
- Fire

Game Rules:
1. The player starts the game by entering
   their name.
2. The dragon continuously runs.
3. The player presses SPACE to jump.
4. If the dragon hits an obstacle, the
   game is over.
5. The player's score increases while
   avoiding obstacles.
6. When the player reaches 50 points,
   an egg is found.
7. Finding the egg means the player wins.
8. The player's result is saved in the
   leaderboard.

Technologies Used:
- Java
- JavaFX
- Object-Oriented Programming
- File I/O

Java Concepts Used:
- Data Types
- Operators
- Expressions
- Conditional Statements
- Loops
- Arrays
- Methods
- Method Overloading
- Classes and Objects
- Inheritance
- Polymorphism
- Abstract Classes
- Interfaces
- Exception Handling
- File I/O
- JavaFX GUI

Main Classes:
Main.java
    Handles the main menu and application
    startup.

Game.java
    Handles the main game logic, dragon
    movement, obstacles, collision and score.

Player.java
    Stores player information and score.

Character.java
    Abstract parent class for characters.

Dragon.java
    Represents the dragon and implements
    jumping functionality.

Jumpable.java
    Interface for jump functionality.

Obstacle.java
    Abstract parent class for obstacles.

Rock.java
    Represents the rock obstacle.

Tree.java
    Represents the tree obstacle.

Fire.java
    Represents the fire obstacle.

Leaderboard.java
    Handles saving and reading player
    results using File I/O.

How to Run:
1. Install JDK.
2. Install JavaFX SDK.
3. Open the project in VS Code.
4. Open the terminal in the project folder.
5. Compile the Java files using the JavaFX
   module path.
6. Run the Main class.

Game Controls:
SPACE = Jump

Winning Condition:
Reach a score of 50.

Losing Condition:
Hit an obstacle.

===============================

The Dragon's Oath_Original
│
├── src
│   ├── Main.java
│   ├── Game.java
│   ├── Player.java
│   ├── Dragon.java
│   ├── Character.java
│   ├── Jumpable.java
│   ├── Obstacle.java
│   ├── Rock.java
│   ├── Tree.java
│   ├── Fire.java
│   └── Leaderboard.java
│
├── out
│
├── leaderboard.txt
│
└── README.txt
