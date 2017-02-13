public class Input extends HTML
{
		private String id;
		private String name;
		private String innerText;
		private String type;
		private String eventAttribute;
		private String eventAction;
		private String value;
		
		//the user can either enter all the values together or enter no
		//values and use the setters to enter the values they want
		public Input()
		{
			this.id = null;
			this.name = null;
			this.innerText = "";
			this.type = null;
			this.eventAttribute = null;
			this.eventAction = null;
			this.value = null;
			tagName = "input";
		}
		
		public Input(String id, String name, String text, String type, String eventAttribute, String eventAction, String value)
		{
			this.id = id;
			this.name = name;
			this.innerText = text;
			this.type = type;
			this.eventAttribute = eventAttribute;
			this.eventAction = eventAction;
			this.value = value;
			tagName = "input";
		}
		
		public String getTag()
		{
			StringBuilder sb = new StringBuilder();
			sb.append("<" + tagName);
			if(id != null)
				sb.append(" id = \"" + id + "\"");
			if(name != null)
				sb.append(" name = \"" + name + "\"");
			if(type != null)
				sb.append(" type = \"" + type + "\"");
			if(value != null)
				sb.append(" value = \"" + value + "\"");
			if(eventAttribute != null && eventAction != null)
			{
				sb.append(" " + eventAttribute + " = \"" + eventAction + "\"");
			}
			sb.append(">");
			sb.append(innerText);
			sb.append("</" + tagName + ">");
			return sb.toString();
		}
}
