// LeetCode 223: Rectangle Area
// Find total area covered by two rectilinear rectangles

public class LC223_RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);

        int overlapX = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlapY = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        int overlap = overlapX * overlapY;

        return areaA + areaB - overlap;
    }

    public static void main(String[] args) {
        // Rectangle 1: (-3,0) to (3,4); Rectangle 2: (0,-1) to (9,2)
        int area = new LC223_RectangleArea().computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
        System.out.println("Total Area: " + area); // 45
    }
}
