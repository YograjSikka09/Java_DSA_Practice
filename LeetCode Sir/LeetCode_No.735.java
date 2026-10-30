class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int a:asteroids){
            boolean alive = true;
            while(alive&& a<0&&!st.isEmpty()&&st.peek()>0){
                if(st.peek()<-a){
                    st.pop();
                }
                else if(st.peek()==-a){
                    st.pop();
                    alive = false;
                }
                else{
                    alive = false;
                }
            }
            if(alive){
                st.push(a);
            }
        }
        int[] res = new int[st.size()];
        for(int i = 0; i <st.size(); i++){
            res[i] = st.get(i);
        }
        return res;
    }
}
