package common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class Utils {

    private static final String FILE_PATH = "src/test/resources/dataStore.json";
    private static final Gson gson = new Gson();

    // Overwrite a value
    public static void set(String key, Object value) {
        Map<String, Object> data = load();
        data.put(key, value); // Overwrites the existing value
        save(data);
    }

    // Append to a list
    public static void addToList(String key, Object value) {
        Map<String, Object> data = load();

        // Retrieve existing list or create a new one
        List<Object> list = (List<Object>) data.getOrDefault(key, new ArrayList<>());
        list.add(value);

        data.put(key, list);
        save(data);
    }

    // Retrieve value (String, List, or Object)
    public static <T> T get(String key, Class<T> type) {
        Map<String, Object> data = load();
        return type.cast(data.get(key));
    }

    // Remove a specific key from the data store
    public static void remove(String key) {
        Map<String, Object> data = load();
        data.remove(key);
        save(data);
    }

    // Clears all stored data by overwriting with an empty JSON object
    public static void clear() {
        save(new HashMap<>()); // Overwrites file with an empty object
    }

    // Deletes the JSON file completely
    public static void deleteFile() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    // Load JSON file content
    private static Map<String, Object> load() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                FileReader reader = new FileReader(file);
                Type type = new TypeToken<Map<String, Object>>() {}.getType();
                return gson.fromJson(reader, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    // Save data to JSON file
    private static void save(Map<String, Object> data) {
        try {
            FileWriter writer = new FileWriter(FILE_PATH);
            gson.toJson(data, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
