package Lesson10.classwork.bracechecher;

public class BraceChecker {
    private String text;
    private Stack mystack;

    public BraceChecker(String text1) {
        text = text1;
    }

    public void check() {
        Stack mystack = new Stack();
        char c;
        int index = 0;
        for (char i = 0; i < text.length(); i++) {
            index++;
            c = text.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    mystack.push(text.charAt(i));
                    break;
              }

            if (c == ')' || c == ']' || c == '}') {
                char d = mystack.pop();

                switch (c) {
                    case ')':
                        if (d == '{') {

                            System.err.println("Error: opented { but closed ) at " + index);
                        }
                        if (d == '[') {
                            System.err.println("Error: opented [ but closed ) at " + index);
                        }
                        break;
                    case ']':
                        if (d == '(') {
                            System.err.println("Error: opented ( but closed ] at " + index);
                        }

                        if (d == '{') {

                            System.err.println("Error: opented { but closed ] at" + index);
                        }
                        break;
                    case '}':
                        if (d == '(') {
                            System.err.println("Error: opented ( but closed } at " + index);
                        }

                        if (d == '[') {
                            System.err.println("Error: opented [ but closed } at " + index);
                        }
                        break;
                }


            }


        }
    }
}












