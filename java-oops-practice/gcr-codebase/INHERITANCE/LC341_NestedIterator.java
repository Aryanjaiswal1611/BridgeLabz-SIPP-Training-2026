import java.util.*;

// LeetCode 341: Flatten Nested List Iterator

interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
}

class NestedIntegerImpl implements NestedInteger {
    private Integer val;
    private List<NestedInteger> list;

    NestedIntegerImpl(Integer val) { this.val = val; }
    NestedIntegerImpl(List<NestedInteger> list) { this.list = list; }

    public boolean isInteger() { return val != null; }
    public Integer getInteger() { return val; }
    public List<NestedInteger> getList() { return list; }
}

class NestedIterator implements Iterator<Integer> {
    private Stack<Iterator<NestedInteger>> stack;
    private Integer nextVal;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.iterator());
    }

    private void advance() {
        nextVal = null;
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
                continue;
            }
            NestedInteger ni = stack.peek().next();
            if (ni.isInteger()) {
                nextVal = ni.getInteger();
                return;
            }
            stack.push(ni.getList().iterator());
        }
    }

    public Integer next() {
        Integer result = nextVal;
        advance();
        return result;
    }

    public boolean hasNext() {
        if (nextVal == null) advance();
        return nextVal != null;
    }
}

public class LC341_NestedIterator {
    public static void main(String[] args) {
        // Example: [1, [4, [6]]]
        List<NestedInteger> list = Arrays.asList(
            new NestedIntegerImpl(1),
            new NestedIntegerImpl(Arrays.asList(
                new NestedIntegerImpl(4),
                new NestedIntegerImpl(Arrays.asList(new NestedIntegerImpl(6)))
            ))
        );

        NestedIterator it = new NestedIterator(list);
        System.out.print("Flattened: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
