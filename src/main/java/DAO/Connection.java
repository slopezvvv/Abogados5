/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import java.util.Arrays;
import javax.swing.text.Document;

/**
 *
 * @author yo
 */
public abstract class Connection implements InterCliente{
    private MongoCollection collection;
    private static final String user = "";
    protected static final String database = "WEB_DB";
    private char[] password = new char[]{};
    
    private static MongoClient m;
    
    // CTOR
    public Connection(String collectionName){
        checkCollection(collectionName);
        loginMongoDB();
    }
    
   
    // Encapsulamiento
    protected final MongoClient getClient(){
        return m;
    }
    protected final MongoCollection getCollection(){
        return this.collection;
    }
    // METODOS CUSTOM
    private final void loginMongoDB(){
        MongoCredential credential = MongoCredential.createCredential(user, database, password);

        MongoClientSettings settings = MongoClientSettings.builder()
            .credential(credential)
            .applyToSslSettings(builder -> builder.enabled(true))
            .applyToClusterSettings(builder -> 
                builder.hosts(Arrays.asList(
                        new ServerAddress("localhost", 27017)
                    )
                )
            )
            .build();
        m = MongoClients.create(settings);
    }
     
    private void checkName(String collectionName) throws IllegalArgumentException{
        this.collection = this.getClient().
            getDatabase(database).
            getCollection(collectionName);
    }
    
    private void createName(String collectionName) throws IllegalArgumentException{
        checkName(collectionName);
        this.getClient().
            getDatabase(database).
            createCollection(collectionName);
    }
    
    protected final void checkCollection(String collectionName){
        try{
            checkName(collectionName);
        }
        catch(IllegalArgumentException iae){
            String m = String.format(
                "Connection warning:\n %s\n%s .\n",
                iae.getMessage(), iae.getCause());
            System.out.println(m);
            createName(collectionName);
        }
    }
}
