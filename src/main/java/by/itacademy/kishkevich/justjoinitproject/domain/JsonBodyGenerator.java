package by.itacademy.kishkevich.justjoinitproject.domain;

import org.json.simple.JSONObject;

import static by.itacademy.kishkevich.justjoinitproject.domain.JsonBodyAtributes.*;

public class JsonBodyGenerator {
    public static JSONObject jsonObj = new JSONObject(); 
    public JSONObject getRandomJsonWithAdditionalField() {
        jsonObj.put(EMAIL, Candidate.getEmail());
        jsonObj.put(PASSWORD, Candidate.getPassword());
        jsonObj.put(NAME, Candidate.getWrongEmail());
        return jsonObj;
    }

    public JSONObject getRandomJsonWithIncorrectValueOfField() {
        jsonObj.put(EMAIL, Candidate.getWrongEmail());
        jsonObj.put(PASSWORD, Candidate.getWrongEmail());
        return jsonObj;
    }

    public JSONObject getRandomJsonWithSomeEmptyValueOfField(String field) {
        if (field.equals(PASSWORD)) {
            jsonObj.put(EMAIL, Candidate.getEmail());
            jsonObj.put(PASSWORD, "");
        } else if (field.equals(EMAIL)) {
            jsonObj.put(EMAIL, "");
            jsonObj.put(PASSWORD, Candidate.getPassword());
        } else {
            jsonObj.put(EMAIL, "");
            jsonObj.put(PASSWORD, "");
        }
        return jsonObj;
    }

    public JSONObject getRandomJsonWithIntegerValueOfField(String field) {
        if (field.equals(EMAIL)) {
            jsonObj.put(EMAIL, Candidate.getNumber());
            jsonObj.put(PASSWORD, "");
        } else if (field.equals(PASSWORD)) {
            jsonObj.put(EMAIL, "");
            jsonObj.put(PASSWORD, Candidate.getNumber());
        } else {
            jsonObj.put(EMAIL, Candidate.getNumber());
            jsonObj.put(PASSWORD, Candidate.getNumber());
        }
        return jsonObj;
    }

    public JSONObject getRandomJsonByEmailAndPassword() {
        jsonObj.put(EMAIL, Candidate.getEmail());
        jsonObj.put(PASSWORD, Candidate.getPassword());
        return jsonObj;
    }

    public JSONObject getRandomJsonWithNullValueOfField() {
        jsonObj.put(EMAIL, null);
        jsonObj.put(PASSWORD, null);
        return jsonObj;
    }

    public JSONObject getEmptyRandomJson() {
        return jsonObj;
    }

    public JSONObject getRandomJsonWithOneField(String field) {
        if (field.equals(EMAIL)) {
            jsonObj.put(EMAIL, Candidate.getEmail());
        } else if (field.equals(PASSWORD)) {
            jsonObj.put(PASSWORD, Candidate.getPassword());
        }
        return jsonObj;
    }
}
