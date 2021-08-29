class Solution {
    // use dfs
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n < 2) return 0;
        
        Map<Integer, List<Integer>> meMap = constructReportingLine(headID, manager);
        
        return countInfoTime(meMap.get(-1), meMap, informTime, 0);
    }
    
    Map<Integer, List<Integer>> constructReportingLine(int headID, int[] manager) {
        Map<Integer, List<Integer>> res = new HashMap<>();
        for (int i = 0; i < manager.length; ++i) {
            List<Integer> employees = res.getOrDefault(manager[i], new ArrayList<>());
            employees.add(i);
            res.put(manager[i], employees);
        }
        return res;
    }
    
    int countInfoTime(List<Integer> employees, Map<Integer, List<Integer>> meMap, int[] informTime, int curTime) {
        if (employees == null || employees.isEmpty()) return curTime;
        
        int max = Integer.MIN_VALUE;
        for (Integer e : employees) {
            max = Math.max(max, countInfoTime(meMap.get(e), meMap, informTime, curTime + informTime[e]));
        }
        
        return max;
    }
}
