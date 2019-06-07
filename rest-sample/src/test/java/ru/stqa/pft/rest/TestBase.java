package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;

import java.util.Set;

public class TestBase {

    public Issue issueById(int issueId) {
        String json = RestAssured.get(String.format("http://bugify.stqa.ru/api/issues/%s.json", issueId)).asString();
        JsonElement issues = new JsonParser().parse(json).getAsJsonObject().get("issues");
        Set<Issue> issuesSet = new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {}.getType());
        Issue issue = issuesSet.iterator().next();
        return issue;
    }

    public boolean isIssueOpen (int issueID)  {
        Issue myIssue = issueById(issueID);
        String status = myIssue.getState_name();
        if (status.equals("Deleted") || status.equals("Closed")) {
            return false;
        } else {
            return true;
        }
    }

    public void skipIfNotFixed(int issueId)  {
        if (isIssueOpen(issueId)) {
            System.out.println("Ignored because of unresolved issue " + issueId + " in Bugify bugtracker");
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }
}
