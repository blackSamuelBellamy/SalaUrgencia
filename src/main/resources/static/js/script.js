    document.addEventListener("DOMContentLoaded", function () {
    // Obtener referencias a los elementos HTML
    const selectElements = document.querySelectorAll("select[name=listaVisitas]");
    const textareaElements = document.querySelectorAll("textarea.observaciones");
    const nombreMedico = document.querySelector("#nombreMedico");

    // Función para obtener y mostrar observaciones
    function mostrarObservaciones(selectedVisitId, textarea) {
    obtenerObservaciones(selectedVisitId)
    .then((observaciones) => {
    textarea.value = observaciones;
})
    .catch((error) => {
    console.error('Error:', error);
    // Puedes manejar el error aquí si es necesario
});
}

        function mostrarNombreMedico(selectedVisitId, nombreMedico) {
            obtenerNombreMedico(selectedVisitId)
                .then((nombre) => {
                    nombreMedico.textContent = nombre;
                })
                .catch((error) => {
                    console.error('Error:', error);
                    // Puedes manejar el error aquí si es necesario
                });
        }

    // Agregar un event listener a cada select
    selectElements.forEach(function (select, index) {
    select.addEventListener("change", function () {
    const selectedVisitId = this.value;
    const textarea = textareaElements[index];
    mostrarNombreMedico(selectedVisitId,nombreMedico)
    mostrarObservaciones(selectedVisitId, textarea);
});

    // Obtener el valor seleccionado en cada select y mostrar las observaciones
    const selectedVisitId = select.value;
    const textarea = textareaElements[index];


    mostrarNombreMedico(selectedVisitId,nombreMedico);
    mostrarObservaciones(selectedVisitId, textarea);
});
});


    function obtenerObservaciones(visitId) {
    const url = `http://localhost:8080/api/visita/${visitId}`;

    return fetch(url)
    .then(response => {
    if (!response.ok) {
    throw new Error('La solicitud no pudo completarse correctamente');
}
    return response.json(); // Parseamos la respuesta como JSON
})
    .then(data => {
    // Suponiendo que la respuesta contiene un campo 'observaciones'
    if (data && data.observaciones) {
    return data.observaciones;
} else {
    throw new Error('No se encontraron observaciones en la respuesta');
}
})
    .catch(error => {
    console.error('Error:', error);
    throw error;
});
}

    function obtenerNombreMedico(visitId) {
        const url = `http://localhost:8080/api/medico/visita/${visitId}`;

        return fetch(url)
            .then(response => {
                if (!response.ok) {
                    throw new Error('La solicitud no pudo completarse correctamente');
                }
                return response.json(); // Parseamos la respuesta como JSON
            })
            .then(data => {
                // Comprobamos que la respuesta tenga las propiedades necesarias
                if (data && data.nombres && data.apellido1 && data.apellido2) {
                    return `${data.nombres} ${data.apellido1} ${data.apellido2}`;
                } else {
                    throw new Error('No se encontraron datos válidos en la respuesta');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                throw error;
            });
    }






