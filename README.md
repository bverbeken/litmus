Litmus
===========================
Litmus is a Play!Framework (1.2.x) module that allows for more expressive testing. For example, it allows
you to write most of your functional tests as one-liners like these:

    assertThat(get("/foo/bar").isUtf8();  
    assertThat(get("/foo/bar").hasFlashParam("success");
  

Litmus also contains a small superclass for model validation tests (thoughtfully called "ValidationTest"), to take away
any excuse you might have not to test validation anymore. You can write things like:

    assertThat("firstName").isRequired();
    assertThat("firstName").shouldNotBe("");
    assertThat("houseNumber").withValue(123).isValid();

<!-- ------------------------------------------------------------------------------------------

Documentation
==========================
For a full list of examples, go have a look at the [litmus-samples](https://github.com/bverbeken/litmus-samples) project. 
It contains examples for all available asserts.     

Getting started
------------------
For functional tests, extend from <b>litmus.functional.FunctionalTest</b>. This is a subclass of the regular Play! FunctionalTest class, so you'll be able to run it from the regular testrunner. 
The litmus FunctionalTest class includes all assertThat() methods from org.fest.assertons.Assertions. See the fest documentation for more info. 
Next to that, it provides you with a number of play-specific assertThat() methods: 
    assertThat(response)
    assertThat(cookie)
    assertThat(html)
    assertThat(htmlElement)


a fluent api to build up a request
----------------------------------
You can write things like 
    Response response = new Request("/login").with("username", "myUser").with("password", "secret").post();
    
And then assert on that response
    assertThat(response).isOk();

----------------------------------------------------------------------------------------- -->

What could be improved/added
===============================
* more asserts (json assert, ..?)
* other types of testing (webdriver,javascript unit testing, etc)
* possibly a custom test runner so that all of these tests can be catogorized, ran individually, etc.


Kudos To 
========

* The Play!Framework Team
* Jsoup
* Fest-assert


Disclaimer
=================================
This is a work in progress. Of course it is, it's software. Sorry for that :) 

If litmus is missing features you dream of, or you have suggestions on how it could be made better, tweet me (
[@bverbeken](http://twitter.com/bverbeken) or clone the github repo and send pull requests.
