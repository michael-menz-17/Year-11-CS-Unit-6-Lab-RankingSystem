public class User {
    private int rank;

    private int progress;

    public User() {
        rank = -8;
        progress = 0;
    }

    public int getRank() {
        return rank;
    }

    public int getProgress() {
        return progress;
    }

    private int getDifference(int acRank) {
        int m = acRank - rank;
        if ((acRank > 0 && rank > 0) || (acRank < 0 && rank < 0)) {
            return m;
        } else {
            if (acRank < 0 && rank > 0) {
                m += 1;
                return m;
            } else {
                m -= 1;
                return m;
            }
        }
    }

    public void incProgress(int acRank) {
        if (acRank > 8 || acRank < -8 || acRank == 0) {
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }
        int d = getDifference(acRank);

        if (d == 0) {
            progress += 3;
        } else if (d == -1) {
            progress += 1;
        } else if (d <= -2) {
            progress += 0;
        } else {
            progress += 10 * d * d;
        }

        change();

    }

    private void change() {
        while (progress >= 100) {
            rank++;
            progress -= 100;

            if (rank == 0) {
                rank = 1;
            }
            if (rank == 8) {
                progress = 0;
            }
        }

    }

    public String toString() {
        return "User{rank=" + rank + ", " + "progress=" + progress + "}";
    }
}