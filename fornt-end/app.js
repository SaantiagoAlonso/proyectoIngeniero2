async function postData(url = "", data = {}) {
    // Default options are marked with *
    const response = await fetch(url, {
      method: "POST", // *GET, POST, PUT, DELETE, etc.
      mode: "cors", // no-cors, *cors, same-origin
      cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
      credentials: "same-origin", // include, *same-origin, omit
      headers: {
        "Content-Type": "application/json",
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      redirect: "follow", // manual, *follow, error
      referrerPolicy: "no-referrer", // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
      body: JSON.stringify(data), // body data type must match "Content-Type" header
    });
    return response.json(); // parses JSON response into native JavaScript objects
  }

  async function getData(url = "", jwt = null) {
    // Default options are marked with *
    const response = await fetch(url, {
      method: "GET", // *GET, POST, PUT, DELETE, etc.
      mode: "cors", // no-cors, *cors, same-origin
      cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
      credentials: "same-origin", // include, *same-origin, omit
      headers: {
        "Content-Type": "application/json",
        "Authorization": "Bearer ".concat(jwt),
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      redirect: "follow", // manual, *follow, error
      referrerPolicy: "no-referrer", // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
    });
    return response.json(); // parses JSON response into native JavaScript objects
  }

  const username = String(document.getElementById('user').value);
  const password = String( document.getElementById('ps').value);

  // Crea un objeto con los datos
//   const dataLogin = {
//       username: username,
//       password: password
//   };
 
//   let loginBtn = document.getElementById('login').addEventListener('click', event => {
//     console.log('login')
   

//     postData("http://localhost:8080/auth/login", {username,password} )


//     .then((data) => {
//         console.log('authenticate. jwt: ', data.jwt);
//         alert(data.jwt)

//         // document.getElementById('jwt').value = data.jwt;

//         return data; // JSON data parsed by `data.json()` call
//     })

//     alert(dataLogin)

// });

document.getElementById('login').addEventListener('click', async event => {
    event.preventDefault(); // Evita que el formulario se envíe de forma predeterminada

    const username = document.getElementById('user').value;
    const password = document.getElementById('ps').value;

    try {
        const data = await postData("http://localhost:8080/auth/login", {username, password});
        console.log('Autenticado. JWT: ', data.jwt);
        alert(data.jwt);

        // Puedes hacer algo con el JWT aquí, como almacenarlo en el almacenamiento local
        localStorage.setItem('jwt', data.jwt);



        // window.location.href = "http://localhost:5500/hola.html";
        window.location.href = "http://localhost:5500/inicioAdmin/inicioAdmin.html";
    } catch (error) {
        console.error('Error:', error);
    }
});


// document.getElementById("logGoogle").addEventListener("click", function() {
//     window.location.href = "https://accounts.google.com/v3/signin/identifier?opparams=%253F&dsh=S672442480%3A1724777940120617&client_id=110711633426-9s4g799tehi3hs6r7l1kfeemc0csthuu.apps.googleusercontent.com&ddm=0&nonce=-PuyL_N0iueRQC9SYIG-PpBCwgUCZqdEgo9m7giYkAI&o2v=2&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Flogin%2Foauth2%2Fcode%2Fgoogle&response_type=code&scope=openid+profile+email&service=lso&state=ucwDTnAPW82n5JDckXW62IJFlqbO5lt8g2wOjVWiGrs%3D&flowName=GeneralOAuthFlow&continue=https%3A%2F%2Faccounts.google.com%2Fsignin%2Foauth%2Fconsent%3Fauthuser%3Dunknown%26part%3DAJi8hAPNwy2S4NyUA-ObDR0SiNnz-mpzgFZfrtFzlihonrxC_X0l5dSe7vmO9ebgXsIWW_2YFo9B74cIwZ-0CLS7mkIKqZxPhC9VL08RG8ZfDY24tXwVz-0R6yi7NCYA9yg7MlkhJlrAs1f8XTMifORDvLxYbM1mfw8xARENiWenFsSW2j-egy_D1UEagGYQMKyVMiWGlVukODHVLY2DIdJkkRKsOAEgB4b5uknbv5PpZDcUS7F_jXZ9jeU8jX0u1BqqIRswauWAvtSrgvHLd47ytNSijZJM78Yhc-oCVEypCeFYEHcVEjqVNC9FdKrmYk2PMNAguqrijhbjkszuh6OI-tYp0hT3GUrA7KuvSXey4AkPMnenAX7LAu31ojp_8ZtJPzLM_bew79bCorE50uFHs04nqaYMi2Fo3JJc4DUQx4lQpu5B878TNLSH7Om6t_wG4bABptm9ylSuHuI9AT3KwbG4CC6t9w%26flowName%3DGeneralOAuthFlow%26as%3DS672442480%253A1724777940120617%26client_id%3D110711633426-9s4g799tehi3hs6r7l1kfeemc0csthuu.apps.googleusercontent.com%23&app_domain=http%3A%2F%2Flocalhost%3A8080&rart=ANgoxceZE-EoXJq1X0jb4hz_ZiumGLHGGKI0LaBcGqu1Gjx5OXPNbPYDcj9tUs8nyvqCXgnokDQfBRUhrKg8O6ecXCI77CyggCjvU6VVJcrUjwIA1VcUTiI";
// });

document.getElementById("logGoogle").addEventListener("click", function() {
    window.location.href = "http://localhost:8080";
    // localStorage.setItem('jwt', data.jwt);
    // console.log('Autenticado. JWT: ', data.jwt);
    // alert(data.jwt);
    // window.location.href = "http://localhost:5500/hola.html";
});

// document.getElementById("logGoogle").addEventListener("click", async function() {
//   event.preventDefault();
//   try {
//       window.location.href = "http://localhost:8080"
//       const response = await fetch("http://localhost:8080/oauth2/authorization/google");
//       const data = await response.json();
//       if (data.jwt) {
//           localStorage.setItem('jwt', data.jwt);
//           window.location.href = "http://localhost:5500/hola.html";
//       }
//   } catch (error) {
//       console.error('Error:', error);
//   }
// });


// let findBtn = document.getElementById('find').addEventListener('click', event => {
//     console.log('find');

//     let jwt = document.getElementById('jwt').value;

//         console.log('input jwt value: ', jwt)
//         getData('http://localhost:8585/api/v1/products/1', jwt)
//         .then(data => {
//             console.log(data)
//             document.getElementById('jwt').value = data.name;
//         });

// });


