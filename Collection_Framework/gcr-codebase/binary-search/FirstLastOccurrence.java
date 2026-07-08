public class FirstLastOccurrence {

    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return result;
    }

    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 4, 5, 5, 6};
        int target = 3;
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        System.out.println("Target: " + target);
        System.out.println("First occurrence: " + first);
        System.out.println("Last occurrence: " + last);

        target = 7;
        first = findFirst(arr, target);
        last = findLast(arr, target);
        System.out.println("Target " + target + " first: " + first + ", last: " + last);
    }
}
