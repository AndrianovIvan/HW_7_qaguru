package ivanandrianv90;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FormTestDemoqaTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void FillFormTests() {
        Selenide.open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Andrianov");
        $("#userEmail").setValue("Ivanandrianv90@gmail.com");
        $("#genterWrapper").find(byText("Male")).click();
        $("#userNumber").setValue("9106756912");
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--027").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $("#hobbiesWrapper").find(byText("Sports")).click();
        $("#hobbiesWrapper").find(byText("Music")).click();
        $("#state").click();
        $("#stateCity-wrapper").find(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").find(byText("Noida")).click();
        $("#currentAddress").setValue("Example street, 13");
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#submit").click();

        //проверка
        $(".modal-content").shouldHave(text("Ivan Andrianov"));
        $(".modal-content").shouldHave(text("Ivanandrianv90@gmail.com"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("9106756912"));
        $(".modal-content").shouldHave(text("27 January,1992"));
        $(".modal-content").shouldHave(text("Computer Science, Economics"));
        $(".modal-content").shouldHave(text("Sports, Music"));
        $(".modal-content").shouldHave(text("test.jpg"));
        $(".modal-content").shouldHave(text("Example street, 13"));
        $(".modal-content").shouldHave(text("NCR Noida"));

    }
}
