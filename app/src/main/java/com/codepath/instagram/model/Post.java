package com.codepath.instagram.model;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject {
    public static final String KEY_USER = "User";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE = "image";
    public static final String KEY_CREATED_AT = "createdAt";


    // getPhotoFileUri() is defined in
    // https://guides.codepath.com/android/Accessing-the-Camera-and-Stored-Media#using-capture-intent
    //File photoFile = getPhotoFileUri(photoFileName);

    //ParseFile parseFile = new ParseFile(photoFile);

    public String getDescription() {
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String description) {
        put(KEY_DESCRIPTION, description);
    }

    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile) {
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }
}


