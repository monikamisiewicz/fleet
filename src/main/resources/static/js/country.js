$('document').ready(function () {

    $('table #editButton').on('click', function (event) {
        // prevent going to Json page
        event.preventDefault();

        // /countries/findById/?id=1

        var href = $(this).attr('href');

        $.get(href, function (country, status) {
            $('#idEdit').val(country.id);
            $('#descriptionEdit').val(country.description);
            $('#capitalEdit').val(country.capital);
            $('#codeEdit').val(country.code);
            $('#continentEdit').val(country.continent);
            $('#nationalityEdit').val(country.nationality);

        });

        $('#editModal').modal();
    });

    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $('#confirmDeleteButton').attr('href', href );

        $('#deleteModal').modal();
    })
});