//***************************************************** Minimum data ******************************************************************


var app = new Vue({
    el: '#wrapper',
    data: {
        link: '',
        minimum: {
            idMin: 0,
            major: '',
            level: '',
            note: '',
            depertmentId: 0
        }
    },
    methods: {
        getDataFromServer: function (event) {
            event.preventDefault();
            this.link = event.currentTarget.href;
            axios.get(this.link)
                .then(function (response) {
                    console.log(response.data.Minimum);
                    $('.myMinimum #idMin').val(response.data.Minimum.idMin);
                    $('.myMinimum #major').val(response.data.Minimum.major);
                    $('.myMinimum #level').val(response.data.Minimum.level);
                    $('.myMinimum #note').val(response.data.Minimum.note);
                    $('.myMinimum #departmentID').val(response.data.Minimum.depertmentId);
                })
                .catch(function (error) {
                    console.log(error)
                })
            $('.myMinimum #minModal').modal();
        },
        sendMinimumToServer: function (event) {
            event.preventDefault();
            this.minimum.idMin = $('.myMinimum #idMin').val();
            this.minimum.major = $('.myMinimum #major').val();
            this.minimum.level = $('.myMinimum #level').val();
            this.minimum.note = $('.myMinimum #note').val();
            this.minimum.depertmentId = $('.myMinimum #departmentID').val();
            console.log(JSON.stringify(this.minimum));
            axios.post("http://localhost:8080/api/v1/minimum?id=" + this.minimum.idMin, JSON.stringify(this.minimum), {
                headers: {
                    'Content-type': 'application/json',
                }
            })
                .then(function (response) {
                    console.log(response);
                    alert("Sukces podczas edycji " + response.data.Minimum.major);
                    window.location.reload();
                })
                .catch(function (error) {
                    console.log(error)
                })
            window.location.reload();

        }
    },


});
