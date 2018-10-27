public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     *
     * description:
     * https://leetcode.com/problems/course-schedule/
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses==0||prerequisites.length==0){
            return true;
        } 
        
        
        
        //course node to neighbors
        HashMap<Integer,List<Integer>> courseMap = createTopologyMap(numCourses,prerequisites);
        
        //count in-degree
        //<node,in-degree>
        HashMap<Integer,Integer> indegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            
            
            
            for (int neighbor : courseMap.get(i)) {
                if (indegree.containsKey(neighbor)){
                    indegree.put(neighbor,indegree.get(neighbor)+1);
                } else {
                    indegree.put(neighbor,1);
                }
            }
        } 
        
        //start path at 0 in-degree
        //i==course node
        Queue<Integer> queue = new LinkedList<>();
        List<Integer>  result = new ArrayList<>();
         for (int i = 0;i<numCourses ;i++ ){
             if (!indegree.containsKey(i)){
                 result.add(i);
                 queue.offer(i);
             } 
             
         }
         
         //bfs
         while(!queue.isEmpty()){
             
             
             int node = queue.poll();
             
             for(Integer neighbor :courseMap.get(node)){
                 //current node in-degree -1
                 indegree.put(neighbor,indegree.get(neighbor)-1);
                 //offer queue neighbors 
                 if (indegree.get(neighbor)==0){ 
                 queue.offer(neighbor);
                 result.add(neighbor);
                 }
             }
             
             
             
         }
         
         return result.size()==numCourses;
         
            
    }
    
    private HashMap<Integer,List<Integer>> createTopologyMap(int n, int[][] prerequisites){
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        
        for (int i =0;i<n ;i++ ){
            map.put(i,new ArrayList<Integer>());
        } 
        
         for (int i =0;i<prerequisites.length ;i++ ){
           int curr = prerequisites[i][0];
           int pre = prerequisites[i][1];
           
           map.get(pre).add(curr);
        } 
        
        return map;
    }
}