package edu.project2;

import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int randomSeedForMyMaze = 11;
        final int squareSideLength = 5;
        final Coordinate startOnLeftTop = new Coordinate(0, 1);
        final Coordinate exitInRightBottom = new Coordinate(10, 9);
        Maze maze = new Maze(new EllerAlgorithm(randomSeedForMyMaze), squareSideLength, squareSideLength);
        maze.setPoints(startOnLeftTop, exitInRightBottom);
        List<Coordinate> path = new BFS(maze).solve();
        String render = new RenderMaze().render(maze);
        String renderPath = new RenderMaze().render(maze, path);
        LOGGER.info(render);
        LOGGER.info(renderPath);
    }
}
