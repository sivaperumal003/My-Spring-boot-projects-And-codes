 function showFunction(){
    fetch("http://localhost:8080/course")
    .then ((response) => response.json())
    .then((course) => {
     var detail=document.getElementById("courseT");
     let r="";
     course.forEach((course) => {
        r+= `<tr><td>${course.id}</td>
                 <td>${course.duration}</td>
                 <td>${course.faculty}</td> 
                 <td>${course.name}</td>
                 
                 
                 </tr>`;
        
     });
     detail.innerHTML=r;
    });
}