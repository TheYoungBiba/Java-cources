package edu.project2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Maze maze = new Maze(new EllerAlgorithm(11), 5, 5);
        maze.setPoints(new Coordinate(0, 1), new Coordinate(10, 9));
        List<Coordinate> path = new PathFinder(maze).solve();
        String render = new RenderMaze().render(maze);
        String renderPath = new RenderMaze().render(maze, path);
        LOGGER.info(render);
        LOGGER.info(renderPath);
    }
}
