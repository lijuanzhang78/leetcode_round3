package DFS;

public class EmployeeImportance {
	Map<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) return 0;
        map = new HashMap<Integer,Employee>();
        for(Employee e : employees) map.put(e.id, e);
        return helper(id);
    }
    
    int helper(int id) {
        int sum = map.get(id).importance;
        if (map.get(id).subordinates.size() == 0) return sum;
        for(int e : map.get(id).subordinates) {
            sum += helper(e);            
        }
        return sum;
    }

}
