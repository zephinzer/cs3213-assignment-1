import java.io.*;

/**
 * This class handles file IO
 * 
 * Last uptaed: 18th August 2014
 * @author zephinzer
 *
 */
public class FileStorage implements IStorage {
	private String data;
	private String filename;
	
	/**
	 * Confirms that the data is initialized and non-empty.
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 * @throws Exception if data has not been initialized/is empty.
	 */
	private void assertDataNotNull() throws Exception {
		if(data == null || data.isEmpty()) {
			throw new Exception("[FileStorage] Data cannot be null");
		}
	}
	
	/**
	 * Confirms that the filename is initialized and non-empty.
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 * @throws Exception if filename has not been initialized/is empty.
	 */
	private void assertFilenameNotNull() throws Exception {
		if(filename == null || filename.isEmpty()) {
			throw new Exception("[FileStorage] Filename cannot be null");
		}
	}
	
	/**
	 * Reloads the contents of the file specified by setFilename(String:filename)
	 * into data. Get data using getData().
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 * @throws Exception
	 */
	public void load() throws Exception {
		try {
			assertFilenameNotNull();
			BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filename));
			String currentLine;
			this.data = new String();
			while((currentLine = bufferedReader.readLine()) != null) {
				this.data += System.lineSeparator() + currentLine;
			}
			bufferedReader.close();
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * Writes data from this instance of FileStorage into the file as specified by
	 * setFilename(String:filename). Get data using getData().
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 * @throws Exception
	 */
	public void save() throws Exception {
		try {
			assertDataNotNull();
			assertFilenameNotNull();
			PrintWriter printWriter = new PrintWriter(this.filename);
			printWriter.print(data);
			printWriter.close();
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * Gets the data stored in this instance.
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 * @return String
	 */
	public String getData() {
		return this.data;
	}
	
	/**
	 * Sets the data of this instance
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * Gets the filename which this instance of FileStorage
	 * writes to.
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 * @return String
	 */
	public String getFilename() {
		return this.filename;
	}
	
	/**
	 * Sets the filename to which this instance of FileStorage
	 * writes to.
	 * 
	 * Last update: 18th August 2014
	 * @author zephinzer
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}