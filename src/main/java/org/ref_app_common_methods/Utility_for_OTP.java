package org.ref_app_common_methods;

import com.org.yajuego.constant.APIRequestBody;
import com.org.yajuego.utils.FileUtils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.ref_app_base.Ref_App_Launch_Close;

import static io.restassured.RestAssured.given;

public class Utility_for_OTP {

    public static String baseURL = null;
    private static String apiKey = null;

    public Utility_for_OTP() {
        setEnvAndKey();
    }

    public String createUser() {
        RestAssured.baseURI = baseURL;
        Response resp = given()
                .body(APIRequestBody.REQ_BODY_OTP)
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .when()
                .post()
                .then()
                .extract()
                .response();

        String response = resp.asPrettyString();
        System.out.println(response);

        JsonPath jp = resp.jsonPath();
        String otpValue = jp.getString("data.authenticate_v1.data.authFactorData.OTP");

        if (otpValue == null) {
            throw new RuntimeException("OTP not found in the response");
        }

        System.out.println(otpValue); // to print OTP
        return otpValue; // returns generated OTP
    }

    private void setEnvAndKey() {
        if (Ref_App_Launch_Close.getEnv()) {
            System.out.println("The Environment is set to Prod :: " + Ref_App_Launch_Close.getEnv());
            baseURL = FileUtils.getValue("PROD_BASE_URL");
            apiKey = FileUtils.getValue("PROD_API_KEY");
        } else {
            System.out.println("The Environment is set to Sandbox :: " + Ref_App_Launch_Close.getEnv());
            baseURL = FileUtils.getValue("SANDBOX_BASE_URL");
            apiKey = FileUtils.getValue("SANDBOX_API_KEY");
        }
        System.out.println("Base URL is :: " + baseURL);
        System.out.println("API Key is :: " + apiKey);
    }
}