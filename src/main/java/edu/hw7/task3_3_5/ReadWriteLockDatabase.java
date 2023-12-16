package edu.hw7.task3_3_5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDatabase implements PersonDatabase {
    private final Map<Integer, Person> idMap = new HashMap<>();

    private final Map<String, Person> nameMap = new HashMap<>();

    private final Map<String, Person> addressMap = new HashMap<>();

    private final Map<String, Person> phoneMap = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public ReadWriteLockDatabase() {}

    @Override
    public void add(Person person) {
        readWriteLock.writeLock().lock();
        idMap.put(person.id(), person);
        nameMap.put(person.name(), person);
        addressMap.put(person.address(), person);
        phoneMap.put(person.phoneNumber(), person);
        readWriteLock.writeLock().unlock();
    }

    @Override
    public void delete(int id) {
        readWriteLock.writeLock().lock();
        Person person = idMap.remove(id);
        if (person != null) {
            nameMap.remove(person.name());
            addressMap.remove(person.address());
            phoneMap.remove(person.phoneNumber());
        }
        readWriteLock.writeLock().unlock();
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        readWriteLock.readLock().lock();
        try {
            return nameMap.entrySet().stream()
                .filter(stringPersonEntry -> stringPersonEntry.getKey().equals(name))
                .map(Map.Entry::getValue)
                .toList();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        readWriteLock.readLock().lock();
        try {
            return addressMap.entrySet().stream()
                .filter(stringPersonEntry -> stringPersonEntry.getKey().equals(address))
                .map(Map.Entry::getValue)
                .toList();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        readWriteLock.readLock().lock();
        try {
            return phoneMap.entrySet().stream()
                .filter(e -> e.getKey().equals(phone))
                .map(Map.Entry::getValue)
                .toList();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public Map<Integer, Person> getIdMap() {
        return idMap;
    }

    public Map<String, Person> getNameMap() {
        return nameMap;
    }

    public Map<String, Person> getAddressMap() {
        return addressMap;
    }

    public Map<String, Person> getPhoneMap() {
        return phoneMap;
    }
}
