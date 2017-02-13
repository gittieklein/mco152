
public abstract class HTMLDecorator extends HTML
{
	protected HTML html; 	
	
	//most decorators don't have anything to them and wrap themselves around
	//the html component
	//if a decorator has more specific parts it will override this getTag
	public String getTag()
	{
		return "<" + tagName + ">" + html.getTag() + "</" + tagName + ">";
	}
}
