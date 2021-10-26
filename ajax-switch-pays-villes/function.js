function load() {
    let paysSelected = document.getElementById('pays').value;
    console.log(paysSelected);

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        // instructions of anonymous function
        if ((xhr.readyState == 4) && (xhr.status == 200)) { // tout s'est passé correctement coté serveur 
            document.getElementById('ville').innerHTML = xhr.responseText
        }
    };

    xhr.open("GET", paysSelected + ".html", true);
    xhr.send();
}