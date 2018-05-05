package com.test.naimish.railapp.Utils;

/**
 * Created by naimish on 4/1/2018.
 */

public interface RailAppConstants {
    //Shared preferences costants

    String TOKEN_CONSTANT = "token";
    String USERID_CONSTANT = "user id";
    String NAME_CONSTANT = "user name";
    String EMAIL_CONSTANT = "user email";
    String PROFILE_PIC_CONSTANT = "Profile picture uri";

    //Request code constants

    int PERMISSION_REQUEST_CODE = 123;
    int REQUEST_GALLERY_CODE = 1;
    int REQUEST_CAMERA_CODE = 20;

    //REST constants

    String BASE_URL = "https://fierce-forest-53940.herokuapp.com/";
    String RAIL_BASE_URL = "https://api.railwayapi.com/";

    //Intent Constants

    String SINGLE_STATION_DETAILS="single station details";

}
