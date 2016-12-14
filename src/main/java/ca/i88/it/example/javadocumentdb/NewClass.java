package ca.i88.it.example.javadocumentdb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

/**
 *
 * @author i88.ca
 */
public class NewClass {

    private static final String DATABASE_ID = "testDB";

    public static void main(String args[]) {
        MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://test-documentdb-mongodb:password@sample-documentdb-mongodb.documents.azure.com:10250/?ssl=true&sslInvalidHostNameAllowed=true"));
        MongoIterable<String> dbs = mongo.listDatabaseNames();
        for (String db : dbs) {
            System.out.println(db);
        }

        MongoDatabase db = mongo.getDatabase(DATABASE_ID);

        db.createCollection("mycol");

        MongoIterable<String> collections = db.listCollectionNames();
        for (String s : collections) {

            System.out.println(s);
        }

        MongoCollection<Document> coll = db.getCollection("mycol");
        System.out.println("Collection mycol selected successfully");
    }

}
