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
    for (var a = 0; a < testTasks.length; a++) {
        document.getElementById("tasks").innerHTML += `
    <li class="taskItem">
        <div class="taskBody">
            <input type="checkbox" id="task-${a}">
            <label for="task-${a}">
                <h3>${testTasks[a].name}</h3>
                <sub class="descriptionOnList">${testTasks[a].description}</sub>
            </label>
        </div>

        <button class='editButton'>
            <img class='editSvg' src='assets/edit.svg' />
        </button>
    </li>
  `;
    }
};
loadTasks();
// funcao para adicionar outra task
var addNewTask = function (object) {
    document.getElementById("tasks").innerHTML += `
    <li class="taskItem">
        <div class="taskBody">
            <input type="checkbox" id="task-${testTasks.length + 1}">
            <label for="task-${testTasks.length + 1}">
                <h3>${object.name}</h3>
                <sub class="descriptionOnList">${object.description}</sub>
            </label>
        </div>

        <button class='editButton'>
            <img class='editSvg' src='assets/edit.svg' />
        </button>
    </li>
  `;
};

// Funcao para enviar o formulario e criar objeto da task nova
const form = document.getElementById("addTaskForm");
form.addEventListener("submit", (event) => {
    event.preventDefault();

    const formData = new FormData(form);

    // So funciona se a task tiver nome
    if (formData.get("taskName")) {
        var newTask = {
            name: formData.get("taskName"),
            description: formData.get("taskDescription"),
            dueDate: formData.get("taskDate"),
            priority: formData.get("taskPriority"),
            category: formData.get("taskCategory"),
            status: formData.get("taskStatus"),
            alarms: "",
        };
        testTasks.push(newTask);
        addNewTask(newTask);
        console.log(testTasks);

        // limpar os inputs
        document.querySelectorAll("input").forEach((input) => {
            input.value = "";
        });
    }
});

// toggle check task quando clica na task inteira
taskItems.forEach((task) => {
    task.addEventListener("click", function (event) {
        if (event.target.tagName.toLowerCase() === "input") return;

        if (event.target.tagName.toLowerCase() === "label") {
            event.preventDefault();
        }

        const checkbox = task.querySelector("input[type='checkbox']");
        checkbox.checked = !checkbox.checked;
    });
});

taskItems.forEach((task) => {
    const editButton = task.querySelector(".editButton");
    if (editButton) {
        editButton.addEventListener("click", function (event) {
            event.stopPropagation();
            console.log("A");
        });
    }
});
