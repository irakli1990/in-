
// ******************************************** User data **********************************************************************************

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
const $userform = $('.myForm #modalUserForm');
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