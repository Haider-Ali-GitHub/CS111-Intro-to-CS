//**
// HeartTransplant class 
// 

public class HeartTransplant {

    // patient array, each Patient is read from the data file
    private Patient[] patients;
 
    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge survivabilityByAge;
 
    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause survivabilityByCause;
 
    /*
     * Default constructor
     * Initializes patients to null.
     * Initializes survivabilityByAge to null.
     * Initializes survivabilityByCause to null. 
     */
    public HeartTransplant() {
        patients=null;
        survivabilityByAge=null;
        survivabilityByCause=null;
    }
    /*
     * Returns patients
     */
    public Patient[] getPatients() {
        return patients;
    } 
    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge getSurvivabilityByAge() {
        return survivabilityByAge;
    }
    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause getSurvivabilityByCause() {
        return survivabilityByCause;
    }
 
    /*
     * 1) Initialize the instance variable patients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file, use StdIn.readInt() to read an integer.
     *    File Format: 
     *      ID, ethnicity, Gender, Age, Cause, Urgency, State of health
     * 
     *    Each line refers to one Patient, all values are integers.
     * 
     */
    public void readPatients (int numberOfLines) {
        patients=new Patient[numberOfLines];
        for (int i = 0; i < patients.length; i++) {
            int Id = StdIn.readInt();
            int Ethnicity = StdIn.readInt();
            int Gender = StdIn.readInt();
            int Age = StdIn.readInt();
            int Cause = StdIn.readInt();
            int Urgency = StdIn.readInt();
            int StateOfHealth = StdIn.readInt();
            patients[i] = new Patient(Id, Ethnicity, Gender, Age, Cause, Urgency, StateOfHealth);
        }
    }
 
    /*
     * 1) Initialize the instance variable survivabilityByAge with a new survivabilityByAge object.
     * 
     * 2) Reads from the command line file to populate the object. 
     *    Use StdIn.readInt() to read an integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     */
    public void readSurvivabilityByAge (int numberOfLines) {
        survivabilityByAge=new SurvivabilityByAge();
        for(int i=0;i<numberOfLines;i++){
            int age = StdIn.readInt();
            int year = StdIn.readInt();
            double rate = StdIn.readDouble();
            survivabilityByAge.addData(age, year, rate);
        }
    }
 
    /*
     * 1) Initialize the instance variable survivabilityByCause with a new survivabilityByCause object.
     * 
     * 2) Reads from the command line file to populate the object. Use StdIn.readInt() to read an 
     *    integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     */
    public void readSurvivabilityByCause (int numberOfLines) {
        survivabilityByCause=new SurvivabilityByCause();
        for(int i=0;i<numberOfLines;i++){
            int cause = StdIn.readInt();
            int year = StdIn.readInt();
            double rate = StdIn.readDouble();
            survivabilityByCause.addData(cause, year, rate);
        }
    }
    
    /*
     * Returns a Patient array containing the patients, 
     * from the patients array, that have age above the parameter age.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with age above the parameter age.
     * 
     * Return null if there is no Patient with age above the 
     * parameter age.
     */ 
    public Patient[] getPatientsWithAgeAbove(int age) {
        Patient[] patientsAboveAge;
        int l=0;
        for (Patient patient : patients) {
            if(patient!=null && patient.getAge()>age){
                l++;
            }
        }
        patientsAboveAge=new Patient[l];
        int i=0;
        for (Patient patient : patients){
            if(patient!=null && patient.getAge()>age){
                patientsAboveAge[i]=patient;
                i++;
            }
        }
        return patientsAboveAge;
    }
 
    /*
     * Returns a Patient array containing the patients, from the patients array, 
     * that have the heart condition cause equal to the parameter cause.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Patient with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Patient[] getPatientsByHeartConditionCause(int cause) {
        Patient[] patientsByHeartConditionCause;
        int length=0;
        for (Patient patient : patients) 
            if(patient!=null && patient.getCause()==cause)
                length++;
        patientsByHeartConditionCause=new Patient[length];
        int i=0;
        for (Patient patient : patients)
            if(patient!=null && patient.getCause()==cause){
                patientsByHeartConditionCause[i]=patient;
                i++;
            }
        return patientsByHeartConditionCause;
    }
 
    /*
     * Returns a Patient array containing patients, from the patients array,
     * that have the state of health equal to the parameter state.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the state of health equal to the parameter state.
     * 
     * Return null if there is no Patient with the state of health 
     * equal to the parameter state.
     */ 
    public Patient[] getPatientsByUrgency(int urgency) {
        Patient[] patientsByUrgency;
        int length=0;
        for (Patient patient : patients) 
            if(patient!=null && patient.getUrgency()>=urgency)
                length++;
        patientsByUrgency=new Patient[length];
        int i=0;
        for (Patient patient : patients)
            if(patient!=null && patient.getUrgency()>=urgency){
                patientsByUrgency[i]=patient;
                i++;
            }
        return patientsByUrgency;
    }
    public Object getPatientForTransplant() {
        return null;
    }
}