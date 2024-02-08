javac bean_session\*a 

jar cvf TP_bean_session.jar META-INF bean_session/*s # qui est normalement vide

asadmin deploy --force TP_bean_session.jar

Copy-Item TP_bean_session.jar ../CLIENT/TP_bean_session.jar -Force # Copy the jar to the client