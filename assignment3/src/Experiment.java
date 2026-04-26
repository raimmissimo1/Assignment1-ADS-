import java.util.Arrays;

public class Experiment {
    private final Sorter sorter;
    private final Searcher searcher;

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter = sorter;
        this.searcher = searcher;
    }

    public long measureSortTime(int[] arr, String type) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        long start = System.nanoTime();
        if ("basic".equalsIgnoreCase(type)) {
            sorter.basicSort(copy);
        } else if ("advanced".equalsIgnoreCase(type)) {
            sorter.advancedSort(copy);
        } else {
            throw new IllegalArgumentException("Unknown sort type: " + type);
        }
        return System.nanoTime() - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        return System.nanoTime() - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};

        System.out.println("=== Sorting and Searching Performance Analysis ===");

        for (int size : sizes) {
            int[] randomArray = sorter.generateRandomArray(size);
            int[] sortedArray = Arrays.copyOf(randomArray, randomArray.length);
            Arrays.sort(sortedArray);

            int target = sortedArray[size / 2];

            long basicRandom = measureSortTime(randomArray, "basic");
            long advancedRandom = measureSortTime(randomArray, "advanced");
            long searchTime = measureSearchTime(sortedArray, target);

            System.out.println("Size: " + size);
            System.out.println("  Selection Sort on random array: " + basicRandom + " ns");
            System.out.println("  Merge Sort on random array:     " + advancedRandom + " ns");
            System.out.println("  Binary Search on sorted array:   " + searchTime + " ns (target=" + target + ")");

            long basicSorted = measureSortTime(sortedArray, "basic");
            long advancedSorted = measureSortTime(sortedArray, "advanced");

            System.out.println("  Selection Sort on sorted array:  " + basicSorted + " ns");
            System.out.println("  Merge Sort on sorted array:      " + advancedSorted + " ns");
            System.out.println();
        }
    }
}
