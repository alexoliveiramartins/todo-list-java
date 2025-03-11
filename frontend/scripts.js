var testTasks = [
    {
        name: "Almocar",
        description: "Comprar marmita",
        dueDate: "2025-02-26T23:13",
        priority: 4,
        category: "Health",
        status: "done",
        alarms: ["2025-02-26T23:11", "2025-02-26T23:15"],
    },
    {
        name: "Andar",
        description: "Andar no parque",
        dueDate: "2025-02-27T10:59",
        priority: 4,
        category: "Health",
        status: "done",
        alarms: ["2005-03-04T00:00"],
    },
    {
        name: "Estudar",
        description: "Trilha de Testes unitarios",
        dueDate: "2025-02-27T09:23",
        priority: 5,
        category: "pessoal",
        status: "todo",
        alarms: [],
    },
    {
        name: "Ir ao mercado",
        description: "Checar lista de compras",
        dueDate: "2025-02-26T23:13",
        priority: 4,
        category: "Health",
        status: "todo",
        alarms: ["2025-02-26T23:16"],
    },
    {
        name: "Refatorar codigo",
        description: "Arrumar bugs",
        dueDate: "2025-02-27T10:58",
        priority: 5,
        category: "Codigo",
        status: "todo",
        alarms: ["2025-02-27T11:37"],
    },
    {
        name: "Workout",
        description: "Go to the gym",
        dueDate: "2025-02-26T23:13",
        priority: 4,
        category: "Health",
        status: "done",
        alarms: ["2025-02-26T23:11", "2025-02-26T23:15"],
    },
];

// carrega as tasks pelo json (testTasks)
var loadTasks = function () {
    document.getElementById("tasks").innerHTML = "";

    for (var a = 0; a < testTasks.length; a++) {
        document.getElementById("tasks").innerHTML += `
    <li class="taskItem" taskIndex="${a}">
        <div class="taskBody">
            <input type="checkbox" id="task-${a}" ${
            testTasks[a].status === "done" ? "checked" : ""
        }>
            <label for="task-${a}">
                <h3>${testTasks[a].name}</h3>
                <sub class="descriptionOnList">${testTasks[a].description}</sub>
            </label>
        </div>

        <button class='editButton' taskIndex="${a}">
            <img class='editSvg' src='assets/edit.svg' />
        </button>
    </li>
  `;
    }

    taskListeners();
};
loadTasks();

function taskListeners() {
    var taskItems = document.querySelectorAll(".taskItem");
    taskItems.forEach((task) => {
        task.addEventListener("click", function (event) {
            if (
                event.target.tagName.toLowerCase() === "input" ||
                event.target.tagName.toLowerCase() === "label"
            )
                return;

            const checkbox = task.querySelector("input[type='checkbox']");
            checkbox.checked = !checkbox.checked;

            const index = task.getAttribute("taskIndex");
            testTasks[index].status = checkbox.checked ? "done" : "todo";
        });
    });
    const editButtons = document.querySelectorAll(".editButton");
    editButtons.forEach((button) => {
        button.addEventListener("click", function (event) {
            event.stopPropagation();
            const index = this.getAttribute("taskIndex");
            startEditing(index);
        });
    });
}

// funcao para adicionar outra task
var addNewTask = function (object) {
    loadTasks();
};

// Funcao para enviar o formulario e criar objeto da task nova
const form = document.getElementById("addTaskForm");
form.addEventListener("submit", (event) => {
    event.preventDefault();

    const formData = new FormData(form);

    var taskData = {
        name: formData.get("taskName"),
        description: formData.get("taskDescription"),
        dueDate: formData.get("taskDate"),
        priority: formData.get("taskPriority"),
        category: formData.get("taskCategory"),
        status: isEditing ? testTasks[editingTaskIndex].status : "todo",
        alarms: isEditing ? testTasks[editingTaskIndex].alarms : [],
    };

    // So funciona se a task tiver nome
    if (taskData.name) {
        if (isEditing) {
            testTasks[editingTaskIndex] = taskData;
            console.log("Task updated:", taskData);

            isEditing = false;
            editingTaskIndex = -1;
            submitButton.textContent = "Enter";
            cancelButton.style.display = "none";
        } else {
            testTasks.push(taskData);
            console.log("New task added:", taskData);
        }

        loadTasks();

        // limpar os inputs
        document.querySelectorAll("input").forEach((input) => {
            input.value = "";
        });
    }
});

function startEditing(index) {
    const task = testTasks[index];
    editingTaskIndex = parseInt(index);
    isEditing = true;

    document.querySelector('input[name="taskName"]').value = task.name;
    document.querySelector('input[name="taskDescription"]').value =
        task.description;
    document.querySelector('input[name="taskDate"]').value = task.dueDate;
    document.querySelector('input[name="taskPriority"]').value = task.priority;
    document.querySelector('input[name="taskCategory"]').value = task.category;

    submitButton.textContent = "Confirm Edit";

    // const form = document.getElementById("addTaskForm");
    if (!document.getElementById("cancelEdit")) {
        form.appendChild(cancelButton);
    }
}

function cancelEditing() {
    editingTaskIndex = -1;
    isEditing = false;

    document.querySelectorAll("input").forEach((input) => {
        input.value = "";
    });
}

var isEditing = false;

// logica do botao de editar/enviar nova task
var submitButton = document.createElement("button");
submitButton.id = "submitTask";
submitButton.type = "submit";
submitButton.className = "addTaskButton";
submitButton.textContent = "Enter";
// cancel button
var cancelButton = document.createElement("button");
cancelButton.id = "cancelEdit";
cancelButton.type = "button";
cancelButton.className = "cancelEditButton";
cancelButton.textContent = "Cancel";

document.getElementById("addTaskForm").appendChild(submitButton);

cancelButton.addEventListener("click", function () {
    cancelEditing();
});

document.getElementById("submitTask").addEventListener("click", () => {
    console.log("a");
});
