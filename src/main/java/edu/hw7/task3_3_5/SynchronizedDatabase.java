package edu.hw7.task3_3_5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynchronizedDatabase implements PersonDatabase {
    private final Map<Integer, Person> idMap = new HashMap<>();

    private final Map<String, Person> nameMap = new HashMap<>();

    private final Map<String, Person> addressMap = new HashMap<>();

    private final Map<String, Person> phoneMap = new HashMap<>();

    public SynchronizedDatabase() {}

    @Override
    public synchronized void add(Person person) {
        idMap.put(person.id(), person);
        nameMap.put(person.name(), person);
        addressMap.put(person.address(), person);
        phoneMap.put(person.phoneNumber(), person);
    }

    @Override
    public synchronized void delete(int id) {
        Person person = idMap.remove(id);
        if (person != null) {
            nameMap.remove(person.name());
            addressMap.remove(person.address());
            phoneMap.remove(person.phoneNumber());
        }
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        return nameMap.entrySet().stream()
            .filter(stringPersonEntry -> stringPersonEntry.getKey().equals(name))
            .map(Map.Entry::getValue)
            .toList();
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return addressMap.entrySet().stream()
            .filter(stringPersonEntry -> stringPersonEntry.getKey().equals(address))
            .map(Map.Entry::getValue)
            .toList();
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        return phoneMap.entrySet().stream()
            .filter(e -> e.getKey().equals(phone))
            .map(Map.Entry::getValue)
            .toList();
    }

    @Override
    public Map<Integer, Person> getIdMap() {
        return idMap;
    }

    @Override
    public Map<String, Person> getNameMap() {
        return nameMap;
    }

    @Override
    public Map<String, Person> getAddressMap() {
        return addressMap;
    }

    @Override
    public Map<String, Person> getPhoneMap() {
        return phoneMap;
    }
}
