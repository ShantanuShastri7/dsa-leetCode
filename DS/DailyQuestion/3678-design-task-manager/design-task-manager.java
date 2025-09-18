class TaskManager {
    TreeSet<Pair<Integer, Pair<Integer, Integer>>> userTaskPrioritySet;
    HashMap<Integer, Integer> taskPriorityMap;
    HashMap<Integer, Integer> taskUserMap;


    public TaskManager(List<List<Integer>> tasks) {
        userTaskPrioritySet = new TreeSet<>((a,b)->{
            Integer result = b.getValue().getValue()-a.getValue().getValue();
            return result!=0?result:b.getValue().getKey()-a.getValue().getKey();
        });
        taskPriorityMap = new HashMap<>();
        taskUserMap = new HashMap<>();

        for (List<Integer> task : tasks) {
            int userID = task.get(0);
            int taskID = task.get(1);
            int priority = task.get(2);

            userTaskPrioritySet.add(new Pair<>(userID, new Pair<>(taskID, priority)));
            taskPriorityMap.put(taskID, priority);
            taskUserMap.put(taskID, userID);
        }
    }

    public void add(int userId, int taskId, int priority) {
        userTaskPrioritySet.add(new Pair<>(userId, new Pair<>(taskId, priority)));
        taskPriorityMap.put(taskId, priority);
        taskUserMap.put(taskId, userId);
    }

    public void edit(int taskId, int newPriority) {
        int priority = taskPriorityMap.get(taskId);
        taskPriorityMap.put(taskId, newPriority);

        Integer userId = taskUserMap.get(taskId);

        userTaskPrioritySet.remove(new Pair<>(userId, new Pair<>(taskId, priority)));
        userTaskPrioritySet.add(new Pair<>(userId, new Pair<>(taskId, newPriority)));
    }

    public void rmv(int taskId) {
        Integer userId = taskUserMap.get(taskId);
        taskUserMap.remove(taskId);

        Integer priority = taskPriorityMap.get(taskId);
        taskPriorityMap.remove(taskId);

        userTaskPrioritySet.remove(new Pair<>(userId, new Pair<>(taskId, priority)));
    }

    public int execTop() {
        if(userTaskPrioritySet.isEmpty()) return -1;
        Integer userID = userTaskPrioritySet.first().getKey();
        userTaskPrioritySet.remove(userTaskPrioritySet.first());

        return userID;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */