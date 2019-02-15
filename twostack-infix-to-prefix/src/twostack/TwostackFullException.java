package twostack;

/**
 * TwostackFullException er en RuntimeException. Dette er fordi den indikerer en logisk feil i programmet.
 * Å legge til et element fra en stabel som er full er en logisk feil. Man trenger ikke å håndtere
 * dette unntaket, men det indikerer en feil og man kan håndtere det om det er nødvendig.
 * Author: Øyvind Johannessen, Roy H. Jensen
 * Version: 1.0
 */
public class TwostackFullException extends RuntimeException {
    public TwostackFullException(String message) {
        super(message);
    }
}
