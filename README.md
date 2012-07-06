Litmus
===========================
Litmus is a playframework (1.x) module that makes TDD easier with play. It's main features are:
* more expressive functional testing
* easy testing of your model validation, both built-in or custom validations
* custom test runner that allows you to categorize tests and run categories separately
* selenium webdriver integration, no more selenium 1 :)

Expressive functional testing
-----------------------------
For example, litmus allows you to write most of your functional tests as one-liners like these:

    assertThat(get("/foo/bar").isUtf8();  
    assertThat(get("/foo/bar").hasFlashParam("success");
  

Model validation testing
------------------------
Litmus also provides a superclass for model validation tests (thoughtfully called "ValidationTest"), to take away
any excuse you might have not to test validation anymore. You can write things like:

    assertThat("firstName").isRequired();
    assertThat("firstName").shouldNotBe("");
    assertThat("houseNumber").withValue(123).isValid();

Custom test runner
------------------
When using Litmus, you get an alternative test runner on http://localhost:9000/@litmus. If you annotate your test classes
or their superclass like so:

    @Category(value = "verySlowTests")

then the litmus test runner will pick up these categories and allow you to run them separately from your browser.
Subclasses of litmus.UnitTest, litmus.FunctionalTest or litmus.WebdriverTest are categorized by default as respectively Unit Tests,
Functional Tests and Webdriver Tests.

Of course, play auto-test still works as before.

Documentation
============================
For more information on how to use Litmus, you can refer to
* the litmus-samples project (<a href="http://github.com/bverbeken/litmus-samples">http://github.com/bverbeken/litmus-samples</a>). This is a normal play application that has examples for all the available asserts.
* the documentation page, which can be found <a href="http://github.com/bverbeken/litmus/blob/master/documentation/manual/home.textile">here</a>.


What could be improved/added
===============================
* more asserts (json assert, ..?)
* other types of testing (javascript unit testing?)

Kudos to the people behind
=============================

* [Play framework](http://www.playframework.org/)
* [jsoup](http://jsoup.org/)
* [Fest](http://code.google.com/p/fest/)


Project Information
=================================

Source code: https://github.com/bverbeken/litmus   
Issue tracking: https://github.com/bverbeken/litmus/issues

This is a work in progress (of course it is, it's software).  
If litmus is missing features you dream of, or you have suggestions on how it could be made better, tweet me ([@bverbeken](http://twitter.com/bverbeken)) or send a pull request.
