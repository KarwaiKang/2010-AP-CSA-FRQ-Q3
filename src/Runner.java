public class Runner {
    public static void main(String[] args) {
        Trail trail = new Trail(100, 150, 105, 120, 90, 80, 50, 75, 75, 70, 80, 90, 100);

        System.out.println(trail.isLevelTrailSegment(7, 10)); // → true
        System.out.println(trail.isLevelTrailSegment(2, 12)); // → false
        System.out.println(trail.isDifficult()); // → true
    }
}
