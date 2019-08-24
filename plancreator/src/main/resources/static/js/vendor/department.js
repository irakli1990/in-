//************************************************ Department data ******************************************************************
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
//********************************************** Edit Department data ****************************************************************

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
//****************************************************** Delete Department data **********************************************************

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
// **************************************************************** Add new Department data **************************************************

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