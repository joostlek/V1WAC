document.getElementById("btn_7").addEventListener("click", function() {add(document.getElementById("btn_7").innerHTML)});
document.getElementById("btn_8").addEventListener("click", function() {add(document.getElementById("btn_8").innerHTML)});
document.getElementById("btn_9").addEventListener("click", function() {add(document.getElementById("btn_9").innerHTML)});
document.getElementById("btn_4").addEventListener("click", function() {add(document.getElementById("btn_4").innerHTML)});
document.getElementById("btn_5").addEventListener("click", function() {add(document.getElementById("btn_5").innerHTML)});
document.getElementById("btn_6").addEventListener("click", function() {add(document.getElementById("btn_6").innerHTML)});
document.getElementById("btn_1").addEventListener("click", function() {add(document.getElementById("btn_1").innerHTML)});
document.getElementById("btn_2").addEventListener("click", function() {add(document.getElementById("btn_2").innerHTML)});
document.getElementById("btn_3").addEventListener("click", function() {add(document.getElementById("btn_3").innerHTML)});
document.getElementById("btn_0").addEventListener("click", function() {add(document.getElementById("btn_0").innerHTML)});
document.getElementById("btn_div").addEventListener("click", function() {add(document.getElementById("btn_div").innerHTML)});
document.getElementById("btn_prod").addEventListener("click", function() {add(document.getElementById("btn_prod").innerHTML)});
document.getElementById("btn_min").addEventListener("click", function() {add(document.getElementById("btn_min").innerHTML)});
document.getElementById("btn_plus").addEventListener("click", function() {add(document.getElementById("btn_plus").innerHTML)});
document.getElementById("btn_eq").addEventListener("click", function() {document.getElementById("display").innerHTML = eval(document.getElementById("display").innerHTML)});
document.getElementById("btn_clear").addEventListener("click", function() {document.getElementById("display").innerHTML = "0"});

function add(number) {
    document.getElementById("display").innerHTML = document.getElementById("display").innerHTML + number;
}
