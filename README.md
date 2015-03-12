## Android JSON Parser
This repository aims to show some ways on how to parse a JSON within an Android app, using simple examples.

## SimpleBackend
SimpleBackend is a backend implemented to provide a simple REST API to get the JSON from the Internet (the most usual way). It is implemented with Grails 2.4.2 and it only provides one method, accessible through HTTP GET, and it returns a single object in JSON format.

<strong>BasicJSONParser</strong>
It is the Android app where you can see how to parse a JSON in the natural way, meaning without any library support nor reflection. The app provides the main view where there is a ListView with the downloaded chracters (just one in this case; see Future Work).

In order to parse a JSON object:
<code>
public void parseExample(JSONObject jsonObject) {

    int intArg = jsonObject.getInt("paramName");
    long longArg = jsonObject.getLong("paramName");
    String stringArg = jsonObject.getString("paramName");

    //If the object contains a list
    JSONArray jsonArray = jsonObject.getJSONArray("paramName");

    //To parse a JSONArray
    for(int i = 0; i < jsonArray.length(); i++) {
        anotherInt = jsonArray.getJSONObject(i).getLong("paramName");
        anotherLong = jsonArray.getJSONObject(i).getInt("paramName");
        anotherString = jsonArray.getJSONObject(i).getString("paramName");
    }
}
</code>

So, these are the basics to parse a JSON using the tools provided directly by Android, they are found in **CharacterDataParser.java** file in the **util** package.

## Future Work
As soon as possible I would like to provide other ways to parse JSON in Android, following the same example.

Antoher thing I have in mind, is to modify the current **SimpleBackend** so instead of getting just one object to get a list of them.
