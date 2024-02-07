javac sr\*a 
jar cvf TP.jar META-INF sr/*s
#asadmin undeploy TP
#asadmin start-domain
asadmin deploy --force TP.jar 

# asadmin create-jdbc-connection-pool --datasourceclassname org.postgresql.ds.PGSimpleDataSource --restype javax.sql.ConnectionPoolDataSource --property portNumber=5432:password=admin:user=root:serverName=192.168.56.4:databaseName=courssn CoursSNPool 
# asadmin create-jdbc-resource --connectionpoolid CoursSNPool jdbc/courssn