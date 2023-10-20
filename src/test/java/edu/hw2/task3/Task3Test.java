package edu.hw2.task3;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;


public class Task3Test {

    @Test
    void faultyConnectionFailedTest() {
//      Будет возвращать псевдо-случайные значения: true, true, true, false
        Random isNotConnected = new Random(7);
        FaultyConnection testCase = new FaultyConnection(isNotConnected);
        Exception e = assertThrows(ConnectionException.class, () -> {
            testCase.execute("doMagic");
        });
        String expectedMessage = "Connection failed.";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    void faultyConnectionManagerTest() {
//      Будет возвращать псевдо-случайные значения: true, true, true, false
        Random isNotConnected = new Random(7);
        FaultyConnectionManager testCase = new FaultyConnectionManager(isNotConnected);
        Exception e = assertThrows(ConnectionException.class, () -> {
            testCase.getConnection().execute("doMagic");
        });
        String expectedMessage = "Connection failed.";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    void defaultConnectionManagerWithFaultyConnectTest() {
//      Будут возвращать псевдо-случайные значения: true, true, true, false
        Random isFaultyConnection = new Random(7);
        Random isNotConnected = new Random(7);
        DefaultConnectionManager testCase = new DefaultConnectionManager(isFaultyConnection, isNotConnected);
        Exception e = assertThrows(ConnectionException.class, () -> {
           testCase.getConnection().execute("doMagic");
        });
        String expectedMessage = "Connection failed.";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.equals(expectedMessage));
    }

    static Arguments[] managers() {
        return new Arguments[]{
//      Будут возвращать псевдо-случайные значения:
//      new Random(7) - true, true, true, false
//      new Random(4) - true, true, true, true
            Arguments.of(new DefaultConnectionManager(new Random(7), new Random(4)), 1),
            Arguments.of(new DefaultConnectionManager(new Random(7), new Random(4)), 2),
            Arguments.of(new DefaultConnectionManager(new Random(7), new Random(4)), 3),
            Arguments.of(new FaultyConnectionManager(new Random(7)), 1),
            Arguments.of(new FaultyConnectionManager(new Random(7)), 2),
            Arguments.of(new FaultyConnectionManager(new Random(7)), 3)
        };
    }

    @ParameterizedTest
    @MethodSource("managers")
    void popularCommandExecutorTest(ConnectionManager testManager, int maxAttempts) {
        PopularCommandExecutor testCase = new PopularCommandExecutor(testManager, maxAttempts);
        Exception e = assertThrows(ConnectionException.class, () -> {
            testCase.tryExecute("doMagic");
        });
        String expectedMessage = "Number of attempts exceeded.";
        String actualMessage = e.getMessage();
        assertTrue(expectedMessage.equals(actualMessage));
    }
}
