# Simultane Labyrinthe

This project is a solution for the task "Simultane Labyrinthe" from the second round of the **BWINF 2024** competition. The goal is to solve multiple labyrinths simultaneously under specific constraints.

## How to Run

Ensure you have Java installed on your system. Compile and run the main program with:
```bash
javac src\SimulanteLabyrinthe.java
java -cp src SimulanteLabyrinthe <input-file-path>
```
## Input Format

The input is a `.txt` file that describes the two labyrinths. The structure is as follows:

1. **First Line**: 
    - Specifies the width `n` and height `m` of the two labyrinths.
2. **Vertical Walls**: 
    - `m` lines with `n-1` entries each.
    - Each entry indicates whether there is a vertical wall to the right of the field (`1` for a wall, `0` for no wall).
3. **Horizontal Walls**:
    - `m-1` lines with `n` entries each.
    - Each entry indicates whether there is a horizontal wall below the field (`1` for a wall, `0` for no wall).
4. **Number of Pits**:
    - A single line specifying the number `g` of pits in the labyrinth.
5. **Pit Coordinates**:
    - `g` lines, each containing the coordinates of a pit in the format `xy`/`xy xy`/`xy xy 1/2`.
    - If there are no pits, this section is skipped.
    - If the pit leads to a field other than `(0,0)`, the second set of coordinates defines the outcome position.

The second labyrinth follows the same structure, starting with the vertical wall definitions.

After that, an optional line follows that specifies the number of plaits in the first maze. In the lines after that, the individual plaits are defined.

Each plait is described in a single line with the following syntax:
```
<maze-source> <x1> <y1> <maze-target> <x2> <y2> <action>
```
- `<maze-source>`: The maze in which the plait is located.
- `<x1> <y1>`: The coordinates of the plait in the source maze.
- `<maze-target>`: The maze where the plait causes a change.
- `<x2> <y2>`: The coordinates in the target maze where the change occurs.
- `<action>`: The action that happens at the specified position in the target maze.

If no plaits are present, this section is skipped.

## References

- Maze visualization (helper script): [Bug-Busters-dev/maze_visualization](https://github.com/Bug-Busters-dev/maze_visualization)
- Task description: [BWINF 2024 Round 2 Task PDF](https://bwinf.de/fileadmin/wettbewerbe/bundeswettbewerb/43/2_runde/Aufgaben432.pdf)

## Project Structure

- `src\SimulanteLabyrinthe.java`: The main Java program to execute the solution.
- `README.md`: This file, providing an overview of the project.
- Other files and directories contain the implementation and any additional resources.

## Notes

- The maze visualization script is optional and can be used to visualize the solution paths.
- For visualization, the referenced helper script needs to be integrated separately.

