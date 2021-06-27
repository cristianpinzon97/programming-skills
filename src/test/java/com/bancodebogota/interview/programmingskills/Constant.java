package com.bancodebogota.interview.programmingskills;

/**
 * Constant for testing an resulting
 */
public class Constant {

    public static final String CREATE_USER = "{\n" +
            "    \"id\": 1,\n" +
            "    \"fullName\": \"Cristian Pinzon\",\n" +
            "    \"function\": \"Junior Software developer\",\n" +
            "    \"email\": null,\n" +
            "    \"phone\": null,\n" +
            "    \"boss\": null,\n" +
            "    \"employees\": null\n" +
            "}";

    public static String GET_USERS = "[{\"id\":2,\"fullName\":\"Cristian Pinzon\",\"function\":\"Senior Software developer\",\"email\":null,\"phone\":null,\"boss\":null,\"employees\":[{\"id\":1,\"fullName\":\"Cristian Pinzon\",\"function\":\"Junior Software developer\",\"email\":null,\"phone\":null,\"employees\":[]}]},{\"id\":1,\"fullName\":\"Cristian Pinzon\",\"function\":\"Junior Software developer\",\"email\":null,\"phone\":null,\"boss\":{\"id\":2,\"fullName\":\"Cristian Pinzon\",\"function\":\"Senior Software developer\",\"email\":null,\"phone\":null,\"employees\":[{\"id\":1,\"fullName\":\"Cristian Pinzon\",\"function\":\"Junior Software developer\",\"email\":null,\"phone\":null,\"employees\":[]}]},\"employees\":[]}]";

    public static String CREATE_BOSS = "{\n" +
            "    \"id\": 2,\n" +
            "    \"fullName\": \"Cristian Pinzon\",\n" +
            "    \"function\": \"Senior Software developer\",\n" +
            "    \"boss\": null,\n" +
            "    \"employees\": null\n" +
            "}";

    public static String CREATE_BOSS_RESPONSE = "{\n" +
            "    \"id\": 1,\n" +
            "    \"fullName\": \"Cristian Pinzon\",\n" +
            "    \"function\": \"Junior Software developer\",\n" +
            "    \"email\": null,\n" +
            "    \"phone\": null,\n" +
            "    \"boss\": {\n" +
            "        \"id\": 2,\n" +
            "        \"fullName\": \"Cristian Pinzon\",\n" +
            "        \"function\": \"Senior Software developer\",\n" +
            "        \"email\": null,\n" +
            "        \"phone\": null,\n" +
            "        \"employees\": null\n" +
            "    },\n" +
            "    \"employees\": []\n" +
            "}";

    // avoid instances of this clases
    private Constant(){}


}
