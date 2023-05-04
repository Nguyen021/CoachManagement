/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function ramdomColor(){
    let r = parseInt(Math.ramdon()*255)
    let g = parseInt(Math.ramdon()*255)
    let b = parseInt(Math.ramdon()*255)
    
    return `rgb(${r},${g},${b})`
}
function drawChart(data,label,id,title, type='pie') {
    const ctx = document.getElementById(id);
    
    let colors = []
    for (let i =0; i < data.length; i++)
        colors.push(ramdomColor())
    
    new Chart(ctx, {
        type: type,
        data: {
            labels: label,
            datasets: [{
                    label: title,
                    data: data,
                    borderWidth: 1,
                    backgroundColor: colors
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}