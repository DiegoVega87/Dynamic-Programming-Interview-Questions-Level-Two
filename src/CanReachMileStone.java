public class CanReachMileStone {

    /*
    * As a startup, you are given a series of milestones that you need to achieve in order to reach your final goal.
    * Each milestone has a specific value representing the maximum progress you can make from that point. Your
    * task is to create a function that takes in an integer array representing these values and returns true if you can
    * reach the final milestone, or false otherwise. The function should start from the first milestone and iterate
    * through each element in the array, checking if it's possible to reach the next milestone. If you can't reach a
    * milestone with any combination of progress values, return false.
    *
    * Example 1:
    * int[] milestones = {2, 3, 1, 1, 4};
    * boolean result = canReachMilestone(milestones);
    * result should be true
    *
    * Example 2:
    * int[] milestones = {3, 2, 1, 0, 4};
    * boolean result = canReachMilestone(milestones);
    * result should be false
    *
    *
    * */

    public static void main(String[] args){

        int[] milestones = {2, 3, 1, 1, 4};
        boolean result = canReachMilestone(milestones);
        System.out.println(result);

        milestones = new int[]{3, 2, 1, 0, 4};
        result = canReachMilestone(milestones);
        System.out.println(result);

        milestones = new int[]{0, 0, 0, 0, 0};
        result = canReachMilestone(milestones);
        System.out.println(result);

        milestones = new int[]{1, 1, 1, 1, 1};
        result = canReachMilestone(milestones);
        System.out.println(result);

        milestones = new int[]{5};
        result = canReachMilestone(milestones);
        System.out.println(result);

        milestones = new int[]{1, 2, 0, 0, 10};
        result = canReachMilestone(milestones);
        System.out.println("False --> "+result);

        milestones = new int[]{1, 2, 0, 1, 10};
        result = canReachMilestone(milestones);
        System.out.println("True --> "+result);

        milestones = new int[]{3, 2, 1, 0, 4};
        result = canReachMilestone(milestones);
        System.out.println(result);

        milestones = new int[]{2, 3, 1, 1, 4};
        result = canReachMilestone(milestones);
        System.out.println(result);

    }

    public static boolean canReachMilestone(int[] milestones){

        int maxProgress = 0;

        for(int i = 0; i < milestones.length; i++){
            if(i > maxProgress){
                return false;
            }

            maxProgress = Math.max(maxProgress, i + milestones[i]);
        }
        System.out.println(maxProgress);
        return true;
    }
}
