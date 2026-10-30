class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer>q = new LinkedList<>();
        for(int st:students){
            q.offer(st);
        }
        int sdi = 0;
        int un = 0;
        while(!q.isEmpty()&& un<q.size()){
            if(q.peek()==sandwiches[sdi]){
                q.poll();
                sdi++;
                un=0;
            }else{
                q.offer(q.poll());
                un++;
            }
        }
        return q.size();
    }
}
