import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class webscaper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int wordcount(final String contents, final String word) {
        int count = 0;
        int i = contents.indexOf(word);
        for (; i < contents.length() - word.length(); ){
            i = contents.indexOf(word,i++);
            count++;
        }
        return count;
    }
    public static int wordcountcaseinsensitive(final String contents, final String word) {
        int count = 0;
        String contentsa =contents.toLowerCase();
        String worda = word.toLowerCase();
        int i = contentsa.indexOf(worda);
        for (; i < contentsa.length() - worda.length(); ){
            contentsa.indexOf(worda,i++);
            count++;
        }
        return count;
    }
    public static void main(String[] unused) {
        System.out.println(wordcount(urlToString("http://erdani.com/tdpl/hamlet.txt"), "prince"));
    }
}
