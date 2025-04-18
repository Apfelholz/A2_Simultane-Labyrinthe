# Simultane Labyrinthe

This project is a solution for the task "Simultane Labyrinthe" from the second round of the **BWINF 2024/2025** competition. The goal is to solve multiple labyrinths simultaneously under specific constraints.

## How to Run

Ensure you have Java installed on your system. Run the main program with:
```bash
java -jar <program-file-path> <input-file-path> <version>
```

If no version is specified, the plate expansion will not be active. It will still be possible to provide custom start/end points and modify the lead fields of pits.

> ⚠️ **Warning:**  
> Enabling the plate expansion by setting the version to `plates` will **consistently slow down the program**.

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

There are 4 optional lines that define the starting and end positions in the different mazes:

```
<startx1> <starty1>
<startx2> <starty2>
<endx1> <endy1>
<endx2> <endy2>
```

After that, an optional line specifies the number of plaits in the mazes. In the lines after that, the individual plaits are defined.

Each plait is described in a single line with the following syntax:
```
<maze-source> <x1> <y1> <maze-target> <x2> <y2> <action>
```
- `<maze-source>`: The maze in which the plait is located. `(1/2)`
- `<x1> <y1>`: The coordinates of the plait in the source maze.
- `<maze-target>`: The maze where the plait causes a change. `(1/2)`
- `<x2> <y2>`: The coordinates in the target maze where the change occurs.
- `<action>`: The action that happens at the specified position in the target maze. `1` -> make the target empty, `2` -> make a vertical wall on that field, `3` -> make a horizontal wall on that field.

If no plaits are present, this section is skipped.

## Output

The program outputs to the console.

It is also possible to get a visualization of the output in the form of `.ppm` from [maze_visualization](https://github.com/Bug-Busters-dev/maze_visualization).

## References

- Maze visualization (helper script): [maze_visualization](https://github.com/Bug-Busters-dev/maze_visualization)
- Task description: [BWINF 2024 Round 2 Task PDF](https://bwinf.de/fileadmin/wettbewerbe/bundeswettbewerb/43/2_runde/Aufgaben432.pdf)

## Project Structure

A2_Simultane-Labyrinthe/
│
├── src/                # Source code of the project  
├── data/               # Datasets and input files  
└── README.md           # This document  

## Notes

- The maze visualization script is optional and can be used to visualize the solution paths.
- For visualization, the referenced helper script needs to be integrated separately.

## Authors
- Jonathan Salomo @apfelholz