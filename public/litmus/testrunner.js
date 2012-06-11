$(function () {

    function testError(message) {
        window.location = createBookmarkUrl();
        stop();
        updateSelected();
    }

    function selectAllTestsAndRun(){
        selectAllTests();
        run();
    }

    function run() {
        updateSelected();
        $(".runButton").hide();
        $(document.body).addClass('running');
        $('.test, #header').removeClass('passed').removeClass('failed');
        $.ajax({
            type:'GET',
            url:initTestRunnerLink,
            success:function () {
                runNextTest();
            },
            error:function (request) {
                testError(request.responseText);
            }
        });
    }

    function runNextTest() {
        if ($(document.body).is('.running')) {
            var test = $('.test.selected:not(.passed,.failed):first');
            if (test.size()) {
                var testId = test.attr('id');
                runTest(testId, test);
            } else {
                result();
            }
        }
    }

    function result() {
        clearInterval(window.checkResult);
        $(document.body).removeClass('running');
        $('.passing').removeClass('passing');
        $('.runButton').show();
        if ($('.test.failed').size()) {
            $('#header').addClass('failed');
        } else {
            $('#header').addClass('passed');
        }
        var areFailedTests = $('.test.failed').size();
        $.ajax({
            type:'GET',
            url:endTestRunnerLink,
            data:{result:areFailedTests ? 'failed' : 'passed'}
        });
        if (areFailedTests) {
            var skip = $("#header").outerHeight();
            skip += $("#results").outerHeight();
        }
    }

    function runTest(testClassName, test) {
        test.addClass('passing');
        if (/.class$/.test(testClassName)) {
            $.ajax({
                type:'GET',
                dataType:'html',
                url:runTestUrl(testClassName),
                complete:function (res, status) {
                    var results = $("<div/>").append(res.responseText).find('table');
                    if (!results || !results.size()) {
                        results = '<strong class="error">Error, the test has not been properly run. Check the server logs, or open this test in another browser tab to see the error page.</strong>';
                    }
                    if (status == 'success') {
                        testSuccess(test, results);
                    } else {
                        testFail(test, results);
                    }
                }
            });
        }
    }

    function testSuccess(test, result) {
        test.removeClass('passing').addClass('passed');
        $('.testResult', test).html(result);
        runNextTest();
    }

    function testFail(test, result) {
        test.removeClass('passing').addClass('failed');
        $('.testResult', test).html(result).show();
        $('.touch', test).html("-");
        runNextTest();
    }

    function stop () {
        result();
    }


    function unselectAllTests() {
        $('.test').removeClass('selected');
        updateSelected();
    }

    function selectAllTests(){
        $('.test').addClass('selected');
        updateSelected();
    }

    function updateSelected() {
        var testToRunCount = $('.test.selected').size();
        if (testToRunCount) {
            $('.nbToRun').text(testToRunCount);
            $('.nbToRunPluralize').text((testToRunCount > 1) ? 's' : '');
            $('#start').removeAttr('disabled').removeClass('disabled');
            $('#bookmarkSave').show();
            $('#bookmarkSave a').attr('href', createBookmarkUrl());
            $('#quickLinks').hide();
        } else {
            $('.nbToRun').text('no');
            $('.nbToRunPluralize').text('');
            $('#start').attr('disabled', 'true').addClass('disabled');
            $('#bookmarkSave').hide();
            $('#quickLinks').show();
        }
        $('.test, #header').removeClass('passed').removeClass('failed');
    }

    function createBookmarkUrl() {
        var url = 'http://' + document.location.host;
        if (document.location.port && url.indexOf(":") == -1) {
            url += ':' + document.location.port;
        }
        url += document.location.pathname;
        url += '?select=';
        var v = false;
        $('.test.selected').each(function () {
            if (v) {
                url += ',';
            }
            url += $(this).attr('id');
            v = true;
        });
        if (url) {
            return url;
        }
    }

    function selectCategory(categoryDiv){
        var ul = categoryDiv.find('ul');
        if ($('.test', ul).size() == $('.test.selected', ul).size()) {
            $('.test', ul).removeClass('selected');
            $(this).removeClass('selected');
        } else {
            $('.test', ul).addClass('selected');
            $(this).addClass('selected');
        }
        updateSelected();
    }

    $('#loading').ajaxStart(function () {
        $(this).show();
    }).ajaxStop(function () {
        $(this).hide();
    });

    $('.test a').click(function (e) {
        e.preventDefault();
        if ($(document.body).is('.running')) return;
        $(this).closest('.test').toggleClass('selected');
        updateSelected();
    });

    $('.test .touch').click(function (e) {
        e.preventDefault();
        var test = $(this).closest('.test');
        $('.testResult', test).toggle();
        $(this).html($(this).html() == '-' ? '+' : '-');
    });

    $('.categoryLink').click(function () {
        if ($(document.body).is('.running')) return;
        selectCategory($(this).parent().parent());
    });


    $('#start').click(function () {
        if ($(this).is('.disabled')) return;
        run();
    });

    $('#stop').click(function () {
        stop();
    });

    $('#selectAllLink').click(function () {
        selectAllTests();
    });

    $('#unselectAll').click(function (e) {
        e.preventDefault();
        unselectAllTests();
    });

    $('#runAllLink').click(function () {
        selectAllTestsAndRun();
    });


    $('.runSingleTestClass').click(function(){
        unselectAllTests();
        var test = $(this).closest('.test');
        test.addClass('selected');
        updateSelected();
        run();
    });

    $('.runSingleCategory').click(function(){
        unselectAllTests();
        selectCategory($(this).parent().parent());
        run();
    });

    $('.traceToggler').live('click', function(e){
        e.preventDefault();
        var $trace = $("pre[data-role=trace]", $(this).parent());
        if ($trace.attr('data-shown') == "true") {
            $trace.hide();
            $(this).text("Show trace");
            $trace.attr('data-shown', false);
        } else {
            $trace.show();
            $(this).text("Hide trace");
            $trace.attr('data-shown', true);
        }
    });


    if (/select=/.exec(document.location.search)) {
        var toSelect = /select=([^&]+)/.exec(document.location.search)[1].split(',');
        if (toSelect[0] == 'all') {
            $('.test').addClass('selected');
        } else {
            $(toSelect).each(function () {
                $(document.getElementById(this)).addClass('selected');
            });
        }
    }

    updateSelected();

    if (/auto=yes/.exec(document.location.search)) {
        selectAllTestsAndRun();
    }

});

