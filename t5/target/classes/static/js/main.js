var classe=null;
var robot=null;

function Handlebuttonclass(id) {
    $(document).ready(function () {
        console.log('Hai cliccato sul bottone delle classi con id: ' + id);
         classe=id;
    });
}
function Handlebuttonrobot(id) {
    $(document).ready(function () {
        console.log('Hai cliccato sul bottone del robot con id: ' + id);
        robot=id;
    });
}

function redirectToPagereport() {
    console.log(classe);
    console.log(robot);
    if(classe  && robot ){
        window.location.href = "/report";
    }
    else{
        alert("Seleziona una classe e un robot");
        console.log("Seleziona una classe e un robot");
    }
 
}


