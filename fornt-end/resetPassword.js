
// async function postData(url = "", data = {}) {
//     // Default options are marked with *
//     const response = await fetch(url, {
//       method: "POST", // *GET, POST, PUT, DELETE, etc.
//       mode: "cors", // no-cors, *cors, same-origin
//       cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
//       credentials: "same-origin", // include, *same-origin, omit
//       headers: {
//         "Content-Type": "application/json",
//         // 'Content-Type': 'application/x-www-form-urlencoded',
//       },
//       redirect: "follow", // manual, *follow, error
//       referrerPolicy: "no-referrer", // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
//       body: JSON.stringify(data), // body data type must match "Content-Type" header
//     });
//     return response.json(); // parses JSON response into native JavaScript objects
//   }


document.getElementById("resetPasswordForm").addEventListener("submit", async function(event) {
    event.preventDefault(); // Evita que el formulario se envíe de manera tradicional

    // Captura el correo electrónico ingresado por el usuario
    const email = document.getElementById("email").value;

    // Crear el objeto que se enviará en la solicitud POST
    const data = {
        email: email
    };

    try {
        // Realiza la solicitud POST al servidor
        const response = await fetch("http://localhost:8080/user/setPassword", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        // Procesa la respuesta del servidor
        if (response.ok) {
            const message = await response.text();
            document.getElementById("message").textContent = message;
        } else {
            document.getElementById("message").textContent = "Error al restablecer la contraseña.";
        }
    } catch (error) {
        console.error("Error:", error);
        document.getElementById("message").textContent = "Error al conectar con el servidor.";
    }
});


// document.getElementById('btnRes').addEventListener('click', async event => {
//     event.preventDefault(); // Evita que el formulario se envíe de forma predeterminada

//     const email= document.getElementById('email').value;
    

//     try {
//         const data = await postData("http://localhost:8080/user/setPassword", {username, password});
        
//         if (response.ok) {
//              const message = await response.text();
//             document.getElementById("message").textContent = message;
//             } else {
//                     document.getElementById("message").textContent = "Error al restablecer la contraseña.";
//                 }
    
//     } catch (error) {
//         console.error('Error:', error);
//         document.getElementById("message").textContent = "Error al conectar con el servidor.";
//     }
// });