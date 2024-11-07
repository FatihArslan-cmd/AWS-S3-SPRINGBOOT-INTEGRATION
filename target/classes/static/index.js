// Global array to store employees
let employees = [];

// Function to open the modal and handle Add/Edit
function openModal(action, empId = null) {
    const modal = document.getElementById('employeeModal');
    const modalTitle = document.getElementById('modalTitle');
    const empIdField = document.getElementById('empId');
    const empNameField = document.getElementById('empName');
    const empJobField = document.getElementById('empJob');
    const empHireDateField = document.getElementById('empHireDate');
    const empSalField = document.getElementById('empSal');
    const empCommField = document.getElementById('empComm');
    const empDeptField = document.getElementById('empDept');
    const empMgrField = document.getElementById('empMgr');

    if (action === 'add') {
        modalTitle.innerText = 'Add Employee';
        empIdField.value = '';
        empNameField.value = '';
        empJobField.value = '';
        empHireDateField.value = '';
        empSalField.value = '';
        empCommField.value = '';
        empDeptField.value = '';
        empMgrField.value = '';
    } else if (action === 'edit' && empId !== null) {
        const emp = employees.find(e => e.id === empId);
        modalTitle.innerText = 'Edit Employee';
        empIdField.value = emp.id;
        empNameField.value = emp.name;
        empJobField.value = emp.job;
        empHireDateField.value = emp.hireDate;
        empSalField.value = emp.salary;
        empCommField.value = emp.commission;
        empDeptField.value = emp.department;
        empMgrField.value = emp.manager;
    }
    modal.style.display = 'flex';
}

// Close modal
function closeModal() {
    const modal = document.getElementById('employeeModal');
    modal.style.display = 'none';
}

// Handle image upload
function handleImageUpload(input) {
    const empAvatar = document.getElementById('empAvatar');
    const file = input.files[0];
    const reader = new FileReader();

    reader.onload = function (e) {
        empAvatar.src = e.target.result;
    }

    if (file) {
        reader.readAsDataURL(file);
    }
}

// Save Employee Data
function saveEmployee() {
    const empId = document.getElementById('empId').value;
    const empName = document.getElementById('empName').value;
    const empJob = document.getElementById('empJob').value;
    const empHireDate = document.getElementById('empHireDate').value;
    const empSal = document.getElementById('empSal').value;
    const empComm = document.getElementById('empComm').value;
    const empDept = document.getElementById('empDept').value;
    const empMgr = document.getElementById('empMgr').value;

    const employee = {
        id: empId,
        name: empName,
        job: empJob,
        hireDate: empHireDate,
        salary: empSal,
        commission: empComm,
        department: empDept,
        manager: empMgr
    };

    employees.push(employee);
    updateEmployeeTable();
    closeModal();
}

// Update the Employee Table
function updateEmployeeTable() {
    const employeeTableBody = document.getElementById('employees');
    employeeTableBody.innerHTML = '';

    employees.forEach(emp => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.job}</td>
            <td>${emp.manager}</td>
            <td>${emp.hireDate}</td>
            <td>${emp.salary}</td>
            <td>${emp.commission}</td>
            <td>${emp.department}</td>
            <td><img src="images.png" alt="Avatar Placeholder"></td>
            <td class="actions">
                <button class="edit-btn" onclick="openModal('edit', '${emp.id}')">Edit</button>
                <button class="delete-btn" onclick="deleteEmployee('${emp.id}')">Delete</button>
            </td>
        `;
        employeeTableBody.appendChild(row);
    });
}

// Delete Employee
function deleteEmployee(empId) {
    employees = employees.filter(emp => emp.id !== empId);
    updateEmployeeTable();
}
