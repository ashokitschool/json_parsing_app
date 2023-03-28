package in.ashokit;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJson {

	public static void main(String[] args) throws Exception {

		Object obj = new JSONParser().parse(new FileReader(new File("person.json")));

		JSONObject jo = (JSONObject) obj;

		// getting firstName and lastName
		String firstName = (String) jo.get("firstName");
		String lastName = (String) jo.get("lastName");

		System.out.println(firstName);
		System.out.println(lastName);

		// getting age
		Long age = (Long) jo.get("age");
		System.out.println(age);

		// getting address
		Map address = ((Map) jo.get("address"));

		// iterating address Map
		Iterator<Map.Entry> itr1 = address.entrySet().iterator();
		while (itr1.hasNext()) {
			Map.Entry pair = itr1.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());
		}

		// getting phoneNumbers
		JSONArray ja = (JSONArray) jo.get("phoneNumbers");

		// iterating phoneNumbers
		Iterator itr2 = ja.iterator();

		while (itr2.hasNext()) {
			itr1 = ((Map) itr2.next()).entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();
				System.out.println(pair.getKey() + " : " + pair.getValue());
			}
		}
	}
}
