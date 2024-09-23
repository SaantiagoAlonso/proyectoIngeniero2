
// document.getElementById('reservationForm').addEventListener('submit', function(event) {
//     event.preventDefault(); // Evita que el formulario se envíe de la forma tradicional

//     // Captura los datos del formulario
//     const nombre = document.querySelector('input[placeholder="Tu nombre"]').value;
//     const identificacion = document.querySelector('input[placeholder="tu identificacion"]').value;
//     const email = document.querySelector('input[placeholder="Tu correo electrónico"]').value;
//     const fechaEntrada = document.querySelector('input[type="date"]:nth-of-type(1)').value;
//     const fechaSalida = document.querySelector('input[type="date"]:nth-of-type(2)').value;
//     const nAdultos = document.querySelector('select[name="adults"]').value;
//     const nNinos = document.querySelector('select[name="child"]').value;
//     const tipoHabitacion = document.querySelector('select[name="type"] option:checked').textContent;

//     // Construye el objeto JSON
//     const reservaData = {
//         cliente: {
//             nombre: nombre,
//             identificacion: identificacion,
//             email: email
//         },
//         fechaEntrada: fechaEntrada,
//         fechaSalida: fechaSalida,
//         n_adultos: parseInt(nAdultos),
//         n_ninos: parseInt(nNinos),
//         tipoHabitacion: tipoHabitacion
//     };

//     // Realiza la solicitud POST
//     fetch("http://localhost:8080/reserva/verificarReserva", {  // Cambia 'URL_DEL_SERVICIO' por la URL de tu endpoint
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json',
//         },
//         body: JSON.stringify(reservaData),
//     })
//     .then(response => response.json())
//     .then(data => {
//         console.log('Éxito:', data);
//         // Aquí puedes manejar la respuesta del servidor
//     })
//     .catch((error) => {
//         console.error('Error:', error);
//     });
// });

// document.addEventListener('DOMContentLoaded', function() {
//     document.getElementById('reservationForm').addEventListener('submit', function(event) {
//         event.preventDefault(); // Evita que el formulario se envíe de la forma tradicional

//         // Captura los datos del formulario
//         const nombre = document.querySelector('input[placeholder="Tu nombre"]').value;
//         const identificacion = document.querySelector('input[placeholder="tu identificacion"]').value;
//         const email = document.querySelector('input[placeholder="Tu correo electrónico"]').value;
//         const fechaEntrada = document.querySelector('input[type="date"]:nth-of-type(1)').value;
//         const fechaSalida = document.querySelector('input[type="date"]:nth-of-type(2)').value;
//         const nAdultos = document.querySelector('select[name="adults"]').value;
//         const nNinos = document.querySelector('select[name="child"]').value;
//         const tipoHabitacion = document.querySelector('select[name="type"] option:checked').textContent;

//         // Construye el objeto JSON
//         const reservaData = {
//             cliente: {
//                 nombre: nombre,
//                 identificacion: identificacion,
//                 email: email
//             },
//             fechaEntrada: fechaEntrada,
//             fechaSalida: fechaSalida,
//             n_adultos: parseInt(nAdultos),
//             n_ninos: parseInt(nNinos),
//             tipoHabitacion: tipoHabitacion
//         };

//         // Realiza la solicitud POST
//         fetch('http://localhost:8080/reserva/verificarReserva', {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json',
//             },
//             body: JSON.stringify(reservaData),
//         })
//         .then(response => response.json())
//         .then(data => {
//             console.log('Éxito:', data);
//             // Aquí puedes manejar la respuesta del servidor
//         })
//         .catch((error) => {
//             console.error('Error:', error);
//         });
//     });
// });



// document.addEventListener('DOMContentLoaded', function () {
//     document.getElementById('reservationForm').addEventListener('submit', function (event) {
//       event.preventDefault(); // Evita que el formulario se envíe de la forma tradicional
  
//       // Captura los datos del formulario
//       const nombre = document.getElementById('nombre').value;
//       const identificacion = document.getElementById('identificación').value;
//       const email = document.getElementById('email').value;
//       const fechaEntrada = document.getElementById('fechaE')[0].value;
//       const fechaSalida = document.getElementById('fachaS')[1].value;
//       const nAdultos = document.getElementById('adultos').value;
//       const nNinos = document.getElementById('ninos').value;
//       const tipoHabitacion = document.getElementById('t_hab').textContent;
  
//       // Construye el objeto JSON
//       const reservaData = {
//         cliente: {
//           nombre: nombre,
//           identificacion: identificacion,
//           email: email
//         },
//         fechaEntrada: fechaEntrada,
//         fechaSalida: fechaSalida,
//         n_adultos: parseInt(nAdultos),
//         n_ninos: parseInt(nNinos),
//         tipoHabitacion: tipoHabitacion
//       };
  
//       // Realiza la solicitud POST
//       fetch('http://localhost:8080/reserva/verificarReserva', {
//         method: 'POST',
//         headers: {
//           'Content-Type': 'application/json',
//         },
//         body: JSON.stringify(reservaData),
//       })
//         .then(response => {
//           if (!response.ok) {
//             throw new Error('Error en la respuesta del servidor');
//           }
//           return response.json();
//         })
//         .then(data => {
//           console.log('Éxito:', data);
//           // Aquí puedes manejar la respuesta del servidor, como mostrar un mensaje al usuario
//           alert('Reserva verificada con éxito');
//         })
//         .catch((error) => {
//           console.error('Error:', error);
//           alert('Hubo un error al verificar la reserva');
//         });
//     });
//   });
  
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('reservationForm').addEventListener('submit', function (event) {
        event.preventDefault(); // Evita que el formulario se envíe de la forma tradicional

        // Captura los datos del formulario
        const nombre = document.getElementById('nombre').value;
        const identificacion = document.getElementById('identificacion').value; // Corregido
        const email = document.getElementById('email').value;
        const fechaEntrada = document.getElementById('fechaE').value; // Corregido
        const fechaSalida = document.getElementById('FechaS').value; // Corregido
        const nAdultos = document.getElementById('adultos').value;
        const nNinos = document.getElementById('ninos').value;
        const tipoHabitacion = document.getElementById('t_hab').value; // Corregido

        // Construye el objeto JSON
        const reservaData = {
            cliente: {
                nombre: nombre,
                identificacion: identificacion,
                email: email
            },
            fechaEntrada: "2024-09-19",
            fechaSalida: "2024-09-25",
            n_adultos: parseInt(nAdultos),
            n_ninos: parseInt(nNinos),
            tipoHabitacion: tipoHabitacion
        };

        console.log('Datos a enviar:', JSON.stringify(reservaData, null, 2));
        // Realiza la solicitud POST
        fetch("http://localhost:8080/reserva/verificarReserva"
            , {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(reservaData),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error en la respuesta del servidor');
                }
                // data = response.json();
                // alert(response);
                return response.text();
                
            })
            .then(data => {
                console.log('Éxito:', data);
                alert('Reserva verificada con éxito' + data);
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('Hubo un error al verificar la reserva');
            });
    });
});
