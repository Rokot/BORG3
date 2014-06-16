
package com.example.borganizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DB {
  
  private static final String DB_NAME = "DBorg";
  private static final int DB_VERSION = 1;
  private static final String DB_TABLE1 = "Mitarbeiter";
  private static final String DB_TABLE2 = "Abteilung";
  private static final String DB_TABLE3 = "Privattermin";
  
  //für Tabelle Mitarbeiter
  public static final String COLUMN_ID = "Mitarbeiter_ID";
  public static final String COLUMN_VNAME = "Vorname";
  public static final String COLUMN_NNAME = "Nachname";
  public static final String COLUMN_BNAME = "Benutzername";
  public static final String COLUMN_PW = "Passwort";
  public static final String COLUMN_ABTEILUNG = "Abteilung";
  /////////////////////////////////////////////////////////////
  //für Tabelle Abteilung
  public static final String COLUMN_ABTNAME = "Abteilungsname";
  public static final String COLUMN_ABTLEITER = "Abteilungsleiter";
  /////////////////////////////////////////////////////////////
  // für tabele Privattermin
  public static final String COLUMN_PTNR = "TerminNr";
  public static final String COLUMN_PMID = "Mitarbeiter_ID";
  public static final String COLUMN_PTNAME = "Terminname";
  public static final String COLUMN_PTORT = "Terminort";
  public static final String COLUMN_PTDATUM = "Datum";
  public static final String COLUMN_PTZEIT = "Zeit";
  
  
  
  private static final String DB_CREATE = 
    "create table " + DB_TABLE1 + "(" +
      COLUMN_ID + " text primary key, " +
      COLUMN_VNAME + " text, " +
      COLUMN_NNAME + " text, " +
      COLUMN_BNAME + " text, " +
      COLUMN_PW + " text, " +
      COLUMN_ABTEILUNG + " text" +
    ");"
    + "create table " 
    + DB_TABLE2 + "(" +
    COLUMN_ABTNAME + " text primary key, " +
    COLUMN_ABTLEITER + " text" +
  ");"
  + "create table "
  + DB_TABLE3 + "(" +
  COLUMN_PTNR + " text primary key, " +
  COLUMN_PTNAME + " text, " +
  COLUMN_PMID + " text, " +
  COLUMN_PTORT + " text, " +
  COLUMN_PTDATUM + " date, " +
  COLUMN_PTZEIT + " time" +
");"
  ;
  
  
  private final Context mCtx;
  
  
  private DBHelper mDBHelper;
  private SQLiteDatabase mDB;
  
  public DB(Context ctx) {
    mCtx = ctx;
  }
  
  
  public void open() {
    mDBHelper = new DBHelper(mCtx, DB_NAME, null, DB_VERSION);
    mDB = mDBHelper.getWritableDatabase();
  }
  
  
  public void close() {
    if (mDBHelper!=null) mDBHelper.close();
  }
  
 
  public Cursor getAllData() {
    return mDB.query(DB_TABLE1, null, null, null, null, null, null);
  }
  

  public void addRec(String id, String vname, String nname, String bname, String pw, String abteilung,
		  			 String abtname, String abtleiter) 
  {
    ContentValues tm = new ContentValues();
    ContentValues ta = new ContentValues();
    tm.put(COLUMN_ID, id);
    tm.put(COLUMN_VNAME, vname);
    tm.put(COLUMN_NNAME, nname);
    tm.put(COLUMN_BNAME, bname);
    tm.put(COLUMN_PW, pw);
    tm.put(COLUMN_ABTEILUNG, abtleiter);
    
    ta.put(COLUMN_ABTNAME, abtname);
    ta.put(COLUMN_ABTLEITER, abtleiter);
    mDB.insert(DB_TABLE1, null, tm);
    mDB.insert(DB_TABLE2, null, ta);
  }
  
  
  public void delRec(long id) {
    mDB.delete(DB_TABLE1, COLUMN_ID + " = " + id, null);
    //mDB.delete(DB_TABLE2, COLUMN_ABTNAME + " = " + id, null);
  }
  
  private class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, CursorFactory factory,
        int version) {
      super(context, name, factory, version);
    }

   
    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL(DB_CREATE);
      
      ContentValues tm = new ContentValues();
      
        tm.put(COLUMN_ID, "sometext ");
        tm.put(COLUMN_VNAME, "sometext");
        tm.put(COLUMN_NNAME, "sometext");
        tm.put(COLUMN_BNAME, "sometext");
        tm.put(COLUMN_PW, "sometext");
        tm.put(COLUMN_ABTEILUNG, "sometext");
        db.insert(DB_TABLE1, null, tm);
      
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
  }
}



