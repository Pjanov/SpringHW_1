package ru.pjanov;

public class Main {
    static final String FILE_NAME = "person.json";

    public static void main(String[] args) {

        Person person = new Person("Andrey", "Pyanov", 39);

        person.serializeToJsonFile(FILE_NAME);
        Person deserializedPerson = person.deserializeFromJsonFile(FILE_NAME);
        person.printPersonDetails(deserializedPerson);
    }
}
