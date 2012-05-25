package controllers;

import com.beust.jcommander.internal.Maps;
import litmus.engine.TestEngine;
import play.mvc.Controller;

import java.util.List;
import java.util.Map;

public class LitmusTestRunner extends Controller {

    public static void testList(){
        Map<String, List<Class>> tests = Maps.newHashMap();
        tests.put("UNIT", TestEngine.allUnitTests());
        tests.put("FUNCTIONAL", TestEngine.allFunctionalTests());
        render(tests);
    }

}
