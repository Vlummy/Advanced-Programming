package friend_app.friend;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Class Person: Represents a human person
 * Author: Roy H. Jenssen, Øyvind Johannessen
 * Version: 1.0
 */
public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birth;
    private char gender;

    /**
     * Default constructor for Person class
     */
    public Person() {}

    /**
     * Constructor for Person class which instantiates a new person with fields set
     * @param firstName
     * @param lastName
     * @param birthYear
     * @param birthMonth
     * @param birthDay
     * @param gender
     */
    public Person(String firstName, String lastName, Integer birthYear, Integer birthMonth, Integer birthDay, char gender) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirth(birthYear, birthMonth, birthDay);
        setGender(gender);

    }

    /**
     * Return this persons first name
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set's the first name of this person
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of this person
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set's the last name of this person
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the birth of this person
     * @return birth
     */
    public LocalDate getBirth() {
        return birth;
    }

    /**
     * Set's the birth to this Person
     * @param birthYear
     * @param birthMonth
     * @param birthDay
     */
    public void setBirth(Integer birthYear, Integer birthMonth, Integer birthDay) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = "";
        if(birthMonth < 10 && birthDay < 10) {
            date = birthYear + "-0" + birthMonth + "-0" + birthDay;
        } else if (birthMonth < 10) {
            date = birthYear + "-0" + birthMonth + "-" + birthDay;
        } else if(birthDay < 10) {
            date = birthYear + "-" + birthMonth + "-0" + birthDay;
        } else {
            date = birthYear + "-" + birthMonth + "-" + birthDay;
        }
        LocalDate birth = LocalDate.parse(date, formatter);
        this.birth = birth;
    }

    /**
     *
     * Calculates the age by using this persons birth and returns an Integer representing the age in years
     * If birth is not set before using this method a NullPointerException will be thrown
     * @return age
     */
    public Integer getAge() {
        if(getBirth() == null)
            throw new NullPointerException("This person's birth has to be set to calculate the age");
        LocalDate currentdate = LocalDate.now();
        Period difference = Period.between(getBirth(), currentdate);
        return difference.getYears();
    }

    /**
     * Returns the gender of this person
     * @return
     */
    public char getGender() {
        return gender;
    }

    /**
     * Set's the gender of this person
     * @param gender
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return getLastName();
    }
}
