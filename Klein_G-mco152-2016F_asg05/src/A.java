
public class A extends HTMLDecorator
{
	private String href;
	
	//the user must pass an html object but can choose if he wants to send the
	//href when creating the object
	public A(HTML html)
	{
		this.html = html;
		href = null;
		tagName = "a";
	}
	
	public A(HTML html, String href)
	{
		this.html = html;
		this.href = href;
		tagName = "a";
	}
	
	public String getTag() 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<" + tagName);
		if(href != null)
			sb.append(" href = \"" + href + "\"");
		sb.append(">");
		return sb.toString() + html.getTag() + "</" + tagName + ">";
	}

}
