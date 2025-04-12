package assignment7;

public class StringMaker {
		private String str;
		
		public StringMaker() {
			this("");
		}
		public StringMaker(String str) {
			this.str = str;
		}

		public String getStr() {
			return str;
		}

		public void setStr(String str) throws ExceptionLineTooLong{
			if(str.length()>20)
				throw new ExceptionLineTooLong("The strings is too long with length -> ", str.length());
			this.str = str;
		}
		
	}

