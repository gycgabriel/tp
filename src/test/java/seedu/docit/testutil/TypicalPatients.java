package seedu.docit.testutil;

import static seedu.docit.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.docit.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.docit.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.docit.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.docit.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.docit.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.docit.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.docit.logic.commands.CommandTestUtil.VALID_PHONE_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.docit.commons.core.index.Index;
import seedu.docit.model.AddressBook;
import seedu.docit.model.patient.Patient;

/**
 * A utility class containing a list of {@code Patient} objects to be used in tests.
 */
public class TypicalPatients {

    public static final Patient ALICE = new PatientBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253")
            .withMedicalHistory("diabetes").build();
    public static final Patient BENSON = new PatientBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withMedicalHistory("cold", "1 Oct 1999").build();
    public static final Patient CARL = new PatientBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("wall street").withMedicalHistory("").build();
    public static final Patient DANIEL = new PatientBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street").withMedicalHistory("diabetes").build();
    public static final Patient ELLE = new PatientBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave")
            .withMedicalHistory("diabetes").build();
    public static final Patient FIONA = new PatientBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo")
            .withMedicalHistory("diabetes").build();
    public static final Patient GEORGE = new PatientBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withAddress("4th street")
            .withMedicalHistory("diabetes").build();

    // Manually added
    public static final Patient HOON = new PatientBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withAddress("little india")
            .withMedicalHistory("diabetes").build();
    public static final Patient IDA = new PatientBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave")
            .withMedicalHistory("diabetes").build();

    // Manually added - Patient's details found in {@code CommandTestUtil}
    public static final Patient AMY = new PatientBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).build();
    public static final Patient BOB = new PatientBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPatients() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical patients.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Patient patient : getTypicalPatients()) {
            ab.addPatient(patient);
        }
        return ab;
    }

    public static List<Patient> getTypicalPatients() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }

    /**
     * Makes the given {@code Patient} contain an {@code EMPTY_MEDICAL_HISTORY}.
     * @param p patient to be edited.
     * @return edited patient.
     */
    public static Patient makeEmptyMedicalHistory(Patient p) {
        Patient edited = p;
        int countOfMedicalEntries = p.getMedicalHistory().size();
        for (int i = countOfMedicalEntries; i > 0; i--) {
            edited = p.deleteMedicalHistory(Index.fromOneBased(i));
        }
        return edited;
    }
}
