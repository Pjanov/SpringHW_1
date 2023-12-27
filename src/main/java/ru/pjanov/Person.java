package ru.pjanov;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.*;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * Сериализует объект Person в JSON и записывает в файл
     *
     * @param fileName имя файла для записи JSON
     */
    public void serializeToJsonFile(String fileName) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(this, writer);
            System.out.println("Объект Person успешно сериализован в файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Десериализует объект Person из JSON файла
     *
     * @param fileName имя файла для чтения JSON
     * @return объект Person, представленный в JSON файле
     */
    public Person deserializeFromJsonFile(String fileName) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, Person.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Метод для вывода всех полей объекта Person.
     *
     * @param person объект Person, поля которого нужно вывести
     */
    public void printPersonDetails(Person person) {
        System.out.println("Имя студента: " + person.firstName);
        System.out.println("Фамилия студента: " + person.lastName);
        System.out.println("Возраст студента: " + person.age);
    }
}

