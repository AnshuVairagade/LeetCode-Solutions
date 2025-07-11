/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> emp = new HashMap<>();
        for(Employee e : employees){
            emp.put(e.id, e);
        }
        return calcImportance(emp, id);
    }

    private int calcImportance(HashMap<Integer, Employee> emp, int id){
        int imp = emp.get(id).importance;

        for(int subId : emp.get(id).subordinates){
            imp += calcImportance(emp, subId);
        }

        return imp;
    }
}