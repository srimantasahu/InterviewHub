package com.kvvssut.interviews.java.collections.sets;

import com.kvvssut.interviews.java.collections.collectioninterface.Task;

enum Priority {
    HIGH, MEDIUM, LOW;
}

/*
 * To test whether two PriorityTasks are equal, we check whether they have the
 * same priority and the same task. These definitions ensure that the natural
 * ordering is consistent with equals.
 */

public final class PriorityTask implements Comparable<PriorityTask> {

    private final Task task;
    private final Priority priority;

    PriorityTask(Task task, Priority priority) {
        this.task = task;
        this.priority = priority;
    }

    public Task getTask() {
        return task;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public int compareTo(PriorityTask priorityTask) {
        int c = priority.compareTo(priorityTask.priority);
        return c != 0 ? c : task.compareTo(priorityTask.task);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PriorityTask) {
            PriorityTask priorityTask = (PriorityTask) obj;
            return task.equal(priorityTask.task)
                   && priority.equals(priorityTask.priority);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return task.hashCode();
    }

    @Override
    public String toString() {
        return task + " : " + priority;
    }

}
