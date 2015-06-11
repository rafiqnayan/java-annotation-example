# java-annotation-example
Demonstrates a how annotations work in java and how to access them using Java reflection API.

This project is a simple demonstration of how unit test frameworks use annotations to run tests.

I've created 3 annotations in this project. They are:

`@UnitTest`: indicates this class is a Unit Test class

`@Test`: indicates this method is a unit test method

`@BeforeMethod`: methods annotated with this will run before each test method

Requirements:
-------------
As annotations are integrated in JDK 1.6, you need to have JDK version >= 1.6