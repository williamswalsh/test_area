package immutable_designs;

/**
 * @author William Walsh
 * @version 02 Nov 2022
 */
public class HiddenInputs {
    final String shareId;
    final String docId;

    private HiddenInputs(String shareId, String docId) {
        this.shareId = shareId;
        this.docId = docId;
    }
}
