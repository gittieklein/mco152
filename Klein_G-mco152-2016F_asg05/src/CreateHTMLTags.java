
public class CreateHTMLTags 
{
	public static void main(String[] args)
	{
		HTML html1 = new Header("my header", null, "HELLO WORLD", 3);
		html1 = new A(html1, "example.com");
		System.out.println(html1.getTag());
		
		HTML html2 = new Div("block", "block", "TouoOne");
		html2 = new Small(html2);
		html2 = new A(html2, "touroone.edu");
		html2 = new I(html2);
		System.out.println(html2.getTag());
		
		HTML html3 = new Input("name", null, null, "button", "onClick", "javascript:alert('action')", null);
		html3 = new I(html3);
		html3 = new Small(html3);
		html3 = new EM(html3);
		System.out.println(html3.getTag());
		
		//you can use one statement
		HTML html4 = new EM (new U(new Paragraph(null, null, "This is my paragraph in an HTML block of code.")));
		System.out.println(html4.getTag());
	}
}
