/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function deleteBus(endpoint,id){
    if (confirm("Bạn chắc chắn xóa không?") === true) {
    fetch(endpoint,{
        method:"delete"
    }).then((res) => {
        if(res.status == 204){
            document.getElementById(`bus${id}`).style.display = "none";
        }else{
            alert("Lỗi hệ thống khi xóa bus!!")
        }
    });
    }
}
