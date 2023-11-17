package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import edu.hw6.task1.DiskMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {
    @Test
    void discMapStandardConstructorTest() throws IOException {
        DiskMap anotherTestDisc = new DiskMap();
        DiskMap testCase = new DiskMap();
        Path referent = Path.of("src", "main", "resources", "disk2.txt");
        assertTrue(Files.exists(referent));
    }

    @Test
    void diskMapStringConstructorExceptionTest() {
        String testCase = Path.of("src", "main", "resources", "test").toString();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            DiskMap testDiskMap = new DiskMap(testCase);
        });
        assertEquals("Incorrect format of Path.", e.getMessage());
    }

    @Test
    void diskMapExternalFileConstructorTest() throws IOException {
        Path testCase = Path.of("src", "main", "resources", "test.txt");
        Files.createFile(testCase);
        StringBuilder testContent = new StringBuilder();
        testContent.append("key1:value1\n")
            .append("key2:value2\n")
            .append("key3:value3");
        Files.writeString(testCase, testContent.toString());
        DiskMap testDiskMap = new DiskMap(testCase);
        Map<String, String> referent = new HashMap<>();
        referent.put("key1", "value1");
        referent.put("key2", "value2");
        referent.put("key3", "value3");
        Files.delete(testCase);
        assertEquals(referent, testDiskMap.getDiskMap());
    }

    @Test
    void diskMapStringConstructorFileNotFoundTest() throws IOException {
        Path testCase = Path.of("src", "main", "resources", "disk0.txt");
        boolean flagBeforeDiskMapConstructor = !Files.exists(testCase);
        DiskMap testDiskMap = new DiskMap(testCase.toString());
        boolean flagAfterDiskMapConstructor = Files.exists(testCase);
        assertTrue(flagBeforeDiskMapConstructor && flagAfterDiskMapConstructor);
    }

    @Test
    void diskMapPathConstructorFileNotFoundTest() throws IOException {
        Path testCase = Path.of("src", "main", "resources", "disk0.txt");
        boolean flagBeforeDiskMapConstructor = !Files.exists(testCase);
        DiskMap testDiskMap = new DiskMap(testCase);
        boolean flagAfterDiskMapConstructor = Files.exists(testCase);
        assertTrue(flagBeforeDiskMapConstructor && flagAfterDiskMapConstructor);
    }

    @Test
    void diskMapFileConstructorFileNotFoundTest() throws IOException {
        File testCase = Path.of("src", "main", "resources", "disk0.txt").toFile();
        boolean flagBeforeDiskMapConstructor = !testCase.exists();
        DiskMap testDiskMap = new DiskMap(testCase);
        boolean flagAfterDiskMapConstructor = testCase.exists();
        assertTrue(flagBeforeDiskMapConstructor && flagAfterDiskMapConstructor);
    }

    @Test
    void diskMapDeleteTest() throws IOException {
        DiskMap testCase = new DiskMap();
        Path referent = testCase.getPath();
        testCase.delete();
        assertFalse(Files.exists(referent));
    }

    @Test
    void overridedDiskMapMethodsFromMapTest() throws IOException {
        Map<String, String> testCase = new DiskMap();

        assertTrue(testCase.isEmpty());
        assertEquals(0, testCase.size());

        testCase.put("key1", "value1");
        testCase.put("key2", "value2");
        testCase.put("key3", "value3");

        assertFalse(testCase.isEmpty());
        assertEquals(3, testCase.size());

        assertTrue(testCase.containsKey("key3"));
        assertFalse(testCase.containsKey("key4"));

        assertTrue(testCase.containsValue("value3"));
        assertFalse(testCase.containsValue("value4"));

        assertEquals("value2", testCase.get("key2"));
        assertEquals(null, testCase.get("key4"));

        testCase.put("key4", "value4");
        assertTrue(testCase.containsKey("key4")
            && testCase.containsValue("value4") && testCase.get("key4").equals("value4")
        );

        testCase.remove("key4");
        assertFalse(testCase.containsKey("key4")
            && testCase.containsValue("value4") && testCase.get("key4").equals("value4")
        );

        Map<String, String> mapToPut = new HashMap<>();
        mapToPut.put("key5", "value5");
        mapToPut.put("key6", "value6");
        mapToPut.put("key7", "value7");
        testCase.putAll(mapToPut);
        Map<String, String> referent = new HashMap<>();
        referent.put("key1", "value1");
        referent.put("key2", "value2");
        referent.put("key3", "value3");
        referent.put("key5", "value5");
        referent.put("key6", "value6");
        referent.put("key7", "value7");
        assertEquals(referent, testCase);

        testCase.clear();
        assertTrue(testCase.isEmpty());

        testCase.putAll(referent);
        Set<String> referentSet = new HashSet<>();
        List<String> tempSet = new LinkedList<>();
        Collections.addAll(tempSet, "key1", "key2", "key3", "key5", "key6", "key7");
        referentSet.addAll(tempSet);
        assertEquals(referentSet, testCase.keySet());

        List<String> referentValues = new LinkedList<>();
        Collections.addAll(referentValues, "value1", "value2", "value3", "value5", "value6", "value7");
        assertEquals(referentValues, testCase.values().stream().sorted().toList());

        Set<Map.Entry<String, String>> referentEntrySet = referent.entrySet();
        assertEquals(referentEntrySet, testCase.entrySet());
    }

    @AfterEach
    public void deleteDisks() throws IOException {
        Path path = Path.of("src", "main", "resources");
        Files.list(path).filter(tempPath -> tempPath.getFileName().toString().matches("^disk\\d+.txt$")).forEach(tempPath -> {
            try {
                Files.delete(tempPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
