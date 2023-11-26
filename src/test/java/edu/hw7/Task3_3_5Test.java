package edu.hw7;

import edu.hw7.task3_3_5.Person;
import edu.hw7.task3_3_5.PersonDatabase;
import edu.hw7.task3_3_5.ReadWriteLockDatabase;
import edu.hw7.task3_3_5.SynchronizedDatabase;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3_3_5Test {
    private static Stream<PersonDatabase> provideArgumentsForTask3_3_3_5Test() {
        return Stream.of(new SynchronizedDatabase(), new ReadWriteLockDatabase());
    }

    private static Thread getAddTestThread(PersonDatabase testDatabase, Person person) {
        return new Thread(() -> {
           testDatabase.add(person);
        });
    }

    private static Thread getDeleteTestThread(PersonDatabase testDatabase, int id) {
        return new Thread(() -> {
            testDatabase.delete(id);
        });
    }

    private static Thread getFindByNameTestThread(PersonDatabase testDatabase, List<Person> listName, String name) {
        return new Thread(() -> {
            listName.addAll(testDatabase.findByName(name));
        });
    }

    private static Thread getFindByAddressTestThread(PersonDatabase testDatabase, List<Person> listAddress,
        String address) {
        return new Thread(() -> {
            listAddress.addAll(testDatabase.findByAddress(address));
        });
    }

    private static Thread getFindByPhoneTestThread(PersonDatabase testDatabase, List<Person> listPhone, String phone) {
        return new Thread(() -> {
            listPhone.addAll(testDatabase.findByPhone(phone));
        });
    }

    @DisplayName("Database add values test.")
    @ParameterizedTest
    @MethodSource("provideArgumentsForTask3_3_3_5Test")
    void addTest(PersonDatabase test) {
        Map<Integer, Person> idMapReferent = Map.of(
            1, new Person(1, "name1", "address1", "phoneNumber1"),
            2, new Person(2, "name2", "address2", "phoneNumber2"),
            3, new Person(3, "name3", "address3", "phoneNumber3"),
            4, new Person(4, "name4", "address4", "phoneNumber4")
        );
        Map<String, Person> nameMapReferent = Map.of(
            "name1", new Person(1, "name1", "address1", "phoneNumber1"),
            "name2", new Person(2, "name2", "address2", "phoneNumber2"),
            "name3", new Person(3, "name3", "address3", "phoneNumber3"),
            "name4", new Person(4, "name4", "address4", "phoneNumber4")
        );
        Map<String, Person> addressMapReferent = Map.of(
            "address1", new Person(1, "name1", "address1", "phoneNumber1"),
            "address2", new Person(2, "name2", "address2", "phoneNumber2"),
            "address3", new Person(3, "name3", "address3", "phoneNumber3"),
            "address4", new Person(4, "name4", "address4", "phoneNumber4")
        );
        Map<String, Person> phoneMapReferent = Map.of(
            "phoneNumber1", new Person(1, "name1", "address1", "phoneNumber1"),
            "phoneNumber2", new Person(2, "name2", "address2", "phoneNumber2"),
            "phoneNumber3", new Person(3, "name3", "address3", "phoneNumber3"),
            "phoneNumber4", new Person(4, "name4", "address4", "phoneNumber4")
        );
        Thread[] testThreads = new Thread[4];
        for (int i = 0; i < 4; i++) {
            testThreads[i] = getAddTestThread(test, new Person(
                i + 1,
                "name" + (i + 1),
                "address" + (i + 1),
                "phoneNumber" + (i + 1)
            ));
        }
        for(Thread thread: testThreads) {
            thread.start();
        }
        try {
            for(Thread thread: testThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(idMapReferent, test.getIdMap());
        assertEquals(nameMapReferent, test.getNameMap());
        assertEquals(addressMapReferent, test.getAddressMap());
        assertEquals(phoneMapReferent, test.getPhoneMap());
    }

    @DisplayName("Database delete values test.")
    @ParameterizedTest
    @MethodSource("provideArgumentsForTask3_3_3_5Test")
    void deleteTest(PersonDatabase test) {
        for (int i = 0; i < 4; i++) {
            test.add(new Person(
                i + 1,
                "name" + (i + 1),
                "address" + (i + 1),
                "phoneNumber" + (i + 1)
            ));
        }
        Thread[] testThreads = new Thread[4];
        for (int i = 0; i < 4; i++) {
            testThreads[i] = getDeleteTestThread(test, i + 1);
        }
        for(Thread thread: testThreads) {
            thread.start();
        }
        try {
            for(Thread thread: testThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(test.getIdMap().isEmpty());
        assertTrue(test.getNameMap().isEmpty());
        assertTrue(test.getAddressMap().isEmpty());
        assertTrue(test.getPhoneMap().isEmpty());
    }

    @DisplayName("Database find by name test.")
    @ParameterizedTest
    @MethodSource("provideArgumentsForTask3_3_3_5Test")
    void findByNameTest(PersonDatabase test) {
        List<Person> referent = List.of(
            new Person(1, "name1", "address1","phoneNumber1"),
            new Person(2, "name2", "address2", "phoneNumber2"),
            new Person(3, "name3", "address3", "phoneNumber3"),
            new Person(4, "name4", "address4", "phoneNumber4")
        );
        List<Person> listName = new Vector<>();
        for (int i = 0; i < 4; i++) {
            test.add(new Person(
                i + 1,
                "name" + (i + 1),
                "address" + (i + 1),
                "phoneNumber" + (i + 1)
            ));
        }
        Thread[] testThreads = new Thread[4];
        for (int i = 0; i < 4; i++) {
            testThreads[i] = getFindByNameTestThread(test, listName, "name" + (i + 1));
        }
        for (Thread thread: testThreads) {
            thread.start();
        }
        try {
            for(Thread thread: testThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Comparator<Person> idCmp = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.id(), o2.id());
            }
        };
        assertEquals(referent.stream().sorted(idCmp).toList(), listName.stream().sorted(idCmp).toList());
    }

    @DisplayName("Database find by address test.")
    @ParameterizedTest
    @MethodSource("provideArgumentsForTask3_3_3_5Test")
    void findByAddressTest(PersonDatabase test) {
        List<Person> referent = List.of(
            new Person(1, "name1", "address1","phoneNumber1"),
            new Person(2, "name2", "address2", "phoneNumber2"),
            new Person(3, "name3", "address3", "phoneNumber3"),
            new Person(4, "name4", "address4", "phoneNumber4")
        );
        List<Person> listAddress = new Vector<>();
        for (int i = 0; i < 4; i++) {
            test.add(new Person(
                i + 1,
                "name" + (i + 1),
                "address" + (i + 1),
                "phoneNumber" + (i + 1)
            ));
        }
        Thread[] testThreads = new Thread[4];
        for (int i = 0; i < 4; i++) {
            testThreads[i] = getFindByAddressTestThread(test, listAddress, "address" + (i + 1));
        }
        for (Thread thread: testThreads) {
            thread.start();
        }
        try {
            for (Thread thread: testThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Comparator<Person> idCmp = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.id(), o2.id());
            }
        };
        assertEquals(referent.stream().sorted(idCmp).toList(), listAddress.stream().sorted(idCmp).toList());
    }

    @DisplayName("Synchronized database find by phone number test.")
    @ParameterizedTest
    @MethodSource("provideArgumentsForTask3_3_3_5Test")
    void findByPhoneNumberTest(PersonDatabase test) {
        List<Person> referent = List.of(
            new Person(1, "name1", "address1","phoneNumber1"),
            new Person(2, "name2", "address2", "phoneNumber2"),
            new Person(3, "name3", "address3", "phoneNumber3"),
            new Person(4, "name4", "address4", "phoneNumber4")
        );
        List<Person> listPhones = new Vector<>();
        test.add(new Person(1, "name1", "address1","phoneNumber1"));
        test.add(new Person(2, "name2", "address2", "phoneNumber2"));
        test.add(new Person(3, "name3", "address3", "phoneNumber3"));
        test.add(new Person(4, "name4", "address4", "phoneNumber4"));
        Thread treadPhoneNumber1 = getFindByPhoneTestThread(test, listPhones, "phoneNumber1");
        Thread treadPhoneNumber2 = getFindByPhoneTestThread(test, listPhones, "phoneNumber2");
        Thread treadPhoneNumber3 = getFindByPhoneTestThread(test, listPhones, "phoneNumber3");
        Thread treadPhoneNumber4 = getFindByPhoneTestThread(test, listPhones, "phoneNumber4");
        treadPhoneNumber1.start();
        treadPhoneNumber2.start();
        treadPhoneNumber3.start();
        treadPhoneNumber4.start();
        try {
            treadPhoneNumber1.join();
            treadPhoneNumber2.join();
            treadPhoneNumber3.join();
            treadPhoneNumber4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Comparator<Person> idCmp = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.id(), o2.id());
            }
        };
        assertEquals(referent.stream().sorted(idCmp).toList(), listPhones.stream().sorted(idCmp).toList());
    }
}
