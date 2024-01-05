import domain.Candidate;
import org.json.simple.JSONObject;

public class GenerateJson {
    public static JSONObject getRandomJsonByFields(String email, String password, String otherTag) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("email", Candidate.getEmail());
        jsonObj.put("password", Candidate.getPassword());
        jsonObj.put("name", Candidate.getWrongEmail());
        return jsonObj;
    }

    public static JSONObject getRandomJsonByFields(String email, String password) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("email", Candidate.getEmail());
        jsonObj.put("password", Candidate.getPassword());
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
    public static JSONObject getRandomJsonByFields() {
        JSONObject jsonObj = new JSONObject();
        return jsonObj;
    }
}
