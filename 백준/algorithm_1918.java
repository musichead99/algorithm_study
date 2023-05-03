import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class algorithm_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String inorder = br.readLine();

        for(int i = 0; i < inorder.length(); i++) {
            char c = inorder.charAt(i);

            if(c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else {
                switch(c) {
                    case '-':
                    case '+':
                    case '*':
                    case '/':
                        while(!s.empty() && getPriority(c) <= getPriority(s.peek())) {
                            sb.append(s.pop());
                        }
                        s.push(c);
                    break;

                    case '(':
                        s.push(c);
                    break;

                    case ')':
                        while(!s.empty() && s.peek() != '(') {
                            sb.append(s.pop());
                        }
                        s.pop();
                    break;
                }
            }
        }

        while(!s.empty()) {
            sb.append(s.pop());
        }

        System.out.println(sb);
    }

    public static int getPriority(char c) {
        int priority = 0;

        if(c == '+' || c == '-') {
            priority = 1;
        } else if(c == '*' || c == '/') {
            priority = 2;
        } 

        return priority;
    }
}