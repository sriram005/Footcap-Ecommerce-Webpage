
let all = document.getElementById("all");
let nike = document.getElementById("nike");
let adidas = document.getElementById("adidas");
let puma = document.getElementById("puma");
let bata = document.getElementById("bata");

let btn_all = document.getElementById("btn-all");
let btn_nike = document.getElementById("btn-nike");
let btn_adidas = document.getElementById("btn-adidas");
let btn_puma = document.getElementById("btn-puma");
let btn_bata = document.getElementById("btn-bata");

nike.style.display = "none";
adidas.style.display = "none";
puma.style.display = "none";
bata.style.display = "none";

btn_all.classList.add("active");

function showNike() {
    all.style.display = "none";
    adidas.style.display = "none";
    nike.style.display = "grid";
    puma.style.display = "none";
    bata.style.display = "none";

    btn_nike.classList.add("active");
    btn_adidas.classList.remove("active");
    btn_puma.classList.remove("active");
    btn_bata.classList.remove("active");
    btn_all.classList.remove("active");
}

function showAll() {
    all.style.display = "grid";
    nike.style.display = "none";
    adidas.style.display = "none";
    puma.style.display = "none";
    bata.style.display = "none";

    btn_all.classList.add("active");
    btn_adidas.classList.remove("active");
    btn_puma.classList.remove("active");
    btn_bata.classList.remove("active");
    btn_nike.classList.remove("active");
}

function showAdidas() {
    adidas.style.display = "grid";
    nike.style.display = "none";
    all.style.display = "none";
    puma.style.display = "none";
    bata.style.display = "none";

    btn_adidas.classList.add("active");
    btn_nike.classList.remove("active");
    btn_puma.classList.remove("active");
    btn_bata.classList.remove("active");
    btn_all.classList.remove("active");
}

function showPuma(){
    adidas.style.display = "none";
    puma.style.display = "grid";
    nike.style.display = "none";
    all.style.display = "none";
    bata.style.display = "none";

    btn_puma.classList.add("active");
    btn_adidas.classList.remove("active");
    btn_nike.classList.remove("active");
    btn_bata.classList.remove("active");
    btn_all.classList.remove("active");
}

function showBata(){
    adidas.style.display = "none";
    puma.style.display = "none";
    nike.style.display = "none";
    all.style.display = "none";
    bata.style.display = "grid";

    btn_bata.classList.add("active");
    btn_adidas.classList.remove("active");
    btn_puma.classList.remove("active");
    btn_nike.classList.remove("active");
    btn_all.classList.remove("active");
}


function validate(){
    let email = document.getElementById("mail").value;
    let password = document.getElementById("pass").value;

    if(document.getElementById("check").checked){
        if((email=="sriramakrishnan005@gmail.com" && password=="Sriram@005") || (email=="srihari6112003@gmail.com" && password=="Haridevil#7810")){
            window.open('/admin/admin.html','_Self');            
        }
        else
            alert("Enter correct Details");
    }
    else{
        window.open("/index.html","_self");
    }
}