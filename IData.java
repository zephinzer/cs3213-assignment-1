import java.util.*;

/**
 * Interface for functions in Class:Data
 * @author zephinzer
 *
 */
public interface IData {
	public ArrayList<String> getData() throws Exception;
	public String getDelimiter() throws Exception;
	public void setDelimiter(String delimiter);
	public boolean setData(ArrayList<String> in);
	public boolean insert(String newEntry) throws Exception;
	public boolean remove(String oldEntry) throws Exception;
	public boolean update(int index, String newEntry) throws Exception;
	public void loadData() throws Exception;
}