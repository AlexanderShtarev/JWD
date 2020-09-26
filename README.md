# JWD
>mkdir app 
>mkdir model 
>move Point.java model
>move Main.java app 
>move slf4j-api-1.7.15.jar lib
>move slf4j-simple-1.7.15.jar lib
>javac -cp lib\slf4j-api-1.7.15.jar;  lib\slf4j-simple-1.7.15.jar -d app 
>Main.java 
>Point.java 
>xcopy C:\Users\Nastya\IdeaProjects\Task02\app C:\Users\Nastya\Desktop\Task02 /s /e Main.class Point.class
>xcopy C:\Users\Nastya\IdeaProjects\Task02\lib C:\Users\Nastya\Desktop\Task02 /s /e lib\slf4j-api-1.7.15.jar lib\slf4j-simple-1.7.15.jar
java -cp app;lib\slf4j-api-1.7.15.jar;lib\slf4j-simple-1.7.15.jar
