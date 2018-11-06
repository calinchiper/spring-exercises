
# A gentle introduction to Spring Boot

![](http://blog.nnadozieomeonu.com/wp-content/uploads/2018/04/spring-boot.png)

### Exercises

*We need to implement a 3-layered web application that expose a REST service using Spring Boot technology*

#### I. JPA/Hibernate Entity
1. In `entity` package create a `Plain Old Java Object` called `Student`
2. Add the following `private` properties: `long` id, `String` firstName, `String` lastName, `String` email, `int` age;
3. Implement (or Generate) setters and getters
4. Mark your class as a JPA `@Entity`
5. Mark the `id` property with JPA annotations: `@Id` and `@GeneratedValue(strategy = GenerationType.IDENTITY)`


#### II. Spring Data Repository
1. Create an interface called `StudentRepository` and annotate it with `@Repository`
2. Extend your interface with Spring Data interface `CrudRepository<Student, Long>`
where the first generic parameter represent the entity used for saving and the second one represent
the type of the `id`. 
3. You're very amused that how an interface with literally no implemented methods can be used for 
saving stuff into the database. Well this is the power of Spring you'll discover soon.

#### II. Spring Dependency Injection & `@Service` Annotation

1. Create an interface called `StudentService` that has the following abstract methods: 
   
    * createStudent
    * getStudentById
    * updateStudent
    * deleteStudent
    * getAllStudents
 
2. Create an implementation class called `StudentServiceImpl` in same package where `StudentService` is declared
    
    * Implement `StudentService` interface (using `implements` keyword)
    * Mark your service class with `@Service` annotation. Now Spring DI Container registered your implementation.

3. Now the next step is to implement every method from the `StudentService` interface but first we need a class that
is responsible for saving/persisting the data in our database. In our case we need the `StudentRepository`

    * Declare `StudentRepository` as a `private` instance variable for the `StudentServiceImpl` class.
    * Use a setter or the constructor to inject the `StudentRepository` into the class
    * Annotate the setter or the constructor with `@Autowired`: Spring will automatically "wire" the interface to the 
    concrete implementation

4. Now it's time to implement the methods


#### II. Spring REST Controller

1. Add another class to the `controller` package called `StudentController`. This controller will be used to model a `RESTful` web service
2. Add the `@RestController` annotation to the class.
3. Declare the following methods:

  * createStudent
  * getStudent
  * updateStudent
  * deleteStudent
  * getAllStudents
  
4. By default, REST controllers will serialize and deserialize Java classes into `JSON` data using the `Jackson 2 JSON library`, which is currently on the classpath by default.
5. What are the arguments and the return type of those methods since we need to call the `StudentService`. Try to write them down. 
6. Using the `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, `@RequestBody`, `@RequestParam` annotation map each method to a REST endpoint 

Endpoint description:

  - "/students" with POST method - create student
  - "/students" with GET method - get all students
  - "/students/id" with GET method - get student by id
  - "/students/id" with PUT method - update student 
  - "/students/id" with DELETE method - delete student by id
