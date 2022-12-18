/**
 *
 * @author kasuni upeksha
 */
class Recipients {
    public String type;
    public String name;
    public String nickName;
    public String designation;
    public String email;
    public String birthYear;
    public String birthMonth;
    public String birthDate;

    Recipients(String line){
        String[] userTypes = line.split(":");
        String[] splitArray = userTypes[1].trim().split(",");

        this.type = userTypes[0];
        this.name = splitArray[0];

        switch (userTypes[0]) {
            case "Official" -> {
                this.email = splitArray[1];
                this.designation = splitArray[2];
            }
            case "Office_friend" -> {
                this.email = splitArray[1];
                this.designation = splitArray[2];
                String[] birthData = splitArray[3].split("/");
                this.birthYear = birthData[0];
                this.birthMonth = birthData[1];
                this.birthDate = birthData[2];
            }
            case "Personal" -> {
                this.nickName = splitArray[1];
                this.email = splitArray[2];
                String[] birthData = splitArray[3].split("/");
                this.birthYear = birthData[0];
                this.birthMonth = birthData[1];
                this.birthDate = birthData[2];
            }
            default -> System.out.println("Invalid Data");
        }


    }
}
