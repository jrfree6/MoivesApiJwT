## MoviesApiJWT

 What You Need
* Java 8 
* Maven  
* Git
* h2Database

Api Documentation:
* http://localhost:8080/swagger-ui.html

Database:
* h2Console: http://localhost:8080/h2-console

Information:
* User: teste@user.com
* Password: @123teste
* JSON :
` {
	"userName" : "userteste",
	"password": "@123teste"	
}
`

Metodos:

UnAuthenticated Route:
 * http://localhost:8080/user/authenticate
 * http://localhost:8080/user/getUser
 * http://localhost:8080/user/saveUser     
 * http://localhost:8080/movies/stats/Available
 * http://localhost:8080/movies/stats/ByGenre
 
Authenticated Route:
* http://localhost:8080/movies/deleteMovie
* http://localhost:8080/movies/getAllMovies
* http://localhost:8080/movies/getMovie
* http://localhost:8080/movies/saveMovie
 
Authentication type
* Authorization: Bearer "token"

---

Develop by jrfree6 :wave:
