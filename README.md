## MoviesApiJWT

 What You Need
* Java 8 
* Maven  
* Git
* h2Database

Api Documentation:
* http://localhost:8080/swagger-ui.html

Metodos:
* http://localhost:8080/stats 
* http://localhost:8080/user/authenticate 

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

UnAuthenticated Route:
 * /user/getUser
 * /user/saveUser     
 * /movies/stats/Available
 * /movies/stats/ByGenre
 
Authenticated Route:
* /movies/deleteMovie
* /movies/getAllMovies
* /movies/getMovie
* /movies/saveMovie
 
Authentication type
* Authorization: Bearer "token"

---

Develop by jrfree6 :wave:
