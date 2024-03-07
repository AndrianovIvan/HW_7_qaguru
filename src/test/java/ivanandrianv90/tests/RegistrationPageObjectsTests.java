package ivanandrianv90.tests;

import ivanandrianv90.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFullFormTest() {
        registrationPage.openPage()
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setEmail("useremail@value.com")
                .setGender("Female")
                .setUserNumber("9183214567")
                .setDateOfBirth("30", "July", "2008")
                .setSubjects("mat")
                .setHobbies("Music")
                .setHobbies("Sports")
                .uploadPicture("test.jpg")
                .setCurrentAddress("CurrentAddressValue")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .submitBtnClick();

        registrationPage.checkResult("Student Name", "FirstName LastName")
                .checkResult("Student Email", "useremail@value.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9183214567")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Music, Sports")
                .checkResult("Picture", "1.jpeg")
                .checkResult("Address", "CurrentAddressValue")
                .checkResult("State and City", "Rajasthan Jaipur");
    }

    @Test
    void fillOnlyRequiredFieldsFormTest() {
        registrationPage.openPage()
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setGender("Female")
                .setUserNumber("9183214567")
                .setDateOfBirth("30", "July", "2008")
                .submitBtnClick();

        registrationPage.checkResult("Student Name", "FirstName LastName")
                .checkResult("Student Email", "\t")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9183214567")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "\t")
                .checkResult("Hobbies", "\t")
                .checkResult("Picture", "\t")
                .checkResult("Address", "\t")
                .checkResult("State and City", "\t")
                .registrationSuccessCheck();
    }

    @Test
    void allFieldsAreEmptyTest() {
        registrationPage.openPage()
                .submitBtnClick();

        registrationPage.registrationFailureCheck();

    }

    @Test
    void phone9DigitsTest() {
        registrationPage.openPage()
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setGender("Female")
                .setUserNumber("123456789")
                .submitBtnClick();

        registrationPage.registrationFailureCheck();

    }
}
