package Utils;

public class Constant {
	public static final String FILE_FULL_PATH = "/home/smart/workspace/taxinearTesting/src/main/resources/Taxinearu.xlsx";
	public static final String FILE_PATH = "src/main/resources/";
	public static final String FILE_NAME = "Taxinearu.xlsx";
	public static final String SHEET_NAME = "Sheet1";
	public static final String SHEET_NAME1 = "Sheet2";
	public static final String SHEET_NAME2 = "Sheet3";
	public static final String SHEET_NAME3 = "Sheet4";
	public static final String SHEET_NAME4 = "Sheet5";
	public static final String SHEET_NAME5 = "Sheet6";
	public static final String SHEET_NAME6 = "Sheet7";
	public static final String SHEET_NAME7 = "Sheet8";
	public static final String URL = "http://138.68.137.97:8080/tnu/home/home.jsp";
	public static final String PARTNER_URL = "http://138.68.137.97:8080/tnu/partner/index.jsp";
	public static final String BASE_URL = "http://138.68.137.97:8080/";
	public static final String TITLE = "Taxinearu - Search, Book & Go.";
	public static final String LOGIN_PARTNER_TITLE = "Login Page | Taxinearu";
	public static final String PASSWORD_REQUEST = "Your request to change your password has been sent to your email.";
	public static final String CHANGEPASSWORDE_MSG = "Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?)";
	public static final String PASSWORD_MISMATCH_ERROR = "Confirm password not matched.";
	public static final String PASSWORD_CHANGED_SUCCESSMSG = "Your password has been updated.";
	public static final String PRIMARY_EMAIL = "testing3492email@gmail.com";
	public static final String PRIMARY_EMAIL_PASSWORD = "8306188737";
	public static final String ALTERNATE_EMAIL = "anjali.smartsensesolutions@gmail.com";
	public static final String ALTERNATE_EMAIL_PASSWORD = "smartAnjali";
	public static final String CONNECTION_EMAIL = "imap.gmail.com";
	public static final String SECURITY_QUESTION1 = "bangalore";
	public static final String SECURITY_QUESTION2 = "anu";
	public static final String SECURITY_CHANGEPASSERROR = "Minimum 7 characters at least 1 Uppercase, 1 Lowercase, 1 Number and No Special Characters allowed";
	public static final String PASSWORD_NOT_MATCH = "Password does not match";
	public static final String SECURITY_QUESTIONSCSMSG = "Security questions have been answered successfully.";
	public static final String NEW_EMAIL = "testclozer@gmail.com";
	public static final String NEW_EMAIL_PASSWORD = "goclozer";
	public static final String EMAIL = "testmyscript123@gmail.com";
	public static final String EMAIL_PASSWORD = "8306188737";

	// change email
	public static final String CHANGE_EMAIL_REQUESTMSG = "Your request to change your email address has been sent to your email.";
	public static final String ENTER_EMAIL_ERROR = "Enter email address";
	public static final String ENTER_EMAIL_ERROR1 = "Enter confirm email address";
	public static final String CHECK_EMAIL_ERROR = "Enter valid email address";
	public static final String CHECK_EMAIL_ERROR1 = "Enter valid confirm email address";
	public static final String EMAIL_MISMATCH_ERROR = "Email address and confirm new address must be same";
	public static final String EMAIL_EXIST_ERROR = "Email already exist";
	public static final String EMAIL_CHANGESCSMSG = "Email address updated successfully";
	public static final String EMAIL_AND_ALTEMAIL_NOTSAME = "Email and Alternative Email can not be same.";

	// email change by security questions
	public static final String SECURITY_QUESTION_ERROR = "Enter email address";
	public static final String SECURITY_QUESTION_ERROR1 = "Confirm email address";
	public static final String EMAIL_EXIST1 = "The email address you have entered already exists, please enter a new email.";
	public static final String EMAIL_MISMATCH_CHECK = "Email address and Confirm email address does not match";
	public static final String EMAIL_UPDATED = "Your email has been updated.";

	// change security question
	public static final String CHANGE_SEQERROR = "Answer can not blank";
	public static final String SEQ1_SUCCESSMSG = "Your request to change your security questions has been sent to your email.";
	public static final String SEQ_UPDATEDSCSMSG = "Security Question updated";
	public static final String SEQ1_SCSMSG_TO_ALTERNATE = "Your request to change your security questions has been sent to your alternative email.";

	// change alternate email errors
	public static final String CHANGE_ALTERNATE_EMAILERROR = "Email and Alternative Email can not be same.";
	public static final String ALTERNATE_EMAIL_UPDATESCSMSG = "Alternate email address updated successfully.";
	public static final String ALTERNATE_EMAIL_UPDATERROR = "Primary email and Alternative email can not be the same.";
	public static final String ALTERNATE_EMAIL_SCSMSG = "Your alternative email has been updated.";

	// passing values for the type(change alternate email by primary)
	public static final int VALID_EMAIL_ERROR = 1;
	public static final int MISMATCH_ERROR = 2;
	public static final int ALTERNATE_EMAIL_NOTSAMERROR = 3;
	public static final int SCS_MSG_ALTERNATE = 4;

	// passing values for the type(change alternate email by security)
	public static final int VALID_EMAIL_BYSECURITY_ERRROR = 1;
	public static final int MISMATCH_BYSECURITY_ERROR = 2;
	public static final int ALTERNATE_EMAIL_NOTSAME_BYSECURITY = 3;
	public static final int SCS_MSG_BY_SECURITY = 4;

	// passing values for the type(change password by alternate mail.
	public static final int CHANGEPWD_ERRORMSG_BYALTERNATE = 1;
	public static final int PASSWORD_MISMATCHE = 2;
	public static final int PWD_UPDATE_MSG = 3;

	// change email by alternate defining type
	public static final int EXIST_EMAIL_ERR = 3;
	public static final int EMAIL_AND_AEMAIL_NTSM = 4;
	public static final int EMAIL_SCSMSG = 5;

	// mandatory fields for the signup field
	public static final String CHECK_FIRSTNAME_ERROR = "Enter First Name";
	public static final String CHECK_LASTNAME_ERROR = "Enter Last Name";
	public static final String CHECK_CONTACT_NOERR = "Enter contact number";
	public static final String CHECK_EMAILADRS_ERROR = "Enter Email Address";
	public static final String CHECK_PWD_ERROR = "Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?)";
	public static final String CHECK_CONPWD_ERROR = "Enter Confirm Password";
	public static final String CHECK_SEQ_ANS_ERROR = "Enter Answer";
	public static final String VALID_FIRSTNAME_ERROR = "First name must be between 5 to 20 digits long";
	public static final String VALID_LASTNAME_ERROR = "Last name must be between 5 to 20 digits long";
	public static final String VALID_CONTACTNO_ERROR = "Please enter valid UK contact number.";
	public static final String PASSWORD_SHD_MATCH = "Confirm Password Not Matched";
	public static final String EMAIL_ALTERNATE_ERROR = "Email and alternate email can't be same";
	public static final String OLD_EMAIL = "The email address you have entered already exists, please enter a new email.";
	public static final String OLD_CONTACTNO = "The contact number you have entered is already registered, Please enter another contact number.";
	public static final String OLD_EMAIL1 = "Email address already exists";
	public static final String OLD_ALTERNATE_EMAIL = "Alternate email address already exists";

	// become a partner
	public static final String FIRST_NAME = "Enter first name";
	public static final String LAST_NAME = "Enter last name";
	public static final String COMPANY_NAME = "Enter company name";
	public static final String AREA_NAME = "Enter area";
	public static final String ADDRESS_NAME = "Enter valid address";
	public static final String CITY_NAME = "Enter city";
	public static final String DISPATCH_L_NAME = "Enter dispatch system";
	public static final String POSTAL_CODE = "Enter postal code";
	public static final String NAME_ERROR = "Name must be between 5 to 20 digits long";
	public static final String PARTNER_NAME_ERROR = "Partner name registred!";

	// admin details
	public static final String URL1 = "http://138.68.137.97:8080/tnu/admin/index.jsp";
	public static final String LOGIN_TITLE = "Login Page | Taxinearu";
	public static final String LOGIN_ADMIN_CHECK = "Please provide username and password";
	public static final String ADMIN_PARTNER_C_NAME = "Enter Company Name";
	public static final String ADMIN_P_ADRS = "Enter Address";
	public static final String ADMIN_P_AREA = "Enter Area";
	public static final String ADMIN_P_CITY = "Enter City";
	public static final String ADMIN_POSTAL_CODE = "Enter Postal Code";
	public static final String CONTACT_P_NAME = "Enter Contact Person Name";
	public static final String CONTACT_P_EMAIL_A = "Enter Contact Person Email Address";
	public static final String CONTACT_P_MOBILE_NUMBER = "Enter Contact Person Mobile Number";
	public static final String PARTNER_NAME_ERROR_ADMIN = "Partner name must be between 5 to 20 digits long";
	public static final String EMAIL_ADMIN_EXIST_E = "Email address already registered";
	public static final String ADMIN_COMPANYN_EXIST = "Partner Name exist!";
	public static final String ADMIN_EMAIL_EXIST = "Email ID or Phone Number already registered.";

	// vehicle add from admin
	public static final String VEHICLE_T_ERROR = "Enter vehicle type";
	public static final String MAX_P_ALLOWED_E = "Enter max people allowance";
	public static final String MIN_RATE = "Enter minimum rate";
	public static final String MAX_RATE = "Enter maximum rate";
	public static final String MIN_MAXRATE_ERROR = "Invalid Rate Formate";
	public static final String VALUE_BETWEEN_ERROR = "Value must be between 0 to 20.";
	public static final String VEHICLE_NAME_EXISTS_ERROR = "Vehicle Type already exists.";

	// vehicle maker management
	public static final String VEHICLE_MAKER_ERROR = "Enter vehicle maker";
	public static final String VEHICLE_MAKER_A_EXISTS = "Vehicle Maker already exists.";

	// event booking
	public static final String EVENT_DATE_ERROR = "Enter event date";
	public static final String PICKUP_AREA_ERROR = "Enter pickup area";
	public static final String DROPOFF_AREA_ERROR = "Enter drop area";
	public static final String LENGTH_FIRSTNAME = "First name must be 2 to 20 characters long";
	public static final String LENGTH_LASTNAME = "Last name must be 2 to 20 characters long";

	// contact us
	public static final String C_NAME_ERROR = "Enter name";
	public static final String SUBJECT_ERROR = "Enter subject";
	public static final String MESSAGE_ERROR = "Enter message";
	public static final String SUBJECT_VALID_ERROR = "Subject must be between 5 to 20 digits long";
	public static final String C_VALID_NAME_ERROR = "Name must be 5 to 20 characters long";

	// booking taxi details
	public static final String B_PICKUP_AREA = "Enter Pickup location";
	public static final String B_DROP_OFF_AREA = "Enter Drop off location";
	public static final String B_SUGGESTION_ERROR = "Please select valid location name from suggestion.";
	public static final String B_CARD_NUMBER_E = "Your card number is incorrect.";
	public static final String B_CARDN_ERROR = "Please enter valid card number";
	public static final String B_CVV_ERROR = "Please enter valid CVV number";
	public static final String B_CVV_ERROR_ABOVE = "Card CVV incorrect.";
	public static final String EXPIRATION_DATE_ERROR = "Your card's expiration month is invalid.";

	// driver add
	public static final String P_CONTACT_ERROR = "Enter valid UK contact number";
	public static final String P_VEHICLE_REG_ERROR = "Enter vehicle registration";
	public static final String P_VEHICLE_COLOR = "Enter valid vehicle colour";
	public static final String P_VALID_REG_NO = "Vehical registration number should be 1 to 7 characters";
	public static final String P_VEHICLE_REG_ALREADY_EXIST_E = "Vehicle with same registration number Exists.Please try with new registration number.";
	public static final String P_DRIVER_NAME_EXIST = "Driver with same first name and last name already registered.";
	public static final String DRIVER_UPDATED_SCS_MSG = "Driver added Successfully.";
	public static final String DRIVER_EDIT_SCS_MSG="Driver information updated Successfully.";

}
