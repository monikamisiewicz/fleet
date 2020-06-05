$('document').ready(function () {

    $('table .btn-primary').on('click', function (event) {
        // prevent going to Json page
        event.preventDefault();

        // /states/findById/?id=1

        var href = $(this).attr('href');

        $.get(href, function (state, status) {
            $('#idEdit').val(state.id);
            $('#ddlCountryEdit').val(state.countryid);
            $('#capitalEdit').val(state.capital);
            $('#codeEdit').val(state.code);
            $('#nameEdit').val(state.name);
            $('#detailsEdit').val(state.details);

        });

        $('#editModal').modal();
    });

    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (state, status) {
            $('#idDetails').val(state.id);
            $('#ddlCountryDetails').val(state.countryid);
            $('#capitalDetails').val(state.capital);
            $('#codeDetails').val(state.code);
            $('#nameDetails').val(state.name);
            $('#detailsDetails').val(state.details);

        });

        $('#detailsModal').modal();
    });


    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $('#deleteModal #delRef').attr('href', href );

        $('#deleteModal').modal();
    })
});