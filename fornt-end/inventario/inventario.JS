document.getElementById('product-entry-form').addEventListener('submit', function(event) {
    event.preventDefault();

    // Obtener los valores del formulario
    const name = document.getElementById('product-name').value;
    const category = document.getElementById('product-category').value;
    const quantity = document.getElementById('product-quantity').value;
    const price = document.getElementById('product-price').value;

    // Crear el objeto de producto
    const product = {
        name: name,
        category: category,
        quantity: quantity,
        price: price
    };

    console.log(product);

    // Hacer la solicitud POST
    fetch('http://localhost:8080/inventario/ingresarProducto', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    })
    .then(response => response.json())
    .then(data => {
        // Agregar el nuevo producto a la tabla de inventario
        const tableBody = document.getElementById('inventory-body');
        const newRow = document.createElement('tr');
        newRow.innerHTML = `
            <td>${data.name}</td>
            <td>${data.category}</td>
            <td>${data.quantity}</td>
            <td>${data.price}</td>
        `;
        tableBody.appendChild(newRow);

        // Limpiar el formulario
        document.getElementById('product-entry-form').reset();
    })
    .catch(error => console.error('Error:', error));
});

