let menu = document.querySelector('#menu-btn');
let navbar = document.querySelector('.header .navbar');

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


menu.onclick = () => {
    menu.classList.toggle('fa-times');
    navbar.classList.toggle('active');
}

window.onscroll = () => {
    menu.classList.remove('fa-times');
    navbar.classList.remove('active');
}

var swiper = new Swiper(".home-slider", {
    grabCursor:true,
    loop:true,
    centeredSlides:true,
    autoplay: {
        delay: 7500,
        disableOnInteraction: false,
    },
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});

var swiper = new Swiper(".room-slider", {
    spaceBetween: 20,
    grabCursor:true,
    loop:true,
    centeredSlides:true,
    autoplay: {
        delay: 7500,
        disableOnInteraction: false,
    },
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
    breakpoints: {
        0: {
            slidesPerView: 1,
        },
        768: {
            slidesPerView: 2,
        },
        991: {
            slidesPerView: 3,
        },
    },
});

var swiper = new Swiper(".gallery-slider", {
    spaceBetween: 10,
    grabCursor:true,
    loop:true,
    centeredSlides:true,
    autoplay: {
        delay: 1500,
        disableOnInteraction: false,
    },
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
    breakpoints: {
        0: {
            slidesPerView: 1,
        },
        768: {
            slidesPerView: 3,
        },
        991: {
            slidesPerView: 4,
        },
    },
});

var swiper = new Swiper(".review-slider", {
    spaceBetween: 10,
    grabCursor:true,
    loop:true,
    centeredSlides:true,
    autoplay: {
        delay: 7500,
        disableOnInteraction: false,
    },
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
});

let accordions = document.querySelectorAll('.faqs .row .content .box');

accordions.forEach(acco =>{
    acco.onclick = () =>{
        accordions.forEach(subAcco => {subAcco.classList.remove('active')});
        acco.classList.add('active');
    }
})