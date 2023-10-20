package edu.hw2;

import edu.hw2.task3.ConnectionException;
import edu.hw2.task3.ConnectionManager;
import edu.hw2.task3.DefaultConnectionManager;
import edu.hw2.task3.PopularCommandExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Random;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;


public class Task3Test {
//    @ParameterizedTest
//    @ArgumentsSource(ConnectionManagerProvider.class)
//    void PopularCommandExecutorTest(ConnectionManager manager, int maxAttempts) {
//        PopularCommandExecutor testCase = new PopularCommandExecutor(manager, maxAttempts);
//        ConnectionException thrown = Assertions.assertThrows(ConnectionException.class, () -> {testCase.updatePackages();
//        });
//        Assertions.assertEquals("Connection failed.", thrown.getMessage());
//    }
//
//    class ConnectionManagerProvider implements ArgumentsProvider {
//        @Override
//        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
//            return Stream.of(
//                Arguments.of(new DefaultConnectionManager(new Random(7), new Random(4)), 3)
//            );
//        }
//    }



//    @ParameterizedTest
//    @ValueSource(ints = {3, 4})
//    void DefaultConnectionManagerTest(int argument) {
//        Random isFaultyConnection = new Random(7);
//        Random isNotConnected = new Random(4);
//        DefaultConnectionManager defaultConnectionManager = new DefaultConnectionManager(isFaultyConnection, isNotConnected);
//        PopularCommandExecutor testCase = new PopularCommandExecutor(defaultConnectionManager, argument);
//        ConnectionException thrown = Assertions.assertThrows(ConnectionException.class, () -> {testCase.updatePackages();
//        });
//        Assertions.assertEquals("Connection failed.", thrown.getMessage());
//    }



}
