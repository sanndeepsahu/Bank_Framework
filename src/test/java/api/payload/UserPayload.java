package api.payload;

// 👉 Payload Class (Test Data)

import org.json.JSONObject;

public class UserPayload {

    public static String createUserPayload(String name, String username, String email)
    {
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("username", username);
        obj.put("email", email);

        return obj.toString();
    }
}
