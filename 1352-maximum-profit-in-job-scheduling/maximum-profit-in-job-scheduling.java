// Documentation is given below

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        Job[] jobs = new Job[n];
        for(int i=0; i<n; i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        } 

        Arrays.sort(jobs, (a, b)-> a.start - b.start);

        // Why 1D Dp???? Explained below;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return schedule(0, jobs, dp);
    }

    // TC = O(n*log(n))
    private int schedule(int i, Job[] jobs, int[] dp){
        if(i == jobs.length) return 0;

        if(dp[i] != -1) return dp[i]; // already scheduled

        Job currJob = jobs[i];
        int next = lowerBound(jobs, i, currJob.end);

        int scheduledProfit = schedule(next, jobs, dp) + currJob.profit;
        int nonScheduleProfit = schedule(i+1, jobs, dp);

        return dp[i] = Math.max(scheduledProfit, nonScheduleProfit);
    }

    private int lowerBound(Job[] jobs, int i, int endTime){
        int ans = jobs.length;

        int low = i+1, high = jobs.length-1;
        while(low <= high){
            int mid = (low + high)/2;

            if(jobs[mid].start >= endTime){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return ans;
    }

    class Job{
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}

/*
TC = O(n*log(n))
SC = O(n)


Try to tabulize this code


Understand why DP with memoization will fail from previous submission

To understand binary Search approach:
https://www.youtube.com/watch?v=LL0tVxlAeV4


Why 1D DP??? Why not using dp[i][profit]

First understand what the DP state really represents here.

In this solution,
dp[i] means
maximum profit you can earn starting from job index i onwards.

That is it.
Nothing else is part of the state.

Why this works
At index i, you only have two meaningful choices

1 Take job i
2 Skip job i

If you take job i
You earn jobs[i][2] profit
Then you must jump to the next non overlapping job
That next job index is uniquely determined using binary search

So the future profit becomes
helper(nextIndex)

If you skip job i
You simply move to the next job
helper(i + 1)

Notice something very important here
At index i, the decision does not depend on how much profit you have already earned.

Why profit does not need to be part of DP state
Profit is an output, not a constraint.

DP state should only include things that affect future decisions.

Ask yourself
If I reach job i with profit 10 or profit 100
Does it change which jobs I can take next?

Answer
No

The next valid job depends only on time, not on profit.

That is why profit does not belong in the DP state.

Why dp[index][profit] is wrong here
Using dp[index][profit] means
The future decisions depend on current profit

But in this problem
Profit does not affect job compatibility
Time does

So dp[index][profit] creates unnecessary states and causes MLE or TLE.

Why multiple ways to schedule same job does not matter
Yes, there may be multiple schedules that reach job i with different profits.

But DP does not need to remember all of them.

DP only cares about
What is the maximum profit possible from this index onwards

Example
Suppose at index i
Path A reaches here with profit 20
Path B reaches here with profit 50

From index i onwards, both paths have the same choices.

So DP keeps only the better one implicitly by storing
dp[i] = best possible future profit

This is optimal substructure.

Why 1D dp is enough
Because
State is fully described by one variable
current job index

Transition is deterministic using binary search

Profit is accumulated during recursion, not stored as a dimension.

Why 2D dp is used in some problems
You need dp[index][profit] only when

1 Profit is bounded and small
2 Profit affects future choices
3 Or you are trying to check feasibility rather than maximize value

This problem satisfies none of these.

Final one line intuition
We are choosing jobs based on time, not profit.
Profit is just summed up, so it does not belong in the DP state.

That is why 1D dp is correct and optimal here.
*/