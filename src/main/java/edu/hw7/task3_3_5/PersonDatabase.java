package edu.hw7.task3_3_5;

import java.util.List;
import java.util.Map;

public interface PersonDatabase {
    void add(Person person);

    void delete(int id);

    List<Person> findByName(String name);

    List<Person> findByAddress(String address);

    List<Person> findByPhone(String phone);

    Map<Integer, Person> getIdMap();

    Map<String, Person> getNameMap();

    Map<String, Person> getAddressMap();

    Map<String, Person> getPhoneMap();
}
