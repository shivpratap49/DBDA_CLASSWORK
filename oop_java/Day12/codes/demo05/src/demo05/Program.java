package demo05;

enum Weekday {
	MONDAY {
		@Override
		public String toString() {
			return "Monday"; 
		}
	},
	TUESDAY {
		@Override
		public String toString() {
			return "Tuesday"; 
		}
	},
	WEDNEDAY {
		@Override
		public String toString() {
			return "Wednesday"; 
		}
	},
	FRIDAY {
		@Override
		public String toString() {
			return "Friday"; 
		}
	},
}
public class Program {

	public static void main(String[] args) {
		for (Weekday wk : Weekday.values()) {
			System.out.println(wk.ordinal() +  " ----" + wk.name() + "---" + wk.toString());
		}

	}

}
