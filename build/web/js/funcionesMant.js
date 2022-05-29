function setDeleteButtons() {
    $(".btnDelete").click(function () {
        let timerInterval;
        var idp = $(this).parent().parent().find(".idp").text();
        var ide;
        if (idp === "") {
            ide = $(this).parent().parent().find(".ide").text();
        }
        Swal.fire({
            title: "Está seguro que desea eliminar?",
            text: "Si lo elimina, Ud puede agregar nuevamente!",
            icon: "warning",
            showCancelButton: true
        }).then((willDelete) => {
            if (willDelete.isConfirmed) {
                if (idp === "") {
                    eliminar(ide, "emp");
                } else {
                    eliminar(idp, "prod");
                }
                Swal.fire({
                    icon: "success",
                    timer: 2000,
                    timerProgressBar: true,
                    willClose: () => {
                      clearInterval(timerInterval)
                    }
                }).then(()=>{
                    parent.location.reload();
                });
            } else {
                Swal.fire({
                    title: 'Acción cancelada!',
                    timer: 1000,
                    timerProgressBar: true,
                    willClose: () => {
                      clearInterval(timerInterval)
                    }
                });
            }
        });
    });
    function eliminar(id, tipo) {
        var url;
        if (tipo === "prod") {
            url = "Controlador?accion=Producto&menu=Delete";
        } else {
            url = "Controlador?accion=Empleado&menu=Delete";
        }
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + id
        });
    }
}


