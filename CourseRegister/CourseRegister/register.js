function showFunction() {
    fetch("http://localhost:8080/register")
        .then((response) => response.json())
        .then((courses) => {
            const detail = document.getElementById("coursedetab");
            let rows = "";

            courses.forEach((course) => {
                rows += `
                    <tr>
                        <td>${course.id}</td>
                        <td>${course.name}</td>
                        <td>${course.email}</td>
                          <td>${course.course}</td>
                        
                    </tr>`;
            });

            detail.innerHTML = rows;
        })
        .catch((error) => {
            console.error("Error fetching course data:", error);
        });
}
