**App**
**Problem Statement::**

 Gordon Ramsey, a very smart guy, like seating food. Now, Gordon is at a restaurant and he has many different types of food to choose from. Gordon gets x amount of satisfaction and requires y amount of time to eat an item from the menu. Given t minutes, write a java program that reads the text file and ﬁnds out the maximum satisfaction that Gordon can get from eating at the restaurant. You will be given a text file with the following format:
 [t][Number of items on menu]
[amount of satisfaction from eating dish 1][time taken for dish 1]
[amount of satisfaction from dish 2][time taken for dish 2]


**Solution::**

Solved this problem based on the 0-1 knapsack problem where the constrain is time (in this case). And the result would be the maximum satisfaction.


**Development**
The solution is developed in  SpringBoot with TDD.

**Steps to run the Application::**

 - It is developed in java 1.8 Clone the project and run the below
   command.

**mvn spring-boot:run**

the application would be up and running on localhost:8080
**API CALL**
Type:: POST
URI::/maxCalories
params: file (Multipartfile).

Refer to the test cases .

