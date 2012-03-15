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

Documentation
============================
For more information on how to use Litmus, you can refer to
* the litmus-samples project (<a href="http://github.com/bverbeken/litmus-samples">http://github.com/bverbeken/litmus-samples</a>). This is a normal play application that has examples for all the available asserts.
* the documentation page, which can be found <a href="http://github.com/bverbeken/litmus/blob/master/documentation/manual/home.textile">here</a>.


What could be improved/added
===============================
* more asserts (json assert, ..?)
* other types of testing (webdriver,javascript unit testing, etc)
* possibly a custom test runner so that all of these tests can be catogorized, ran individually, etc.


Kudos to the people behind
=============================

* [Play framework](http://www.playframework.org/)
* [jsoup](http://jsoup.org/)
* [Fest](http://code.google.com/p/fest/)


Disclaimer
=================================
This is a work in progress. Of course it is, it's software. Sorry for that :) 

If litmus is missing features you dream of, or you have suggestions on how it could be made better, tweet me ([@bverbeken](http://twitter.com/bverbeken)) or clone the github repo and start sending pull requests.
