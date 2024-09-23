
// window.onload = function() {
//     const jwt = localStorage.getItem('jwt');

//     console.log(jwt)
  
//     if (!jwt) {
//         // Si no hay JWT, redirige al usuario a la página de login
//         window.location.href = "index.html";
        
//     } else {
//         // Opcionalmente, puedes verificar el JWT con el backend para asegurar que es válido
//         verifyToken(jwt).then(isValid => {
//             if (!isValid) {
//                 // Si el token no es válido, redirige al login
//                 window.location.href = "index.html";
//             }
//         }).catch(err => {
//             console.error('Error verifying token:', err);
//             window.location.href = "index.html";
//         });
//     }
//   };
  
//   async function verifyToken(jwt) {
//     const response = await fetch("http://localhost:8080/verify-token", {
//         method: "GET",
//         headers: {
//             "Authorization": "Bearer " + jwt,
//             "Content-Type": "application/json"
//         }
         
//     });
    
//     return response.ok;
//   }
// }

// window.onload = function() {
//     // Verifica si hay un JWT en el almacenamiento local
//     const jwt = localStorage.getItem('jwt');

//     if (jwt) {
//         // Si el JWT existe en el almacenamiento local, no haces nada y puedes continuar con la página
//         console.log('JWT en localStorage:', jwt);
//     } else {
//         // Si no hay JWT en el almacenamiento local, verifica si el JWT está en los parámetros de la URL
//         const params = new URLSearchParams(window.location.search);
//         const urlJwt = params.get('jwt');

//         if (urlJwt) {
//             // Si hay un JWT en los parámetros de la URL, almacénalo en el almacenamiento local
//             localStorage.setItem('jwt', urlJwt);
//             console.log('JWT guardado desde URL:', urlJwt);
//         } else {
//             // Si no hay JWT en el almacenamiento local ni en la URL, redirige al usuario a la página de login
//             console.log('No hay JWT, redirigiendo a login...');
//             window.location.href = "index.html";
//         }
//     }
// };



window.onload = function() {
    // Verifica si hay un JWT en el almacenamiento local
    const jwt = localStorage.getItem('jwt');

    if (jwt) {
        // Si el JWT existe en el almacenamiento local, no haces nada y puedes continuar con la página
        console.log('JWT en localStorage:', jwt);
    } else {
        // Si no hay JWT en el almacenamiento local, verifica si el JWT está en los parámetros de la URL
        const params = new URLSearchParams(window.location.search);
        const urlJwt = params.get('jwt');

        if (urlJwt) {
            // Si hay un JWT en los parámetros de la URL, almacénalo en el almacenamiento local
            localStorage.setItem('jwt', urlJwt);
            console.log('JWT guardado desde URL:', urlJwt);
        } else {
            // Si no hay JWT en el almacenamiento local ni en la URL, redirige al usuario a la página de login
            console.log('No hay JWT, redirigiendo a login...');
            window.location.href = "index.html";
        }
    }
};

document.addEventListener('DOMContentLoaded', function() {
    const url = 'http://localhost:8080/user/listUsers'; 
    const jwt = localStorage.getItem('jwt'); // Obtener el JWT del localStorage

    // if (!jwt) {
    //     alert('No estás autenticado. Redirigiendo al login.');
    //     window.location.href = 'index.html'; // Redirige al login si no hay JWT
    //     return;
    // }

    // Obtener la lista de usuarios del backend con el JWT
    fetch(url, {
        method: 'GET',
        headers: {
            'Authorization': 'Bearer ' + jwt,
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(data => renderUserList(data))
    .catch(error => console.error('Error:', error));

    // Función para renderizar la lista de usuarios
    function renderUserList(users) {
        const userList = document.getElementById('user-list');
        userList.innerHTML = ''; // Limpiar la lista

        users.forEach(user => {
            const li = document.createElement('li');
            li.innerHTML = `
                <strong>id Usuario:</strong> ${user.id} <br>
                <strong>Nombre de usuario:</strong> ${user.username} <br>
                <strong>Email:</strong> ${user.email} <br>
                <strong>Edad:</strong> ${user.age} <br>
                <button onclick="updateUser(${user.id})">Actualizar</button>
                <button onclick="deleteUser(${user.id})">Eliminar</button>
            `;
            userList.appendChild(li);
        });
    }

    // Funciones para actualizar y eliminar usuarios
    // function updateUser(userId) {
    //     const updateUrl = `http://localhost:8080/user/updateUser/${userId}`;
    //     // Ejemplo básico de cómo podrías manejar la actualización con JWT
    //     fetch(updateUrl, {
    //         method: 'PUT',
    //         headers: {
    //             'Authorization': 'Bearer ' + jwt,
    //             'Content-Type': 'application/json'
    //         },
    //         body: JSON.stringify({
    //             // Aquí deberías incluir los datos actualizados
    //             username: 'nuevoNombre',
    //             email: 'nuevoEmail@example.com',
    //             age: 30
    //         })
    //     })
    //     .then(response => response.json())
    //     .then(data => {
    //         console.log('Usuario actualizado:', data);
    //         alert('Usuario actualizado exitosamente');
    //     })
    //     .catch(error => console.error('Error:', error));
    // }

    // function deleteUser(userId) {
    //     const deleteUrl = `http://localhost:8080/user/delete/${userId}`;
    //     // Ejemplo básico de cómo podrías manejar la eliminación con JWT
    //     fetch(deleteUrl, {
    //         method: 'DELETE',
    //         headers: {
    //             'Authorization': 'Bearer ' + jwt,
    //             'Content-Type': 'application/json'
    //         }
    //     })
    //     .then(response => {
    //         if (response.ok) {
    //             alert('Usuario eliminado exitosamente');
    //             // Remueve el usuario de la lista sin recargar la página
    //             document.getElementById('user-list').removeChild(document.getElementById(`user-${userId}`));
    //         } else {
    //             console.error('Error al eliminar el usuario');
    //         }
    //     })
    //     .catch(error => console.error('Error:', error));
    // }
});

// deleteUser.js

async function deleteUser(userId, jwt) {
    try {
        const jwt = localStorage.getItem('jwt');
        const response = await fetch(`http://localhost:8080/user/delete/${userId}`, {
            method: 'DELETE',
            headers: {
                'Authorization': `Bearer ${jwt}`,
                'Content-Type': 'application/json'
            }
        });

        if (response.ok) {
            alert('Usuario eliminado correctamente');
            // Aquí puedes agregar lógica para actualizar la lista de usuarios o redirigir
        } else {
            alert('Error al eliminar el usuario');
        }
    } catch (error) {
        console.error('Error:', error);
    }
}

function updateUser(userId) {
    window.location.href = `actualizar.html?id=${userId}`;
}


// Asegúrate de exportar la función si estás usando módulos ES6
// export { deleteUser };


// Función para cerrar sesión
function logout() {
    // Elimina el JWT del almacenamiento local
    localStorage.removeItem('jwt');

    // Opcionalmente, puedes realizar una solicitud al servidor para invalidar el JWT (si es necesario)
    // Nota: Asegúrate de que tu backend tenga un endpoint para manejar el cierre de sesión si lo deseas

    // Redirige al usuario a la página de inicio de sesión o a una página de confirmación de cierre de sesión
    window.location.href = '/index.html'; // Cambia esta URL a la página deseada
}

// Llama a la función logout cuando se carga el documento
  const logoutButton = document.getElementById('logoutButton');
    if (logoutButton) {
        logoutButton.addEventListener('click', logout);
    };
