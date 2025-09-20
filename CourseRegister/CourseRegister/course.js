function showFunction() {
    fetch("http://localhost:8080/course")
        .then((response) => response.json())
        .then((courses) => {
            const detail = document.getElementById("coursedetab");
            let rows = "";

            courses.forEach((course) => {
                rows += `
                    <tr>
                        <td>${course.id}</td>
                        <td>${course.duration}</td>
                        <td>${course.faculty}</td>
                          <td>${course.name}</td>
                        
                    </tr>`;
            });

            detail.innerHTML = rows;
        })
        .catch((error) => {
            console.error("Error fetching course data:", error);
        });
}
