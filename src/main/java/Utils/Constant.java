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
	public static final String SHEET_NAME5="Sheet6";
	public static final String SHEET_NAME6="Sheet7";
	public static final String SHEET_NAME7="Sheet8";
	public static final String SHEET_NAME8="Sheet9";
	public static final String URL = "http://138.68.137.97:8080/tnu/home/home.jsp";
	public static final String BASE_URL = "http://138.68.137.97:8080/";
	public static final String TITLE = "Taxinearu - Search, Book & Go.";
	public static final String PASSWORD_REQUEST = "Your request to change your password has been sent to your email.";
	public static final String CHANGEPASSWORDE_MSG = "Password should be 7 characters long, containing alphabetic, numeric and one capital letter, password cannot contain any special characters(~!@#$%^&*_+=|(){}[]:;<>,./?)";
	public static final String PASSWORD_MISMATCH_ERROR = "New password and confirm new password mismatch.";
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
	public static final String EMAIL="testmyscript123@gmail.com";
	public static final String EMAIL_PASSWORD="8306188737";
	
	
	

	// change email
	public static final String CHANGE_EMAIL_REQUESTMSG = "Your request to change your email address has been sent to your email.";
	public static final String ENTER_EMAIL_ERROR = "Enter email address";
	public static final String ENTER_EMAIL_ERROR1 = "Enter confirm email address";
	public static final String CHECK_EMAIL_ERROR = "Enter valid email address";
	public static final String CHECK_EMAIL_ERROR1 = "Enter valid confirm email address";
	public static final String EMAIL_MISMATCH_ERROR = "Email address and confirm new address must be same";
	public static final String EMAIL_EXIST_ERROR = "Email already exist";
	public static final String EMAIL_CHANGESCSMSG = "Email address updated successfully";

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
	public static final int EMAIL_SCSMSG = 4;

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
    public static final String OLD_EMAIL1="Email address already exists";
    public static final String OLD_ALTERNATE_EMAIL="Alternate email address already exists";
    
    
	//become a partner
	public static final String FIRST_NAME="Enter first name";
	public static final String LAST_NAME="Enter last name";
	public static final String COMPANY_NAME="Enter company name";
	public static final String AREA_NAME="Enter area";
	public static final String ADDRESS_NAME="Enter valid address";
	public static final String CITY_NAME="Enter city";
	public static final String DISPATCH_L_NAME="Enter dispatch system";
	public static final String POSTAL_CODE="Enter postal code";
    public static final String NAME_ERROR="Name must be between 5 to 20 digits long";
    public static final String PARTNER_NAME_ERROR="Partner name registred!";
	
    
   //admin details
    public static final String URL1="http://138.68.137.97:8080/tnu/admin/index.jsp";
    public static final String LOGIN_TITLE="Login Page | Taxinearu";
    public static final String LOGIN_ADMIN_CHECK="Please provide username and password";	
    public static final String ADMIN_PARTNER_C_NAME="Enter Company Name";
    public static final String ADMIN_P_ADRS="Enter Address";
    public static final String ADMIN_P_CITY="Enter City";
    public static final String ADMIN_POSTAL_CODE="Enter Postal Code";
    public static final String CONTACT_P_NAME="Enter Contact Person Name";
    public static final String CONTACT_P_EMAIL_A="Enter Contact Person Email Address";
    public static final String CONTACT_P_MOBILE_NUMBER="Enter Contact Person Mobile Number";
    
  





}
