package com.neda.carwarehouse.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import com.neda.carwarehouse.entity.Car;

public class ContentProviderWithHelper extends ContentProvider {

    public static final String CONTENT_AUTHORITY = "ContentProviderWithHelper";
    public static final Uri CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    CarWarhouseRoomDatabase carWarhouseRoomDatabase;

    private static final int MULTIPLE_ROWS_TASKS = 1;
    private static final int SINGLE_ROW_TASKS = 2;

    public ContentProviderWithHelper() {}

    @Override    //initialize the provider
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        carWarhouseRoomDatabase = CarWarhouseRoomDatabase.getDatabase(getContext());
        return true;
    }

    //give each URI a unique code that will be used later by the content provider’s methods to tell which table to use or to retrieve the requested ID.
    private static UriMatcher createUriMatcher() {
        final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = CONTENT_AUTHORITY;
        //sUriMatcher will return code 1 if uri like authority/tasks
        uriMatcher.addURI(authority, Car.TABLE_NAME, MULTIPLE_ROWS_TASKS);
        //sUriMatcher will return code 2 if uri like e.g. authority/tasks/7 (where 7 is id of row in tasks table)
        //the ‘#’ character represents an integer value which represents an ID.
        uriMatcher.addURI(authority, Car.TABLE_NAME + "/#", SINGLE_ROW_TASKS);
        return uriMatcher;
    }

    //Uri: maps to the table name
    //projection: list of columns that should be included in each row
    //selection: is a string that represents the where clause
    //Selection Arguments: an array of strings represents values that should be embedded in the selection statement
    //sort order: a string that indicates whether to sort the data in ascending or descending order.
    @Override //Cursor is an interface provides random read-write access to the result set returned by a database query.
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(Car.TABLE_NAME);
        String query = builder.buildQuery(projection, selection, null, null, sortOrder, null);
        final Cursor cursor = carWarhouseRoomDatabase
                .getOpenHelper()
                .getReadableDatabase()
                .query(query, selectionArgs);
        return cursor;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int deletionCount; //return of this method is the number of rows that get affected by the delete operation.
        //Implement this to handle requests to delete one or more rows.
        deletionCount = carWarhouseRoomDatabase
                .getOpenHelper() //a reference to low level db
                .getWritableDatabase() //readable access
                .delete(Car.TABLE_NAME, selection, selectionArgs);
        return deletionCount;
    }

    @Override    //returns the MIME type of data in the content provider
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //This method inserts a new row to the database and returns a new Uri with the inserted row ID.
    //contentValues is a special data structure that is used to hold the data of one row only. It is used to send data to the database.
    //The content values data structure uses the key-value pair format.
    //The keys in the content values are the table’s columns names.
    //Content Values can hold the data of one row only, while Cursor might contain data for multiple rows.
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        // TODO: Implement this to handle requests to insert a new row.
        long rowId = carWarhouseRoomDatabase
                .getOpenHelper()
                .getWritableDatabase()
                .insert(Car.TABLE_NAME, 0, contentValues);
        return ContentUris.withAppendedId(CONTENT_URI, rowId);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        int updateCount;
        updateCount = carWarhouseRoomDatabase
                .getOpenHelper()
                .getWritableDatabase()
                .update(Car.TABLE_NAME, 0, values, selection, selectionArgs);
        return updateCount;
    }
}