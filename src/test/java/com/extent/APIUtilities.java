package com.extent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class APIUtilities {

	public void commonAPi(String testKey) throws IOException {
		String Testdatapath="path";
		FeatureHelper featureHelper=new FeatureHelper();
		HashMap<String, String> testData=featureHelper.getExcelData(testKey, Testdatapath);
		String routes=testData.get("Routes");
		String templateID=testData.get("TemplateID");
		String clientID=testData.get("ClientID");
		String cos=testData.get("Cos");
		String date=testData.get("date");
		String testLab=testData.get("TestLab");



		RestAssured.baseURI="http://sxsxxs98989.deltx.com";
		RestAssured.port=87878;
		RestAssured.basePath="/dedliengine/testdat";

		String request=new String (Files.readAllBytes(Paths.get(System.getProperty("user.dir")
				+File.separator+"src/test/resources/data/PNRCREATEpayload.json")));
		request=request.replace("<Routes>",routes)
				.replace("<TemplateID>",templateID)
				.replace("<ClientID>",clientID)
				.replace("<Cos>",cos)
				.replace("<Date>",date)
				.replace("<TestLab>",testLab);

		String res=RestAssured.given().when().contentType(ContentType.JSON).
				when().body(request).post().then().extract().response().asPrettyString();

		JsonPath json=new JsonPath(res);
		json.get("").toString();
		


	}
}
