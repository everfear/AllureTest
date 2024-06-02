import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureReportStepsTest {

    private static final String REPO = "eroshenkoam/allure-example";
    private static final int ISSUENUM = 89;

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий" + REPO, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys(REPO);
            $("#query-builder-test").submit();
        });

        step("Кликаем по ссылке репозитория" + REPO, () -> {
            $(linkText(REPO)).click();
        });

        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие Issue с номером" + ISSUENUM, () -> {
            $(withText("#" + ISSUENUM)).should(Condition.exist);
        });

        closeWebDriver();
    }

    @Test
    public void testAnnotatedStep() {
        AllureReportWebStepsTest steps = new AllureReportWebStepsTest();

        steps.openMainPage();
        steps.searchForRepo(REPO);
        steps.clickOnRepoLink(REPO);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUENUM);
    }
}