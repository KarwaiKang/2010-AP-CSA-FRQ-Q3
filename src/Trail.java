public class Trail {
    /**
     * Representation of the trail. The number of markers on the trail is {@code markers.length}.
     */
    private int[] markers;

    public Trail(int... markers) {
        this.markers = markers;
    }

    /**
     * Determines if a trail segment is level. A trail segment is defined by a starting marker,
     * an ending marker, and all markers between those two markers.
     * A trail segment is level if it has a difference between the maximum elevation
     * and minimum elevation that is less than or equal to 10 meters.
     *
     * @param start the index of the starting marker
     * @param end   the index of the ending marker
     *              Precondition: {@code 0 <= start < end <= markers.length - 1}
     * @return {@code true} if the difference between the maximum and minimum
     * elevation on this segment of the trail is less than or equal to 10 meters;
     * {@code false} otherwise.
     */
    public boolean isLevelTrailSegment(int start, int end) {
        int max = markers[start];
        int min = markers[start];
        for (int i = start + 1; i <= end; i++) {
            if (markers[i] > max)
                max = markers[i];
            if (markers[i] < min)
                min = markers[i];
        }
        return max - min < 11;
    }

    /**
     * Determines if this trail is rated difficult. A trail is rated by counting the number of changes in
     * elevation that are at least 30 meters (up or down) between two consecutive markers. A trail
     * with 3 or more such changes is rated difficult.
     *
     * @return {@code true} if the trail is rated difficult;
     * {@code false} otherwise.
     */
    public boolean isDifficult() {
        int changes = 0;
        for (int i = 0; i < markers.length - 1; i++) {
            if (markers[i] - markers[i + 1] >= 30 || markers[i] - markers[i + 1] <= -30)
                changes++;
            if (changes == 3)
                return true;
        }
        return false;
    }
}