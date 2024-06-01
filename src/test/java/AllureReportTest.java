import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class AllureReportTest {

    @Test
    public void testIssueSearch(){
        open("https://github.com");

        $(".header-search-button").click();
        $(".header-search-button").sendKeys("eroshenkoam/allure-example");
        $(".header-search-button").submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("89")).should(Condition.exist);

        closeWebDriver();

    }
}
