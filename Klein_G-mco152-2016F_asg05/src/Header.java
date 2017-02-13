
public class Header extends HTML
{
	private String id;
	private String name;
	private String innerText;
	private int num;

	//the user can either enter all the values together or enter no
	//values. if the user wants some they could pass in nulls
	public Header(int num)
	{
		this.num = num;
		this.id = null;
		this.name = null;
		this.innerText = "";
		tagName = "h" + num;
	}	
	
	public Header (String id, String name, String text, int num)
	{
		this.id = id;
		this.name = name;
		this.innerText = text;
		this.num = num;
		tagName = "h" + num;
	}
	
	public String getTag()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<" + tagName);
		if(id != null)
			sb.append(" id = \"" + id + "\"");
		if(name != null)
			sb.append(" name = \"" + name + "\"");
		sb.append(">");
		sb.append(innerText);
		sb.append("</" + tagName + ">");
		return sb.toString();
	}
}
