package com.example.fitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String databaseName="fitnessAppDatabase";

    private final String userInfoTableCreation =
            "create table userinfo(username text primary key, "+
                    "password text, "+
                    "age integer, "+
                    "height integer, "+
                    "weight integer, "+
                    "sex text, "+
                    "userloginname text," +
                    "FOREIGN KEY(userloginname) references user(userloginname));";
    private final String userTableCreation =
            "create table user(userloginname text primary key, "+
                    "password text);";

    private final String mealTableCreation =
            "create table meal(mealName text primary key, "+
                    "mealCalorie integer);";

    private final String foodTableCreation =
            "create table food(foodName text primary key, "+
                    "calories integer);";

    private final String containsTableCreation =
            "create table contains(foodName text,"+
                    "mealName text," +
                    "FOREIGN KEY(foodName) REFERENCES food (foodName) ," +
                    "FOREIGN KEY(mealName) REFERENCES meal (mealName));";


    private SQLiteDatabase db;

    public MyDatabaseHelper(Context context){
        super(context, databaseName, null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(userInfoTableCreation);
        db.execSQL(userTableCreation);
        db.execSQL(mealTableCreation);
        db.execSQL(foodTableCreation);
        db.execSQL(containsTableCreation);

        //////////////////////////////////user///////////////////////////////////////////////////
        db.execSQL("insert into user (userloginname,password)"+
                "values ('ahmed','1234')");

        db.execSQL("insert into user (userloginname,password)"+
                "values ('farah','1234')");

        db.execSQL("insert into user (userloginname,password)"+
                "values ('moe','1234')");
        ////////////////////////////////////userinfo////////////////////////////////////////////////
        db.execSQL("insert into userinfo (username,password,age,height,weight,sex,userloginname)"+
                "values ('ahmed','1234',22,1.70,65,'M','ahmed')");

        db.execSQL("insert into userinfo (username,password,age,height,weight,sex,userloginname)"+
                "values ('farah','1234',20,1.60,65,'F','farah')");

        db.execSQL("insert into userinfo (username,password,age,height,weight,sex,userloginname)"+
                "values ('moe','1234',25,1.80,85,'M','moe')");
        ///////////////////////////////////////meal////////////////////////////////////////////
        db.execSQL("insert into meal (mealName,mealCalorie)"+
                "values ('Rice & Chicken',448)");

        db.execSQL("insert into meal (mealName,mealCalorie)"+
                "values ('Grilled 100g Steak',271)");

        db.execSQL("insert into meal (mealName,mealCalorie)"+
                "values ('Macand Chease',164)");
        ///////////////////////////////////food////////////////////////////////////////////////
        db.execSQL("insert into food (foodName,calories)"+
                "values ('Chicken Breast',165 )");

        db.execSQL("insert into food (foodName,calories)"+
                "values ('Banana',89  )");

        db.execSQL("insert into food (foodName,calories)"+
                "values ('Steak',271  )");
        //////////////////////////////////contains/////////////////////////////////////////////////
        db.execSQL("insert into contains (foodName,mealName)"+
                "values ('Chicken Breast','Rice & chicken' )");

        db.execSQL("insert into contains (foodName,mealName)"+
                "values ('Banana','fruit Salad')");

        db.execSQL("insert into contains (foodName,mealName)"+
                "values ('Strawberry','Fruit Salad')");

        db.execSQL("insert into contains (foodName,mealName)"+
                "values ('Orange','Fruit Salad')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS userinfo");
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS meal");
        db.execSQL("DROP TABLE IF EXISTS food");
        db.execSQL("DROP TABLE IF EXISTS contains");
        onCreate(db);
    }

   public boolean check_user(String username){
db=getReadableDatabase();
        Cursor user_pass=db.rawQuery("select * from user where userloginname= ?",new String[]{username});
        return true;

    }
    public boolean checkusernamepassword(String user_name,String password){


SQLiteDatabase db=this.getReadableDatabase();
Cursor mydb =db.rawQuery("select * from user where userloginname =? and password = ?",new String[]{user_name,password});
    if(mydb.getCount()==0) {
        //System.out.println(mydb.getCount());
      //System.out.println("ttttt");
        return true;}
    else
        //System.out.println("rrrrrrr");
        return false ;
    }
}
