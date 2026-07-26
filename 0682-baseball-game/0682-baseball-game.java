class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int n = operations.length;
        for(int i=0;i<n;i++){
            String s = operations[i];
            if(s.equals("C")) st.pop();
            else if(s.equals("D")) st.push(2*st.peek());
            else if(s.equals("+")){
                int top = st.pop();
                int stop = st.peek();
                int sum = top+stop;
                st.push(top);
                st.push(sum);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        int s = 0;
        while(!st.isEmpty()){
            s += st.pop();
        }
        return s;
    }
}