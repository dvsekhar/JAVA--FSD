
    function text1() {
        var answer1 = document.getElementById("ans1");
        answer1.style.display = (answer1.style.display === 'none') ? 'block' : 'none';
    }

    function text2() {
        var answer2 = document.getElementById("ans2");
        answer2.style.display = (answer2.style.display === 'none') ? 'block' : 'none';
    }

    function text3() {
        var answer3 = document.getElementById("ans3");
        answer3.style.display = (answer3.style.display === 'none') ? 'block' : 'none';
    }
    
    var addonCount = 1;

        function addTask() {
            addonCount++;

            var newAddon = document.createElement("div");
            newAddon.className = "addon";
            newAddon.id = "addon" + addonCount;
            newAddon.style.display = 'block';

            newAddon.innerHTML = `
                <div class="form-details">
                    <label for="task">Task Name:</label>
                    <input type="text" id="task${addonCount}" name="task${addonCount}" placeholder="Task Name">
                </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <div class="form-details">
                    <label for="cost">Cost Price:</label>
                    <input type="text" id="cost${addonCount}" name="cost${addonCount}" placeholder="Cost Per Day">
                </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <div class="form-details">
                    <label for="days">Estimate Duration:</label>
                    <input type="text" id="days${addonCount}" name="days${addonCount}" placeholder="Days">
                </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <div class="form-details">
                    <label for="total">Total:</label>
                    <span id="total${addonCount}">0</span>
                </div>
            `;

            document.getElementById("formContainer").appendChild(newAddon);
            
            newAddon.querySelectorAll('input[type="text"]').forEach(input => {
            input.addEventListener('input', () => calculateTotal(addonCount));
            });
            

        }
        
        function calculateTotal(index) {
            var costInput = document.getElementById("cost" + index);
            var daysInput = document.getElementById("days" + index);
            var totalSpan = document.getElementById("total" + index);

            var cost = parseFloat(costInput.value) || 0;
            var days = parseFloat(daysInput.value) || 0;

            var total = cost * days;
            totalSpan.innerHTML = isNaN(total) ? "0" : total.toFixed(2);
        }
        
        function budgetForm(event) {
        event.preventDefault(); 
        
        const estimationId = document.getElementById('estimation').value;
        const projectName = document.getElementById('name').value;
        const clientName = document.getElementById('name1').value;
        const startDate = document.getElementById('startdate').value;
        const endDate = document.getElementById('enddate').value;

        
        var totalSum = 0;
        var currentAddon = 1;

        while (document.getElementById("total" + currentAddon)) {
            var totalSpan = document.getElementById("total" + currentAddon);
            var totalValue = parseFloat(totalSpan.innerHTML) || 0;
            totalSum += totalValue;

            currentAddon++;
        }
        
        const message = `Total estimation is ${totalSum} <br> for the following details: &nbsp;
        Estimation Id: ${estimationId},
        Project Name: ${projectName},
        Client Name: ${clientName},<br>
        Start Date: ${startDate},
        End Date: ${endDate}.
        `;

        const output = document.getElementById('output');
        output.innerHTML = message;
        }
        
        