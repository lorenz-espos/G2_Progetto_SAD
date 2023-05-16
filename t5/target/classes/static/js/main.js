var classe=null;
var robot=null;
// Variabile per tenere traccia del bottone precedentemente selezionato
var bottonePrecedente1 = null;
// Variabile per tenere traccia del bottone precedentemente selezionato
var bottonePrecedente2 = null;

function Handlebuttonclass(id,button) {
    $(document).ready(function () {
        classe=id;
         console.log('Hai cliccato sul bottone delle classi con id: ' + classe);
            // Se il bottone precedentemente selezionato è diverso da null
            // allora rimuoviamo la classe highlighted
            if (bottonePrecedente1 != null) {
                bottonePrecedente1.classList.remove("highlighted");
            }
         if (button.classList.contains("highlighted")) {
            button.classList.remove("highlighted");
          } else {
            button.classList.add("highlighted");
          }

          bottonePrecedente1 = button;
    });
}

function Handlebuttonrobot(id,button) {
    $(document).ready(function () {
        robot=id;
        console.log('Hai cliccato sul bottone del robot con id: ' + robot);

            // Se il bottone precedentemente selezionato è diverso da null
            // allora rimuoviamo la classe highlighted
            if (bottonePrecedente2 != null) {
                bottonePrecedente2.classList.remove("highlighted");
            }

        if (button.classList.contains("highlighted")) {
            button.classList.remove("highlighted");
          } else {
            button.classList.add("highlighted");
          }
          bottonePrecedente2 = button;

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

function redirectToPagemain() {
        window.location.href = "/main";
}


