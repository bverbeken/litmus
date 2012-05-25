package controllers;

import litmus.engine.TestMap;
import play.mvc.Controller;

import static litmus.engine.TestEngine.getAllTests;

public class LitmusTestRunner extends Controller {

    public static void testList(){
        TestMap tests = getAllTests();
        render(tests);
    }

}
