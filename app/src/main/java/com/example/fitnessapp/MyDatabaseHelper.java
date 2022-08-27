package com.example.fitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String databaseName="fitnessAppDatabase";

    private static final int databaseVersion = 5;

    private static final String table_name="userinfo";
    private static final String username_col="username";
    private static final String password_col="password";
    private static final String age_col="age";
    private static final String height_col="height";
    private static final String weight_col="weight";
    private static final String weightGoal_col="weightGoal";
    private static final String sex_col="sex";




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
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
          String userInfoTableCreation =
                "CREATE TABLE " + table_name+"("
                        +"username_col text primary key, "
                        +"password_col text,"
                        +"age_col text,"
                        +"height_col text,"
                        +"weight_col text,"
                        +"weightGoal_col text,"
                        +"sex_col text)";
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
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
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

    public void addNewUsername(String usernamelog){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(usernamelog,username_col);
       /*db.insert(table_name,null,values);*/
        db.close();
    }
    public void addNewPassword(String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(password,password_col);
        /*db.insert(table_name,null,values);*/

        db.close();
    }
    public void addNewAge(String age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(age,age_col);

        db.insert(table_name,null,values);
        db.close();
    }
    public void addNewHeight(String height){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(height,height_col);


        db.insert(table_name,null,values);
        db.close();
    }
    public void addNewWeight(String weight){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(weight,weight_col);


        db.insert(table_name,null,values);
        db.close();
    }

    public void addNewWeightGoal(String weightgoal){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(weightgoal,weightGoal_col);


        db.insert(table_name,null,values);
        db.close();
    }

    public void addNewSex(String sex){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(sex,sex_col);

        db.insert(table_name,null,values);
        db.close();
    }

}
