// Thêm mới smartphone
function addNewSmartPhone(event) {
    event.preventDefault(); // Ngăn reload trang

    let producer = $('#producer').val().trim();
    let model = $('#model').val().trim();
    let price = parseFloat($('#price').val());

    if (!producer || !model || isNaN(price)) {
        alert("Vui lòng điền đầy đủ và đúng định dạng thông tin.");
        return;
    }

    let newSmartphone = {
        producer: producer,
        model: model,
        price: price
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newSmartphone),
        url: "http://localhost:8080/api/smartphones",
        success: function () {
            successHandler();           // reload danh sách
            clearForm();                // reset form
            $('#add-smartphone').hide();
            $('#display-create').show();
            $('#title').show();
            $('html, body').animate({ scrollTop: 0 }, 300);
        },
        error: function () {
            alert("Đã xảy ra lỗi khi thêm mới smartphone.");
        }
    });
}

// Hiển thị danh sách smartphone
function successHandler() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/smartphones",
        success: function (data) {
            let content = `<table id="display-list"><tr>
                <th>Producer</th>
                <th>Model</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>`;

            for (let smartphone of data) {
                content += getSmartphone(smartphone);
            }
            content += "</table>";

            $('#smartphoneList').html(content).show();
            $('#add-smartphone').hide();
            $('#edit-form').hide();
            $('#display-create').show();
            $('#title').show();
        }
    });
}

// Hiển thị form thêm mới
function displayFormCreate() {
    $('#smartphoneList').hide();
    $('#edit-form').hide();
    $('#add-smartphone').show();
    $('#display-create').hide();
    $('#title').hide();
}

// Tạo HTML từng dòng smartphone
function getSmartphone(smartphone) {
    return `
        <tr>
            <td>${smartphone.producer}</td>
            <td>${smartphone.model}</td>
            <td>${smartphone.price}</td>
            <td>
                <button onclick="showEditForm(${smartphone.id})">Edit</button>
                <button onclick="deleteSmartphone(${smartphone.id})">Delete</button>
            </td>
        </tr>
    `;
}

// Xoá smartphone
function deleteSmartphone(id) {
    if (!confirm("Bạn có chắc chắn muốn xoá không?")) return;

    $.ajax({
        type: "DELETE",
        url: `http://localhost:8080/api/smartphones/${id}`,
        success: successHandler,
        error: function () {
            alert("Không thể xóa smartphone này.");
        }
    });
}

// Reset form thêm mới
function clearForm() {
    $('#producer').val('');
    $('#model').val('');
    $('#price').val('');
}

// Hiển thị form sửa
function showEditForm(id) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/smartphones/${id}`,
        success: function (data) {
            $('#edit-id').val(data.id);
            $('#edit-producer').val(data.producer);
            $('#edit-model').val(data.model);
            $('#edit-price').val(data.price);

            $('#add-smartphone').hide();
            $('#edit-form').show();
            $('#smartphoneList').hide();
            $('#display-create').show();
            $('#title').hide();

            $('html, body').animate({
                scrollTop: $("#edit-form").offset().top
            }, 400);
        },
        error: function () {
            alert("Không thể lấy thông tin smartphone.");
        }
    });
}

// Gửi cập nhật
function submitEdit(event) {
    event.preventDefault();

    let id = $('#edit-id').val();
    let updatedPhone = {
        producer: $('#edit-producer').val().trim(),
        model: $('#edit-model').val().trim(),
        price: parseFloat($('#edit-price').val())
    };

    if (!updatedPhone.producer || !updatedPhone.model || isNaN(updatedPhone.price)) {
        alert("Vui lòng nhập đầy đủ và đúng định dạng.");
        return;
    }

    $.ajax({
        type: "PUT",
        url: `http://localhost:8080/api/smartphones/${id}`,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        data: JSON.stringify(updatedPhone),
        success: function () {
            alert("Cập nhật thành công!");
            $('#edit-form').hide();
            successHandler();
            $('html, body').animate({ scrollTop: 0 }, 300);
        },
        error: function () {
            alert("Cập nhật thất bại.");
        }
    });
}

// Hủy form sửa
function cancelEditForm() {
    $('#edit-form').hide();
    $('#smartphoneList').show();
    $('#title').show();
}
