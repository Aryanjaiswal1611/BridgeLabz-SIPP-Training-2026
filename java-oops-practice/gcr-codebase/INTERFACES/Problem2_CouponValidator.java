// Problem 2: Online Coupon Validator - Interface with abstract + static methods

interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 5 && code.length() <= 12;
    }
}

class ShoppingCart implements CouponValidator {
    private String[] validCoupons;

    public ShoppingCart(String[] validCoupons) {
        this.validCoupons = validCoupons;
    }

    @Override
    public boolean validateCoupon(String code) {
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }
        for (String valid : validCoupons) {
            if (valid.equals(code)) {
                return true;
            }
        }
        return false;
    }
}

public class Problem2_CouponValidator {
    public static void main(String[] args) {
        System.out.println("=== Problem 2: Online Coupon Validator ===\n");

        String[] validCodes = { "SAVE10", "WELCOME5", "FREESHIP", "VIP20OFF" };
        String[] testCodes = { "SAVE10", "BAD", "WELCOME5", "INVALID99", "FREESHIP", "TOOLONGCODE123", "VIP20OFF", "NONE" };

        ShoppingCart cart = new ShoppingCart(validCodes);

        for (String code : testCodes) {
            boolean valid = cart.validateCoupon(code);
            System.out.println("Coupon '" + code + "' (len=" + code.length() + ") -> "
                    + (valid ? "VALID" : "INVALID"));
        }
    }
}
