/*!
    * Start Bootstrap - SB Admin v7.0.2 (https://startbootstrap.com/template/sb-admin)
    * Copyright 2013-2021 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */
    // 
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

});
function habilitarCampos(){
    $("input").removeAttr("readonly");
    $("input").removeAttr("disabled");
    $("select").removeAttr("disabled");
    $("textarea").removeAttr("disabled");
};


                            var Materiales;
                            $('#mainRealizarCoti').ready(main());
                            

                            function main() {
                                BotonesFunc();
                            }
                            function BotonesFunc() {
                                $('#btnRegistrar').click(function () {
                                    Materiales = $('#txtMaterial').val();
                                    if (!validar(Materiales, 1, 'ListaMateriales')) {
                                        addMateriales(Materiales);
                                        return false;
                                    } else {
                                        alert("Material ya existe");
                                        return false;
                                    }
                                });
                                $('#btnListar').click(function () {
                                    listar();
                                    return false;
                                });
                            }
                            function addMateriales(material) {
                                var fila = "<tr><td><div class='form-check form-switch'><input type='checkbox' class='form" +
                                        "-check-input' id='txtindices'></div></td><td>" + material + "</td><td><div cla" +
                                        "ss='col-4'><div class='form-group'><input type='number' class='form-control' i" +
                                        "d='Cant_Mater_Listar' placeholder='0'></div></div></td></tr>";
                                $('#ListaMateriales').append(fila);
                            }
                            function validar(Dato, pos, id) {
                                var bandera = false;
                                var table = document.getElementById(id);
                                for (var i = 0; i < table.rows.length; i++) {
                                    if (table.rows[i].cells[pos].innerHTML === Dato) {
                                        bandera = true;
                                    }
                                }
                                return bandera;
                            }
                            function listar() {
                                $('#ListaMateriales tr').each(function () {
                                    let check = $(this)
                                            .find('#txtindices')
                                            .is(':checked');
                                    let materiales = $(this)
                                            .find('td')
                                            .eq(1)
                                            .text();
                                    let cantidad = $(this)
                                            .find('#Cant_Mater_Listar')
                                            .val();
                                    if (!validar(materiales, 0, 'MaterialesListados')) {
                                        if (check) {
                                            var filaListar = "<tr><td>" + materiales + "</td><td>" + cantidad + "</td><td><" +
                                                    "input type='button' class='borrar btn btn-primary' value='Eliminar' /></td></t" +
                                                    "r>";
                                            $('#MaterialesListados').append(filaListar);
                                        } else if (!check) {
                                        }
                                    }
                                });
                            }

                            $(document).on('click', '.borrar', function (event) {
                                event.preventDefault();
                                $(this)
                                        .closest('tr')
                                        .remove();
                            });
