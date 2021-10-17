package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.AppointmentBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Patient;
import seedu.address.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddPatientCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new AppointmentBook(), new UserPrefs());
    }

    @Test
    public void execute_newPerson_success() {
        Patient validPatient = new PersonBuilder().build();

        Model expectedModel = new ModelManager(model.getAddressBook(), new AppointmentBook(), new UserPrefs());
        expectedModel.addPatient(validPatient);

        assertCommandSuccess(new AddPatientCommand(validPatient), model,
                String.format(AddPatientCommand.MESSAGE_SUCCESS, validPatient), expectedModel);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Patient patientInList = model.getAddressBook().getPersonList().get(0);
        assertCommandFailure(new AddPatientCommand(patientInList), model, AddPatientCommand.MESSAGE_DUPLICATE_PERSON);
    }

}
