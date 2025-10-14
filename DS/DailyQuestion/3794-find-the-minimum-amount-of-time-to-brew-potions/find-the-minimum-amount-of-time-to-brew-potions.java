class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long sumSkill = 0;
        for (int s : skill) sumSkill += s;

        // prevWizardDone = time last wizard finished potion 0 (all wizards processed potion 0)
        long prevWizardDone = sumSkill * (long) mana[0];

        for (int j = 1; j < m; j++) {
            // prevPotionDone will track earliest possible time potion j could be at the right end
            long prevPotionDone = prevWizardDone;

            for (int i = n - 2; i >= 0; i--) {
                //This is the time when wizard i is doen brewing potion j-1
                //1st constraint
                prevPotionDone -= (long) skill[i + 1] * mana[j - 1];

                //This is the time when wizard i can start to brew potion j
                // We subtract wizard i's brewing time from previous wizard's brewing time
                long candidate = prevWizardDone - (long) skill[i] * mana[j];

                // choose the later (the minimal feasible start that satisfies both)
                prevWizardDone = Math.max(prevPotionDone, candidate);
            }

            System.out.print(" At mana:" + j + " prevWizardDone: "+prevWizardDone);

            prevWizardDone += sumSkill * (long) mana[j];
        }

        return prevWizardDone;
    }
}