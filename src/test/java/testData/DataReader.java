package testData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class DataReader {
	
	public List <HashMap <String ,String>> getJsonDataToMAp() throws IOException
	{
		//reading json to string
		String jsonreader = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//testData//testData.json"));
		
		//covert string to hashmap jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		List <HashMap <String ,String>> data = mapper.readValue(jsonreader , new TypeReference<List <HashMap <String , String >>>() {
		});
		return data;
				
				
				

		
	}

}
