class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<>();
        
        HashMap<String,PriorityQueue<String>> map = new HashMap<>();
        
        for(List<String> l:tickets)
        {
            String from = l.get(0);
            String to = l.get(1);
            if(map.containsKey(from))
            {
                map.get(from).offer(to);
            }
            else
            {
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.offer(to);
                map.put(from,pq);
            }           
        }
        
        String src = "JFK";
        
        dfs(src,map,ans);
        
        return ans;        
    }
    
    void dfs(String src,HashMap<String,PriorityQueue<String>> map,List<String> ans)
    {
        PriorityQueue<String> pq = map.get(src);
        
        while((pq!=null) && !(pq.isEmpty()))
        {
            dfs(pq.poll(),map,ans);
        }
        
        ans.add(0,src);
    }
}