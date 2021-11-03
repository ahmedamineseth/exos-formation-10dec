<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Welcome to MediCom App</title>
</head>
<body>

	<main class="container">
		<div class="border-1 w-50 mx-auto">
			<form class="p-3">
				<h2 class="h4">Authentification</h2>
				<hr>
				<div class="mb-3 row">
					<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="staticEmail">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="authPassword" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="authPassword">
					</div>
				</div>

				<button type="button" class="btn btn-primary btn-sm"
					onclick="authentifier()">Authentifier</button>
			</form>
		</div>
	</main>

	<script>
		function setCookie(cname, cvalue, exdays) {
			const d = new Date();
			d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
			let expires = "expires=" + d.toUTCString();
			document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
		}

		function authentifier(login, password) {
			login = document.getElementById('staticEmail').value
			password = document.getElementById('authPassword').value
			
			let data = {
				"username" : login,
				"password" : password
			}
			
			fetch("http://localhost:8080/medical7/",
			{
			    method: "POST",
			    cache: 'no-cache',
		        body: JSON.stringify(data)
			})
			.then(function(res){ return res.json(); })
			.then(function(data){ alert( JSON.stringify( data ) ) })
			
			/* if (  ) { // authentification réussie
				setCookie("username", login, 3)
				// login étant le nom d'utilisateur qui vient de s'authentifier
				window.location = "dashboard.html"
			} else {
				alert("Login ou password est incorrect!")
			} */ 

		}
	</script>

</body>
</html>