package functional.response;

import litmus.functional.FunctionalTest;
import litmus.functional.Request;
import litmus.functional.Response;
import org.junit.Test;

public class RequestParametersExample extends FunctionalTest {

    @Test
    public void parametersThatAreSpecifiedForAGETArePassedInTheUrl() {
        Response response = new Request("/parameters").with("parameter", "value1").get();
        assertThat(response.getText()).isEqualTo("Parameter passed: value1");
    }

    @Test
    public void parametersThatAreSpecifiedForAGETareUrlEncoded() {
        Response response = new Request("/parameters").with("parameter", "value 1").get();
        assertThat(response.getText()).isEqualTo("Parameter passed: value 1");
    }

    @Test
    public void parametersThatAreSpecifiedForAPOSTArePassedInTheBody() {
        Response response = new Request("/parameters").with("parameter", "value1").post();
        assertThat(response.getText()).isEqualTo("Parameter passed: value1");
    }


}
