package lesson3.homework.expert;

public class RegionStatistic {
    private int region;
    private int countInputCars;
    private int maxPopularInputCarRegion;
    private long maxPopularInputCarRegionCount;

    public RegionStatistic(int region, int countInputCars, int maxPopularInputCarRegion, long maxPopularInputCarRegionCount) {
        this.region = region;
        this.countInputCars = countInputCars;
        this.maxPopularInputCarRegion = maxPopularInputCarRegion;
        this.maxPopularInputCarRegionCount = maxPopularInputCarRegionCount;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(region)
                .append(" - больше всего въехало с номерами ")
                .append(maxPopularInputCarRegion)
                .append(": ")
                .append(maxPopularInputCarRegionCount)
                .append(" машин(ы)")
                .toString();
    }

    public int getRegion() {
        return region;
    }

    public int getCountInputCars() {
        return countInputCars;
    }

    public int getMaxPopularInputCarRegion() {
        return maxPopularInputCarRegion;
    }

    public long getMaxPopularInputCarRegionCount() {
        return maxPopularInputCarRegionCount;
    }
}
