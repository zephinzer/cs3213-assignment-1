import java.util.*;
/**
 * Data class to hold the data in memory
 * @author zephinzer
 *
 */

public class Data implements IData {
	private IStorage storageEngine;
	private ArrayList<String> data;
	private String delimiter;
	
	/**
	 * Confirms that the data stored in this instance of Data is
	 * not null.
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 * @throws Exception
	 */
	private void assertDataNotNull() throws Exception {
		if(this.data == null) {
			throw new Exception("[Data] Data cannot be null");
		}
	}
	
	/**
	 * Confirms that the data stored in this instance of Data is
	 * non-empty.
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 * @throws Exception
	 */
	private void assertDataNotEmpty() throws Exception {
		if(this.data.size() < 1) {
			throw new Exception("[Data] Data cannot be empty");
		}
	}
	
	/**
	 * Confirms that the storage engine for this instance of Data
	 * has been set.
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 * @throws Exception
	 */
	private void assertStorageEngineNotNull() throws Exception {
		if(this.storageEngine == null) {
			throw new Exception("[Data] Storage engine must be set");
		}
	}
	
	/**
	 * Confirms that the delimiter used in this instance of Data
	 * has been set and is non-empty.
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 * @throws Exception
	 */
	private void assertDelimiterNotNull() throws Exception {
		if(this.delimiter == null || this.delimiter.isEmpty()) {
			throw new Exception("[Data] Delimiter cannot be null");
		}
	}
	
	/**
	 * Gets the deimiter used to separate items for this instance of Data
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 * @return String
	 */
	public String getDelimiter() throws Exception {
		assertDelimiterNotNull();
		return this.delimiter;
	}
	
	/**
	 * Sets the delimiter used to separate items for this instance of Data
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 * @param delimiter
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	
	/**
	 * Gets the local data set in this instance of Data. Returns the
	 * data as an Array<String> structure
	 * 
	 * Last updated: 18th August 2014
	 * @author zephinzer
	 * @param void
	 * @return Array<String>
	 */
	public ArrayList<String> getData() throws Exception {
		assertDataNotNull();
		return this.data;
	}
	
	/**
	 * Sets the local data to equal ArrayList<String>:dataIn;
	 * Returns true on function success and false on function failure
	 * 
	 * Last updated: 18th August 2014
	 * @author zephinzer
	 * @param ArrayList<String>:dataIn
	 * @return boolean
	 */
	public boolean setData(ArrayList<String> dataIn) {
		try {
			this.data = dataIn;
		} catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	/**
	 * Returns an instance of the storage engine being used
	 * in the Data class
	 * 
	 * Last updated: 18th August 2014
	 * @author zephinzer
	 * @return instance of storage engine
	 */
	public IStorage getStorageEngine() throws Exception {
		assertStorageEngineNotNull();
		return this.storageEngine;
	}
	
	/**
	 * Sets the instance of the storage engine being used.
	 * 
	 * @author zephinzer
	 * @param IStorage:storageEngine
	 */
	public void setStorageEngine(IStorage storageEngine) {
		this.storageEngine = storageEngine;
	}
	
	/**
	 * Inserts String:newEntry into the data of this instance of Data.
	 * Returns true on success, false otherwise.
	 * 
	 * @author zephinzer
	 * @param String:newEntry
	 * @return boolean
	 */
	public boolean insert(String newEntry) throws Exception {
		assertDataNotNull();
		if(this.data.contains(newEntry)) {
			return true;
		} else {
			this.data.add(newEntry);
			return false;
		}
	}
	
	/**
	 * Removes String:oldEntry from data in this instance of Data.
	 * Returns true on success, false otherwise.
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 * @param String:oldEntry
	 * @return boolean
	 */
	public boolean remove(String oldEntry) {
		try {
			int locationOfOldEntry = data.indexOf(oldEntry);
			data.remove(locationOfOldEntry);
			return true;
		} catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Updates the array at the index argument
	 * 
	 * Last updated: 18th August 2014
	 * @author zephinzer	
	 * @param index: An integer
	 * @param newEntry
	 */
	public boolean update(int index, String newEntry) {
		try {
			data.remove(index);
			data.add(index, newEntry);
			return true;
		} catch(Exception ex) {
			return false;
		}
	}
	
	/**
	 * Retrieves the data from the storage engine set from
	 * setStorageEngine(IStorage:storageEngine).
	 * 
	 */
	public void loadData() throws Exception {
		assertStorageEngineNotNull();
		assertDelimiterNotNull();
		storageEngine.load();
		String fileData = storageEngine.getData();
		StringTokenizer dataTokens = new StringTokenizer(fileData, this.delimiter);
		this.data = new ArrayList<String>();
		while(dataTokens.hasMoreTokens()) {
			this.data.add(dataTokens.nextToken());
		}
	}
}