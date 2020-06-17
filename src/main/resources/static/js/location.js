$('document').ready(function () {

    $('table .btn-primary').on('click', function (event) {
        // prevent going to Json page
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (location, status) {
            $('#idEdit').val(location.id);
            $('#ddlCountryEdit').val(location.countryid);
            $('#ddlStateEdit').val(location.stateid);
            $('#descriptionEdit').val(location.description);
            $('#cityEdit').val(location.city);
            $('#addressEdit').val(location.address);
            $('#detailsEdit').val(location.details);

        });

        $('#editModal').modal();
    });

    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (location, status) {
            $('#idDetails').val(location.id);
            $('#ddlCountryDetails').val(location.countryid);
            $('#ddlStateDetails').val(location.stateid);
            $('#descriptionDetails').val(location.description);
            $('#cityDetails').val(location.city);
            $('#addressDetails').val(location.address);
            $('#detailsDetails').val(location.details);

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