package tools;

import java.sql.Connection;

import oracle.jdbc.pool.OracleDataSource;

public class DBConnection {

    private Connection connection;
    
    public Connection getConnection(){
        try{
            OracleDataSource ods = new OracleDataSource();
            ods.setDriverType("thin");
            ods.setServerName("localhost");
            ods.setPortNumber(1521);
            ods.setUser("system");
            ods.setServiceName("XE");
            ods.setPassword("MCCMetrodata");
            this.connection = ods.getConnection(); 
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return connection;
        
        		
    }
    

}
