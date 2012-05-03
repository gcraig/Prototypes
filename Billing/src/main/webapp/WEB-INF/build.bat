@echo off
java -version
javac -version

set classpath=.;C:\biz\WEB-INF\lib\struts.jar;C:\bea\weblogic81\server\lib\weblogic.jar

cd classes


javac -d . -classpath %CLASSPATH% com\csr\invoice\*.java
javac -d . -classpath %CLASSPATH% com\csr\invoice\dao\*.java
javac -d . -classpath %CLASSPATH% com\csr\invoice\action\*.java
javac -d . -classpath %CLASSPATH% com\csr\setup\action\*.java

pause