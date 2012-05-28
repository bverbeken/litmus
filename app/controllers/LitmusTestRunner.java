package controllers;

import litmus.engine.Tests;
import play.Logger;
import play.Play;
import play.libs.IO;
import play.mvc.Controller;
import play.templates.Template;
import play.templates.TemplateLoader;
import play.test.TestEngine;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class LitmusTestRunner extends Controller {

    public static void testList(){
        Tests tests = new Tests();
        render(tests);
    }

    public static void run(String test) throws Exception {
        if (test.equals("init")) {
            File testResults = Play.getFile("test-result");
            if (!testResults.exists()) {
                testResults.mkdir();
            }
            for(File tr : testResults.listFiles()) {
                if ((tr.getName().endsWith(".html") || tr.getName().startsWith("result.")) && !tr.delete()) {
                    Logger.warn("Cannot delete %s ...", tr.getAbsolutePath());
                }
            }
            renderText("done");
        }
        if (test.equals("end")) {
            File testResults = Play.getFile("test-result/result." + params.get("result"));
            IO.writeContent(params.get("result"), testResults);
            renderText("done");
        }
        if (test.endsWith(".class")) {
            Play.getFile("test-result").mkdir();
            TestEngine.TestResults results = TestEngine.run(test.substring(0, test.length() - 6));
            response.status = results.passed ? 200 : 500;
            Template resultTemplate = TemplateLoader.load("LitmusTestRunner/results.html");
            Map<String, Object> options = new HashMap<String, Object>();
            options.put("test", test);
            options.put("results", results);
            String result = resultTemplate.render(options);
            File testResults = Play.getFile("test-result/" + test + (results.passed ? ".passed" : ".failed") + ".html");
            IO.writeContent(result, testResults);
            try {
                // Write xml output
                options.remove("out");
                resultTemplate = TemplateLoader.load("LitmusTestRunner/results-xunit.xml");
                String resultXunit = resultTemplate.render(options);
                File testXunitResults = Play.getFile("test-result/TEST-" + test.substring(0, test.length()-6) + ".xml");
                IO.writeContent(resultXunit, testXunitResults);
            } catch(Exception e) {
                Logger.error(e, "Cannot ouput XML unit output");
            }            
            response.contentType = "text/html";
            renderText(result);
        }       
        if (test.endsWith(".test.html.result")) {
            flash.keep();
            test = test.substring(0, test.length() - 7);
            File testResults = Play.getFile("test-result/" + test.replace("/", ".") + ".passed.html");
            if (testResults.exists()) {
                response.contentType = "text/html";
                response.status = 200;
                renderText(IO.readContentAsString(testResults));
            }
            testResults = Play.getFile("test-result/" + test.replace("/", ".") + ".failed.html");
            if (testResults.exists()) {
                response.contentType = "text/html";
                response.status = 500;
                renderText(IO.readContentAsString(testResults));
            }
            response.status = 404;
            renderText("No test result");
        }
    }


}
