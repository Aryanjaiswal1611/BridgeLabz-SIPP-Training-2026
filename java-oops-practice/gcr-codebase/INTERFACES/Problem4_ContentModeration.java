// Problem 4: AI-Based Content Moderation Platform

interface TextModeration {
    boolean containsOffensiveLanguage(String post);

    default void displayModerationPolicy() {
        System.out.println("[TextModeration] Policy: No hate speech, harassment, or explicit content.");
    }

    static boolean containsRestrictedWords(String post) {
        String[] restricted = { "spam", "buy now", "click here", "free money", "scam", "hack" };
        if (post == null) return false;
        String lower = post.toLowerCase();
        for (String word : restricted) {
            if (lower.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

interface SpamDetection {
    boolean isSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("[SpamDetection] Policy: No repetitive, promotional, or misleading content.");
    }
}

class ContentModerator implements TextModeration, SpamDetection {
    @Override
    public boolean containsOffensiveLanguage(String post) {
        String[] offensive = { "foul", "abuse", "offensive", "hate" };
        String lower = post.toLowerCase();
        for (String word : offensive) {
            if (lower.contains(word)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSpam(String post) {
        return TextModeration.containsRestrictedWords(post);
    }

    @Override
    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
        System.out.println("[ContentModerator] Combined policy enforced.");
    }

    public void moderatePosts(String[] posts) {
        for (int i = 0; i < posts.length; i++) {
            System.out.println("\nPost " + (i + 1) + ": \"" + posts[i] + "\"");
            boolean isSpam = isSpam(posts[i]);
            boolean isOffensive = containsOffensiveLanguage(posts[i]);

            if (isSpam) {
                System.out.println("  -> Category: SPAM (contains restricted words)");
            } else if (isOffensive) {
                System.out.println("  -> Category: OFFENSIVE");
            } else {
                System.out.println("  -> Category: VALID");
            }
        }
    }
}

public class Problem4_ContentModeration {
    public static void main(String[] args) {
        System.out.println("=== Problem 4: AI-Based Content Moderation ===\n");

        String[] posts = {
            "Hello everyone, nice to meet you!",
            "Click here to claim your free money now!!!",
            "This is a foul and abusive message.",
            "Check out this great product!",
            "Buy now and get rich quick! scam alert",
            "Enjoying a beautiful sunny day at the park."
        };

        ContentModerator moderator = new ContentModerator();
        moderator.displayModerationPolicy();
        moderator.moderatePosts(posts);
    }
}
