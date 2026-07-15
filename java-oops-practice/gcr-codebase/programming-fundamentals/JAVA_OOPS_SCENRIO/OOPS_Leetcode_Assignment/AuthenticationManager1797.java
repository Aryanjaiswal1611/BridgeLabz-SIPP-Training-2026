import java.util.HashMap;

class AuthenticationManager {

    private int timeToLive;

    private HashMap<String, Integer> tokens;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        tokens = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {

        if (tokens.containsKey(tokenId)
                && tokens.get(tokenId) > currentTime) {

            tokens.put(tokenId,
                    currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {

        int count = 0;

        for (int expiryTime : tokens.values()) {

            if (expiryTime > currentTime) {
                count++;
            }
        }

        return count;
    }
}