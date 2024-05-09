package ma.ac.usms.ensak.persistance;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class StorageFile {
	
	 public static <T> void saveToJsonFile(T instance, String path) {
	        // Deserialize existing data or create a new list
	        List<T> instances = readObjectsFromJsonFile(path, (Class<T>) instance.getClass());

	        // Add the new instance to the list
	        instances.add(instance);

	        // Serialize the updated list to JSON
	        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String json = gson.toJson(instances);

	        // Write JSON data to the file
	        try (FileWriter writer = new FileWriter(path)) {
	            writer.write(json);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static <T> List<T> readObjectsFromJsonFile(String path, Class<T> type) {
			List<T> instances = new ArrayList<>();
	
			File file = new File(path);
			if (file.exists() && file.length() > 0) {
				try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
					Gson gson = new GsonBuilder().create(); 
					Type listType = new ParameterizedType() {
						@Override
						public Type[] getActualTypeArguments() {
							return new Type[]{type};
						}
	
						@Override
						public Type getRawType() {
							return List.class;
						}
	
						@Override
						public Type getOwnerType() {
							return null;
						}
					};
					instances = gson.fromJson(reader, listType);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	
			return instances;
		}

		public static <T> void saveListToJsonFile(List<T> instances, String path) {
			// Serialize the list to JSON
	        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String json = gson.toJson(instances);

	        // Write JSON data to the file
	        try (FileWriter writer = new FileWriter(path, false)) {
	            writer.write(json);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}

}
