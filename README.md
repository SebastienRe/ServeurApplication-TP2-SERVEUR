asadmin undeploy TP

asadmin start-domain

asadmin create-jdbc-connection-pool --datasourceclassname org.postgresql.ds.PGSimpleDataSource --restype javax.sql.ConnectionPoolDataSource --property portNumber=5432:password=3tud14nt:user=etdsn:serverName=pedago.univ-avignon.fr:databaseName=coursSN CoursSNPool

asadmin create-jdbc-resource --connectionpoolid CoursSNPool jdbc/courSN