# Yonder Autumn Internship 2018

## A gentle introduction to Spring Boot

### Exercises

#### I. Spring Dependency Injection & `@Service` Annotation

1. Create an interface called `StudentService` that has the following abstract methods: 
   
    * createStudent
    * getStudentById
    * updateStudent
    * deleteStudent
 
2. Create an implementation class called `StudentServiceImpl` in same package where `StudentService` is declared
    
    * Implement `StudentService` interface (using `implements` keyword)
    * Mark your service class with `@Service` annotation. Now Spring DI Container registered your implementation.

3. Now the next step is to implement every method from the `StudentService` interface but first we need a class that
is responsible for saving/persisting the data in our database. In our case we need to search the `repository` package. 
What we found? An interface called `StudentRepository`. You're very amused that how an interface with literally no 
implemented methods can be used for saving stuff into the database. Well this is the power of Spring you'll discover soon.

    * Declare `StudentRepository` as a `private` instance variable for the `StudentServiceImpl` class.
    * Use a setter or the constructor to inject the `StudentRepository` into the class
    * Annotate the setter or the constructor with `@Autowired`: Spring will automatically "wire" the interface to the 
    concrete implementation

4. Now it's time to implement the methods


#### II. Spring REST Controller

1.  


#### III. Spring REST Client


    