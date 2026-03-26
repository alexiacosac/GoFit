package com.gofit.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;


    private String firstName;
    private String lastName;

    private double height;
    private double weight;

    private LocalDate birthDate; // 🔥 folosim asta


    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String activityLevel;
    private String goal;

    private String role;

    // constructor gol (obligatoriu)
    public User() {}

    // constructor corect (fără age)
    public User(Long id, String email, String password, String role,
                double height, double weight, LocalDate birthDate,
                String activityLevel, String goal) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.height = height;
        this.weight = weight;
        this.birthDate = birthDate;
        this.activityLevel = activityLevel;
        this.goal = goal;
    }

    // getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getDailyCalories() {
        // 1. Calculăm vârsta
        int age = java.time.Period.between(this.birthDate, java.time.LocalDate.now()).getYears();

        // 2. Calculăm BMR (Mifflin-St Jeor)
        double bmr;
        if ("MALE".equals(this.gender.name())) {
            bmr = 10 * this.weight + 6.25 * this.height - 5 * age + 5;
        } else {
            bmr = 10 * this.weight + 6.25 * this.height - 5 * age - 161;
        }

        // 3. Multiplicator activitate (exact logică din UserController)
        double activityMultiplier = switch (this.activityLevel) {
            case "SEDENTARY" -> 1.2;
            case "LIGHT"     -> 1.375;
            case "MODERATE"  -> 1.55;
            case "ACTIVE"    -> 1.725;
            case "ATHLETE"   -> 1.9;
            default          -> 1.4;
        };

        int maintenance = (int) (bmr * activityMultiplier);

        // 4. Ajustare după obiectiv (Goal)
        return switch (this.goal) {
            case "LOSE_WEIGHT"   -> maintenance - 500;
            case "GAIN_WEIGHT"   -> maintenance + 500;
            case "BUILD_MUSCLE"  -> maintenance + 300;
            default              -> maintenance;
        };
    }
}