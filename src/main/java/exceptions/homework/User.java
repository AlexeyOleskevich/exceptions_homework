package exceptions.homework;

import exceptions.homework.exception.WrongDataAmountException;
import exceptions.homework.exception.WrongDataTypeException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class User {
    private String name;
    private String surName;
    private String patronymic;
    private LocalDate birthDate;
    private int phoneNumber;
    private char gender;
    static final int REQUIRED_DATA_LENGTH = 6;

    private User(String name, String surName, String patronymic,
                LocalDate birthDate, int phoneNumber, char gender) {
        this.name = name;
        this.surName = surName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public static User createUser(String input) {
        try {
            validateDataAmount(input);
            validateDataTypes(input);
        } catch (WrongDataAmountException e) {
            System.out.println("Количество данных: " + e.getDataLength());
        } catch (WrongDataTypeException e) {
            System.out.println("Неверный формат: " + e.getDataName());
        }
        String[] parsedData = input.split(" ");
        String name = parsedData[0];
        String surName = parsedData[1];
        String patronymic = parsedData[2];
        LocalDate birth = LocalDate.parse(parsedData[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        int phone = Integer.parseInt(parsedData[4]);
        char gender = parsedData[5].charAt(0);
        return new User(name, surName, patronymic, birth, phone, gender);

    }

    static void validateDataAmount(String data) {
        String[] parsedData = data.split(" ");
        int dataLength = parsedData.length;

        if (dataLength > REQUIRED_DATA_LENGTH) {
            throw new WrongDataAmountException("Вы ввели больше данных, чем требуется!", dataLength);
        }
        if (dataLength < REQUIRED_DATA_LENGTH) {
            throw new WrongDataAmountException("Вы ввели меньше данных, чем требуется!", dataLength);
        }
    }

    static void validateDataTypes(String data) {
        String[] parsedData = data.split(" ");
        String name = parsedData[0];
        if (!name.chars().allMatch(Character::isLetter)) {
            throw new WrongDataTypeException("Неверный формат данных!", "Имя");
        }
        String surName = parsedData[1];
        if (!surName.chars().allMatch(Character::isLetter)) {
            throw new WrongDataTypeException("Неверный формат данных!", "Фамилия");
        }
        String patronymic = parsedData[2];
        if (!patronymic.chars().allMatch(Character::isLetter)) {
            throw new WrongDataTypeException("Неверный формат данных!", "Отчество");
        }
        try {
            LocalDate birth = LocalDate.parse(parsedData[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new WrongDataTypeException("Неверный формат данных!", "Дата рождения");
        }
        String phoneNumber = parsedData[4];
        try {
            int number = Integer.parseInt(phoneNumber);
        } catch (NumberFormatException e) {
            throw new WrongDataTypeException("Неверный формат данных!", "Номер телефона");
        }
        String gender = parsedData[5];
        if (!(gender.length() == 1) || (!gender.equals("f") && !gender.equals("m"))) {
            throw new WrongDataTypeException("Неверный формат данных!", "Пол");
        }
    }
}
