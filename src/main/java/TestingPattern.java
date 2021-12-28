import java.util.ArrayList;
import java.util.regex.Pattern;

public class TestingPattern {

	public static final String INPUT_VALIDATION_PATTERN = "[(?:\\p{L}\\p{M}*)0-9/_\\-\\ \\'\\.\\,\\&?\\!:\\;\\(\\)]+";
	
	public static void main(String[] args) {
		
		ArrayList<String> testInput = new ArrayList<String>();
		testInput.add("<<script>>alert('XSS')<</script>>");
		testInput.add("<body onload=alert(‘something’)>;");
		testInput.add("%3cscript%3ealert(document.cookie)%3c/script%3e");

		
		for(String testStr: testInput) {
			System.out.println(testStr + ", Valid: " + (Pattern.matches(INPUT_VALIDATION_PATTERN, testStr)? "Valid":"Invalid"));
		}
	}
}
