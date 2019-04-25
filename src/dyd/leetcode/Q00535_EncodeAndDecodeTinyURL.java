package dyd.leetcode;

import java.util.HashMap;

public class Q00535_EncodeAndDecodeTinyURL {
    private static final String TINY_URL_PREFIX = "https://tinyurl.com/";

    private HashMap<String, String> tiny2Originals = new HashMap();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tinyUrl = TINY_URL_PREFIX + longUrl.hashCode();
        tiny2Originals.put(tinyUrl, longUrl);
        return tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (tiny2Originals.containsKey(shortUrl)) {
            return tiny2Originals.get(shortUrl);
        } else {
            return shortUrl;
        }
    }

    public static void main(String[] args) {
        Q00535_EncodeAndDecodeTinyURL q = new Q00535_EncodeAndDecodeTinyURL();
        String tinyUrl = q.encode("https://www.google.com");
        System.out.println(tinyUrl);
        System.out.println(q.decode(tinyUrl));

    }
}
