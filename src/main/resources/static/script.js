// Función para abrir el formulario modal
function openForm(action, propertyId = null) {
    const propertyFormModal = document.getElementById("propertyFormModal");
    propertyFormModal.style.display = "block";  // Mostrar el formulario

    const formTitle = document.getElementById("formTitle");
    const propertyIdForm = document.getElementById("propertyIdForm");

    if (action === 'create') {
        formTitle.innerText = 'Create Property';
        propertyIdForm.style.display = "none";  // Ocultar el campo Property Id
        document.getElementById("propertyId").removeAttribute("required");
    } else if (action === 'update') {
        formTitle.innerText = 'Update Property';
        propertyIdForm.style.display = "block";  // Mostrar el campo Property Id
        document.getElementById("propertyId").setAttribute("required", "required");
        document.getElementById("propertyId").value = propertyId;  // Asignar el ID de la propiedad
    }

    // Asociar evento al formulario
    propertyFormModal.onsubmit = function (event) {
        event.preventDefault();
        submitForm(action);  // Llamar a la función submitForm con la acción actual
    }
}

// Función para obtener todas las propiedades
function fetchProperties() {
    fetch('/api/property')
        .then(response => response.json())
        .then(data => {
            const propertyList = document.getElementById("property-list");
            propertyList.innerHTML = '';  // Limpiar la lista existente

            data.forEach(property => {
                const row = document.createElement("div");
                row.className = "row mb-2";

                row.innerHTML = `
                    <div class="col">${property.propertyId}</div>
                    <div class="col">${property.address}</div>
                    <div class="col">${property.price}</div>
                    <div class="col">${property.size}</div>
                    <div class="col">${property.description}</div>
                    <div class="col">
                        <button class="btn btn-warning" onclick="openForm('update', ${property.propertyId})">Update</button>
                        <button class="btn btn-danger" onclick="deleteProperty(${property.propertyId})">Delete</button>
                    </div>
                `;
                propertyList.appendChild(row);
            });
        })
        .catch(error => console.error('Error fetching properties:', error));
}

// Función para cerrar el formulario modal
function closeForm() {
    document.getElementById("propertyFormModal").style.display = "none";
}

// Función para enviar la solicitud al servidor usando Fetch API
function submitForm(action) {
    const address = document.getElementById("address").value;
    const price = document.getElementById("price").value;
    const size = document.getElementById("size").value;
    const description = document.getElementById("description").value;

    const data = {
        address: address,
        price: parseFloat(price),
        size: parseFloat(size),
        description: description
    };

    let url = '/api/property';
    let method = 'POST';

    if (action === 'update') {
        const propertyId = document.getElementById("propertyId").value;
        url += `/${propertyId}`;  // Actualiza la URL para la acción de actualización
        method = 'PUT';
    }

    fetch(url, {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(result => {
        console.log('Success:', result);
        closeForm();  // Cerrar el formulario después de enviar
        fetchProperties();  // Actualizar la lista de propiedades
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

// Función para eliminar una propiedad
function deleteProperty(propertyId) {
    fetch(`/api/property/${propertyId}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            fetchProperties();  // Actualizar la lista de propiedades después de eliminar
        } else {
            console.error('Error deleting property');
        }
    })
    .catch(error => console.error('Error:', error));
}
