public class test {
	public static void main(String[] args) {
//		DateTime test = new DateTime("2020-04-22@16:15");
//		System.out.println(test.year);
//		System.out.println(test.month);
//		System.out.println(test.day);
//		System.out.println(test.hours);
//		System.out.println(test.mins);
//		System.out.println(test.toString());
		DateTime test1 = new DateTime("2020-04-02@01:02");
		System.out.println(test1.toString());
//		System.out.println (test1.toString());
//		System.out.println(test.equals(test1));
//		TodoItem todotest = new TodoItem("task", false, test);
//		TodoItem todotest1 = new TodoItem("task", false, test);
//		System.out.println(todotest.equals(todotest1));
		try {
		TodoList testList = new TodoList("sampleFile.txt");
		
		}
		catch (Exception e) {
			
		}
		
	}
}