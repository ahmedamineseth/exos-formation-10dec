function load() {
    let paysSelected = document.getElementById('pays').value;
    console.log(paysSelected);

    /*
    Ajax en utilisant jquery
    $.ajax({
        url: paysSelected + ".html",
        success: function(result) {
            document.getElementById('ville').innerHTML = result
        }
    });*/

    /*
    Ajax en utilisant fetch API
    */

    fetch(paysSelected + ".html") // si on ne spécifie rien, l'appel fait est un GET
        .then(res => {
            return res.text(); // extraction du texte à partir de l'objet response de fetch API
        })
        .then(data => {
            document.getElementById('ville').innerHTML = data;
        })
        .catch(error => alert("Erreur : " + error));


    /* var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        // instructions of anonymous function
        if ((xhr.readyState == 4) && (xhr.status == 200)) { // tout s'est passé correctement coté serveur 
            document.getElementById('ville').innerHTML = xhr.responseText
        }

        if (xhr.status == 404) {
            alert("Veuiullez vérifier l'url");
        }
    };

    xhr.open("GET", paysSelected + ".html", true);
    xhr.send(); */



}

function saveData() {
    let obj = {
        nom: document.getElementById('nom').value,
        prenom: document.getElementById('prenom').value,
        datenaissance: document.getElementById('datenaissance').value,
        adresse: document.getElementById('adresse').value,
        pays: document.getElementById('pays').value,
        ville: document.getElementById('ville').value
    }

    //var obj = new FormData(document.getElementById('login-form'));

    console.log(obj);

    fetch("show.php", {
        method: "POST",
        cache: 'no-cache',
        body: JSON.stringify(obj)
    }).then(res => {
        console.log(res)
        alert("Enregistrement effectué avec succès")

        listInput = document.getElementsByTagName('input');
        for (let index = 0; index < listInput.length; index++) {
            const element = listInput[index];
            element.value = "";
        }

    });




    return false;
}

// je lance une action 
//-> si ça se fait correctement , je fais une 2ème action
//-> si on a une erreur, je fais rien