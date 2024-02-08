javac bean_entity\*a -d .

rm bean_entity\*_*

jar cvf TP_bean_entity.jar META-INF bean_entity/*s

asadmin deploy --force TP_bean_entity.jar

Copy-Item TP_bean_entity.jar ../CLIENT/TP_bean_entity.jar -Force # Copy the jar to the client