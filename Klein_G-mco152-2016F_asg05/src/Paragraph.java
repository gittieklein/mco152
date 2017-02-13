
public class Paragraph extends HTML
{
	private String id;
	private String name;
	private String innerText;
	
	//the user can either enter all the values together or enter no
	//values. if the user wants some they could pass in nulls
	public Paragraph()
	{
		this.id = null;
		this.name = null;
		this.innerText = "";
		tagName = "p";
	}
	
	public Paragraph(String id, String name, String text)
	{
		this.id = id;
		this.name = name;
		this.innerText = text;
		tagName = "p";
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
