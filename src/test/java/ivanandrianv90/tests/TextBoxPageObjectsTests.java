package ivanandrianv90.tests;

import ivanandrianv90.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxPageObjectsTests {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFullFormTest() {
        textBoxPage.openPage()
                .setFullName("TestFullName")
                .setEmailInput("Test@Email.com")
                .setCurrentAddressInput("TestCurrentAddress")
                .setPermanentAddressInput("TestPermanentAddress")
                .submitBtnClick();

        textBoxPage.nameCheck("TestFullName")
                .emailCheck("Test@Email.com")
                .currentAddressCheck("TestCurrentAddress")
                .permanentAddressCheck("TestPermanentAddress");
    }
}
