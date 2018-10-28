# CSX42: Assignment 3
## Name: Aaditya Sakharam Patil
-----------------------------------------------------------------------
-----------------------------------------------------------------------
###Assuming you are in the directory containing this README
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on project.
#### Note: build.xml is present in workerThreads/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile workerThreads/src/build.xml clean

Description: It cleans up all the .class files that were generated when 
you compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile workerThreads/src/build.xml all

Description: Compiles code and generates .class files inside the BUILD 
folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile workerThreads/src/build.xml run -Darg0=src/input.txt -Darg1=number_of_threads -Darg2=debug_value 

Note: For this command to work correctly place all the files in src directory. 
else, Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
## Description:
Data Structure used for Result:
ArrayList

Threads synchronously store prime numbers in results's ArrayList.
We can check if the entry of a no. already exist to avoid duplicates.

Complexity to add a Number: O(n)
-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 10/28/2018


