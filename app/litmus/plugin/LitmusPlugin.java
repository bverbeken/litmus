package litmus.plugin;

import play.PlayPlugin;

import static play.mvc.Router.prependRoute;

public class LitmusPlugin extends PlayPlugin {

    @Override
    public void onRoutesLoaded() {
        prependRoute("GET", "/@tests", "LitmusTestRunner.testList");
        prependRoute("GET", "/@tests/init", "LitmusTestRunner.init");
        prependRoute("GET", "/@tests/end", "LitmusTestRunner.end");
        prependRoute("GET", "/@tests/run", "LitmusTestRunner.run");
    }


}
