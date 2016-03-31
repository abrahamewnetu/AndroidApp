package abrahamewnetu.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by abrahamewnetu on 3/7/16.
 */
public class MyDBHelper extends SQLiteOpenHelper {

    private static final String TAG = "Database ";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME ="productDB.db";
    private static final String TABLE_PRODUCTS ="products";
    public static final String COLUMN_ID =" id";
    private static final String COLUMN_PRODUCTNAME="productname";
    private static final String COLUMN_QUANTITY ="quantity";

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                      int version){
        super(context,DATABASE_NAME,factory,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String st = "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_PRODUCTNAME +
                "TEXT, " + COLUMN_QUANTITY + " INTEGER " + ")";

        Log.d(TAG, "product table created");
        db.execSQL(st);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IN EXISTS " + TABLE_PRODUCTS);
        onCreate(db);

    }

    public void addProduct(Product p){
        ContentValues values = new ContentValues();//helps to insert new row into the table
        values.put(COLUMN_PRODUCTNAME,p.getProductName());
        values.put(COLUMN_QUANTITY, p.getQuantity());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS,null, values);
        Log.d(TAG, "Inserted " + p.getProductName() + "" + p.getQuantity());
        db.close();
    }

    public Product findProduct(String s){
        String select = "productname  = \"" + s + "\"";
        String query = "Select * FROM " + TABLE_PRODUCTS + "where " + select;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Product p = new Product();
        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            p.setId(Integer.parseInt(cursor.getString(0)));
            p.setProductName(cursor.getString(1));
            p.setQuantity(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        }

        else
            p = null;
        return p;
    }

    public boolean deleteProduct(String s){
        boolean result = false;
        String query = "Select * from " + TABLE_PRODUCTS + " where " + COLUMN_PRODUCTNAME +
                " =\"" + s + "\"";
        SQLiteDatabase db = getWritableDatabase();
        Product p = new Product();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            p.setId(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_PRODUCTS, COLUMN_ID + "=?",
                    new String[]{String.valueOf(p.getId())});
            cursor.close();
            result = true;

        }
        db.close();
        return result;
    }
}
