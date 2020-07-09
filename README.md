# GreetingRestApis
This is PAILEE-GREET-APP project for java rest api's using JAX-RS..

This has been successfully deployed into AWS EC2 instance linux server.

Below are the required software details install into this server.

1) JDK 1.8
2) Tomcat 7 or Tomcat8.
3) MySQL server

Below are the API's Tested

1) GET-->http://ec2-54-166-140-225.compute-1.amazonaws.com:8080/PAILEE-GREET-APP/api/users?start=0&limit=10
2) POST-->http://ec2-54-166-140-225.compute-1.amazonaws.com:8080/PAILEE-GREET-APP/api/users 

body json
{
 	"firstName":"XXXX",
	 "lastName":"YYYY",
	"email":"XXXXX@gmail.com",
	"password":"XXXXXX"
}
3) PUT-->http://ec2-54-166-140-225.compute-1.amazonaws.com:8080/PAILEE-GREET-APP/api/users/Ziu72dKsFr1crOMCoSexQwAuKM66Nq
4) DELETE-->http://ec2-54-166-140-225.compute-1.amazonaws.com:8080/PAILEE-GREET-APP/api/users/RPJxeRSqJKICXrA1Y0wfeov33HahoV
5) GET-->http://ec2-54-166-140-225.compute-1.amazonaws.com:8080/PAILEE-GREET-APP/api/users

