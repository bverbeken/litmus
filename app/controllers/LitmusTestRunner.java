package controllers;

import litmus.engine.Tests;
import play.mvc.Controller;

public class LitmusTestRunner extends Controller {

    public static void testList(){
        Tests tests = new Tests();
        render(tests);
    }

}
