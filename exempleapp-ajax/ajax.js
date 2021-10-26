function load(page) {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        // instructions of anonymous function
        console.log("ready state ok");
        if ((xhr.readyState == 4) && (xhr.status == 200)) { // tout s'est passé correctement coté serveur 
            console.log(xhr.responseText);
            document.getElementById('principal').innerHTML = xhr.responseText
        }
    };

    xhr.open("GET", page + ".html", true);
    xhr.send();
}