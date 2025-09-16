public class Codec {
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        return longUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortUrl;
    }
}


/*
public class Codec {
    HashMap<String, String> enc;

    Codec(){
        enc = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tinyUrl = longUrl;
        enc.put(tinyUrl, longUrl);
        return tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return enc.get(shortUrl);
    }

    // Encode using the ascii value of characters
    private String encoding(String longUrl){
        String cipher = "";
        for(char ch : )
    }
}
*/