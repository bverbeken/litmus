package controllers;

import litmus.engine.Tests;
import play.Logger;
import play.mvc.Controller;
import play.test.TestEngine;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static play.Play.getFile;
import static play.libs.IO.writeContent;
import static play.templates.TemplateLoader.load;
import static play.test.TestEngine.TestResults;


@SuppressWarnings({"UnusedDeclaration", "ConstantConditions"})
public class LitmusTestRunner extends Controller {

    public static void testList() {
        Tests tests = new Tests();
        render(tests);
    }

    public static void init() {
        File testResults = getFile("test-result");
        if (!testResults.exists()) {
            testResults.mkdir();
        }
        for (File tr : testResults.listFiles()) {
            if ((tr.getName().endsWith(".html") || tr.getName().startsWith("result.")) && !tr.delete()) {
                Logger.warn("Cannot delete %s ...", tr.getAbsolutePath());
            }
        }
        renderText("done");
    }

    public static void end() {
        File testResults = getFile("test-result/result." + params.get("result"));
        writeContent(params.get("result"), testResults);
        renderText("done");
    }

    public static void run(String test) {
        getFile("test-result").mkdir();
        TestResults results = TestEngine.run(test.substring(0, test.length() - 6));
        Map<String, Object> options = makeOptions(test, results);
        String result = load("LitmusTestRunner/results.html").render(options);
        File resultsFile = getFile("test-result/" + test + (results.passed ? ".passed" : ".failed") + ".html");
        writeContent(result, resultsFile);
        writeXmlOutput(options);
        response.status = results.passed ? 200 : 500;
        response.contentType = "text/html";
        renderText(result);
    }

    private static Map<String, Object> makeOptions(String test, TestResults results) {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("test", test);
        options.put("results", results);
        return options;
    }

    private static void writeXmlOutput(Map<String, Object> options) {
        try {
            options.remove("out");
            String test = options.get("test").toString();
            String resultXunit = load("LitmusTestRunner/results-xunit.xml").render(options);
            File testXunitResults = getFile("test-result/TEST-" + test.substring(0, test.length() - 6) + ".xml");
            writeContent(resultXunit, testXunitResults);
        } catch (Exception e) {
            Logger.error(e, "Cannot output XML unit output");
        }
    }


}
