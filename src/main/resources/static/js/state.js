$('document').ready(function () {

    $('table .btn-primary').on('click', function (event) {
        // prevent going to Json page
        event.preventDefault();

        // /states/findById/?id=1

        //szuka atrybutu href w tabeli, w buttonie .btn-primary, czyli adres: "@{states/findById/(id=${state.id})}"
        var href = $(this).attr('href');
        console.log("href: ", href);

        //$ .get () Metoda wykorzystuje żądania HTTP GET, aby pobrać dane z serwera.
        //$.get(URL,callback);
        $.get(href, function (state, status) {
            $('#idEdit').val(state.id);
            $('#ddlCountryEdit').val(state.countryid);
            $('#capitalEdit').val(state.capital);
            $('#codeEdit').val(state.code);
            $('#nameEdit').val(state.name);
            $('#detailsEdit').val(state.details);
        //metoda va(value) ustawia atrybut wartości
        });

        $('#editModal').modal();
    });

    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');
        console.log("href: ", href);

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