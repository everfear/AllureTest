import modelStepTest.modelStepTest;
import org.junit.jupiter.api.Test;


public class StepTest{

    @Test
    public void testWebStep() {
        modelStepTest steps = new modelStepTest();

        steps.openMainPage();
        steps.searchForRepo(steps.getRepo());
        steps.clickOnRepoLink(steps.getRepo());
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(steps.getIssuenum());
    }
}