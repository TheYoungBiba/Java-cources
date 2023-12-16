package edu.hw6.task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Comparator;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("MultiplestringLiterals")
public class DiskMap implements Map<String, String> {
    private final String colon = ":";
    private static int diskNameCounter = 1;
    private Path disk;
    private Map<String, String> diskMap;

    @SuppressWarnings("HiddenField")
    public DiskMap() throws IOException {
        String discName = "disk" + diskNameCounter + ".txt";
        Path disk = Path.of("src", "main", "resources", discName);
        if (Files.exists(disk)) {
            final int shiftToDiscNumber = 5;
            diskNameCounter = Files.list(disk.getParent())
                .filter(path -> path.getFileName().toString().matches("^disk\\d+.txt$"))
                .map(path -> {
                    String fileName = path.getFileName().toString();
                    Character charNumber = fileName.charAt(fileName.length() - shiftToDiscNumber);
                    return Integer.parseInt(charNumber.toString());
                })
                .max(Comparator.comparingInt(Integer::intValue))
                .get() + 1;
            discName = "disk" + diskNameCounter + ".txt";
        }
        this.disk = Path.of("src", "main", "resources", discName);
        Files.createFile(this.disk);
        loadDisk();
        diskNameCounter++;
    }

    public DiskMap(String path) throws IOException {
        if (!path.endsWith(".txt")) {
            throw new IllegalArgumentException("Incorrect format of Path.");
        }
        this.disk = Path.of(path);
        if (!Files.exists(disk)) {
            Files.createFile(disk);
        }
        loadDisk();
    }

    public DiskMap(Path path) throws IOException {
        this.disk = path;
        if (!Files.exists(disk)) {
            Files.createFile(disk);
        }
        loadDisk();
    }

    public DiskMap(File disk) throws IOException {
        if (!disk.exists()) {
            disk.createNewFile();
        }
        this.disk = disk.toPath();
        loadDisk();
    }

    private boolean isValidData(List<String> listOfEntry) {
        return listOfEntry.stream().allMatch(string -> string.matches(".+:.+"));
    }

    private void loadDisk() throws IOException {
        List<String> listOfEntry = Files.readAllLines(disk);
        if (!isValidData(listOfEntry)) {
            throw new InvalidPropertiesFormatException("Disc contains invalid record");
        }
        diskMap = listOfEntry
            .stream()
            .map(string -> string.split(colon))
            .collect(Collectors.toMap(strings -> strings[0], strings -> strings[1]));
    }

    private void saveDiskMap() throws IOException {
        StringBuilder tempDiskContainer = new StringBuilder();
        diskMap.entrySet().stream()
            .map(stringStringEntry -> stringStringEntry.getKey() + colon + stringStringEntry.getValue())
            .forEach(tempDiskContainer::append);
        Files.writeString(disk, tempDiskContainer.toString());
    }

    public void delete() throws IOException {
        Files.delete(disk);
    }

    public Path getPath() {
        return disk;
    }

    public Map<String, String> getDiskMap() {
        return diskMap;
    }

    @Override
    public int size() {
        return diskMap.size();
    }

    @Override
    public boolean isEmpty() {
        return diskMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return diskMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return diskMap.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return diskMap.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        try {
            String ret = diskMap.put(key, value);
            saveDiskMap();
            return ret;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String remove(Object key) {
        try {
            String ret = diskMap.remove(key);
            saveDiskMap();
            return ret;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        try {
            diskMap.putAll(m);
            saveDiskMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void clear() {
        try {
            Files.writeString(disk, "");
            diskMap.clear();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return diskMap.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return diskMap.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return diskMap.entrySet();
    }
}
