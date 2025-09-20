function showfunction(){
    fetch("http://localhost:8080/register")
    .then((response) => response.json())
    .then((course) =>{
        var detail=document.getElementById("tablede");
        let r="";
        course.forEach((course) => {
            r+=`<tr>
            <td>${course.id}</td>
            <td>${course.name}</td>
            <td>${course.email}</td>
            <td>${course.course}</td>
            </tr>`;
            
        });
        detail.innerHTML=r;
    });
}