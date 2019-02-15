package twostack;

/**
 * TwostackEmptyException er en RuntimeException. Dette er fordi den indikerer en logisk feil i programmet.
 * Å fjerne et element fra en stabel som allerede er tom er en logisk feil. Man trenger ikke å håndtere
 * dette unntaket, men det indikerer en feil og man kan håndtere det om det er nødvendig.
 * Author: Øyvind Johannessen, Roy H. Jensen
 * Version: 1.0
 */
public class TwostackEmptyException extends RuntimeException {
    public TwostackEmptyException(String message) {
        super(message);
    }
}
