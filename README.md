# clinic
This is Java Web Application with Servlets and JSP files. Application uses MySql database.
The application uses 3 groups of users. These are patients, medical staff, and administrators. 
Patients are registered and logged. They choose a specific medical department at the clinic, 
then a desired doctor with whom they want to schedule a review and appointment. 
After that, the term is busy. Medical staff is registered and logged. 
Medical doctors-type doctor can see if a patient has scheduled a review with him, 
if he is giving that patient a solitary remedy. This quantity of drugs is removed 
from the main condition, so medication can be ordered in a timely manner without shortage. 
The patient who is examined in the database is marked as being overlooked and no longer 
appears on the list of patients that a particular doctor needs to review, he has performed 
the examination, and the system records it as being reviewed. The last group of users are 
administrators who oversee the whole system. Administrators are logged by default with the 
admin username and admin admin, and they are allowed to register once, set their username 
and password, and after that, administrators can not be added.
The application needs to be deployed on Apache Tomcat server.
