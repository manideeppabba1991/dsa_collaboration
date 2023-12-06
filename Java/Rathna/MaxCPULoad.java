import java.util.Arrays;
import java.util.Comparator;

public class MaxCPULoad {
    public static void main(String[] args) {
        int[][] jobs = {{1,4,3}, {2,5,4}, {7,9,6}, {3,6,5}};
        int maxCPUUsage = findMaxCPUUsage(jobs);
        System.out.println("Max CPU: " + maxCPUUsage);
    }

    private static int findMaxCPUUsage(int[][] jobs) {
        int size = jobs.length;
        Arrays.sort(jobs, Comparator.comparing(value -> value[0])); // For sorting
        //{{1,4,3}, {2,5,4}, {3,6,5}, {7,9,6}};
        int[] jobInterval = jobs[0];
        int cpuUsage = jobs[0][2];
        for(int i = 1; i < size; i++) {
            if(jobInterval[0] <= jobs[i][1] && jobs[i][0] <= jobInterval[1]) { //jobs intersect - if condition is passed
                jobInterval[0] = Math.min(jobInterval[0], jobs[i][0]); //1
                jobInterval[1] = Math.max(jobInterval[1], jobs[i][1]); //6
                cpuUsage = cpuUsage + jobs[i][2];//12
            } else {
                jobInterval[0] = jobs[i][0];
                jobInterval[1] = jobs[i][1];
                cpuUsage = Math.max(cpuUsage, jobs[i][2]);
            }
        } 
        return cpuUsage;
        
    }
    
}
