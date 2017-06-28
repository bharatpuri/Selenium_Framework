package com.autoiq.common.utility;

import java.util.HashMap;
import java.util.Map;

/**
 * This class will load the all data from external file and store in MAP
 * 
 * @author bharatp
 *
 */
public class DataStoreInObjects {
	Map<String, String> dataFromFiles;

	public DataStoreInObjects() {
		dataFromFiles = new HashMap<String, String>();
	}

	public String getValue(String key) throws HandleException {
		String temp = dataFromFiles.get(key);
		if (temp == null) {
			throw new HandleException(key + ": Failed Key not found in selected file");
		} else if (dataFromFiles.get(key).isEmpty()) {
			throw new HandleException(key + ": Failed Kay does not have any value");
		}
		return temp;
	}

	public void put(String key, String value) {
		dataFromFiles.put(key, value);
	}
}

