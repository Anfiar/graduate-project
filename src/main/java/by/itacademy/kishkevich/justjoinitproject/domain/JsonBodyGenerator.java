package by.itacademy.kishkevich.justjoinitproject.domain;

import org.json.simple.JSONObject;

public class JsonBodyGenerator {
    public static JSONObject getRandomJsonWithAdditionalField() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("email", Candidate.getEmail());
        jsonObj.put("password", Candidate.getPassword());
        jsonObj.put("name", Candidate.getWrongEmail());
        return jsonObj;
    }

    public static JSONObject getRandomJsonWithIncorrectValueOfField() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("email", Candidate.getWrongEmail());
        jsonObj.put("password", Candidate.getWrongEmail());
        return jsonObj;
    }

    public static JSONObject getRandomJsonWithSomeEmptyValueOfField(String field) {
        JSONObject jsonObj = new JSONObject();
        if (field == "password") {
            jsonObj.put("email", Candidate.getEmail());
            jsonObj.put("password", "");
        } else if (field == "email") {
            jsonObj.put("email", "");
            jsonObj.put("password", Candidate.getPassword());
        } else {
            jsonObj.put("email", "");
            jsonObj.put("password", "");
        }
        return jsonObj;
    }

    public static JSONObject getRandomJsonWithIntegerValueOfField(String field) {
        JSONObject jsonObj = new JSONObject();
        if (field == "email") {
            jsonObj.put("email", Candidate.getNumber());
            jsonObj.put("password", "");
        } else if (field == "password") {
            jsonObj.put("email", "");
            jsonObj.put("password", Candidate.getNumber());
        } else {
            jsonObj.put("email", Candidate.getNumber());
            jsonObj.put("password", Candidate.getNumber());
        }
        return jsonObj;
    }

    public static JSONObject getRandomJsonByEmailAndPassword() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("email", Candidate.getEmail());
        jsonObj.put("password", Candidate.getPassword());
        return jsonObj;
    }

    public static JSONObject getRandomJsonWithNullValueOfField() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("email", null);
        jsonObj.put("password", null);
        return jsonObj;
    }

    public static JSONObject getEmptyRandomJson() {
        JSONObject jsonObj = new JSONObject();
        return jsonObj;
    }

    public static JSONObject getRandomJsonByFields(String field) {
        JSONObject jsonObj = new JSONObject();
        if (field == "email") {
            jsonObj.put("email", Candidate.getEmail());
        } else {
            jsonObj.put("password", Candidate.getPassword());
        }
        return jsonObj;
    }
}
