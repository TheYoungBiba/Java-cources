package edu.project2;

import java.util.HashSet;
import java.util.List;

public class RenderMaze implements Renderer {
    public RenderMaze() {}

    @Override
    public String render(Maze maze) {
        StringBuilder renderedMaze = new StringBuilder();
        renderedMaze.append("\n");
        int[][] preRenderedGrid = maze.getPreRenderedGrid();
        for (int i = 0; i < preRenderedGrid.length; i++) {
            for (int j = 0; j < preRenderedGrid[i].length; j++) {
                if (preRenderedGrid[i][j] == 2) {
                    renderedMaze.append(" ● ");
                } else if (preRenderedGrid[i][j] == 1) {
                    renderedMaze.append("███");
                } else {
                    renderedMaze.append("   ");
                }
            }
            renderedMaze.append("\n");
        }
        return renderedMaze.toString();
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        HashSet<Coordinate> pathCoords = new HashSet<>(path);
        StringBuilder renderedMaze = new StringBuilder();
        renderedMaze.append("\n");
        if (pathCoords.isEmpty()) {
            renderedMaze.append("Path not found.\n");
        }
        int[][] preRenderedGrid = maze.getPreRenderedGrid();
        for (int i = 0; i < preRenderedGrid.length; i++) {
            for (int j = 0; j < preRenderedGrid[i].length; j++) {
                if (preRenderedGrid[i][j] == 1) {
                    renderedMaze.append("███");
                } else if (path.contains(new Coordinate(i, j))) {
                    renderedMaze.append(" ● ");
                }
                else {
                    renderedMaze.append("   ");
                }
            }
            renderedMaze.append("\n");
        }
        return renderedMaze.toString();
    }
}
