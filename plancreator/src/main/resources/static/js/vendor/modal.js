const $id = $('.myForm #id');
const $akromim = $('.myForm #akronim');
const $nazwa = $('.myForm #nazwa');


$('.table .eBtn').on('click', function (event) {
    event.preventDefault();
    const $link = $(this).attr('href');
    $.get($link, function (res) {
        console.log("response:" + res['Department'].akronim);
        $id.val(res['Department'].idDepartment);
        $akromim.val(res['Department'].akronim);
        $nazwa.val(res['Department'].name);

    });
    $('.myForm #exampleModal').modal();
});


const apiUrl = "http://localhost:8080/api/v1/department?id=";
const $form = $('.myForm #modalForm');
const $submitBtn = $form.find(":submit");

$form.on("submit", function (e) {
    e.preventDefault();

    //po kliknięciu wyłączam submit i dodaję mu loading
    $submitBtn.addClass('loading');
    $submitBtn.prop('disabled', true);

    const ob = {
        akronim: $akromim.val(),
        name: $nazwa.val()
    };
    console.log(ob);
    //wysyłamy dane
    $.ajax({
        url: apiUrl + $id.val(),
        async: true,
        method: "PUT",
        contentType: 'application/json',
        dataType: "json",
        data: JSON.stringify(ob)
    }).done(function (res) {
        alert("sukces podczas edicji " + res['Department'].name)
    })
        .always(function () {
            $submitBtn.removeClass('loading');
            $submitBtn.prop('disabled', false);
            window.location.reload();
        });

});

$tabletoReload = $('.table');
$('.table .dBtn').on('click', function (event) {
    event.preventDefault();
    const $link = $(this).attr('href');
    $.get($link, function (res) {
        // $id.val(res['Department'].idDepartment);
        if (confirm("czy naprawde chcesz usunuć " + res['Department'].name)) {
            $.ajax({
                url: apiUrl + res['Department'].idDepartment,
                method: "DElETE"
            }).done(function (res) {
                alert(res.body)
            }).always(function () {
                $submitBtn.removeClass('loading');
                $submitBtn.prop('disabled', false);
                window.location.reload();

            });
        }


    })

});

$('.card-body #aBtn').on('click', function (event) {
    event.preventDefault();
    $('.myForm #exampleAddModal').modal();
});


const postUrl = "http://localhost:8080/api/v1/department";
const $Addform = $('.myForm #modalAddForm');

$Addform.on("submit", function (e) {
    e.preventDefault();

    $addAkronim = $('.myForm #addAkronim');
    $addNazwa = $('.myForm #addNazwa');

    //po kliknięciu wyłączam submit i dodaję mu loading
    $submitBtn.addClass('loading');
    $submitBtn.prop('disabled', true);

    const ob = {
        akronim: $addAkronim.val(),
        name: $addNazwa.val()
    };
    console.log(ob);
    //wysyłamy dane
    $.ajax({
        url: postUrl,
        async: true,
        method: "POST",
        contentType: 'application/json',
        dataType: "json",
        data: JSON.stringify(ob)
    }).done(function (res) {
        alert("sukces podczas edicji " + res['Department'].name)
    })
        .always(function () {
            $submitBtn.removeClass('loading');
            $submitBtn.prop('disabled', false);
            window.location.reload();
        });

});


var userID;
const $firstname = $('.myForm #firstname');
const $lastname = $('.myForm #lastname');
const $username = $('.myForm #username');
const $password = $('.myForm #password');
const $status = $('.myForm #selectoption');

$('.table #uBtn').on('click', function (event) {
    event.preventDefault();
    const $link = $(this).attr('href');
    $.get($link, function (res) {
        console.log(res);
        userID = res["User"].id;
        $firstname.val(res["User"].firstname);
        $lastname.val(res["User"].lastname);
        $username.val(res["User"].username);


    });
    $('.myForm #userModal').modal();
});
const userUrl = "http://localhost:8080/api/v1/User?id=";
const $userform = $('.myForm #userModal');
const $userSubmit = $userform.find(':submit');

$userform.on("submit", function (e) {
    e.preventDefault();

    const $firstname = $('.myForm #firstname');
    const $lastname = $('.myForm #lastname');
    const $username = $('.myForm #username');
    const $password = $('.myForm #password');
    const $status = $('.myForm #selectoption');

    $userSubmit.addClass('loading');
    $userSubmit.prop('disabled', true);

    const ob = {
        firstname: $firstname.val(),
        lastname: $lastname.val(),
        username: $username.val(),
        password: $password.val(),
        active: $status.val(),
    };
    console.log(ob);
    $.ajax({
        url: userUrl + userID,
        async: true,
        method: "POST",
        contentType: 'application/json',
        dataType: "json",
        data: JSON.stringify(ob)
    }).done(function (res) {
        alert("sukces podczas edicji " + res['User'].firstname)
    })
        .always(function () {
            $userSubmit.removeClass('loading');
            $userSubmit.prop('disabled', false);
            // window.location.reload();
        });

});


const $idMin = $('.myForm #idMin');
const $major = $('.myForm #major');
const $level = $('.myForm #level');
const $note = $('.myForm #note');



$('.table .mBtn').on('click', function (event) {
    event.preventDefault();
    const $link = $(this).attr('href');
    $.get($link, function (res) {
        console.log("response:" + res['Minimum'].major);
        console.log("response:" + res['Minimum'].idMin);
        console.log("response:" + res['Minimum'].major);
        console.log("response:" + res['Minimum'].note);
        $idMin.val(res['Minimum'].idMin);
        $major.val(res['Minimum'].major);
        $level.val(res['Minimum'].level);
        $note.val(res['Minimum'].note);

    });
    $('.myForm #minModal').modal();
});
// {"Minimum":{"idMin":1,"major":"edukacja artystyczna w zakresie sztuk plastycznych","level":"I st.","note":null,"depertmentId":1,"departmentByDepertmentId":{"idDepartment":1,"name":"Wydział Artystyczny","akronim":"wart"}}}




(function($) {
    "use strict"; // Start of use strict

    // Toggle the side navigation
    $("#sidebarToggle").on('click',function(e) {
        e.preventDefault();
        $("body").toggleClass("sidebar-toggled");
        $(".sidebar").toggleClass("toggled");
    });

    // Prevent the content wrapper from scrolling when the fixed side navigation hovered over
    $('body.fixed-nav .sidebar').on('mousewheel DOMMouseScroll wheel', function(e) {
        if ($(window).width() > 768) {
            var e0 = e.originalEvent,
                delta = e0.wheelDelta || -e0.detail;
            this.scrollTop += (delta < 0 ? 1 : -1) * 30;
            e.preventDefault();
        }
    });

    // Scroll to top button appear
    $(document).on('scroll',function() {
        var scrollDistance = $(this).scrollTop();
        if (scrollDistance > 100) {
            $('.scroll-to-top').fadeIn();
        } else {
            $('.scroll-to-top').fadeOut();
        }
    });

    // Smooth scrolling using jQuery easing
    $(document).on('click', 'a.scroll-to-top', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: ($($anchor.attr('href')).offset().top)
        }, 1000);
        event.preventDefault();
    });

})(jQuery); // End of use strict
