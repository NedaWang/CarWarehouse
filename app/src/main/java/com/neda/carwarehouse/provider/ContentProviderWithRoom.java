package com.neda.carwarehouse.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import com.neda.carwarehouse.entity.Car;

public class ContentProviderWithRoom extends ContentProvider {

    public static final String CONTENT_AUTHORITY = "ContentProviderWithRoom";
    public static final Uri CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    CarWarhouseRoomDatabase carWarhouseRoomDatabase;
    CarDao carDao;

    private static final int MULTIPLE_ROWS_TASKS = 1;
    private static final int SINGLE_ROW_TASKS = 2;

    public ContentProviderWithRoom() {
    }

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

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        //return carDao.deleteAllCars();
        int deletionCount;
        deletionCount = carWarhouseRoomDatabase
                .getOpenHelper()
                .getWritableDatabase()
                .delete("cars", selection, selectionArgs);

        return deletionCount;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowId = carWarhouseRoomDatabase
                .getOpenHelper()
                .getWritableDatabase()
                .insert(Car.TABLE_NAME, 0, values);
        return ContentUris.withAppendedId(CONTENT_URI, rowId);
    }

    @Override
    public boolean onCreate() {
        carWarhouseRoomDatabase = CarWarhouseRoomDatabase.getDatabase(getContext());
        carDao = carWarhouseRoomDatabase.getCarDao();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor data = carDao.getAllCarsCursor();
        return data;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}