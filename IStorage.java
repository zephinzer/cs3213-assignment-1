public interface IStorage {
	public void load() throws Exception;
	public void save() throws Exception;
	public String getData();
	public void setData(String data);
	public String getFilename();
	public void setFilename(String filename);
}