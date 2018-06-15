# Students-result-fetching-program
Fetches Students result from JNTUH result site and combine into pdf file

Note: The code provided here is partial code, because if every student tries to fetch every other students result then the website server will crash and it will act as DDOS attack

### How this code works

Libraries to include: Selenium, HTMLUnit driver, Itextpdf, Jtidy

This program goes to result website such as 

http://epayments.jntuh.ac.in/results/

![image]()

or

http://202.63.105.184/RESULT/homepage.jsp?id=1&name=BTEH_1277

![image]()

Using HTMLUnit driver

The program will then insert the values such as hallticket id, date of birth and captcha and stores the result for each student.
It then combine everyone's result in a pdf file.

### Features
- Toppers list at start of pdf
- Red color background row for failed subjects and Green color background row for passed subjects


## Screenshots

Please refer pdf:

