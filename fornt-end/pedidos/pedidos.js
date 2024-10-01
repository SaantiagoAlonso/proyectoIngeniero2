document.getElementById('pedido-form').addEventListener('submit', function(event) {
    event.preventDefault();  // Evitar que el formulario recargue la página
    
    // Obtener los valores del formulario
    let nombreCliente = document.getElementById('nombre-cliente').value;
    let numeroMesa = document.getElementById('numero-mesa').value;
    let fechaHora = document.getElementById('fecha-hora').value;
    let articulos = {};
    
    document.querySelectorAll('.item-row').forEach(row => {
        let articuloNombre = row.querySelector('.item-select option:checked').textContent;
        let articuloPrecio = parseFloat(row.querySelector('.item-price').value);
        articulos[articuloNombre] = articuloPrecio;  // Llenar el objeto de artículos
    });
    
    let totalPedido = parseFloat(document.getElementById('total-pedido').value);

    // Crear el objeto pedido
    let pedido = {
        nombre_cliente: nombreCliente,
        n_mesa: parseInt(numeroMesa),
        fecha_pedido: fechaHora,
        articulos: articulos,
        precioTotal: totalPedido
    };

    alert("Datos que se enviarán al backend:\n" + JSON.stringify(pedido, null, 2));

    // Enviar los datos al backend usando fetch
    fetch('http://localhost:8080/pedido/registarPedido', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(pedido)
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        alert('Pedido registrado: ' + data.mensaje);
    })
    .catch(error => {
        console.error('Error al registrar el pedido:', error);
    });
});
