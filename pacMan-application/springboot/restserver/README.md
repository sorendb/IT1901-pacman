# Restserver
The springboot/restserver module manages the entire process related to saving high scores, as well as retrieving them for the purpose of generating a leaderboard at the end of the game. To implement this functionality, a REST server is created using the Spring Boot framework. 

## Classes: 
  - PacManModelApplication
  - PacManModelController
  - PacManModelService

## PacManModelApplication
This class only has one method, which is the main method that is used to bootstrap and launch the Spring application. 

## PacManModelController
In a Spring Boot REST application, we need a controller that handles HTTP requests and defines the endpoints of our RESTAPI. In this class, we have a method that uses @GetMapping to request all highscores from the server. We also have a method that uses @PutMapping to add a new highscore to the database.

It imports necessary classes, including Spring's annotations for RESTful web services (@RestController, @RequestMapping, @GetMapping, @PutMapping), and the PacManUser class.

The @RequestMapping("/api/highscores") annotation at the class level specifies that all endpoints in this controller will be relative to "/api/highscores". 

The "@Autowired" annotation is used to inject a "PacManModelService" instance into the controller. This implies that there exists a service class, PacManModelService, responsible for encapsulating the logic associated with saving and retrieving PacMan highscores from the database via the persistence class.

## PacManModelService
 PacManModelService is used as a service class, meaning that it's methods deal with the interacting with PacMan highscores. The method called getHighScores fetches the highscores from the database, and the addHighScore method adds a new highscore. The two methods uses the PacManPersistence class in order to interact with the PacMan highscores.


## Approach to testing of the springboot/restserver module: 

There is one test class for the springboot/restserver module. 
<br>
The approach to testing has been a two-part process.
<br>
The first part tests the RemotePacManModelController class. The testing here relates to the GET- and PUT-methods of the controller. This is done to ensure that the program is able to transfer information between the HTTP request and the service class.
<br>
The second part tests the PacManModelService class. This part tests that the information sent to the rest-server with addHighScore() is the same as the information returned with getHighscores().
<br>
The scores stored from the tests are deleted upon the test's completion.
<br>
![Spring Boot Test Coverage](/pacMan-application/docs/release3/jacoco3/springbootTestCoverage.png)
<br>
The PacManModelController has a lower test coverage because of duplicate methods that were necessary to seperate test scores from real scores earned in game. Test scores are sent to a different JSON file and deleted upon the test's completion.
<br>

![Controller test coverage](/pacMan-application/docs/release3/jacoco3/PacManModelControllerTestCoverage.png)
<br>
![Detailed controller test coverage](/pacMan-application/docs/release3/jacoco3/detailedTestCoverageInController.png)
<br>
Both sets of get and put methods are identical, the only difference is where the score is stored.